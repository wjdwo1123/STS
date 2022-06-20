package kr.co.insaPrj5.hr.attd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.insaPrj5.hr.attd.to.MonthAttdMgtTO;

public interface MonthAttdMgtRepository extends JpaRepository<MonthAttdMgtTO , String>{

}
