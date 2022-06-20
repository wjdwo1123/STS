package kr.co.insaPrj5.hr.attd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tobesoft.xplatform.data.PlatformData;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.attd.sf.AttdServiceFacade;
import kr.co.insaPrj5.hr.attd.to.DayAttdMgtTO;
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;

@RestController
public class DayAttdManageController{
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	HashMap<String,Object> map = new HashMap<>();
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	//일근태조회
	@RequestMapping("/attendance/findDayAttdMgtList.do")
	public HashMap<String,Object> findDayAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		String applyDay = reqData.getVariable("applyDay").getString();
		
		HashMap<String, Object> result = null;	
			map.clear();
			map.put("applyDay",applyDay);
			result = attdServiceFacade.findDayAttdMgtList(map);
			
			List<DayAttdMgtTO> datAttdMgtList = (List<DayAttdMgtTO>) result.get("result");

	
			datasetBeanMapper.beansToDataset(resData, datAttdMgtList,DayAttdMgtTO.class);
			
		return null;
	}
	
	
	//일근태마감 Y
	@RequestMapping("/attendance/modifyDayAttdList.do")
	public HashMap<String,Object> modifyDayAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
			System.out.println("----------------------------일근태마감 Y----------------------------");
			System.out.println(reqData.getVariableList());
		ArrayList<DayAttdMgtTO> dayAttdMgtList = (ArrayList<DayAttdMgtTO>) datasetBeanMapper.datasetToBeans(reqData, DayAttdMgtTO.class);
		
		System.out.println("-----222222222222222222222222222222222---------------");
			attdServiceFacade.modifyDayAttdMgtList(dayAttdMgtList);
			
		return null;
	}

}

