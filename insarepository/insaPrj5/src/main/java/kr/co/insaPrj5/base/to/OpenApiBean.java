package kr.co.insaPrj5.base.to;




import kr.co.insaPrj5.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Dataset(name="gds_api")
public class OpenApiBean {

	String tm;
	String thema;
	String courseAreaName;
	String courseName;
	String spotName;
	//String resNo;
	//String title;
	//String opStDt;
	//String opEdDt;
	//String opAt;
	//String placeNm;
	//String payAt;

}
