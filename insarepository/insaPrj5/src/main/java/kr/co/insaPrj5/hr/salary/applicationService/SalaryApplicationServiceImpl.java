package kr.co.insaPrj5.hr.salary.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.insaPrj5.hr.salary.applicationService.SalaryApplicationService;
import kr.co.insaPrj5.hr.salary.applicationService.SalaryApplicationServiceImpl;

import kr.co.insaPrj5.hr.salary.dao.BaseExtSalDAO; 
import kr.co.insaPrj5.hr.salary.dao.MonthDeductionDAO;
import kr.co.insaPrj5.hr.salary.dao.MonthExtSalDAO;
import kr.co.insaPrj5.hr.salary.dao.MonthSalaryDAO;
import kr.co.insaPrj5.hr.salary.repository.BaseDeductionRepository;
import kr.co.insaPrj5.hr.salary.repository.BaseExtSalRepository;
import kr.co.insaPrj5.hr.salary.repository.BaseSalaryRepository;
import kr.co.insaPrj5.hr.salary.repository.MonthDeductionRepository;
import kr.co.insaPrj5.hr.salary.repository.MonthExtSalRepository;
import kr.co.insaPrj5.hr.salary.repository.MonthSalaryRepository;
import kr.co.insaPrj5.hr.salary.to.BaseDeductionTO;
import kr.co.insaPrj5.hr.salary.to.BaseExtSalTO;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryBean;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryTO;

@Component
public class SalaryApplicationServiceImpl implements SalaryApplicationService{
	@Autowired
	private MonthDeductionDAO monthDeductionDAO;
	@Autowired
	private MonthExtSalDAO monthExtSalDAO;
	@Autowired
	private MonthSalaryDAO monthSalaryDAO;
 
	@Autowired
	private BaseExtSalDAO baseExtSalDAO;
 
	@Autowired
	private BaseSalaryRepository baseSalaryRepository;
	@Autowired
	private BaseDeductionRepository baseDeductionRepository;
	@Autowired
	private MonthDeductionRepository monthDeductionRepository;
	@Autowired
	private MonthExtSalRepository monthExtSalRepository;
	@Autowired
	private BaseExtSalRepository baseExtSalRepository;
	@Autowired
	private MonthSalaryRepository monthSalaryRepository;
	
	
	
	
	@Override
	public HashMap<String,Object> findMonthSalary(HashMap<String,Object> map) {
		monthSalaryDAO.batchMonthSalaryProcess(map);
		@SuppressWarnings("unchecked")
		ArrayList<MonthSalaryTO> mto = (ArrayList<MonthSalaryTO>) map.get("result");
		
		MonthSalaryTO to= mto.get(0);
		to.setMonthDeductionList(monthDeductionDAO.selectMonthDeductionList(to));
		to.setMonthExtSalList(monthExtSalDAO.selectMonthExtSalList(to));
		map.put("result",to);
		return map;
	}
	
	
	
	@Override
	public HashMap<String,Object> findYearSalary(HashMap<String,Object> map) {
		ArrayList<MonthSalaryTO> to=monthSalaryDAO.selectYearSalary(map);
		map.clear();
		map.put("result",to);
		return map;
	}
	
	//마감 /마감취소 
	@Override
	public void modifyMonthSalary(MonthSalaryBean monthSalary) {
		monthSalaryDAO.updateMonthSalary(monthSalary);
	}
	
	
	
	//공제기준관리 조회 
	@Override
	public ArrayList<BaseDeductionTO> findBaseDeductionList() {
		ArrayList<BaseDeductionTO> baseDeductionList = (ArrayList<BaseDeductionTO>) baseDeductionRepository.findAll();
		//ArrayList<BaseDeductionTO> baseDeductionList = baseDeductionDAO.selectBaseDeductionList();
		return baseDeductionList;
	}
	
	
	//공제기준관리 insert,update,delete 
	@Override
	public void batchBaseDeductionProcess(ArrayList<BaseDeductionTO> baseDeductionList) {

		for(BaseDeductionTO baseDeduction : baseDeductionList){
			switch(baseDeduction.getStatus()){
				case "insert" :
					
					baseDeductionRepository.save(baseDeduction);
					//baseDeductionDAO.insertBaseDeduction(baseDeduction);
					break;
				case "update" :
					baseDeductionRepository.save(baseDeduction);
					//baseDeductionDAO.updateBaseDeduction(baseDeduction);
					break;
				case "delete" :
					baseDeductionRepository.delete(baseDeduction);
					//baseDeductionDAO.deleteBaseDeduction(baseDeduction);
					break;
			}
		}	
	}
	@Override
	public ArrayList<BaseSalaryTO> findBaseSalaryList() {
		System.out.println("=============================급여기준관리조회================================");
		ArrayList<BaseSalaryTO> baseSalaryList =(ArrayList<BaseSalaryTO>) baseSalaryRepository.findAll();
		//ArrayList<BaseSalaryTO> baseSalaryList = baseSalaryDAO.selectBaseSalaryList();
		return baseSalaryList;
	}
	@Override
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList) {
		for(BaseSalaryTO baseSalary : baseSalaryList){
			if(baseSalary.getStatus().equals("update"))
				System.out.println("=====================급여기준관리 변경확정 버튼=============================");
				
			baseSalaryRepository.save(baseSalary);
				//baseSalaryDAO.updateBaseSalary(baseSalary);
				 
		}
	}
	
	
	//초과수당관리 조회
	@Override
	public ArrayList<BaseExtSalTO> findBaseExtSalList() {
		
		ArrayList<BaseExtSalTO> baseExtSalList =(ArrayList<BaseExtSalTO>) baseExtSalRepository.findAll();
		//ArrayList<BaseExtSalTO> baseExtSalList = baseExtSalDAO.selectBaseExtSalList();
		
		return baseExtSalList;
	}
	
	//초과수당관리 변경확정
	@Override
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList) {
		for(BaseExtSalTO baseExtSal : baseExtSalList){
			baseExtSalRepository.save(baseExtSal);
			//baseExtSalDAO.updateBaseExtSal(baseExtSal);
		}		
	}


	//공제기준관리 -> 공제항목코드 추가+1
	@Override
	public String findLastBaseDeduction() { 
		String deductionCode = baseExtSalDAO.selectLastDeductionCode();		
		return deductionCode;
	}
}
