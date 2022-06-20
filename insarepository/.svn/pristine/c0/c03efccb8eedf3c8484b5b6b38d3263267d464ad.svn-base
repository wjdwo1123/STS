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

@RestController
public class DayAttdController{
	
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	private HashMap<String,Object> map = new HashMap<>();
	
	@Autowired
	
	private DatasetBeanMapper datasetBeanMapper;
	
	//조회하기
	
	@RequestMapping("/attendance/findDayAttdList.do")
	public HashMap<String,Object> findDayAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
			System.out.println("<<<<<  일근태조회  >>>>>>");
			String empCode = reqData.getVariable("empCode").getString();
			String applyDay = reqData.getVariable("applyDay").getString();

			
			map.put("empCode",empCode);
			map.put("applyDay",applyDay);
			ArrayList<DayAttdTO> dayAttdList = attdServiceFacade.findDayAttdList(map);

		
		datasetBeanMapper.beansToDataset(resData,dayAttdList,DayAttdTO.class);
		return null;
	}
	
	
	
//일근태기록하기 [출근 외출 귀사 퇴근]
	@RequestMapping("/attendance/dayAttendance.do")
	public HashMap<String,Object> registDayAttd(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		System.out.println("☆★☆★일근태기록☆★☆★");
		System.out.println(reqData);

		DayAttdTO dayAttd = datasetBeanMapper.datasetToBean(reqData, DayAttdTO.class);
		System.out.println("--------------------------일근태기록하기-------------------------------");
		System.out.println(dayAttd);
		
		map.clear();
		map.put("empCode",dayAttd.getEmpCode());
		map.put("attdTypeCode",dayAttd.getAttdTypeCode());
		map.put("attdTypeName",dayAttd.getAttdTypeName());
		map.put("applyDay",dayAttd.getApplyDay());
		map.put("time",dayAttd.getTime());
		attdServiceFacade.registDayAttd(map);
//		HashMap<String,Object> map2=attdServiceFacade.registDayAttd(map);
//		System.out.println(map2.get("errorCode"));
		//HashMap<String,Object> result = attdServiceFacade.registDayAttd(map);
//		System.out.println("여기도 안오나");
//		System.out.println("키셋?");
		//System.out.println("@맵"+result);
		
				
			return null;
	}
	//일근태삭제 
	@RequestMapping("/attendance/removeDayAttdList.do")
	public HashMap<String,Object> removeDayAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		System.out.println("<<<<< 일근태 삭제 >>>>>>");
		System.out.println(reqData);
			
		ArrayList<DayAttdTO> dayAttdList = (ArrayList<DayAttdTO>)datasetBeanMapper.datasetToBeans(reqData, DayAttdTO.class);
		System.out.println("<<<<< 일근태 삭제 2222222222222 >>>>>>");
	
			attdServiceFacade.removeDayAttdList(dayAttdList);

		return null;
	}
	
}
	
	
