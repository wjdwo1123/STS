package kr.co.insaPrj5.base.applicationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.insaPrj5.base.dao.DetailCodeDAO;
import kr.co.insaPrj5.base.dao.HolidayDAO;
import kr.co.insaPrj5.base.dao.ReportDAO;
import kr.co.insaPrj5.base.exception.IdNotFoundException;
import kr.co.insaPrj5.base.exception.PwMissMatchException;
import kr.co.insaPrj5.base.repository.CodeRepository;
import kr.co.insaPrj5.base.repository.DeptRepository;
import kr.co.insaPrj5.base.repository.DetailCodeRepository;
import kr.co.insaPrj5.base.repository.HolidayRepository;
import kr.co.insaPrj5.base.to.CodeTO;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.base.to.DetailCodeTO;
import kr.co.insaPrj5.base.to.HolidayTO;
import kr.co.insaPrj5.base.to.ReportSalaryTO;
import kr.co.insaPrj5.base.to.ReportTO;
 
import kr.co.insaPrj5.hr.emp.applicationService.EmpApplicationService;
 
import kr.co.insaPrj5.hr.emp.to.EmpTO; 
import kr.co.insaPrj5.hr.salary.repository.BaseSalaryRepository;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;

@Component
public class BaseApplicationServiceImpl implements BaseApplicationService {
	@Autowired
	EmpApplicationService empApplicationService;
 
	@Autowired
	private HolidayDAO holidayDAO;
 
	@Autowired
	private ReportDAO reportDAO;
	@Autowired
	DetailCodeDAO detailCodeDAO;
	
 
	@Autowired
	private DeptRepository deptrepository;
	@Autowired
	private CodeRepository codeRepository;
	@Autowired
	private DetailCodeRepository detailCodeRepository;
	@Autowired
	private HolidayRepository holidayRepository;
	@Autowired
	private BaseSalaryRepository baseSalaryRepository;
	
	
	
	public boolean loginEmployee(String name, String empCode) throws IdNotFoundException, PwMissMatchException {

		EmpTO emp = empApplicationService.selectEmp(name); // empName�쑝濡� �궗�썝�쓽 �젙蹂대�� 李얜뒗�떎
		System.our.println("ㄹㅇ핵심마지막");
		if (emp == null) {			
			throw new IdNotFoundException("�궗�썝紐낆씠 議댁옱�븯吏� �븡�뒿�땲�떎");
		} else {
			if (emp.getEmpCode().equals(empCode)) {				
				return true;
			} else {				
				throw new PwMissMatchException("�궗�썝踰덊샇瑜� �솗�씤�빐二쇱꽭�슂");
				System.our.println("★★★★★★★★★★★");
				System.our.println("★★★★★★★★★★★");
			}
		}
	}

	@Override
	public ArrayList<DetailCodeTO> findDetailCodeList(String codetype) {
		// TODO Auto-generated method stub
		
		ArrayList<DetailCodeTO> detailCodeList = null;
		detailCodeList = detailCodeRepository.findAllBycodeNumber(codetype);
		//detailCodeList = detailCodeDAO.selectDetailCodeList(codetype);
		
		return detailCodeList; 
	}
	
	@Override
	public void registEmpCode(EmpTO emp) {
		// TODO Auto-generated method stub		
		
		DetailCodeTO detailCodeto = new DetailCodeTO();
		detailCodeto.setDetailCodeNumber(emp.getEmpCode());
		detailCodeto.setDetailCodeName(emp.getEmpName());
		detailCodeto.setCodeNumber("CO-17");
		detailCodeto.setDetailCodeNameusing("N");
		System.out.println("###########################################################################");
		
		//detailCodeDAO.registDetailCode(detailCodeto);	
	}

	@Override
	public void deleteEmpCode(EmpTO emp) {
		DetailCodeTO detailCodeto = new DetailCodeTO();
		detailCodeto.setDetailCodeNumber(emp.getEmpCode());
		detailCodeto.setDetailCodeName(emp.getEmpName());
		//detailCodeRepository.deleteById(id);
		//detailCodeDAO.deleteDetailCode(detailCodeto);
		
		
	}

	@Override
	public ArrayList<DetailCodeTO> findDetailCodeListRest(HashMap<String, Object> map) {

		ArrayList<DetailCodeTO> detailCodeList = null;
		
		detailCodeList = detailCodeDAO.selectDetailCodeListRest(map);

		return detailCodeList;
	}

