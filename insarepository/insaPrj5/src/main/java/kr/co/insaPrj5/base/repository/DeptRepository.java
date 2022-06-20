package kr.co.insaPrj5.base.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.base.to.DetailCodeTO;

public interface DeptRepository extends JpaRepository<DeptTO, String>{


}
