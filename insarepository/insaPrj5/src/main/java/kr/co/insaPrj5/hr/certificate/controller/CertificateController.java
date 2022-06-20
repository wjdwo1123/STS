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
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;
import kr.co.insaPrj5.hr.certificate.sf.CertificateServiceFacade;
import kr.co.insaPrj5.hr.certificate.to.CertificateBean;
import kr.co.insaPrj5.hr.certificate.to.CertificateTO;

@RestController
public class CertificateController{
	@Autowired
	private CertificateServiceFacade certificateServiceFacade;	
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	HashMap<String,Object> map = new HashMap<>();
	
	
	//재직증명서 신청
	@RequestMapping("/certificate/registRequest.do")
	public HashMap<String,Object> registRequest(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
			System.out.println("<<<<<  재직증명서신청   >>>>>>");
			System.out.println("=============================="+reqData);
			CertificateBean certificate = datasetBeanMapper.datasetToBean(reqData, CertificateBean.class);
			System.out.println("재직증명서@@@@@@@@@@@"+certificate.toString());
			certificateServiceFacade.registRequest(certificate);
 
		return null;
	}
	
	
	//재직증명서 조회
	@RequestMapping("/certificate/findCertificateList.do")
	public HashMap<String,Object> findCertificateList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("<<<<<  재직증명서조회  >>>>>>");
		String empCode = reqData.getVariable("empCode").getString();
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();
		
			map.clear();
			map.put("empCode",empCode);
			map.put("startDate",startDate);
			map.put("endDate",endDate);
			ArrayList<CertificateTO> certificateList = certificateServiceFacade.findCertificateList(map);
			datasetBeanMapper.beansToDataset(resData,certificateList,CertificateTO.class);
			
		return null;
	}
 //신청취소버튼 
	@RequestMapping("/certificate/removeCertificateRequest.do")
	public HashMap<String,Object> removeCertificateRequest(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		ArrayList<CertificateBean> certificateList = (ArrayList<CertificateBean>)datasetBeanMapper.datasetToBeans(reqData, CertificateBean.class);
		

			certificateServiceFacade.removeCertificateRequest(certificateList);

		return null;
	}
}