	@Override
	public ArrayList<HolidayTO> findHolidayList() {
		
		ArrayList<HolidayTO> holidayList = (ArrayList<HolidayTO>) holidayRepository.findAll();
		//ArrayList<HolidayTO> holidayList = holidayDAO.selectHolidayList();

		return holidayList;
	}

	//�떆�뒪�뀥愿�由ъ뿉-> 遺��꽌愿�由щぉ濡� ���옣踰꾪듉�떆 �떎�뻾 �릺�뒗寃쎈줈 
	@Override
	public void batchDeptProcess(ArrayList<DeptTO> deptto) {
		
		DetailCodeTO detailCodeto = new DetailCodeTO();

		for (DeptTO dept : deptto) {
			String getStatus = dept.getStatus();
			
			switch (getStatus == null ? "" :  getStatus ) {
			
			case "update":
				dept.setStatus(null);
				deptrepository.save(dept);
				detailCodeto.setDetailCodeNumber(dept.getDeptCode());
				detailCodeto.setDetailCodeName(dept.getDeptName());
				detailCodeto.setCodeNumber("CO-07");
				detailCodeto.setDetailCodeNameusing("Y");
				System.out.println("==================== 遺��꽌愿�由щぉ濡� update �떆�옉 =====================");
				detailCodeRepository.save(detailCodeto);
				System.out.println("==================== 遺��꽌愿�由щぉ濡� update �걹 =====================");
				//detailCodeDAO.updateDetailCode(detailCodeto);
				break;

			case "insert":
				dept.setStatus(null);
				deptrepository.save(dept);
				//deptDAO.registDept(dept);
				detailCodeto.setDetailCodeNumber(dept.getDeptCode());
				detailCodeto.setDetailCodeName(dept.getDeptName());
				detailCodeto.setCodeNumber("CO-07");
				detailCodeto.setDetailCodeNameusing("Y");
				System.out.println("==================== 遺��꽌愿�由щぉ濡� insert �떆�옉 =====================");
				detailCodeRepository.save(detailCodeto);
				System.out.println("==================== 遺��꽌愿�由щぉ濡� insert �걹 =====================");
				//detailCodeDAO.registDetailCode(detailCodeto);
				break;

			case "delete":
				deptrepository.delete(dept);
				//deptDAO.deleteDept(dept);
				detailCodeto.setDetailCodeNumber(dept.getDeptCode());
				detailCodeto.setDetailCodeName(dept.getDeptName());
				detailCodeRepository.deleteByDetailCodeNumberAndDetailCodeName(detailCodeto.getDetailCodeNumber(),detailCodeto.getDetailCodeName());
				//detailCodeDAO.deleteDetailCode(detailCodeto);
				break;

			/*
			 * case "null": break;
			 */
			}
		}

	}

