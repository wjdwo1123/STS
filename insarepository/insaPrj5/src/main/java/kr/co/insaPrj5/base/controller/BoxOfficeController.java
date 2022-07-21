package kr.co.insaPrj5.base.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;

@RestController
public class BoxOfficeController {
	   
	@PostMapping("/base/boxOffice.do")
	public ModelMap showBoxOffice(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("목요일 수정");
		  ModelMap modelMap = new ModelMap();
	      try {  
	    	 request.setCharacterEncoding("UTF-8");
			 response.setContentType("application/json; charset=UTF-8");
	         
	         Calendar c1 = new GregorianCalendar(); // �궇吏쒓��졇�삤�뒗 class 
	         c1.add(Calendar.DATE, -1); // �씪蹂꾨컯�뒪�삤�뵾�뒪 API : �삤�뒛�궇吏쒕줈遺��꽣 -1 (�쁺�솕�뜲�씠�꽣媛��삤�뒛�궇吏쒕뒗�뾽濡쒕뱶媛��븞�맖)
	         SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd"); // �궇吏� �룷留�
	         
	         String yesterDay = date.format(c1.getTime()); // String�쑝濡� ���옣         
	         // c1.getTime()�씠  Tue Feb 04 15:16:59 KST 2020 李랁엳�뒗�뜲 吏��젙�빐�몦 ���엯�쑝濡� �궇吏쒗삎�떇�쓣蹂�寃� 
	         
	         String targetDt=yesterDay; //�궇吏쒓린以�
	         String itemPerPage="10"; //�븳�럹�씠吏��뿉蹂댁뿬吏덉닔
	         String multiMovieYn=""; //�떎�뼇�꽦 "Y",�긽�뾽�쁺�솕 "N" ,default �쟾泥�
	         String repNationCd=""; //�븳援� "k",�쇅援��쁺�솕 "F" ,default �쟾泥�
	         String wideAreaCd=""; //�긽�쁺吏��뿭蹂꾩“�쉶媛��뒫, default �쟾泥�

	         String key="6b146419f65095b1292760b0974a7add";  // 怨듦났api�뿉�꽌諛쏆��궎踰덊샇 (�떊泥��빐�꽌諛쏆쓬)
	         KobisOpenAPIRestService service=new KobisOpenAPIRestService(key);
	         
	         String dailyResponse=service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);          
	         
	         modelMap.put("errorCode", 0);
	         modelMap.put("errorMsg", "success");
	         modelMap.put("dailyResponse", dailyResponse);

	      } catch (Exception e) {
	    	  modelMap.put("errorCode", -1);
	    	  modelMap.put("errorMsg", e.getMessage());
	      }
	      return modelMap;
	   }

	}