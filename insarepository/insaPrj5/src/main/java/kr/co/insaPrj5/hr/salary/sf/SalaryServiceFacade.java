package kr.co.insaPrj5.hr.salary.sf;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.insaPrj5.hr.salary.to.BaseDeductionTO;
import kr.co.insaPrj5.hr.salary.to.BaseExtSalTO;
import kr.co.insaPrj5.hr.salary.to.BaseSalaryTO;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryBean;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryTO;

public interface SalaryServiceFacade {
	
	public ArrayList<BaseSalaryTO> findBaseSalaryList();
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList);

	public ArrayList<BaseDeductionTO> findBaseDeductionList();
	public void batchBaseDeductionProcess(ArrayList<BaseDeductionTO> baseDeductionList);

	public ArrayList<BaseExtSalTO> findBaseExtSalList();
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList);

	public HashMap<String, Object> findMonthSalary(HashMap<String,Object> map);
	public HashMap<String, Object> findYearSalary(HashMap<String,Object> map);
	public void modifyMonthSalary(MonthSalaryBean monthSalary);
	public String findLastBaseDeduction();
}
