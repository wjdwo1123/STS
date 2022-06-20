package kr.co.insaPrj5.hr.emp.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="AUTHCHECK")
@Dataset(name="ds_admin")
@Table(name = "AUTHCHECK")
@EqualsAndHashCode(callSuper=false)
public class AuthGroupTO extends BaseTO {

	@Id
	private String deptCode;
	
	 private String  groupCode,groupName,groupAlo,empCode;


	
}
