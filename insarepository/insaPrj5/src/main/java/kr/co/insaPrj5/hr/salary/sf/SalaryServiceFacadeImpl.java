package kr.co.insaPrj5.hr.salary.sf;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.insaPrj5.hr.salary.applicationService.SalaryApplicationService;
import kr.co.insaPrj5.hr.salary.sf.SalaryServiceFacade;
import kr.co.insaPrj5.hr.salary.sf.SalaryServiceFacadeImpl;
import kr.co.insaPrj5.hr.salary.to.BaseDeductionTO;
import kr.co.insaPrj5.hr.salary.to.BaseExtSalTO;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryBean;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryTO;                                            
@Service
public class SalaryServiceFacadeImpl implements SalaryServiceFacade{
	@Autowired
	private SalaryApplicationService salaryApplicationService;
	
	@Override
	public ArrayList<BaseSalaryTO> findBaseSalaryList() {		
			ArrayList<BaseSalaryTO> baseSalaryList=salaryApplicationService.findBaseSalaryList();
			return baseSalaryList;	
	}
	
	@Override
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList) {
			salaryApplicationService.modifyBaseSalaryList(baseSalaryList);					
	}
	
	@Override
	public ArrayList<BaseDeductionTO> findBaseDeductionList() {
			ArrayList<BaseDeductionTO> baseDeductionList=salaryApplicationService.findBaseDeductionList();
			return baseDeductionList;
	}
	
	@Override
	public void batchBaseDeductionProcess(ArrayList<BaseDeductionTO> baseDeductionList) {
			salaryApplicationService.batchBaseDeductionProcess(baseDeductionList);
	}
	
	@Override
	public ArrayList<BaseExtSalTO> findBaseExtSalList() {
			ArrayList<BaseExtSalTO> baseExtSalList=salaryApplicationService.findBaseExtSalList();
			return baseExtSalList;
	}	
	@Override
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList) {
			salaryApplicationService.modifyBaseExtSalList(baseExtSalList);
	}

	@Override
	public HashMap<String,Object> findMonthSalary(HashMap<String,Object> map) {
			HashMap<String,Object> result = salaryApplicationService.findMonthSalary(map);
			return 	result;
	}

	@Override
	public HashMap<String,Object> findYearSalary(HashMap<String,Object> map) {
			HashMap<String,Object> result=salaryApplicationService.findYearSalary(map);
			return result;
	}
	
	@Override
	public void modifyMonthSalary(MonthSalaryBean monthSalary) {
			salaryApplicationService.modifyMonthSalary(monthSalary);
	}

	@Override
	public String findLastBaseDeduction() {
		String deductionCode = salaryApplicationService.findLastBaseDeduction();
		return deductionCode;	
	}
	
}
