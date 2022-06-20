
  package kr.co.insaPrj5.hr.emp.to;
  
  import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;
  
  
  
  @Data
  @Entity(name="TESTTABLE")
  @Dataset(name="ds_empList")
  @Table(name = "TESTTABLE")
  @EqualsAndHashCode(callSuper=false)
  public class testEmpTO extends BaseTO{
  
	  @Id
  private String empName;
  
  private String gender,
  prNum,age,eduLevel,coffee,birthday,menuUrl,memo;
  
	
  
  }
  
 