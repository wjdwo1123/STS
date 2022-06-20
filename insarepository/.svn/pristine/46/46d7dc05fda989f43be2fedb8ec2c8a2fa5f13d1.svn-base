package kr.co.insaPrj5.hr.emp.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity//(name="AUTH_MENU")
@Dataset(name="ds_scMenu")
@Table(name = "AUTH_MENU")
@EqualsAndHashCode(callSuper=false)
public class AuthMenuTO extends BaseTO {

	@Id
	private String menuId;
	
	 private String  menuNm,menuLv,menuSt,menuStatus,groupCode,deptCode,empCode;


	
}
