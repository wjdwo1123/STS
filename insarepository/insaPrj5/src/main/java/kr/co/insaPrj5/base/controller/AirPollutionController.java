package kr.co.insaPrj5.base.controller;

import java.io.BufferedReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;

@RestController
public class AirPollutionController{
	
	BufferedReader br = null;

	@PostMapping("/base/airPollution.do")
	public ModelMap showDust(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("목요일 수정");
		ModelMap modelMap = new ModelMap();
		BufferedReader br = null;
	    try{     
	    	request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
	        String serviceKey = "3mdiAYH1D2bnbdkEio3XJCqCD15oudYH18XvcLgs8DVRLcbgn4WpNnFalMpgvW8V0bC79bNhELI8m2n7FvaAMQ%3D%3D";
	        	
	        String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?"
	        		+ "serviceKey="+serviceKey
	        		+ "&numOfRows=18"
	            	+ "&pageNo=1"
	            	+ "&sidoName=%EA%B2%BD%EB%82%A8"
	            	+ "&searchCondition=DAILY"
	            	+ "&_returnType=json";
	        System.our.println("�꽭踰덉㎏");
	            
	            URL url = new URL(urlstr);
	            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
	            urlconnection.setRequestMethod("GET");
	            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
	            String result = "";
	            String line;
	            while((line = br.readLine()) != null) {
	                result = result + line + "\n";
	            }
	            modelMap.put("errorCode", 0);
	            modelMap.put("errorMsg", "success");
	            modelMap.put("result", result);
		        
	        }catch(Exception e){
	        	modelMap.put("errorCode", -1);
	        	modelMap.put("errorMsg", e.getMessage());
	        }
		    return modelMap;
	      
	   }

	}