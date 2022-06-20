package kr.co.insaPrj5.common.util;

import net.sf.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

/*자바빈즈의 세터 게터의 자동화. 여기서는 세터만해줌*/

@Component
public class BeanCreator {

    public <T> T create(JSONObject jsonObject, Class<T> beanClass) { // json, slipBean.class
        T instance = null; //slipBean

        try {
            instance = beanClass.newInstance(); //slipBean 객체생성 

            for (Object key : jsonObject.keySet()) {  //jsonObject 는 slip의 arraylike  형식. 
            	System.out.println("		@@@ BeanCreator_Key: "+key+",		Value: "+jsonObject.get(key).toString());
                String firstUpperKey = key.toString().substring(0, 1).toUpperCase() + key.toString().substring(1); //SlipNo
                String methodName = "set" + firstUpperKey; // setSlipNo
                Method method = null;
                try {
                    method = beanClass.getMethod(methodName, String.class);
                } catch (NoSuchMethodException e) {
                    System.out.println("존재하지 않는 빈네임 : " + firstUpperKey);
                }

                if (method != null)
                    method.invoke(instance, jsonObject.get(key).toString()); 
            } //TO에 setting을 해준다.
            System.out.println();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return instance;
    }
    
    private BeanCreator() {
    }
}
