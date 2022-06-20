package kr.co.insaPrj5.hr.salary.to;
 

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
@Table(name = "BASE_EXT_SAL")
@Dataset(name="ds_baseExtSal")
public class BaseExtSalTO extends BaseTO{
	@Id
	private String extSalCode;
	private String extSalName,ratio;

}
