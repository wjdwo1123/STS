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
@Table(name = "POSITION")
@Dataset(name="ds_baseSalary")
public class BaseSalaryTO extends BaseTO {
	@Id
	private String positionCode;
	
	@Column(nullable=false)
	private String position,baseSalary,hobongRatio;
	
}
