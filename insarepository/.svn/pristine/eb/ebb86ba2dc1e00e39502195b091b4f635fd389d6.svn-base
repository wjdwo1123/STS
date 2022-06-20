package kr.co.insaPrj5.base.controller;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.insaPrj5.base.sf.BaseServiceFacade;
import kr.co.insaPrj5.common.mapper.DatasetBeanMapper;
import kr.co.insaPrj5.hr.emp.sf.EmpServiceFacade;
import kr.co.insaPrj5.hr.emp.to.EmpTO;

@RestController
public class EmpLoginController {
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private EmpServiceFacade empServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("/base/login.do")
	public ModelMap empLogin(@RequestAttribute("reqData") PlatformData reqData,
							@RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("�쁿�쁾�쁿�쁾濡쒓렇�씤而⑦듃濡ㅻ윭吏꾩엯�쁿�쁾�쁿�쁾");
		
		String name = reqData.getVariable("empName").getString();
		String empCode = reqData.getVariable("empCode").getString();
		
		
		EmpTO empto = null;
			
			if(baseServiceFacade.login(name,empCode)) {
			 empto = empServiceFacade.getEmp(name);
			}
			datasetBeanMapper.beanToDataset(resData, empto, EmpTO.class);
	
		return null;
	}
}
