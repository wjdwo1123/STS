package kr.co.insaPrj5.base.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import kr.co.insaPrj5.base.sf.BaseServiceFacade;
import kr.co.insaPrj5.base.to.CodeTO;
import kr.co.insaPrj5.base.to.DetailCodeTO;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.emp.to.EmpTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

@RestController
public class CodeListController {
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
							
	
	//codeDialog 다이알로그 
	//코드조회 
	@RequestMapping("/base/detailCodeList.do")
	public ArrayList<DetailCodeTO> detailCodelist(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		System.out.println("☆★☆★detailCodeList컨트롤러진입☆★☆★");
		
		
		String code = reqData.getVariable("code").getString();
		ArrayList<DetailCodeTO> detailcodeto=baseServiceFacade.findDetailCodeList(code);
		
		datasetBeanMapper.beansToDataset(resData, detailcodeto, DetailCodeTO.class);
		
		return null;
	}
//codeRestDialog 다이알로그 
	@RequestMapping("/base/detailCodeListRest.do")
	public ArrayList<DetailCodeTO> detailCodelistRest(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		System.out.println("☆★☆★detailCodeList컨트롤러진입☆★☆★");
		
		String code1 = reqData.getVariable("code1").getString();
		String code2 = reqData.getVariable("code2").getString();
		String code3 = reqData.getVariable("code3").getString();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("code1", code1);
		map.put("code2", code2);
		map.put("code3", code3);
		ArrayList<DetailCodeTO> detailcodeto =baseServiceFacade.findDetailCodeListRest(map);
		
		datasetBeanMapper.beansToDataset(resData, detailcodeto, DetailCodeTO.class);
		
		return null;
	}
	
	//코드 조회 
	@GetMapping("/base/codeList.do")
	public ArrayList<CodeTO> codelist(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		ArrayList<CodeTO> codeList=baseServiceFacade.findCodeList();
		
		datasetBeanMapper.beansToDataset(resData, codeList, CodeTO.class);
		return null;
	}
}
