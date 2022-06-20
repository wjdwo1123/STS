package kr.co.insaPrj5.base.dao;
 
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.base.to.HolidayTO;
 

@Mapper
public interface HolidayDAO {
	public String selectWeekDayCount(Map<String, Object> map);
	//public ArrayList<HolidayTO> selectHolidayList();
	//public void updateCodeList(HolidayTO holyday);
	//public void insertCodeList(HolidayTO holyday);
	public void deleteCodeList(HolidayTO holyday); 
}
