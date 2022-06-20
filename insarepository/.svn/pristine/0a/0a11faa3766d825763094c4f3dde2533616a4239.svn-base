package kr.co.insaPrj5.hr.emp.applicationService;

import java.util.ArrayList;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.hr.emp.to.CareerInfoTO;
import kr.co.insaPrj5.hr.emp.to.EducationInfoTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.emp.to.FamilyInfoTO;
import kr.co.insaPrj5.hr.emp.to.LicenseInfoTO;
import kr.co.insaPrj5.hr.emp.to.WorkInfoTO;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;

public interface EmpApplicationService {
	public EmpTO selectEmp(String name);
	public String findLastEmpCode();
	public EmpTO findAllEmployeeInfo(String empCode);
	public ArrayList<EmpTO> findEmployeeListByDept(String deptName);
	public void registEmployee(EmpTO emp);
	public void modifyEmployee(EmpTO emp);	
	public void deleteEmpList(ArrayList<EmpTO> empList);
	public ArrayList<DeptTO> findDeptList();	
	public void modifyGroup(EmpTO emp);	
	public ArrayList<BaseSalaryTO> selectPositionList();
}

 