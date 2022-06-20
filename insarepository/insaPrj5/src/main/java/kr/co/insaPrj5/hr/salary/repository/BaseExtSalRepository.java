package kr.co.insaPrj5.hr.salary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

 import kr.co.insaPrj5.hr.salary.to.BaseExtSalTO;

public interface BaseExtSalRepository extends JpaRepository<BaseExtSalTO, String>{

}
