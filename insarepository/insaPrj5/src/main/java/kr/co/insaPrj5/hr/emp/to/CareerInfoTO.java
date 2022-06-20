package kr.co.insaPrj5.hr.emp.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.insaPrj5.base.to.BaseTO;
import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "CAREER_INFO")
@Dataset(name="ds_careerInfo")
public class CareerInfoTO extends BaseTO{

@Id
private String empCode;
private String careerCode, companyName, occupation, assignmentTask, exHiredate, exRetirementDate,status;

}
