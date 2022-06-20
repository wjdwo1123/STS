package kr.co.insaPrj5.base.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.insaPrj5.base.sf.BaseServiceFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.insaPrj5.common.util.FIleUtil;

@Controller
public class EmpImgController {
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	private ModelMap modelMap = new ModelMap();

	@PostMapping("base/empImg.do")
	public ModelMap handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest)request; 
		Iterator<String> iterator = mhsr.getFileNames(); 
		MultipartFile multipartFile = null; 
		while(iterator.hasNext()){ 
			multipartFile = mhsr.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){ 
				System.out.println("------------- file start -------------");
				System.out.println("name : "+multipartFile.getName());
				System.out.println("filename : "+multipartFile.getOriginalFilename());
				System.out.println("size : "+multipartFile.getSize());
				System.out.println("-------------- file end --------------\n"); }

		}



		//org.apache.tomcat.util.http.fileupload package : 인코딩타입 - 'multipart/form-data'
		//DiskFileItemFactory factory = new DiskFileItemFactory(); //디스크에 있는 파일 읽어오는 class
		//ServletFileUpload upload = new ServletFileUpload(factory); //읽어온파일 서버에 올리는 애
		//RequestContext rc = new ServletRequestContext(request);

		String empCode = request.getParameter("empCode");
		String empImgUrl = null;
//		try {
//
//			/*
//			1. all : 모든 경고를 억제
//			2. cast : 캐스트 연산자 관련 경고 억제
//			3. dep-ann : 사용하지 말아야 할 주석 관련 경고 억제
//			4. deprecation : 사용하지 말아야 할 메소드 관련 경고 억제
//			5. fallthrough : switch문에서의 break 누락 관련 경고 억제
//			6. finally : 반환하지 않는 finally 블럭 관련 경고 억제
//			7. null : null 분석 관련 경고 억제
//			8. rawtypes : 제네릭을 사용하는 클래스 매개 변수가 불특정일 때의 경고 억제
//			9. unchecked : 검증되지 않은 연산자 관련 경고 억제
//			10. unused : 사용하지 않는 코드 관련 경고 억제
//			 */	   
//			if((multipartFile.getName() != null) && (multipartFile.getSize() > 0)){
//				empImgUrl = FileUploadUtil.doFileUpload(request, multipartFile, empCode);
//				String imgExtend = empImgUrl.substring(empImgUrl.lastIndexOf(".")+1);
//				HashMap<String,Object> map = new HashMap<>();
//				map.put("empCode",empCode);
//				map.put("imgExtend",imgExtend);
//				baseServiceFacade.registEmpImg(map);
//				System.out.println("empImgUrl: "+empImgUrl);
//			}
//			modelMap.put("empImgUrl", empImgUrl);
//			modelMap.put("errorCode", 0);
//			modelMap.put("errorMsg", "사진 저장에 성공했습니다");
//		} catch (IOException e){
//			modelMap.put("errorCode", -1);
//			modelMap.put("errorMsg", "사진 저장에 실패했습니다");
//		}
		return modelMap;
	}
}