package kr.co.insaPrj5.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobesoft.xplatform.data.PlatformData;

import kr.co.insaPrj5.base.sf.BaseServiceFacade;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;

@RestController
public class PositionListController{
	@Autowired
	BaseServiceFacade baseServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
//직급관리목록 로딩시
	@RequestMapping("base/findPositionList.do")
	public Map<String, Object> findPositionList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		ArrayList<BaseSalaryTO> positionList=baseServiceFacade.findPositionList();						
		datasetBeanMapper.beansToDataset(resData, positionList, BaseSalaryTO.class);

		return null;
	}
	
	//직급관리목록 저장 
	@RequestMapping("base/modifyPosition.do")
	public void modifyPosition(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
				
		
		ArrayList<BaseSalaryTO> positionList =(ArrayList<BaseSalaryTO>) datasetBeanMapper.datasetToBeans(reqData,BaseSalaryTO.class);

		baseServiceFacade.modifyPosition(positionList);
	}	

}