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
		System.out.println("44444");
		EmpTO emp = empApplicationService.selectEmp(name); // empName占쎌몵嚥∽옙 占쎄텢占쎌뜚占쎌벥 占쎌젟癰귣�占쏙옙 筌≪뼔�뮉占쎈뼄
		if (emp == null) {			
			throw new IdNotFoundException("");
		} else {
			if (emp.getEmpCode().equals(empCode)) {				
				return true;
			} else {				
				throw new PwMissMatchException("占쎄텢占쎌뜚甕곕뜇�깈�몴占� 占쎌넇占쎌뵥占쎈퉸雅뚯눘苑�占쎌뒄");
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
		System.out.println("###########################################################1111111111111");
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

	//占쎈뻻占쎈뮞占쎈�ζ꽴占썹뵳�딅퓠-> �겫占쏙옙苑뚧꽴占썹뵳�됥걠嚥∽옙 占쏙옙占쎌삢甕곌쑵�뱣占쎈뻻 占쎈뼄占쎈뻬 占쎈┷占쎈뮉野껋럥以� 
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
				System.out.println("==================== �겫占쏙옙苑뚧꽴占썹뵳�됥걠嚥∽옙 update 占쎈뻻占쎌삂 =====================");
				detailCodeRepository.save(detailCodeto);
				System.out.println("==================== �겫占쏙옙苑뚧꽴占썹뵳�됥걠嚥∽옙 update 占쎄국 =====================");
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
				System.out.println("==================== �겫占쏙옙苑뚧꽴占썹뵳�됥걠嚥∽옙 insert 占쎈뻻占쎌삂 =====================");
				detailCodeRepository.save(detailCodeto);
				System.out.println("==================== �겫占쏙옙苑뚧꽴占썹뵳�됥걠嚥∽옙 insert 占쎄국 =====================");
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

	//筌욊낫�닋�꽴占썹뵳�됥걠嚥∽옙 占쏙옙占쎌삢甕곌쑵�뱣 [ �빊遺쏙옙 , 占쎄텣占쎌젫 , 占쎈땾占쎌젟 ] 
	@Override
	public void modifyPosition(ArrayList<BaseSalaryTO> positionList) {
 
		if (positionList != null && positionList.size() > 0) {
			for (BaseSalaryTO position : positionList) {
				DetailCodeTO detailCodeto = new DetailCodeTO();
				switch (position.getStatus()) {

				case "update":
					System.out.println("==================== update 占쎈뻻占쎌삂 =====================");
					position.setStatus("");
					baseSalaryRepository.save(position);
					System.out.println("======================= update 占쎄국==================");
					//baseSalaryDAO.updatePosition(position);
					detailCodeto.setDetailCodeNumber(position.getPositionCode()); //筌욊낫�닋�굜遺얜굡  ex) POS001
					detailCodeto.setDetailCodeName(position.getPosition()); //筌욊낯肄�  ex) �겫占쏙옙�삢 
					detailCodeto.setCodeNumber("CO-04");
					detailCodeto.setDetailCodeNameusing("Y");
					detailCodeRepository.deleteByDetailCodeNumberAndDetailCodeNameAndCodeNumberAndDetailCodeNameusing(detailCodeto.getDetailCodeNumber(),detailCodeto.getDetailCodeName(),detailCodeto.getCodeNumber(),detailCodeto.getDetailCodeNameusing());
					//detailCodeDAO.updateDetailCode(detailCodeto);
					break;

				case "insert":
					System.out.println("====================insert 占쎈뻻占쎌삂 =====================");
					position.setStatus("");
					baseSalaryRepository.save(position);
					System.out.println("=======================insert 占쎄국==================");
					//baseSalaryDAO.insertPosition(position);
					detailCodeto.setDetailCodeNumber(position.getPositionCode());
					detailCodeto.setDetailCodeName(position.getPosition());
					detailCodeto.setCodeNumber("CO-04");
					detailCodeto.setDetailCodeNameusing("Y");
					detailCodeRepository.deleteByDetailCodeNumberAndDetailCodeNameAndCodeNumberAndDetailCodeNameusing(detailCodeto.getDetailCodeNumber(),detailCodeto.getDetailCodeName(),detailCodeto.getCodeNumber(),detailCodeto.getDetailCodeNameusing());
					
					//detailCodeDAO.registDetailCode(detailCodeto);
					break;

				case "delete":
					System.out.println("====================delete 占쎈뻻占쎌삂 =====================");
					position.setStatus("");
					baseSalaryRepository.delete(position);
					System.out.println("=======================delete 占쎄국==================");
					//baseSalaryDAO.deletePosition(position);
					detailCodeto.setDetailCodeNumber(position.getPositionCode());
					detailCodeto.setDetailCodeName(position.getPosition());
					System.out.println("####################筌욊낫�닋�꽴占썹뵳�됥걠嚥≪빘肉� 筌욊낫�닋�굜遺얜굡筌욑옙占쎌뒭疫뀐옙 占쎈뻻占쎌삂 #########################");
					detailCodeRepository.deleteByDetailCodeNumberAndDetailCodeName(detailCodeto.getDetailCodeNumber(),detailCodeto.getDetailCodeName()); //  detailCodeNumber, detailCodeName
					//detailCodeDAO.deleteDetailCode(detailCodeto);
					
					break; 
				}
			}
		}
	}

	@Override
	public String findWeekDayCount(Map<String, Object> map) {
		System.out.println("===============占쎌뵬占쎈땾=================");
		System.out.println(map.toString());
		System.out.println("================占쎌뵬占쎈땾================");
		return holidayDAO.selectWeekDayCount(map);

	
	}
//占쎌뵠沃섎챷占� 
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
		System.out.println("甕곗쥙�뵠占쎈뮞占쎈선占쎈탣占쎄퐣�뜮袁⑸뮞 占쎌뵠占쎈퓹占쎈돗 : "+emp);
		System.out.println("甕곗쥙�뵠占쎈뮞占쎈선占쎈탣占쎄퐣�뜮袁⑸뮞 占쎌뵠占쎈퓹占쎈돗占쎈뮞占쎈�믭옙�뵠占쎄숲占쎈뮞 : "+emp.getStatus());
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
	
	//�뵳�뗫７占쎈뱜
	@Override
	public ReportTO viewReport(String empCode) {
		ReportTO to = reportDAO.selectReport(empCode);
		return to;
	}
	
	//�뵳�뗫７占쎈뱜	
	@Override
	public ReportSalaryTO viewSalaryReport(HashMap<String, Object> parameters) {
		ReportSalaryTO to = reportDAO.selecSalarytReport(parameters);
		return to;
	}
}