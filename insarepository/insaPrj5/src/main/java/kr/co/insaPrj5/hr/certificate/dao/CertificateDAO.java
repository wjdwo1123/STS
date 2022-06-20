package kr.co.insaPrj5.hr.certificate.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.hr.certificate.to.CertificateTO;
@Mapper
public interface CertificateDAO {
	
	//public void insertCertificateRequest(CertificateTO certificate);
	
	public ArrayList<CertificateTO>selectCertificateList(HashMap<String,Object> map);
	
	//public void deleteCertificate(CertificateTO certificate);
	
	public ArrayList<CertificateTO> selectCertificateListByAllDept(String requestDate);
	
	public ArrayList<CertificateTO> selectCertificateListByDept(HashMap<String,Object> map);
	
	public void updateCertificate(CertificateTO certificate);
	
}
