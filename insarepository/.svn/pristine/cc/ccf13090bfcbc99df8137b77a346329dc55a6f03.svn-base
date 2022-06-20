package kr.co.insaPrj5.hr.emp.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_licenseInfo")
@Table(name = "LICENSE_INFO")
public class LicenseInfoTO extends BaseTO{
	@Id
	private String empCode;
	private String licenseCode,licenseName, getDate, expireDate, licenseLevel, licenseCenter, issueNumber,status;

}
