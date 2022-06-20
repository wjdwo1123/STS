package kr.co.insaPrj5.hr.attd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.insaPrj5.hr.attd.to.RestAttdTO;

public interface RestAttdRepository extends JpaRepository <RestAttdTO,String>{

}
