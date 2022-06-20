package kr.co.insaPrj5.hr.certificate.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
 

@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "CERTIFICATE")
@Dataset(name="ds_CertificateBean")
@IdClass(value=CertificatePK.class)
public class CertificateBean implements Serializable{
	
	@Id
	private String empCode;

	@Id
	private String requestDate;
	
	private String useDate;
	
	private String usageCode;
	
	private String etc;
	
	private String approvalStatus;
	
	private String rejectCause;
	
	private String status;
	
}
 

 