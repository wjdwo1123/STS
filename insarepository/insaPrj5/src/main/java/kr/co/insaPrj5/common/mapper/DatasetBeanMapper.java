package kr.co.insaPrj5.common.mapper;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.WordUtils;
import org.jfree.util.Log;
import org.springframework.stereotype.Component;

import kr.co.insaPrj5.common.annotation.ColumnName;
import kr.co.insaPrj5.common.annotation.Dataset;
import kr.co.insaPrj5.common.annotation.Remove;
import lombok.extern.slf4j.Slf4j;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.DataTypes;
import com.tobesoft.xplatform.data.PlatformData;

@Slf4j
@Component
public class DatasetBeanMapper {

    public <T> List<T> datasetToBeans(PlatformData reqData, Class<T> classType) throws Exception {
        String datasetName = getDataSetName(classType);
        log.info("datasetName:"+datasetName);
        DataSet dataset = reqData.getDataSet(datasetName);
        log.info("dataset:"+dataset);
        List<T> beanList = new ArrayList<T>();
        log.info("beanList:"+beanList);
        T bean = null;
        int rowCount = dataset.getRowCount();
        
       
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            bean = getBean(dataset, classType, rowIndex);
            beanList.add(bean);
            log.info("beanList:"+beanList);
        }

        rowCount = dataset.getRemovedRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            bean = getDeletedBean(dataset, classType, rowIndex);
            beanList.add(bean);
        }
        return beanList;
    }

    public <T> T datasetToBean(PlatformData reqData, Class<T> classType) throws Exception {
        T bean = null;
        String datasetName = getDataSetName(classType);
        log.info("datasetName:"+datasetName);
        DataSet dataset = reqData.getDataSet(datasetName);

        if(dataset.getRemovedRowCount() == 0)
            bean = getBean(dataset, classType, 0);
        else
            bean = getDeletedBean(dataset, classType, 0);
        return bean;
    }

    public <T> void beansToDataset(PlatformData resData, List<T> beanList, Class<T> classType) throws Exception {
        Map<String, String> nameMap = new HashMap<String, String>();

       DataSetList datasetList = resData.getDataSetList();
       
        String datasetName = getDataSetName(classType);
        log.info("datasetName:"+datasetName);
        DataSet dataset = new DataSet(datasetName);
        
       datasetList.add(dataset);
       
        Field[] fields = classType.getDeclaredFields();
        for(Field field : fields)
            setColumnName(dataset, nameMap, field);
        for(T bean : beanList)
            setColumnValue(dataset, nameMap, bean);
    }


    public <T> void beanToDataset(PlatformData resData, T bean, Class<T> classType) throws Exception {
        Map<String, String> nameMap = new HashMap<String, String>();
        DataSetList datasetList = resData.getDataSetList();
       
        String datasetName = getDataSetName(classType);
        DataSet dataset = new DataSet(datasetName);

        datasetList.add(dataset);

        if(bean != null) {
        	
        	Field[] fields = classType.getDeclaredFields();
        	
            for(Field field : fields)
                setColumnName(dataset, nameMap, field);
           
            setColumnValue(dataset, nameMap, bean);
        }
    }

    public void mapToDataset(PlatformData resData, List<Map<String, Object>> mapList, String datasetName) throws Exception {
        DataSetList datasetList = resData.getDataSetList();
        DataSet dataset = new DataSet(datasetName);
        datasetList.add(dataset);

        for(String key : mapList.get(0).keySet()) {
            String columnName = key.toLowerCase();
            dataset.addColumn(columnName, DataTypes.STRING, 256);
        }

        int rowIndex = 0;
        for(Map<String, Object> map : mapList) {
            rowIndex = dataset.newRow();
            for(String key : map.keySet()) {
                Object columnValue = map.get(key);
                dataset.set(rowIndex, key.toLowerCase(), columnValue);
            }
        }
    }

    public List<Map<String, Object>> datasetToMap(PlatformData reqData, String datasetName) throws Exception {
        List<Map<String, Object>> mapList = new ArrayList<>();

        DataSet dataset = reqData.getDataSet(datasetName);
        int rowCount = dataset.getRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", dataset.getRowTypeName(rowIndex));

            for(int colIndex = 0; colIndex < dataset.getColumnCount(); colIndex++) {
                String key = dataset.getColumn(colIndex).getName();
                Object value = dataset.getObject(rowIndex, key);
                map.put(formattingToCamel(key), value);
            }
            mapList.add(map);
        }

        rowCount = dataset.getRemovedRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", dataset.getRowTypeName(rowIndex));

            for(int colIndex = 0; colIndex < dataset.getColumnCount(); colIndex++) {
                String key = dataset.getColumn(colIndex).getName();
                Object value = dataset.getObject(rowIndex, key);
                map.put(formattingToCamel(key), value);
            }
            mapList.add(map);
        }
        return mapList;
    }

    private <T> String getDataSetName(Class<T> classType) {
        if(classType.isAnnotationPresent(Dataset.class))
            return classType.getAnnotation(Dataset.class).name();
        else
            return "ds" + classType.getName().replace("Bean", "");
    }

    private String getColumnName(Method method) {
        String columnName = null;
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof ColumnName) {
                String annotaionName = ((ColumnName) annotation).name();
                columnName = annotaionName;
            }
        }
        if (annotations.length == 0)
            columnName = formattingToSnake(method.getName());
        return columnName;
    }

    private void setColumnName(DataSet dataset, Map<String, String> nameMap, Field field) {
        	ColumnName column = field.getAnnotation(ColumnName.class);
            Remove remove = field.getAnnotation(Remove.class);

            if(column != null) {
                dataset.addColumn(column.name(), getDataType(field));
                nameMap.put(column.name(), field.getName());
            } else if(column == null && remove == null) {
                String columnName = formattingToSnake(field.getName());
                dataset.addColumn(columnName, getDataType(field));
                nameMap.put(columnName, field.getName());
            }
        
    }

    private <T> void setColumnValue(DataSet dataset, Map<String, String> nameMap, T bean) throws Exception {
        int rowIndex = dataset.newRow();

        for(String columnName : nameMap.keySet()) {
            String fieldName = nameMap.get(columnName);
            Field value = bean.getClass().getDeclaredField(fieldName.trim());
            value.setAccessible(true);									// Priavte 로 되어있는 객체에 접근하기 위해서 사용
            dataset.set(rowIndex, columnName, value.get(bean));			// 값을 얻기 위해서 사용 
        }
    }

    private <T> T getBean(DataSet dataset, Class<T> classType, int rowIndex) throws Exception {
        T bean = classType.newInstance();
        Method[] methods = classType.getDeclaredMethods();
        Method statusMethod = classType.getMethod("setStatus", String.class);
        String rowType = null;
        
        switch(dataset.getRowTypeName(rowIndex)){
        	case "inserted" :
        		
        		rowType = "insert";
        		break;
        	case "updated" :
        		
        		rowType = "update";
        		break;
        }
        statusMethod.invoke(bean, rowType);
        for(Method method : methods) {
            if(method.getName().startsWith("set")) {
                String columnName = getColumnName(method);
               
                if(columnName != null) {
                    Object columnValue = dataset.getObject(rowIndex, columnName);
                  
                    if(columnValue != null)
                        method.invoke(bean, columnValue);
                }
            }
        }
        return bean;
    }
    private <T> T getDeletedBean(DataSet dataset, Class<T> classType, int rowIndex) throws Exception {
        T bean = classType.newInstance();
        Method[] methods = classType.getDeclaredMethods();
        Method statusMethod = classType.getMethod("setStatus", String.class);
        statusMethod.invoke(bean, "delete");
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String columnName = getColumnName(method);
                if (columnName != null) {
                    Object columnValue = dataset.getRemovedData(rowIndex, columnName);
                    if (columnValue != null)
                        method.invoke(bean, columnValue);
                }
            }
        }
        return bean;
    }
    private int getDataType(Field field) {
        Class<?> returnType = field.getType();
        if(returnType == Date.class)
            return DataTypes.DATE;
        else if(returnType == String.class)
            return DataTypes.STRING;
        else if(returnType == int.class || returnType == boolean.class)
            return DataTypes.INT;
        else if(returnType == BigDecimal.class)
            return DataTypes.BIG_DECIMAL;
        else if(returnType == double.class )
            return DataTypes.DOUBLE;
        else if(returnType == byte[].class)
            return DataTypes.BLOB;
        else
            return DataTypes.NULL;
    }

    private String formattingToSnake(String name) {
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";


        if(name.startsWith("set") || name.startsWith("get"))
            name = name.substring(3);
        // aA -> a_A
        name = name.replaceAll(regex, replacement);
        // return A_A
        return name.toUpperCase();

    }

    private String formattingToCamel(String name) {

        if(name.startsWith("set") || name.startsWith("get"))
            name = name.substring(3);
        String camel = WordUtils.capitalizeFully(name, new char[]{'_'}).replaceAll("_", "");
        return camel.substring(0, 1).toLowerCase() + camel.substring(1);
    }

}
