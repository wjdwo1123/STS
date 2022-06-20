package kr.co.insaPrj5.hr.salary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.insaPrj5.hr.salary.to.MonthSalaryTO;



public interface MonthSalaryRepository extends JpaRepository<MonthSalaryTO, String>{

}
