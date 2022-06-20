package kr.co.insaPrj5.hr.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.emp.sf.EmpServiceFacade;
import kr.co.insaPrj5.hr.emp.to.AuthGroupTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmpListController {
	@Autowired
	private EmpServiceFacade empServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	
	//부서조회 
	@RequestMapping("/emp/list.do")
	public HashMap<String,Object> emplist(@RequestAttribute("reqData") PlatformData reqData,
                                          @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		   System.out.println("☆★☆★로그인컨트롤러진입☆★☆★emplist");
		   String value = reqData.getVariable("value").getString();
	
			ArrayList<EmpTO> list = (ArrayList<EmpTO>) empServiceFacade.findEmpList(value);			
			log.info("list :"+list);
			datasetBeanMapper.beansToDataset(resData, list, EmpTO.class);
	 
		return null;
	}
	
	
	//부서조회 
	@RequestMapping("/emp/listGroup.do")
	public HashMap<String,Object> listGroup(@RequestAttribute("reqData") PlatformData reqData,
                                          @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		   System.out.println("☆★☆★로그인컨트롤러진입☆★☆★listGroup");
		   String deptName = reqData.getVariable("value").getString();
	
			ArrayList<DeptTO> list = (ArrayList<DeptTO>) empServiceFacade.findGroupList(deptName);			
			log.info("list :"+list);
			datasetBeanMapper.beansToDataset(resData, list, DeptTO.class);
	 
		return null;
	}
	
}