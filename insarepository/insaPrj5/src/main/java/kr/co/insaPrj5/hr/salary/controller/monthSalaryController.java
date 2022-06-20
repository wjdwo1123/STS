package kr.co.insaPrj5.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.tobesoft.xplatform.data.PlatformData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;
import kr.co.insaPrj5.hr.salary.sf.SalaryServiceFacade;
import kr.co.insaPrj5.hr.salary.to.MonthDeductionTO;
import kr.co.insaPrj5.hr.salary.to.MonthExtSalTO;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryBean;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryTO;
import kr.co.insaPrj5.hr.salary.to.YearSalaryBean;

@RestController
public class monthSalaryController{
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	HashMap<String,Object> map = new HashMap<>();

	
	//월급여조회
	@RequestMapping("/salary/findMonthSalary.do")
	public HashMap<String,Object> findMonthSalary(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		System.out.println("<<<<<  월급여조회  >>>>>>");
		String applyYearMonth = reqData.getVariable("applyYearMonth").getString();
		String empCode = reqData.getVariable("empCode").getString();
		
		HashMap<String,Object> result=new HashMap<>();
		
		map.clear();
		map.put("applyYearMonth",applyYearMonth);
		map.put("empCode",empCode);
		result = salaryServiceFacade.findMonthSalary(map);
		System.out.println("@@@@@@@@@@@@@@"+result.get("result"));
		
		MonthSalaryTO monthSalaryTO=(MonthSalaryTO)result.get("result");
		List<MonthDeductionTO> monthDeductionList=monthSalaryTO.getMonthDeductionList();
		List<MonthExtSalTO> monthExtSalList=monthSalaryTO.getMonthExtSalList();
		
		datasetBeanMapper.beanToDataset(resData,monthSalaryTO,MonthSalaryTO.class);
		datasetBeanMapper.beansToDataset(resData,monthDeductionList,MonthDeductionTO.class);
		datasetBeanMapper.beansToDataset(resData,monthExtSalList,MonthExtSalTO.class);
	     
	      


		return null;
	}

	//연급여버튼
	@RequestMapping("/salary/findYearSalary.do")
	public HashMap<String,Object> findYearSalary(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		HashMap<String,Object> result = null;
		
		String empCode = reqData.getVariable("empCode").getString();
		String applyYear = reqData.getVariable("applyYear").getString();
		
		//YearSalaryBean
		

			map.clear();
			//String applyYearMonth = applyYear+"%";
			String applyYearMonth = applyYear;
			map.put("applyYearMonth",applyYearMonth);
			map.put("empCode",empCode);
			result = salaryServiceFacade.findYearSalary(map);
			System.out.println("@@@@@@@@@@@@@@"+result.get("result"));
			
			List<MonthSalaryTO> monthSalaryTO=(List<MonthSalaryTO>)result.get("result");
			datasetBeanMapper.beansToDataset(resData,monthSalaryTO,MonthSalaryTO.class);

		return null;
	}

	
	//마감,마감취소 버튼
	@RequestMapping("/salary/modifyMonthSalary.do")
	public HashMap<String,Object> modifyMonthSalary(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
			System.out.println("<<<<<  마감 마감취소컨트롤러  >>>>>>");
			System.out.println(reqData);
			MonthSalaryBean monthSalary = datasetBeanMapper.datasetToBean(reqData, MonthSalaryBean.class);
			
	 

			salaryServiceFacade.modifyMonthSalary(monthSalary);
 
		return null;
	}
}