package kr.co.insaPrj5.hr.salary.to;

import javax.persistence.Column;
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
@Table(name = "BASE_DEDUCTION")
@Dataset(name="ds_baseDeduction")
public class BaseDeductionTO extends BaseTO{
	@Id
	private String deductionCode;
	
	@Column(nullable=false)
	private String deductionName,ratio;

	@Override
	public String toString() {
		return "BaseDeductionTO [deductionCode=" + deductionCode + ", deductionName=" + deductionName + ", ratio="
				+ ratio +  "]";
	}

}
