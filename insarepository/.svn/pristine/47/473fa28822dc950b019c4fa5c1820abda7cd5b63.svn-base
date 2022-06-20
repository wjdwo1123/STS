package kr.co.insaPrj5.hr.certificate.to;
 
import java.io.Serializable;

import javax.persistence.Entity;
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
@Dataset(name="ds_employment")
@IdClass(value=CertificateTO.class)
public class CertificateTO implements Serializable{
	@Id
	private String empCode;

	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private String requestDate;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private String useDate;
	private String detailCodeName;
	private String usageCode;
	private String empName;
	private String deptName;
	private String usageName;
	private String etc;
	private String approvalStatus;
	private String rejectCause;
	private String status;

}
 

 