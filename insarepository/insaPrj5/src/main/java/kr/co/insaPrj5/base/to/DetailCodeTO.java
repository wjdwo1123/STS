package kr.co.insaPrj5.base.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;

@SuppressWarnings("serial")
@Entity	//jpa 룰 사용할려고 쓴것 (jpa를 사용할 객체라고 선언)
@Data
@Table(name = "DETAIL_CODE")
@Dataset(name="gds_detailcode")
@IdClass(value=DetailCodeTO.class)
public class DetailCodeTO implements Serializable{
	@Id
	private String detailCodeNumber;
	
	@Id
	private String codeNumber; 
	
	private String detailCodeName;	
	 
	@Column(nullable=false)
	private String detailCodeNameusing;

}



