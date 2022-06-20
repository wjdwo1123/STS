package kr.co.insaPrj5.hr.attd.controller;

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
import kr.co.insaPrj5.hr.attd.sf.AttdServiceFacade;
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;

@RestController
public class AttdApplovalController{
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	//근태외신청목록조회 
	@RequestMapping("/attendance/attendanceApploval.do")
	public HashMap<String,Object> findRestAttdListByDept(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
			System.out.println("<<<<<  근태외신청목록조회   >>>>>>");
			String startDate = reqData.getVariable("startDate").getString();
			String endDate = reqData.getVariable("endDate").getString();
			String deptName = reqData.getVariable("deptName").getString();
		
		
			HashMap<String,Object> map = new HashMap<>();
		 
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("deptName", deptName);
			ArrayList<RestAttdTO> restAttdList = attdServiceFacade.findRestAttdListByDept(map);
			System.out.println(restAttdList.toString());
  
				
			datasetBeanMapper.beansToDataset(resData,restAttdList,RestAttdTO.class);
		return null;
	}
	
	//근태외신청 확정  
	@RequestMapping("/attendance/modifyRestAttdList.do")
	public HashMap<String,Object> modifyRestAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		System.out.println("☆★☆★근태외신청 확정☆★☆★");
		ArrayList<RestAttdTO> restAttdList = (ArrayList<RestAttdTO>)datasetBeanMapper.datasetToBeans(reqData, RestAttdTO.class);
		attdServiceFacade.modifyRestAttdList(restAttdList);
		return null;
	}
}