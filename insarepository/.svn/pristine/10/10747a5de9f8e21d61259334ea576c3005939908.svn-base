package kr.co.insaPrj5.base.sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.insaPrj5.base.applicationService.BaseApplicationService;
import kr.co.insaPrj5.base.exception.IdNotFoundException;
import kr.co.insaPrj5.base.exception.PwMissMatchException;
import kr.co.insaPrj5.base.to.CodeTO;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.base.to.DetailCodeTO;
import kr.co.insaPrj5.base.to.HolidayTO;
import kr.co.insaPrj5.base.to.ReportSalaryTO;
import kr.co.insaPrj5.base.to.ReportTO;
import kr.co.insaPrj5.base.to.WeekDayCountBean;
import kr.co.insaPrj5.hr.emp.applicationService.EmpApplicationService;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;

@Service
public class BaseServiceFacadeImpl implements BaseServiceFacade {
	@Autowired
	private BaseApplicationService baseApplicationService;
	@Autowired
	private EmpApplicationService empApplicationService;
	
	@Override
	public boolean login(String name, String empCode) throws IdNotFoundException, PwMissMatchException {
		try {
			boolean check = baseApplicationService.loginEmployee(name, empCode);
			return check;
		}  
		catch (IdNotFoundException e) {
			throw e;
		} catch (PwMissMatchException e) {
			throw e;
		}
	}

	
	@Override
	public ArrayList<DetailCodeTO> findDetailCodeList(String codetype) {
		ArrayList<DetailCodeTO> detailCodeto = baseApplicationService.findDetailCodeList(codetype);
		
		return detailCodeto;
	}

	
	public ArrayList<DetailCodeTO> findDetailCodeListRest(HashMap<String, Object> map) {
		ArrayList<DetailCodeTO> detailCodeto = baseApplicationService.findDetailCodeListRest(map);

		return detailCodeto;
	}

	
	@Override
	public ArrayList<HolidayTO> findHolidayList() {
		// TODO Auto-generated method stub
			ArrayList<HolidayTO> holidayList = baseApplicationService.findHolidayList();

			return holidayList;
	}

	
	@Override
	public String findWeekDayCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return baseApplicationService.findWeekDayCount(map);
			
	}

	
	@Override
	public void registEmpImg(HashMap<String,Object> map) {
			baseApplicationService.registEmpImg(map);
	}

	
	@Override
	public void batchDeptProcess(ArrayList<DeptTO> deptto) {
			baseApplicationService.batchDeptProcess(deptto);
	}

	
	@Override
	public ArrayList<BaseSalaryTO> findPositionList() {
		ArrayList<BaseSalaryTO> positionList = empApplicationService.selectPositionList();

		return positionList;
	}

	
	@Override
	public void modifyPosition(ArrayList<BaseSalaryTO> positionList) {
		// TODO Auto-generated method stub
			baseApplicationService.modifyPosition(positionList);
	}

	
	@Override
	public ArrayList<CodeTO> findCodeList() {
		// TODO Auto-generated method stub
		ArrayList<CodeTO> codeto = baseApplicationService.findCodeList();
		return codeto;
	}

	
	@Override
	public void registCodeList(List<HolidayTO> holyday) {
		// TODO Auto-generated method stub
			baseApplicationService.registCodeList(holyday);
	}
	
	@Override
	   public ReportTO viewReport(String empCode) {             
	       ReportTO to = baseApplicationService.viewReport(empCode);
	         return to;
	   }
	
	@Override
	public ReportSalaryTO viewSalaryReport(HashMap<String, Object> parameters) {
		 ReportSalaryTO to=baseApplicationService.viewSalaryReport(parameters);
			return to;
	}
}
