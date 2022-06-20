package kr.co.insaPrj5.hr.emp.sf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.hr.emp.applicationService.EmpApplicationService;
import kr.co.insaPrj5.hr.emp.dao.EmpDAO;
import kr.co.insaPrj5.hr.emp.to.AuthGroupTO;
import kr.co.insaPrj5.hr.emp.to.AuthMenuTO;
import kr.co.insaPrj5.hr.emp.to.CareerInfoTO;
import kr.co.insaPrj5.hr.emp.to.EducationInfoTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.emp.to.FamilyInfoTO;
import kr.co.insaPrj5.hr.emp.to.LicenseInfoTO;
import kr.co.insaPrj5.hr.emp.to.WorkInfoTO;
import kr.co.insaPrj5.hr.emp.to.testEmpTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceFacadeImpl implements EmpServiceFacade {
	@Autowired
	private EmpApplicationService empApplicationService;	
	@Autowired
	private EmpDAO empDAO;	
	@Override
	public EmpTO getEmp(String name) {
		// TODO Auto-generated method stub		
		EmpTO empto = null;
		empto = empApplicationService.selectEmp(name);
		return empto;
	}

	@Override
	public String findLastEmpCode() {		// 
		String empCode = empApplicationService.findLastEmpCode();
		return empCode;		
	}

	@Override
	public void registEmployee(EmpTO empto) {
		empApplicationService.registEmployee(empto);	
	}

	@Override
	public List<EmpTO> findEmpList(String value) {
		ArrayList<EmpTO> empList = empApplicationService.findEmployeeListByDept(value);
		return empList;
	}

	@Override
	public EmpTO findAllEmpInfo(String empCode) {
		EmpTO empTO = empApplicationService.findAllEmployeeInfo(empCode);
		return empTO;
	}

	@Override
	public void modifyEmployee(EmpTO emp) {
		empApplicationService.modifyEmployee(emp);			
	}

	@Override
	public void deleteEmpList(ArrayList<EmpTO> empList) {
		empApplicationService.deleteEmpList(empList);
	}

	@Override
	public ArrayList<DeptTO> findDeptList() {
		ArrayList<DeptTO> deptList = empApplicationService.findDeptList();		
		return deptList;
	}


	

	
	 @Override public void registtestEmployee(testEmpTO testEmp) {
	  empDAO.registTest(testEmp);
	  
	  }

	@Override
	public ArrayList<testEmpTO> selectEmployee(String empName) {
		ArrayList<testEmpTO> testEmp = empDAO.selecttestEmployee(empName);
		return testEmp;
	}

	@Override
	public ArrayList<AuthGroupTO> selectAuthGroup(String dptCode) {
		ArrayList<AuthGroupTO> testEmp = empDAO.selectAuthGroup(dptCode);
		
		
		return testEmp;
	}

	@Override
	public void modifyAuthGroup(String empCode) {
		 empDAO.modifyAuthGroup(empCode);
		
	}

	@Override
	public void modifyGroup(EmpTO emp) {
		empApplicationService.modifyGroup(emp);	
		
	}

	@Override
	public ArrayList<AuthMenuTO> selectAuthMenu(String dptCode) {
		ArrayList<AuthMenuTO> authMenu =empDAO.selectAuthMenu(dptCode);
		return authMenu;
	}

	@Override
	public void modiAuthMenu(ArrayList<AuthMenuTO> authMenu) {
		
		empDAO.modiAuthMenu(authMenu);
	}

	@Override
	public ArrayList<DeptTO> findGroupList(String deptName) {
		// TODO Auto-generated method stub
		ArrayList<DeptTO> authMenu =empDAO.findGroupList(deptName);
		return authMenu;
	}
	 
}