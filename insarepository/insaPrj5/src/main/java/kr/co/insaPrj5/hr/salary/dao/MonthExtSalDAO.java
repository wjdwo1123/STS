package kr.co.insaPrj5.hr.salary.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.hr.salary.to.MonthExtSalTO;
import kr.co.insaPrj5.hr.salary.to.MonthSalaryTO;
@Mapper
public interface MonthExtSalDAO {
	public ArrayList<MonthExtSalTO> selectMonthExtSalList(MonthSalaryTO to);
}
