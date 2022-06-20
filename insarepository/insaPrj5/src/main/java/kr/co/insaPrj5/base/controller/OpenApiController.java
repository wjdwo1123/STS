package kr.co.insaPrj5.base.controller;

import com.tobesoft.xplatform.data.PlatformData;
import kr.co.insaPrj5.base.to.OpenApiBean;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

@RestController
public class OpenApiController {

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	//로그인>Main 문화정보 오픈API
	@RequestMapping(value="base/openApi.do")
	public void openApiHandler(@RequestAttribute("reqData") PlatformData reqData,
							   @RequestAttribute("resData") PlatformData resData) throws Exception {

		ArrayList<OpenApiBean> openApiList= new ArrayList<>();
		OpenApiBean OpenApiBean = null;

//		String url =
//				"http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?"
//						+ "serviceKey=LJE4Swf/D8mDyQcKigQcBW6xbmavmbs39+KV6zuMXyuMgJvfdJmji4ZM0ElE9OUvcvhpZtH8gyPLzj+NHZFHtg=="
//						+ "&pageNo=1"
//						+ "&numOfRows=15"
//						+ "&dataType=JSON"
//						+ "&CURRENT_DATE=2019122010"
//						+ "&HOUR=24"
//						+ "&COURSE_ID=1";
		String url =
				"http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?"
				+ "serviceKey=LJE4Swf%2FD8mDyQcKigQcBW6xbmavmbs39%2BKV6zuMXyuMgJvfdJmji4ZM0ElE9OUvcvhpZtH8gyPLzj%2BNHZFHtg%3D%3D"
				+ "&pageNo=2"
				+ "&numOfRows=20"
				+ "&dataType=XML"
				+ "&CURRENT_DATE=2019122010"
				+ "&HOUR=24"
				+ "&COURSE_ID=1";
			
				
		System.out.println(url);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); // xml데이터를 파싱할 수 있는 객체
		Document doc = dBuilder.parse(url);   // url의 xml데이터를 분석하여 DOM문서객체 반환
		doc.getDocumentElement().normalize();   // DOM트리가 XML문서의 구조대로 완성된다

		NodeList nList = doc.getElementsByTagName("item"); // item 태그 리스트 반환

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp); // 각각의 item태그

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {   // 해당 노드가 요소노드이면
				Element eElement = (Element) nNode;  // Element객체로 형변환

				OpenApiBean = new OpenApiBean();
				// 해당 태그의 텍스트노드 값을 가져와 세팅
				OpenApiBean.setTm(getTagValue("tm", eElement)); // 공연번호
				OpenApiBean.setThema(getTagValue("thema", eElement)); // 제목
				OpenApiBean.setCourseAreaName(getTagValue("courseAreaName", eElement)); // 공연시작일
				OpenApiBean.setCourseName(getTagValue("courseName", eElement)); // 공연종료일
				OpenApiBean.setSpotName(getTagValue("spotName", eElement)); // 오픈런
				//OpenApiBean.setPlaceNm(getTagValue("place_nm", eElement)); // 시설명
				//OpenApiBean.setPayAt(getTagValue("pay_at", eElement)); // 유무료 구분

			}
			openApiList.add(OpenApiBean);
		}
		datasetBeanMapper.beansToDataset(resData, openApiList, OpenApiBean.class);
	}

	private static String getTagValue(String tag, Element eElement) {  // 자식 태그명, item태그
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes(); // item태그의 자식태그 중 해당 태그의 리스트.중 0번째 인덱스.의 모든 자식노드 / 즉 해당 tag의 자식노드 리스트
		Node nValue = (Node) nlList.item(0);
		// 하위 노드 리스트의 첫 번째 노드(item index 0) / 즉 텍스트 노드다
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue(); // 노드의 값 반환
	}
}
