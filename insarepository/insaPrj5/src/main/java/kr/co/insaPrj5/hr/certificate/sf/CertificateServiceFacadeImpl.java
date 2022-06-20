package kr.co.insaPrj5.hr.certificate.sf;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.insaPrj5.hr.certificate.applicationService.CertificateApplicationService;
import kr.co.insaPrj5.hr.certificate.to.CertificateBean;
import kr.co.insaPrj5.hr.certificate.to.CertificateTO;

@Service
public class CertificateServiceFacadeImpl implements CertificateServiceFacade{
	@Autowired
	private CertificateApplicationService certificateApplicationService;

	public void registRequest(CertificateBean certificate) {
		certificateApplicationService.registRequest(certificate);	
	}
	@Override
	public ArrayList<CertificateTO> findCertificateList(HashMap<String,Object> map) {

		ArrayList<CertificateTO> certificateList=certificateApplicationService.findCertificateList(map);
		return certificateList;

	}
	@Override
	public void removeCertificateRequest(ArrayList<CertificateBean> certificateList) {

		certificateApplicationService.removeCertificateRequest(certificateList);

	}
	@Override
	public ArrayList<CertificateTO> findCertificateListByDept(HashMap<String,Object> map) {

		ArrayList<CertificateTO> certificateList=certificateApplicationService.findCertificateListByDept(map);
		return certificateList;

	}
	@Override
	public void modifyCertificateList(ArrayList<CertificateTO> certificateList) {

		certificateApplicationService.modifyCertificateList(certificateList);

	}	
}
