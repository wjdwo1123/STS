package kr.co.insaPrj5.hr.attd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.insaPrj5.hr.attd.to.DayAttdMgtTO;

public interface DayAttdMgtRepository extends JpaRepository<DayAttdMgtTO, String>{

}
