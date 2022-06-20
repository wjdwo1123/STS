package kr.co.insaPrj5.hr.emp.sf;

import java.util.ArrayList;
import java.util.List;

import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.hr.emp.to.AuthGroupTO;
import kr.co.insaPrj5.hr.emp.to.AuthMenuTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.emp.to.testEmpTO;

public interface EmpServiceFacade {
	public EmpTO getEmp(String name); //selectEmp
	public String findLastEmpCode();
	public EmpTO findAllEmpInfo(String empCode);	
	public List<EmpTO> findEmpList(String dept); //findEmployeeListByDept
	public void registEmployee(EmpTO empto);
	
	public void modifyEmployee(EmpTO emp);
 
	public void modifyGroup(EmpTO emp);
	public void deleteEmpList(ArrayList<EmpTO> empList);
	public ArrayList<DeptTO> findDeptList();
	public void registtestEmployee(testEmpTO testEmp);
	public void modifyAuthGroup(String empCode);
	public ArrayList<DeptTO> findGroupList(String deptName);
	public ArrayList<testEmpTO> selectEmployee(String empName);
	public ArrayList<AuthGroupTO> selectAuthGroup(String empCode);
	public void modiAuthMenu(ArrayList<AuthMenuTO> authMenu);
	public ArrayList<AuthMenuTO> selectAuthMenu(String empCode);
}

 


 