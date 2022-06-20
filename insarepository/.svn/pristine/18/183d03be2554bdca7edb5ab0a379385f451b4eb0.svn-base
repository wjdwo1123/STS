package kr.co.insaPrj5.base.applicationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.insaPrj5.base.exception.IdNotFoundException;
import kr.co.insaPrj5.base.exception.PwMissMatchException;
import kr.co.insaPrj5.base.to.CodeTO;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.base.to.DetailCodeTO;
import kr.co.insaPrj5.base.to.HolidayTO;
import kr.co.insaPrj5.base.to.ReportSalaryTO;
import kr.co.insaPrj5.base.to.ReportTO;
import kr.co.insaPrj5.base.to.WeekDayCountBean;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;


public interface BaseApplicationService {
   public boolean loginEmployee(String name, String empCode) throws IdNotFoundException, PwMissMatchException; 

   public ArrayList<DetailCodeTO> findDetailCodeList(String codetype);
   public ArrayList<DetailCodeTO> findDetailCodeListRest(HashMap<String, Object> map);

   public ArrayList<HolidayTO> findHolidayList();
   public String findWeekDayCount(Map<String, Object> map);

   public void registEmpImg(HashMap<String,Object> map);

   public void batchDeptProcess(ArrayList<DeptTO> deptto);
   public void modifyPosition(ArrayList<BaseSalaryTO> positionList);
   
   public void registEmpCode(EmpTO emp);
   public void deleteEmpCode(EmpTO emp);

   public ArrayList<CodeTO> findCodeList();

   public void registCodeList(List<HolidayTO> holyday);

   public ReportTO viewReport(String empCode);
   public ReportSalaryTO viewSalaryReport(HashMap<String, Object> parameters);
}