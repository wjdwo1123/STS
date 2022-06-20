package kr.co.insaPrj5.hr.emp.to;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
import java.util.List;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;
 

@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "EMP")
@Dataset(name="gds_emp")
@Data
public class EmpTO extends BaseTO{

    @Id
	private String empCode;
    
	private String empName,birthdate,gender,mobileNumber,address,deptName,
	detailAddress,postNumber,email,lastSchool,imgExtend,deptCode,position,authority;
	
	@JoinColumn(name="empCode")
	@OneToMany 
	private List<WorkInfoTO> workInfoList;
	
	@JoinColumn(name="empCode")
	@OneToMany 
	private List<CareerInfoTO> careerInfoList;
	
	@JoinColumn(name="empCode")
	@OneToMany 
	private List<EducationInfoTO> educationInfoList;
	
	@JoinColumn(name="empCode")
	@OneToMany 
	private List<LicenseInfoTO> licenseInfoList;
	
	@JoinColumn(name="empCode")
	@OneToMany
	private List<FamilyInfoTO> familyInfoList;
 
	 @JoinColumn(name="empCode")
	 @OneToMany 
	 private List<AuthGroupTO> authGroupList;

}

 