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
import kr.co.insaPrj5.hr.attd.to.MonthAttdMgtTO;

@RestController
public class MonthAttdManageController{
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	HashMap<String,Object> map = new HashMap<>();
	
	
	//일근태 [전체마감하기] 버튼  프로시저 
	//월근태 [조회하기]  프로시저
	@RequestMapping("/attendance/findMonthAttdMgtList.do")
	public HashMap<String,Object> findMonthAttdMgtList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		String applyYearMonth = reqData.getVariable("applyYearMonth").getString();
		
		HashMap<String, Object> result = null;
		map.put("applyYearMonth",applyYearMonth);
		result = attdServiceFacade.findMonthAttdMgtList(map);
		List<MonthAttdMgtTO> Monthresult=(List<MonthAttdMgtTO>) result.get("result");
		System.out.println("????????????????????????????????????");
		datasetBeanMapper.beansToDataset(resData, Monthresult,MonthAttdMgtTO.class);
 			
		return null;
	} 
	//월근태 마감 , 마감취소 
	@RequestMapping("/attendance/modifyMonthAttdList.do")
	public HashMap<String,Object> modifyMonthAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		ArrayList<MonthAttdMgtTO> monthAttdMgtList = (ArrayList<MonthAttdMgtTO>) datasetBeanMapper.datasetToBeans(reqData,MonthAttdMgtTO.class);
		
			attdServiceFacade.modifyMonthAttdMgtList(monthAttdMgtList);
			 
		return null;
	} 

}