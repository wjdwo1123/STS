package kr.co.insaPrj5.hr.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tobesoft.xplatform.data.PlatformData;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;
import kr.co.insaPrj5.hr.emp.sf.EmpServiceFacade;
import kr.co.insaPrj5.hr.emp.to.CareerInfoTO;
import kr.co.insaPrj5.hr.emp.to.EducationInfoTO;
import kr.co.insaPrj5.hr.emp.to.EmpTO;
import kr.co.insaPrj5.hr.emp.to.FamilyInfoTO;
import kr.co.insaPrj5.hr.emp.to.LicenseInfoTO;
import kr.co.insaPrj5.hr.emp.to.WorkInfoTO;
import kr.co.insaPrj5.hr.salary.to.MonthDeductionTO;
import kr.co.insaPrj5.hr.salary.to.MonthExtSalTO;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmpDetailController {	
	@Autowired
	private EmpServiceFacade empServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	HashMap<String,Object> map = new HashMap<>();
	
	
	//기본정보,재직정보,경력정보,학력정보,자격증정보,가족정보 
	@RequestMapping("emp/findAllEmployeeInfo.do")
	public HashMap<String,Object> findAllEmployeeInfo(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("☆★☆★detailCodeList컨트롤러진입☆★☆★");
		String empCode = reqData.getVariable("empCode").getString();
		
		
			EmpTO empTO=empServiceFacade.findAllEmpInfo(empCode);
			
			List<WorkInfoTO> workInfoList=empTO.getWorkInfoList();
			List<CareerInfoTO> careerInfoList=empTO.getCareerInfoList();
			List<EducationInfoTO> educationInfoList=empTO.getEducationInfoList();
			List<LicenseInfoTO> licenseInfoList=empTO.getLicenseInfoList();
			List<FamilyInfoTO> familyInfoList=empTO.getFamilyInfoList(); 
			
			//datasetBeanMapper.beansToDataset(resData,empTO,EmpTO.class);
			datasetBeanMapper.beansToDataset(resData,workInfoList,WorkInfoTO.class);
			datasetBeanMapper.beansToDataset(resData,careerInfoList,CareerInfoTO.class);
			datasetBeanMapper.beansToDataset(resData,educationInfoList,EducationInfoTO.class);
			datasetBeanMapper.beansToDataset(resData,familyInfoList,FamilyInfoTO.class);
			datasetBeanMapper.beansToDataset(resData,licenseInfoList,LicenseInfoTO.class);
		     
			
		return null;
	}
	
	
	//사원상세조회 기본정보 저장 버튼 
	@RequestMapping("/emp/modifyEmployee.do")
	public HashMap<String,Object> modifyEmployee(HttpServletRequest request, HttpServletResponse responsea) throws Exception {
		PlatformData reqData=(PlatformData) request.getAttribute("reqData");
		System.out.println("<<<<<<<<<<<<<<<<<<<<사원상세조회 저장 컨트롤러 진입 >>>>>>>>>>>>>>>>>>>>");
		EmpTO emp = datasetBeanMapper.datasetToBean(reqData, EmpTO.class);
		System.out.println("//////////////////////////////"+emp.toString());
		ArrayList<WorkInfoTO> workinfo = (ArrayList<WorkInfoTO>) datasetBeanMapper.datasetToBeans(reqData, WorkInfoTO.class);
		log.info("workinfo123 :" + emp);
		log.info("workinfo123 :" + workinfo);
		ArrayList<CareerInfoTO> careerinfo = (ArrayList<CareerInfoTO>) datasetBeanMapper.datasetToBeans(reqData, CareerInfoTO.class);
		ArrayList<EducationInfoTO> educationinfo = (ArrayList<EducationInfoTO>) datasetBeanMapper.datasetToBeans(reqData, EducationInfoTO.class);
		ArrayList<FamilyInfoTO> familyinfo = (ArrayList<FamilyInfoTO>) datasetBeanMapper.datasetToBeans(reqData, FamilyInfoTO.class);
		ArrayList<LicenseInfoTO> licenseinfo = (ArrayList<LicenseInfoTO>) datasetBeanMapper.datasetToBeans(reqData, LicenseInfoTO.class);

		
		emp.setWorkInfoList(workinfo);
		emp.setCareerInfoList(careerinfo);
		emp.setEducationInfoList(educationinfo);
		emp.setFamilyInfoList(familyinfo);
		emp.setLicenseInfoList(licenseinfo);
		
		
		empServiceFacade.modifyEmployee(emp);
 

		return null;
	}
	
	//사원 삭제 
	@RequestMapping("emp/removeEmployeeList.do")
	public HashMap<String,Object> removeEmployeeList(@RequestParam("sendData") String sendData){
		try{		
			Gson gson = new Gson();
			ArrayList<EmpTO> empList = gson.fromJson(sendData, new TypeToken<ArrayList<EmpTO>>(){}.getType());
			empServiceFacade.deleteEmpList(empList);
			map.clear();
			map.put("errorMsg","success");
			map.put("errorCode", 0);
		} catch (Exception e) {
			map.clear();
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
}
