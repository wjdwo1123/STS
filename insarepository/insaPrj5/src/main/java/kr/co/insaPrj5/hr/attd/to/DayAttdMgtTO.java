package kr.co.insaPrj5.hr.attd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;


@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "DAY_ATTD_MANAGE")
@Dataset(name="ds_dayAttenMng")
@IdClass(value=DayAttdMgtTO.class)
public class DayAttdMgtTO extends BaseTO implements Serializable{
	
	
	@Id
	private String empCode;

	@Id
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private String applyDays;
	
	@Column(nullable=false)
	private String empName , dayAttdCode,dayAttdName ,attendTime,halfHolidayStatus
	,quitTime ,lateWhether ,leaveHour ,workHour,earlyLeaveHour
	,overWorkHour ,nightWorkHour ,finalizeStatus, privateLeaveHour, publicLeaveHour;
 

}
