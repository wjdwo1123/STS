package kr.co.insaPrj5.hr.salary.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "FULLTIME_EMPLOYEE_SALARY")
@Dataset(name="ds_monthDeductionList")
public class MonthDeductionTO {
	@Id
	private String empCode;
	private String applyYearMonth;
	private String deductionName;
	private String price;
}
 