package kr.co.insaPrj5.hr.attd.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.insaPrj5.hr.attd.dao.DayAttdDAO;
import kr.co.insaPrj5.hr.attd.dao.DayAttdMgtDAO;
import kr.co.insaPrj5.hr.attd.dao.MonthAttdMgtDAO;
import kr.co.insaPrj5.hr.attd.dao.RestAttdDAO;
import kr.co.insaPrj5.hr.attd.repository.DayAttdMgtRepository;
import kr.co.insaPrj5.hr.attd.repository.DayAttdRepository;
import kr.co.insaPrj5.hr.attd.repository.MonthAttdMgtRepository;
import kr.co.insaPrj5.hr.attd.repository.RestAttdRepository;
import kr.co.insaPrj5.hr.attd.to.DayAttdMgtTO;
import kr.co.insaPrj5.hr.attd.to.DayAttdTO;
import kr.co.insaPrj5.hr.attd.to.MonthAttdMgtTO;
 
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;

@Component
public class AttdApplicationServiceImpl implements AttdApplicationService{
	
	@Autowired
	private DayAttdDAO dayAttdDAO;
	@Autowired
	private RestAttdDAO restAttdDAO;
	@Autowired
	private DayAttdMgtDAO dayAttdMgtDAO;
	@Autowired
	private MonthAttdMgtDAO monthAttdMgtDAO;
	
	@Autowired
	private DayAttdMgtRepository dayAttdMgtRepository;
	@Autowired
	private DayAttdRepository dayAttdRepository;
	@Autowired
	private MonthAttdMgtRepository monthAttdMgtRepository;
	@Autowired
	private RestAttdRepository restAttdRepository;
	
	
	

	@Override
	public ArrayList<DayAttdTO> findDayAttdList(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		ArrayList<DayAttdTO> dayAttdList=dayAttdDAO.selectDayAttdList(map);

		return dayAttdList;
	}

	@Override
	public HashMap<String, Object> registDayAttd(HashMap<String, Object> map) {
		System.out.println("어플서비스");
		return dayAttdDAO.batchInsertDayAttd(map);		
	}

	@Override
	public void removeDayAttdList(ArrayList<DayAttdTO> dayAttdList) {
		// TODO Auto-generated method stub
		
		System.out.println("<<<<< 일근태 삭제 Scrcice임플 >>>>>>");
		for(DayAttdTO dayAttd : dayAttdList){
			dayAttdDAO.deleteDayAttd(dayAttd);
		}
	}
	
	@Override
	public ArrayList<RestAttdTO> findRestAttdListByToday(String empCode, String toDay) {
		ArrayList<RestAttdTO> restAttdList = restAttdDAO.selectRestAttdListByToday(empCode, toDay);

		return restAttdList;
	}

	
	//일근태 마감 
	@Override
	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList) {
		// TODO Auto-generated method stub
		for(DayAttdMgtTO dayAttdMgt : dayAttdMgtList){
			 
			dayAttdMgtDAO.updateDayAttdMgtList(dayAttdMgt);
			 
		}		
	}
	//월근태 프로시저 
	public HashMap<String, Object> findMonthAttdMgtList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		monthAttdMgtDAO.batchMonthAttdMgtProcess(map);
		return map;
	}
	
	@Override
	public ArrayList<RestAttdTO> findRestAttdListByDept(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		ArrayList<RestAttdTO> restAttdList = null;
		String deptName = (String) map.get("deptName");
		String startDate = (String) map.get("startDate");
		if(deptName.equals("모든부서")) {
			restAttdList = restAttdDAO.selectRestAttdListByAllDept(startDate);
		}else {
			restAttdList = restAttdDAO.selectRestAttdListByDept(map);
		}
		return restAttdList;
	}
	
	
	@Override
	public void registRestAttd(RestAttdTO restAttd) {
		// TODO Auto-generated method stub
		System.out.println(restAttd.toString());
		restAttdDAO.insertRestAttd(restAttd);
	}
	
	@Override
	public ArrayList<RestAttdTO> findRestAttdList(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		ArrayList<RestAttdTO> restAttdList=null;
		if(map.get("code").toString().isEmpty()) // if(map.get("code") == "")
			restAttdList = restAttdDAO.selectRestAttdList(map);
		else
			restAttdList = restAttdDAO.selectRestAttdListCode(map);
		return restAttdList;
	}
	
	@Override
	public void removeRestAttdList(ArrayList<RestAttdTO> restAttdList) {
		// TODO Auto-generated method stub
		for(RestAttdTO restAttd : restAttdList){
			restAttdDAO.deleteRestAttd(restAttd);
		}	
	}

	@Override
	public void modifyRestAttdList(ArrayList<RestAttdTO> restAttdList) {
		// TODO Auto-generated method stub
		for(RestAttdTO restAttd : restAttdList){
			
			if(restAttd.getStatus().equals("update")){
				System.out.println("***************************************************"+restAttd);
				
				restAttdDAO.updateRestAttd(restAttd);
			}
		}		
	}
	//일근태프로시저
	@Override
	public HashMap<String, Object> findDayAttdMgtList(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		dayAttdMgtDAO.batchDayAttdMgtProcess(map);
		return map;
	}
	
	@Override
	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList) {
		// TODO Auto-generated method stub

		for(MonthAttdMgtTO monthAttdMgt : monthAttdMgtList){
			 
				monthAttdMgtDAO.updateMonthAttdMgtList(monthAttdMgt);
		 
		}	
	}
	@Override
	public void insertDayAttd(DayAttdTO dayAttd) { //test
		// TODO Auto-generated method stub

		dayAttdDAO.insertDayAttd(dayAttd);

	}

}
