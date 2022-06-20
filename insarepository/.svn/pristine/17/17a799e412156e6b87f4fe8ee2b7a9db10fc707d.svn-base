package kr.co.insaPrj5.base.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

 
import com.tobesoft.xplatform.data.PlatformData;

import kr.co.insaPrj5.base.sf.BaseServiceFacade;
import kr.co.insaPrj5.base.to.DeptTO;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
 
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import kr.co.insaPrj5.hr.emp.sf.EmpServiceFacade;


@RestController
public class DeptListController {	
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private EmpServiceFacade empServiceFacade;	
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	
	
//시스템관리에-> 부서관리목록 저장버튼시 실행 되는경로 
	@RequestMapping("/base/batchDeptProcess.do")
	public void batchDeptProcess(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("부서관리목록????????????????????????????????????????????????????");
		ArrayList<DeptTO> deptto =(ArrayList<DeptTO>) datasetBeanMapper.datasetToBeans(reqData,DeptTO.class);
		
		baseServiceFacade.batchDeptProcess(deptto);
	}

	
	//부서로딩 
	@RequestMapping("/base/findDeptList")
	public ModelMap findDeptList(HttpServletRequest request, HttpServletResponse responsea) throws Exception {
		System.out.println("<<<<< 부서로딩    >>>>>>");
		
		
		PlatformData resData=(PlatformData) request.getAttribute("resData");

		List<DeptTO> list = empServiceFacade.findDeptList();
		datasetBeanMapper.beansToDataset(resData, list, DeptTO.class);
 
		return null;
	}
}
