package kr.co.insaPrj5.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.insaPrj5.base.to.HolidayTO;

public interface HolidayRepository extends JpaRepository<HolidayTO,Integer>{

	
}
