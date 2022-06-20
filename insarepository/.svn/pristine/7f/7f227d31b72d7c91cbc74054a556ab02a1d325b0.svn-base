package kr.co.insaPrj5.hr.attd.controller;

import java.util.ArrayList;
import java.util.HashMap;

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
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;
 
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;

@RestController
public class RestAttdController {
	@Autowired
	private AttdServiceFacade attdServiceFacade ;
	HashMap<String,Object> map = new HashMap<>();

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	//근태외 신청버튼 [공외출 사외출 조퇴]
	//휴가 신청버튼 [경조사,예비군,연차,오전반차,오후반차]
	@RequestMapping("/attendance/registRestAttd.do")
	public void registRestAttd(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
			
			System.out.println("<<<<<  근태외 신청[공외출 사외출 조퇴]   >>>>>>");
		
			RestAttdTO restAttd = datasetBeanMapper.datasetToBean(reqData, RestAttdTO.class);
			System.out.println("///////////////////////////////////////////");
			attdServiceFacade.registRestAttd(restAttd);		 
	}

	
 
	//근태외 조회 
	@RequestMapping("/attendance/findRestAttdList.do")
	public HashMap<String,Object> findRestAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("<<<<<  근태외조회  >>>>>>");
		String empCode = reqData.getVariable("empCode").getString();
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();
		String code = reqData.getVariable("code").getString();
		
		 
			map.clear();
			map.put("empCode",empCode);
			map.put("startDate",startDate);
			map.put("endDate",endDate);
			map.put("code",code);
			ArrayList<RestAttdTO> restAttdList = attdServiceFacade.findRestAttdList(map);
			 System.out.println(restAttdList.toString());
			datasetBeanMapper.beansToDataset(resData,restAttdList,RestAttdTO.class);
		return null;
	}
	
	
	
	
	//근태외 삭제 
	@RequestMapping("/attendance/removeRestAttdList.do")
	public HashMap<String,Object> removeRestAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		ArrayList<RestAttdTO> restAttdList = (ArrayList<RestAttdTO>)datasetBeanMapper.datasetToBeans(reqData,RestAttdTO.class);
 
			attdServiceFacade.removeRestAttdList(restAttdList);
			
		return null;
 

	}
}
