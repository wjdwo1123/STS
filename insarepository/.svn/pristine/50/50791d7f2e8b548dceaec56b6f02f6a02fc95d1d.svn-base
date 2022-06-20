package kr.co.insaPrj5.hr.attd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;


@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "DS_MONTH_ATTD_MANAGE")
@Dataset(name="ds_monthAttenMng")
@IdClass(value=MonthAttdMgtTO.class)
public class MonthAttdMgtTO extends BaseTO implements Serializable{
	@Id
	private String empCode;
	
	@Id
	private String applyYearMonth;
	
	@Column(nullable=false)
	private String empName ,basicWorkDays
	,weekdayWorkDays ,basicWorkHour ,workHour
	,overWorkHour ,nightWorkHour ,holidayWorkDays,earlyLeaveDays
	,holidayWorkHour ,lateDays ,absentDays ,halfHolidays ,Holidays ,finalizeStatus ;

}
