package kr.co.insaPrj5.hr.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.VariableList;

import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.emp.repository.EmptestRepository;
import kr.co.insaPrj5.hr.emp.sf.EmpServiceFacade;
import kr.co.insaPrj5.hr.emp.to.AuthGroupTO;
import kr.co.insaPrj5.hr.emp.to.AuthMenuTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.emp.to.WorkInfoTO;
import kr.co.insaPrj5.hr.emp.to.testEmpTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmpTestController {
	@Autowired
	private EmpServiceFacade empServiceFacade;	
	@Autowired
	private EmptestRepository emptestRepository;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	  //사원등록
	  
	
	  
 
	  
	  @RequestMapping("emp/findAuthMenu.do") 
	  public ArrayList<AuthMenuTO> findAuthMenu(@RequestAttribute("variableList") VariableList varList, 
			  								  @RequestAttribute("resData") PlatformData resData) throws
	  Exception { 
		  System.out.println("<<<<< findAuthMenu등록시작   >>>>>>");
		  		
		  String dptCode =varList.getString("dptCode");

		  log.info("dptCode 일세!:"+ dptCode);
		  
		   ArrayList<AuthMenuTO> authEmp =empServiceFacade.selectAuthMenu(dptCode);
		   datasetBeanMapper.beansToDataset(resData, authEmp, AuthMenuTO.class);
		 
	  return null;
}
	  
	  
	  @RequestMapping("emp/findAuthGroup.do") 
	  public ArrayList<AuthGroupTO> findAuthGroup(@RequestAttribute("variableList") VariableList varList, 
			  								      @RequestAttribute("resData") PlatformData resData) throws
	  Exception { 
		  System.out.println("<<<<< test그룹시작   >>>>>>");
		  String dptCode =varList.getString("dptCode");
		  log.info("empCode 일세!:"+ dptCode);
		  ArrayList<AuthGroupTO> authGroup=empServiceFacade.selectAuthGroup(dptCode);
		
		  datasetBeanMapper.beansToDataset(resData, authGroup, AuthGroupTO.class);
		  
	  return null;
}
	  
	  @RequestMapping("emp/modifyAuthGroup.do") 
	  public ArrayList<AuthGroupTO> modifyAuthGroup(@RequestAttribute("reqData") PlatformData reqData, 
			  									    @RequestAttribute("resData") PlatformData resData) throws
	  Exception { 
		  
	
		  EmpTO emp = datasetBeanMapper.datasetToBean(reqData, EmpTO.class);
		  
		  ArrayList<AuthGroupTO> testEmpAuth = (ArrayList<AuthGroupTO>) datasetBeanMapper.datasetToBeans(reqData, AuthGroupTO.class);
		  
		  emp.setAuthGroupList(testEmpAuth);
		  
		  empServiceFacade.modifyGroup(emp);

		log.info("workinfo 일세!:"+ testEmpAuth);
		log.info("testEmpTO 일세!:"+ emp);
		
		  
	  return null;
}
	  
	  @RequestMapping("emp/modiAuthMenu.do") 
	  public ArrayList<AuthGroupTO> modiAuthMenu(@RequestAttribute("reqData") PlatformData reqData,
			  								      @RequestAttribute("resData") PlatformData resData) throws
	  Exception { 
		  System.out.println("<<<<< modify그룹시작   >>>>>>");
		  ArrayList<AuthMenuTO> authMenu = (ArrayList<AuthMenuTO>) datasetBeanMapper.datasetToBeans(reqData, AuthMenuTO.class);
		  
		  empServiceFacade.modiAuthMenu(authMenu);
		  log.info("empCode 일세!:"+ authMenu);
		  //datasetBeanMapper.beansToDataset(resData, authGroup, AuthGroupTO.class);
		  
	  return null;
}

}
