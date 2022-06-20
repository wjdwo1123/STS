package kr.co.insaPrj5.base.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;

@Entity
@Data
@Table(name = "HOLIDAY")
@Dataset(name="ds_holiday")
public class HolidayTO{
	@Id
	//@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH24:mi:ss", timezone="Asia/Seoul")
	private String applyDay;

	private String holidayName;
	@Column(nullable=false)
	private String note;
	@Column(nullable=false)
	private String status;
}
