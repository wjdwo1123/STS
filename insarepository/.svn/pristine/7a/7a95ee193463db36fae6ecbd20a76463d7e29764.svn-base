package kr.co.insaPrj5.hr.salary.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "MONTH_SALARY")
@Dataset(name="ds_MonthSalary")
public class MonthSalaryTO extends BaseTO{
	@Id
	private String empCode;
	private String applyYearMonth;
	private String basicSalary;
	private String positionSalary;
	private String familySalary;
	private String foodSalary;
	private String overWorkSalary;
	private String nationalPension;
	private String healthInsurance;
	private String longTermInsurance;
	private String employmentInsurance;
	private String religionDonation;
	private String incomeTax;
	private String residentTax;
	private String basicSalBefore;
	private String finalizeStatus;
	private String totalSalary;
	private String totalExpense;
	private String netAmount;
	private String totalDeduction;	
	
	@JoinColumn(name="empCode")
	@OneToMany 
	private List<MonthDeductionTO> monthDeductionList;
	
	@JoinColumn(name="empCode")
	@OneToMany 
	private List<MonthExtSalTO> monthExtSalList;
	
}