	//吏곴툒愿�由щぉ濡� ���옣踰꾪듉 [ 異붽� , �궘�젣 , �닔�젙 ] 
	@Override
	public void modifyPosition(ArrayList<BaseSalaryTO> positionList) {
 
		if (positionList != null && positionList.size() > 0) {
			for (BaseSalaryTO position : positionList) {
				DetailCodeTO detailCodeto = new DetailCodeTO();
				switch (position.getStatus()) {

				case "update":
					System.out.println("==================== update �떆�옉 =====================");
					position.setStatus("");
					baseSalaryRepository.save(position);
					System.out.println("======================= update �걹==================");
					//baseSalaryDAO.updatePosition(position);
					detailCodeto.setDetailCodeNumber(position.getPositionCode()); //吏곴툒肄붾뱶  ex) POS001
					detailCodeto.setDetailCodeName(position.getPosition()); //吏곸콉  ex) 遺��옣 
					detailCodeto.setCodeNumber("CO-04");
					detailCodeto.setDetailCodeNameusing("Y");
					detailCodeRepository.deleteByDetailCodeNumberAndDetailCodeNameAndCodeNumberAndDetailCodeNameusing(detailCodeto.getDetailCodeNumber(),detailCodeto.getDetailCodeName(),detailCodeto.getCodeNumber(),detailCodeto.getDetailCodeNameusing());
					//detailCodeDAO.updateDetailCode(detailCodeto);
					break;

				case "insert":
					System.out.println("====================insert �떆�옉 =====================");
					position.setStatus("");
					baseSalaryRepository.save(position);
					System.out.println("=======================insert �걹==================");
					//baseSalaryDAO.insertPosition(position);
					detailCodeto.setDetailCodeNumber(position.getPositionCode());
					detailCodeto.setDetailCodeName(position.getPosition());
					detailCodeto.setCodeNumber("CO-04");
					detailCodeto.setDetailCodeNameusing("Y");
					detailCodeRepository.deleteByDetailCodeNumberAndDetailCodeNameAndCodeNumberAndDetailCodeNameusing(detailCodeto.getDetailCodeNumber(),detailCodeto.getDetailCodeName(),detailCodeto.getCodeNumber(),detailCodeto.getDetailCodeNameusing());
					
					//detailCodeDAO.registDetailCode(detailCodeto);
					break;

				case "delete":
					System.out.println("====================delete �떆�옉 =====================");
					position.setStatus("");
					baseSalaryRepository.delete(position);
					System.out.println("=======================delete �걹==================");
					//baseSalaryDAO.deletePosition(position);
					detailCodeto.setDetailCodeNumber(position.getPositionCode());
					detailCodeto.setDetailCodeName(position.getPosition());
					System.out.println("####################吏곴툒愿�由щぉ濡앹뿉 吏곴툒肄붾뱶吏��슦湲� �떆�옉 #########################");
					detailCodeRepository.deleteByDetailCodeNumberAndDetailCodeName(detailCodeto.getDetailCodeNumber(),detailCodeto.getDetailCodeName()); //  detailCodeNumber, detailCodeName
					//detailCodeDAO.deleteDetailCode(detailCodeto);
					
					break; 
				}
			}
		}
	}

	@Override
	public String findWeekDayCount(Map<String, Object> map) {
		System.out.println("===============�씪�닔=================");
		System.out.println(map.toString());
		System.out.println("================�씪�닔================");
		return holidayDAO.selectWeekDayCount(map);

	
	}
//�씠誘몄� 
	@Override
	public void registEmpImg(HashMap<String,Object> map) {
		String empCode = (String) map.get("empCode");
		String imgExtend = (String) map.get("imgExtend");
		EmpTO emp = empApplicationService.findAllEmployeeInfo(empCode);
		if (emp == null) {
			emp = new EmpTO();
			emp.setEmpCode(empCode);
			emp.setStatus("insert");
		} else {
			emp.setStatus("update");
		}
		emp.setImgExtend(imgExtend);
		System.out.println("踰좎씠�뒪�뼱�뵆�꽌鍮꾩뒪 �씠�뿞�뵾 : "+emp);
		System.out.println("踰좎씠�뒪�뼱�뵆�꽌鍮꾩뒪 �씠�뿞�뵾�뒪�뀒�씠�꽣�뒪 : "+emp.getStatus());
		empApplicationService.modifyEmployee(emp);

	}

	@Override
	public ArrayList<CodeTO> findCodeList() {
		ArrayList<CodeTO> codeList =(ArrayList<CodeTO>) codeRepository.findAll();
		//ArrayList<CodeTO> codeList = codeDAO.selectCode();

		return codeList;
	}

	@Override
	public void registCodeList(List<HolidayTO> holyday) {
		for (HolidayTO holiday : holyday) {
			switch (holiday.getStatus()) {

			case "update":
				holidayRepository.save(holiday);
				//holidayDAO.updateCodeList(holiday);
				break;
			
			case "insert":
				holidayRepository.save(holiday);
				//holidayDAO.insertCodeList(holiday);
				break;

			case "delete": 
				System.out.println("============================================================");
				//holidayRepository.delete(holiday);
				holidayDAO.deleteCodeList(holiday);
				break;

			}
		}
	}
	
	//由ы룷�듃
	@Override
	public ReportTO viewReport(String empCode) {
		ReportTO to = reportDAO.selectReport(empCode);
		return to;
	}
	
	//由ы룷�듃	
	@Override
	public ReportSalaryTO viewSalaryReport(HashMap<String, Object> parameters) {
		ReportSalaryTO to = reportDAO.selecSalarytReport(parameters);
		return to;
	}
}