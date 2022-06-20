package kr.co.insaPrj5.hr.emp.controller;

import java.util.HashMap;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tobesoft.xplatform.data.PlatformData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.insaPrj5.base.to.WeekDayCountBean;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;
import kr.co.insaPrj5.hr.emp.sf.EmpServiceFacade;
import kr.co.insaPrj5.hr.emp.to.EmpBean;
import kr.co.insaPrj5.hr.emp.to.EmpTO;

@Controller
public class EmpRegistController{
	@Autowired
	private EmpServiceFacade empServiceFacade;	
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	HashMap<String,Object> map = new HashMap<>();
	
	

	//사원등록 
	@RequestMapping("emp/registEmployee.do")
	public HashMap<String,Object> registEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("<<<<< 사원등록    >>>>>>");
		PlatformData reqData=(PlatformData) request.getAttribute("reqData");
		EmpTO emp = datasetBeanMapper.datasetToBean(reqData, EmpTO.class);
		System.out.println(emp.toString());
		
		
		
			empServiceFacade.registEmployee(emp);		
 


		return null;
	}
	
	
	//사번생성 
		@RequestMapping("emp/findLastEmpCode.do")
		public HashMap<String,Object> findLastEmpCode(HttpServletRequest request, HttpServletResponse response) throws Exception  {
			PlatformData resData=(PlatformData) request.getAttribute("resData");
			EmpTO lastEmpCode= new EmpTO();
				
			String result = empServiceFacade.findLastEmpCode();  //lastEmpCode
			lastEmpCode.setEmpCode(result);
			System.out.println("$%&#^#!#~!##@#!@^$*%*%^*^%@#@#@!################"+lastEmpCode.getEmpCode());
				
			datasetBeanMapper.beanToDataset(resData, lastEmpCode, EmpTO.class);
				
			return null;
		}
		
	}
