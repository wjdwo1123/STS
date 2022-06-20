package kr.co.insaPrj5.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.salary.sf.SalaryServiceFacade;
import kr.co.insaPrj5.hr.salary.to.BaseDeductionTO;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryBean;

@RestController
public class BaseDeductionController {
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	HashMap<String,Object> map = new HashMap<>();

	
	//공제기준관리 로딩시 
	@RequestMapping("/salary/findBaseDeductionList.do")
	public HashMap<String,Object> findBaseDeductionList(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		PlatformData resData=(PlatformData) request.getAttribute("resData");
		
			ArrayList<BaseDeductionTO> baseDeductionList = salaryServiceFacade.findBaseDeductionList();
			
			datasetBeanMapper.beansToDataset(resData,baseDeductionList,BaseDeductionTO.class);
			
		return null;
	}

	//공제기준관리 -> 공제항목코드 추가+1
	@RequestMapping("/salary/findLastBaseDeduction.do")
	public HashMap<String,Object> findLastBaseDeduction(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		PlatformData resData=(PlatformData) request.getAttribute("resData");
		
		String result = salaryServiceFacade.findLastBaseDeduction();  //lastDeductionCode
	
		BaseDeductionTO deductionCode= new BaseDeductionTO();
		deductionCode.setDeductionCode(result);
		System.out.println("$%&#^#!#~!##@#!@^$*%*%^*^%@#@#@!################"+deductionCode.getDeductionCode());
			
		datasetBeanMapper.beanToDataset(resData, deductionCode, BaseDeductionTO.class);
			
		return null;
	}	
	
	//변경 확정
	@RequestMapping("/salary/batchBaseDeductionProcess.do")
	public HashMap<String,Object> batchBaseDeductionProcess(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		ArrayList<BaseDeductionTO> baseDeductionList = (ArrayList<BaseDeductionTO>) datasetBeanMapper.datasetToBeans(reqData, BaseDeductionTO.class);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(baseDeductionList.toString());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		salaryServiceFacade.batchBaseDeductionProcess(baseDeductionList);
			 
		return null;
	}
}