package kr.co.insaPrj5.base.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.PlatformData;

import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.common.util.FIleUtil;

@Controller
public class SaveEmpImgController{


	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	@Autowired
	private FIleUtil fIleUtil;

	
	// 사원의 이미지를 저장하는 메서드 
	@RequestMapping("/base/saveEmpImg.do")
	public ModelAndView saveEmpImg(@RequestAttribute("reqData") PlatformData reqData,
				 		   @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		
		DataSet dataset = reqData.getDataSet("ds_img");
		FileOutputStream out=null; //파일로 바이트 단위의 출력을 내보내는 클래스 
		//File files = null;
		File[] listFile=null;
		String fullFileName = (String) dataset.getObject(0, "EMP_FILE_NAME");
		String fileName = fullFileName.substring(0,fullFileName.lastIndexOf('.'));
		System.out.println("================ FullEmpImg : "+fullFileName);
		System.out.println("================ EmpImg : "+fileName);
		String filePath ="C:\\dev\\Apache2.2\\htdocs\\EmpImg\\";
		try {
			listFile = new File(filePath).listFiles();
			if(listFile.length > 0) {
				for(int i=0; i<listFile.length; i++) {
					String listFileName = listFile[i].getName();
					String subStringFile = listFileName.substring(0, listFileName.lastIndexOf('.'));
					System.out.println("파일이름??"+listFileName);
					System.out.println("자른파일??"+listFileName.substring(0, listFileName.lastIndexOf('.')));
					if(subStringFile.equals(fileName)) {
						System.out.println("이프문에들어온거"+i);
						System.out.println("삭제되나?"+listFile[i].delete());
						listFile[i].delete();
					}
				}
			}
			/*
			 * files = new File(filePath+"A1112.*"); System.out.println(files);
			 * files.delete();
			 */
			if (fullFileName != null) {
			out = new FileOutputStream(filePath+fullFileName); //파일 입출력 
			byte[] file = dataset.getBlob(0, "IMG_FILE_DATA"); //Blob : Binary Large Objects 의약자임  [이미지, 사운드, 동영상 등 대용량 바이너리 데이터 가져오기] 
			BufferedOutputStream  bufferedOut=new BufferedOutputStream(out); // FileOutputStream 값을 입출력 
			bufferedOut.write(file); 
			bufferedOut.flush(); //현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다. 
			bufferedOut.close();
			out.close();
			bufferedOut=null;
			out = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return null;
	}
}