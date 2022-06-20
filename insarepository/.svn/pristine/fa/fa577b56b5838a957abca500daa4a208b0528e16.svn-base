package kr.co.insaPrj5.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobesoft.xplatform.data.PlatformData;

import kr.co.insaPrj5.base.sf.BaseServiceFacade;
import kr.co.insaPrj5.base.to.HolidayTO;
import kr.co.insaPrj5.base.to.WeekDayCountBean;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;
import kr.co.insaPrj5.hr.salary.to.BaseDeductionTO;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayListController {
	@Autowired
	private BaseServiceFacade baseServiceFacade ;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	private ModelMap modelMap = new ModelMap();
	
	
	//휴일 로딩
	@RequestMapping("/base/findHolidayList.do")
	public ModelMap findHolidayList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		ArrayList<HolidayTO> holidayList = baseServiceFacade.findHolidayList();
		
		datasetBeanMapper.beansToDataset(resData,holidayList,HolidayTO.class);
		
		return null;
	}
	
	
//일수 조회
	@SuppressWarnings("null")
	@RequestMapping("/base/findWeekDayCount.do")
	public ModelMap findWeekDayCount(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
			
			System.out.println("<<<<<  일수조회  >>>>>>");
			
			String startDate = reqData.getVariable("startDate").getString();
			String endDate = reqData.getVariable("endDate").getString();
		
			
			Map<String, Object> map = new HashMap<>();
		
			map.put("startDate",startDate);
			map.put("endDate",endDate);
			String result = baseServiceFacade.findWeekDayCount(map);
			WeekDayCountBean weekdayCount = new WeekDayCountBean();
			weekdayCount.setWeekdayCount(result);
			System.out.println("%%%%%%%%%%%%%%%%%%"+weekdayCount.getWeekdayCount());
			
			datasetBeanMapper.beanToDataset(resData,weekdayCount,WeekDayCountBean.class);
		
		
		return null;
	}
//휴일 저장 
	@RequestMapping("/base/regitCodeList.do")
	public void regitCodeList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		ArrayList<HolidayTO> holydayList = (ArrayList<HolidayTO>) datasetBeanMapper.datasetToBeans(reqData, HolidayTO.class);
		
		baseServiceFacade.registCodeList(holydayList);
	}
}

