package kr.co.insaPrj5.base.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.base.to.ReportSalaryTO;
import kr.co.insaPrj5.base.to.ReportTO;

@Mapper
public interface ReportDAO {
   public ReportTO selectReport(String empCode);

   public ReportSalaryTO selecSalarytReport(HashMap<String, Object> parameters);
   
}