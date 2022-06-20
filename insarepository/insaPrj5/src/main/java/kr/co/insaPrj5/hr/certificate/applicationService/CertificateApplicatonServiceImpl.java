package kr.co.insaPrj5.hr.certificate.applicationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import kr.co.insaPrj5.hr.certificate.dao.CertificateDAO;
import kr.co.insaPrj5.hr.certificate.repository.CertificateBeanRepository;
import kr.co.insaPrj5.hr.certificate.repository.CertificateRepository;
import kr.co.insaPrj5.hr.certificate.to.CertificateBean;
import kr.co.insaPrj5.hr.certificate.to.CertificateTO;

@Component
public class CertificateApplicatonServiceImpl implements CertificateApplicationService{
	@Autowired
	private CertificateDAO certificateDAO ;  

	@Autowired
	private CertificateBeanRepository certificateBeanRepository ; 
	
	
	//재직 신청 
	@Override
	public void registRequest(CertificateBean certificate) {		
	
		certificateBeanRepository.save(certificate);
		//certificateDAO.insertCertificateRequest(certificate);  
	} 
	
	
	@Override
	public ArrayList<CertificateTO> findCertificateList(HashMap<String,Object> map) {
		
	      System.out.println("===============================================================================================");
	      System.out.println("value:: "+map.get("empCode"));
	      System.out.println("value:: "+map.get("startDate"));
	      System.out.println("value:: "+map.get("endDate"));
	    
		ArrayList<CertificateTO> certificateList=certificateDAO.selectCertificateList(map);
		return certificateList;
	}
	
	
	@Override
	public void removeCertificateRequest(ArrayList<CertificateBean> certificateList) {
		 System.out.println("===============================================================================================");
		 System.out.println(certificateList); 
		 //for(CertificateBean bean: certificateList)
		 certificateBeanRepository.deleteAll(certificateList);
		//certificateDAO.deleteCertificate(certificate);
		 
	}
	
	
	@Override
	public ArrayList<CertificateTO> findCertificateListByDept(HashMap<String,Object> map) {
		ArrayList<CertificateTO> certificateList = null;

		if(map.get("deptName").equals("모든부서")) {
			certificateList = certificateDAO.selectCertificateListByAllDept((String) map.get("startDate"));
		}else {
			certificateList = certificateDAO.selectCertificateListByDept(map);
		}
		return certificateList;
	}
	
	//인사관리 ->재직증명서관리 -> 확정 버튼
	@Transactional
	@Override
	public void modifyCertificateList(ArrayList<CertificateTO> certificateList) {
		
//		List<CertificateBean> list=new ArrayList<CertificateBean>();
//
//		CertificateBean CertificateUpdate = new CertificateBean();
//		for(CertificateTO certificate : certificateList) {
//			CertificateUpdate.setEmpCode(certificate.getEmpCode()); 
//			CertificateUpdate.setRejectCause(certificate.getRejectCause());  
//			CertificateUpdate.setRequestDate(certificate.getRequestDate());
//			CertificateUpdate.setApprovalStatus(certificate.getApprovalStatus());
//			list.add(CertificateUpdate);
//			System.out.println("===================================================================");
//			System.out.println(CertificateUpdate.toString());
//			System.out.println("===================================================================");
//			certificateBeanRepository.saveAll(list);		
//		}
 
		for(CertificateTO certificate:certificateList) {
			certificateDAO.updateCertificate(certificate);
		}
	}
	
}
