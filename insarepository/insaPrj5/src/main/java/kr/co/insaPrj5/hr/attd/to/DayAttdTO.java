package kr.co.insaPrj5.hr.attd.to;

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
@Table(name = "DAY_ATTD")
@Dataset(name="ds_girok")
public class DayAttdTO extends BaseTO{
	@Id
	private String empCode;
	private String empName, dayAttdCode, applyDay
	,attdTypeCode ,attdTypeName, time;

}
 