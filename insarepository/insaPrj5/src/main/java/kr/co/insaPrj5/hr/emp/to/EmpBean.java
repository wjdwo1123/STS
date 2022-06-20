package kr.co.insaPrj5.hr.emp.to;

import javax.persistence.Id;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="gds_lastEmpCode")
public class EmpBean {
   
	private String empCode;
}
