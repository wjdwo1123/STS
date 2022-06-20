package kr.co.insaPrj5.base.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "DIVISION_CODE")
@Dataset(name="gds_codeList")
public class CodeTO extends BaseTO{
	@Id
	private String codeNumber;
	private String codeName;
	private String modifiable;
	
 
}
