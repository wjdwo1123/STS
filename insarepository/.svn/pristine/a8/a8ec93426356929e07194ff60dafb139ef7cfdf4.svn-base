package kr.co.insaPrj5.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tobesoft.xplatform.data.PlatformData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.salary.sf.SalaryServiceFacade;
import kr.co.insaPrj5.hr.salary.to.BaseDeductionTO;
import kr.co.insaPrj5.hr.salary.to.BaseExtSalTO;

@RestController
public class BaseExtSalController{
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	HashMap<String,Object> map = new HashMap<>();
	
	
	//초과수당관리 로딩 
	@RequestMapping("/salary/findBaseExtSalList.do")
	public HashMap<String,Object> findBaseExtSalList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		
	
			ArrayList<BaseExtSalTO> baseExtSalList = salaryServiceFacade.findBaseExtSalList();
			
			datasetBeanMapper.beansToDataset(resData,baseExtSalList,BaseExtSalTO.class);
			
		return null;
	}

	//변경확정버튼 
	@RequestMapping("/salary/modifyBaseExtSalList.do")
	public HashMap<String,Object> modifyBaseExtSalList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		
		ArrayList<BaseExtSalTO> baseExtSalList = (ArrayList<BaseExtSalTO>) datasetBeanMapper.datasetToBeans(reqData, BaseExtSalTO.class);

		salaryServiceFacade.modifyBaseExtSalList(baseExtSalList);
	 
		return null;
	}
}
