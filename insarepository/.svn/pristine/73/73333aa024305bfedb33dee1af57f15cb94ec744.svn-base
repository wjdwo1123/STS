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
@Table(name = "FAMILY_INFO")
@Dataset(name="ds_familyInfo")
public class FamilyInfoTO extends BaseTO{
	@Id
	private String empCode;
	private String familyCode,familyName,relation,birthdate,liveTogether,status;

}
