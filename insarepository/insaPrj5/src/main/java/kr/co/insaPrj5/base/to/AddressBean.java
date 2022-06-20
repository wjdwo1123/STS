package kr.co.insaPrj5.base.to;

import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

@Dataset(name="gds_post")
public class AddressBean{
	@Setter
	@Getter
   String zipNO, lnmAdres, rnAdres;

}