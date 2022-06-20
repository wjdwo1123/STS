package kr.co.insaPrj5.base.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="DEPT")
@Dataset(name="gds_group")
public class DeptTO extends BaseTO{
	
	@Id
	private String deptCode;
	
	private String deptName;
	
	private String deptTel;
	
	private String empCode;
	

}
