package kr.co.insaPrj5.hr.attd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.insaPrj5.hr.attd.to.DayAttdTO;

public interface DayAttdRepository extends JpaRepository<DayAttdTO, String>{

}
