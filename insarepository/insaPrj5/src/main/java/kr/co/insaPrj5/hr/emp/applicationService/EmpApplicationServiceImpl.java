package kr.co.insaPrj5.hr.emp.applicationService;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.insaPrj5.base.applicationService.BaseApplicationService;
import kr.co.insaPrj5.base.repository.DeptRepository;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.hr.emp.dao.CareerInfoDAO;
import kr.co.insaPrj5.hr.emp.dao.EducationInfoDAO;
import kr.co.insaPrj5.hr.emp.dao.EmpDAO;
import kr.co.insaPrj5.hr.emp.dao.FamilyInfoDAO;
import kr.co.insaPrj5.hr.emp.dao.LicenseInfoDAO;
import kr.co.insaPrj5.hr.emp.dao.WorkInfoDAO;
import kr.co.insaPrj5.hr.emp.to.AuthGroupTO;
import kr.co.insaPrj5.hr.emp.to.CareerInfoTO;
import kr.co.insaPrj5.hr.emp.to.EducationInfoTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.emp.to.FamilyInfoTO;
import kr.co.insaPrj5.hr.emp.to.LicenseInfoTO;
import kr.co.insaPrj5.hr.emp.to.WorkInfoTO;
import kr.co.insaPrj5.hr.salary.applicationService.SalaryApplicationService;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmpApplicationServiceImpl implements EmpApplicationService {
	@Autowired
	SalaryApplicationService salaryApplicationService;
	@Autowired
	BaseApplicationService baseApplicationService;	
	@Autowired
	private EmpDAO empDAO ;
	@Autowired
	private WorkInfoDAO workInfoDAO ;
	@Autowired
	private CareerInfoDAO careerInfoDAO ;
	@Autowired
	private EducationInfoDAO educationInfoDAO ;
	@Autowired
	private LicenseInfoDAO licenseInfoDAO ;
	@Autowired
	private FamilyInfoDAO familyInfoDAO ;

	@Autowired
	private DeptRepository deptrepository;
 
	
	
	@Override
	public EmpTO selectEmp(String name) {	
		
		//EmpTO empto = (EmpTO) empRepository.findByName(name); 
		EmpTO empto = empDAO.selectEmp(name);		
		return empto; 
	}
	
	//사번생성 
	@Override
	public String findLastEmpCode() {	
		String empCode = empDAO.selectLastEmpCode();		
		return empCode;
	}
	
	//사원상세조회 
	@Override
	public EmpTO findAllEmployeeInfo(String empCode) {
		EmpTO empTO = empDAO.selectEmployee(empCode); //일대다 
		return empTO;
	}
	
	@Override
	public ArrayList<EmpTO> findEmployeeListByDept(String value) {	
		
		ArrayList<EmpTO> empList = null;
		if (value.equals("전체부서")) {
			empList = empDAO.selectEmpList();
		} else if (value.substring(value.length()-1, value.length()).equals("팀")) {
			empList = empDAO.selectEmpListD(value);
		} else {
			 System.out.println("====================================사원명으로검색=========================================");
			
			 empList = empDAO.selectEmpListN(value);
		}		
		System.out.println(empList);
		return empList;
	}
	
	@Override
	public void registEmployee(EmpTO emp) {	
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		empDAO.registEmployee(emp);
		baseApplicationService.registEmpCode(emp);			
	}
	

	@Override
	public void deleteEmpList(ArrayList<EmpTO> empList) { 

		for(EmpTO emp : empList){
			  empDAO.deleteEmployee(emp);
			  baseApplicationService.deleteEmpCode(emp);
		  }	
	}
	
	@Override
	public ArrayList<DeptTO> findDeptList() {
		
		ArrayList<DeptTO> deptList =(ArrayList<DeptTO>) deptrepository.findAll();
		//ArrayList<DeptTO> deptList = deptDAO.selectDeptList();		
		return deptList;
	}

	@Override
	public ArrayList<BaseSalaryTO> selectPositionList() {

		ArrayList<BaseSalaryTO> positionList = salaryApplicationService.findBaseSalaryList();

		return positionList;
	}

	
 

	 @Override
	   public void modifyEmployee(EmpTO emp) {
		  	
		 //empRepository.save(emp);
		 empDAO.updateEmployee(emp);
	      
	      if (emp.getWorkInfoList() != null) {
	         List<WorkInfoTO> workInfoList = emp.getWorkInfoList();
	         for (WorkInfoTO workInfo : workInfoList) {            
	            switch (workInfo.getStatus()) {
	            case "insert":
	            	System.out.println("@@insert");
	               workInfoDAO.insertWorkInfo(workInfo);
	               break;
	            case "update":
	            	System.out.println("@@update");
	               workInfoDAO.updateWorkInfo(workInfo);
	               break;
	            case "delete":
	            	System.out.println("@@delete");
	               workInfoDAO.deleteWorkInfo(workInfo);
	               break;
	            }
	         }
	      }      
	      
	      if (emp.getCareerInfoList() != null && emp.getCareerInfoList().size() > 0) {
	         List<CareerInfoTO> careerInfoList = emp.getCareerInfoList();
	         for (CareerInfoTO careerInfo : careerInfoList) {
	            switch (careerInfo.getStatus()) {
	            case "insert":
	               careerInfoDAO.insertCareerInfo(careerInfo);
	               break;
	            case "update":
	               careerInfoDAO.updateCareerInfo(careerInfo);
	               break;
	            case "delete":
	               careerInfoDAO.deleteCareerInfo(careerInfo);
	               break;
	            }
	         }
	      }      
	      
	      if (emp.getEducationInfoList() != null && emp.getEducationInfoList().size() > 0) {
	         List<EducationInfoTO> educationInfoList = emp.getEducationInfoList();
	         for (EducationInfoTO educationInfo : educationInfoList) {
	            switch (educationInfo.getStatus()) {
	            case "insert":
	               educationInfoDAO.insertEducationInfo(educationInfo);
	               break;
	            case "update":
	               educationInfoDAO.updateEducationInfo(educationInfo);
	               break;
	            case "delete":
	               educationInfoDAO.deleteEducationInfo(educationInfo);
	               break;
	            }
	         }
	      }      
	      
	      if (emp.getLicenseInfoList() != null && emp.getLicenseInfoList().size() > 0) {
	         List<LicenseInfoTO> licenseInfoList = emp.getLicenseInfoList();
	         for (LicenseInfoTO licenseInfo : licenseInfoList) {
	            switch (licenseInfo.getStatus()) {
	            case "insert":
	               licenseInfoDAO.insertLicenseInfo(licenseInfo);
	               break;
	            case "update":
	               licenseInfoDAO.updateLicenseInfo(licenseInfo);
	               break;
	            case "delete":
	               licenseInfoDAO.deleteLicenseInfo(licenseInfo);
	               break;
	            }
	         }
	      }      
	      
	      if (emp.getFamilyInfoList() != null && emp.getFamilyInfoList().size() > 0) {
	         List<FamilyInfoTO> familyInfoList = emp.getFamilyInfoList();
	         for (FamilyInfoTO familyInfo : familyInfoList) {
	            switch (familyInfo.getStatus()) {
	            case "insert":
	               familyInfoDAO.insertFamilyInfo(familyInfo);
	               break;
	            case "update":
	               familyInfoDAO.updateFamilyInfo(familyInfo);
	               break;
	            case "delete":
	               familyInfoDAO.deleteFamilyInfo(familyInfo);
	               break;
	            }
	         }
	      }   
	   }

	@Override
	public void modifyGroup(EmpTO emp) {
		
		if (emp.getAuthGroupList() != null) {
	         List<AuthGroupTO> authGroupList = emp.getAuthGroupList();
	         for (AuthGroupTO authGroup : authGroupList) {   
	        	 System.out.println(authGroup.getGroupAlo());
	        	empDAO.modifyGroup(authGroup);
	            }
	         }
	      }      
		
	}
 	
