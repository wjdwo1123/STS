package kr.co.insaPrj5.hr.attd.sf;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.insaPrj5.hr.attd.applicationService.AttdApplicationService;
import kr.co.insaPrj5.hr.attd.sf.AttdServiceFacade;
import kr.co.insaPrj5.hr.attd.sf.AttdServiceFacadeImpl;
import kr.co.insaPrj5.hr.attd.to.DayAttdMgtTO;
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;
import kr.co.insaPrj5.hr.attd.to.MonthAttdMgtTO;
 
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;

@Service
public class AttdServiceFacadeImpl implements AttdServiceFacade{
	@Autowired
	private AttdApplicationService attdApplicationService;

	@Override
	public ArrayList<DayAttdTO> findDayAttdList(HashMap<String,Object> map) {
		ArrayList<DayAttdTO> dayAttdList=attdApplicationService.findDayAttdList(map);
		return dayAttdList;
	}

	@Override
	public HashMap<String, Object> registDayAttd(HashMap<String, Object> map) {
		System.out.println("퍼사드");
		return attdApplicationService.registDayAttd(map);
	}

	@Override
	public void removeDayAttdList(ArrayList<DayAttdTO> dayAttdList) {
		attdApplicationService.removeDayAttdList(dayAttdList);
	}

	@Override
	public ArrayList<RestAttdTO> findRestAttdList(HashMap<String,Object> map) {
		ArrayList<RestAttdTO> restAttdList = attdApplicationService.findRestAttdList(map);
		return restAttdList;
	}

	@Override
	public ArrayList<RestAttdTO> findRestAttdListByDept(HashMap<String,Object> map) {
		ArrayList<RestAttdTO> restAttdList = attdApplicationService.findRestAttdListByDept(map);
		return restAttdList;
	}

	@Override
	public ArrayList<RestAttdTO> findRestAttdListByToday(String empCode, String toDay) {
		ArrayList<RestAttdTO> restAttdList = attdApplicationService.findRestAttdListByToday(empCode,toDay);
		return restAttdList;
	}

	@Override
	public void registRestAttd(RestAttdTO restAttd) {
		attdApplicationService.registRestAttd(restAttd);
	}

	@Override
	public void modifyRestAttdList(ArrayList<RestAttdTO> restAttdList) {
		attdApplicationService.modifyRestAttdList(restAttdList);
	}

	@Override
	public void removeRestAttdList(ArrayList<RestAttdTO> restAttdList) {
		attdApplicationService.removeRestAttdList(restAttdList);
	}

	@Override
	public HashMap<String, Object> findDayAttdMgtList(HashMap<String,Object> map) {
		HashMap<String, Object> result = attdApplicationService.findDayAttdMgtList(map);
		return result;
	}

	@Override
	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList) {
		attdApplicationService.modifyDayAttdMgtList(dayAttdMgtList);
	}

	@Override
	public HashMap<String, Object> findMonthAttdMgtList(HashMap<String, Object> map) {
		HashMap<String, Object> result = attdApplicationService.findMonthAttdMgtList(map);
		return result;
	}

	@Override
	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList) {
		attdApplicationService.modifyMonthAttdMgtList(monthAttdMgtList);		
	}

	@Override
	public void insertDayAttd(DayAttdTO dayAttd) {
		attdApplicationService.insertDayAttd(dayAttd);
	}

}