package kr.co.insaPrj5.hr.certificate.controller;

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
import kr.co.insaPrj5.hr.certificate.sf.CertificateServiceFacade;
import kr.co.insaPrj5.hr.certificate.to.CertificateTO;

@RestController
public class CertificateApprovalController{
	@Autowired
	private CertificateServiceFacade certificateServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	HashMap<String,Object> map = new HashMap<>();

	
	//재직증명서관리 조회
	@RequestMapping("/certificate/findCertificateListByDept.do")
	public HashMap<String,Object> findCertificateListByDept(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("<<<<<  재직증명서조회  >>>>>>");
		String deptName = reqData.getVariable("deptName").getString();
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();
		
	 
			map.clear();
			map.put("deptName",deptName);
			map.put("startDate",startDate);
			map.put("endDate",endDate);
			System.out.println("맵1111 : "+map);
			ArrayList<CertificateTO> certificateList = certificateServiceFacade.findCertificateListByDept(map);
			datasetBeanMapper.beansToDataset(resData,certificateList,CertificateTO.class);
			
		return null;
	}

	
	//재직증명서 관리 조회 
	
	@RequestMapping("/certificate/modifyCertificateList.do")
	public HashMap<String,Object> modifyCertificateList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("<<<<<  재직증명서확정    >>>>>>");
		ArrayList<CertificateTO> certificateList=(ArrayList<CertificateTO>) datasetBeanMapper.datasetToBeans(reqData,CertificateTO.class);
		
		
			certificateServiceFacade.modifyCertificateList(certificateList);
		
		return null;
	}
}
