package kr.co.insaPrj5.hr.attd.applicationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.insaPrj5.hr.attd.to.DayAttdMgtTO;
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;
import kr.co.insaPrj5.hr.attd.to.MonthAttdMgtTO;
 
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;

public interface AttdApplicationService {
	public ArrayList<DayAttdTO> findDayAttdList(HashMap<String,Object> map);
	public HashMap<String, Object> registDayAttd(HashMap<String, Object> map);
	public void removeDayAttdList(ArrayList<DayAttdTO> dayAttdList);
	public void insertDayAttd(DayAttdTO dayAttd); //test

	public HashMap<String, Object> findDayAttdMgtList(HashMap<String,Object> map);
	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList);
	public HashMap<String, Object> findMonthAttdMgtList(HashMap<String, Object> map);
	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList);
	
	public ArrayList<RestAttdTO> findRestAttdList(HashMap<String,Object> map);
	public ArrayList<RestAttdTO> findRestAttdListByDept(HashMap<String,Object> map);
	public ArrayList<RestAttdTO> findRestAttdListByToday(String empCode, String toDay);
	public void registRestAttd(RestAttdTO restAttd);
	public void modifyRestAttdList(ArrayList<RestAttdTO> restAttdList);
	public void removeRestAttdList(ArrayList<RestAttdTO> restAttdList);
}
