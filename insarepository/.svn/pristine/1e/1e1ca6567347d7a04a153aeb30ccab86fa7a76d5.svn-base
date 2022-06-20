package kr.co.insaPrj5.hr.emp.dao;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.hr.emp.to.AuthGroupTO;
import kr.co.insaPrj5.hr.emp.to.AuthMenuTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.emp.to.testEmpTO;
@Mapper
public interface EmpDAO {
	public EmpTO selectEmp(String name);
	public String selectLastEmpCode();
	public ArrayList<EmpTO> selectEmpList();
	public ArrayList<EmpTO> selectEmpListD(String dept);
	public ArrayList<EmpTO> selectEmpListN(String name);	 
	public EmpTO selectEmployee(String empCode);
	public void modifyAuthGroup(String empCode);
	public void registTest(testEmpTO testEmp);
	public ArrayList<testEmpTO> selecttestEmployee(String empName);
	public ArrayList<AuthGroupTO> selectAuthGroup(String empCode);
	public void registEmployee(EmpTO empto);
	public void updateEmployee(EmpTO empto);
	public void deleteEmployee(EmpTO empto);
	public void  modifyGroup(AuthGroupTO authGroup);
	public ArrayList<DeptTO>  findGroupList(String value);
	public 	ArrayList<AuthMenuTO> selectAuthMenu(String empCode);
	public void modiAuthMenu(ArrayList<AuthMenuTO> authMenu);
}
