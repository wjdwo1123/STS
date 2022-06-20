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
@Table(name = "WORK_INFO")
@Dataset(name="ds_workInfo")
public class WorkInfoTO extends BaseTO{
	@Id
	private String empCode;
	private String workInfoDays, hiredate, retireDate, 
	occupation, employmentType, hobong, position, deptName,status;

}
