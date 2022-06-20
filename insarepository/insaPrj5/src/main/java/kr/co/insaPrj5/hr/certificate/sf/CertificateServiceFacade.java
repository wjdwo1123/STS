package kr.co.insaPrj5.hr.certificate.sf;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.insaPrj5.hr.certificate.to.CertificateBean;
import kr.co.insaPrj5.hr.certificate.to.CertificateTO;

public interface CertificateServiceFacade {
	
	public void registRequest(CertificateBean certificate);	
	public ArrayList<CertificateTO> findCertificateList(HashMap<String,Object> map);
	public void removeCertificateRequest(ArrayList<CertificateBean> certificateList);
	public ArrayList<CertificateTO> findCertificateListByDept(HashMap<String,Object> map);
	public void modifyCertificateList(ArrayList<CertificateTO> certificateList);
	
}
