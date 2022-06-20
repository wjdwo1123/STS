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
import kr.co.insaPrj5.hr.attd.to.DayAttdMgtTO;
import kr.co.insaPrj5.hr.salary.sf.SalaryServiceFacade;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;
import kr.co.insaPrj5.hr.salary.to.MonthExtSalTO;

@RestController
public class BaseSalaryController {
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	HashMap<String,Object> map = new HashMap<>();
	
	
	
	//급여기준관리 
	@RequestMapping("/salary/findBaseSalaryList.do")
	public HashMap<String,Object> findBaseSalaryList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
	
		
			ArrayList<BaseSalaryTO> baseSalaryList = salaryServiceFacade.findBaseSalaryList();
		
			datasetBeanMapper.beansToDataset(resData,baseSalaryList,BaseSalaryTO.class);
		return null;
	}
//변경확정 버튼 
	@RequestMapping("/salary/modifyBaseSalaryList.do")
	public HashMap<String,Object> modifyBaseSalaryList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		ArrayList<BaseSalaryTO> baseSalaryList = (ArrayList<BaseSalaryTO>) datasetBeanMapper.datasetToBeans(reqData,BaseSalaryTO.class);
			salaryServiceFacade.modifyBaseSalaryList(baseSalaryList);
			
		return null;
	}
}
