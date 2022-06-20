package kr.co.insaPrj5.hr.salary.to;
 
import javax.persistence.Id;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_yearSalary")
public class YearSalaryBean extends BaseTO{
	@Id
	private String empCode;
	private String applyYearMonth;
	private String salary;
	private String totalExtSal;
	private String totalPayment;
	private String totalDeduction;
	private String realSalary;
	
}
