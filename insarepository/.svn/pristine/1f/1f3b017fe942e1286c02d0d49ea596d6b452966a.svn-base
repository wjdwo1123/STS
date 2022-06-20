package kr.co.insaPrj5.common.interceptor;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.Debugger;
import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.VariableList;
import com.tobesoft.xplatform.tx.HttpPlatformRequest;
import com.tobesoft.xplatform.tx.HttpPlatformResponse;
import com.tobesoft.xplatform.tx.PlatformType;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class XplatformInterceptor extends HandlerInterceptorAdapter {
   @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	   
       System.out.println("@@@@@@@@@@@@XplatformInterceptor preHandle메서드 작동");
        HttpPlatformRequest httpPlatformRequest = new HttpPlatformRequest(request);
        httpPlatformRequest.receiveData();
        //xml로 되어있는 데이터 셋을 java 데이터셋으로 바꿔주고 안에 간직해주는 메서드
        
        PlatformData reqData = httpPlatformRequest.getData();
        PlatformData resData = new PlatformData();
        debug(reqData.getDataSetList(), reqData.getVariableList());
        System.out.println("========================"+reqData.getDataSetList()+"=====================찍히는값");
        request.setAttribute("reqData", reqData);
        request.setAttribute("variableList", reqData.getVariableList());
        request.setAttribute("resData", resData);
       System.out.println("@@@@@@@@@@@@XplatformInterceptor preHandle메서드 종료");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       System.out.println("@@@@@@@@@@@@XplatformInterceptor postHandle메서드 접근");
       super.postHandle(request, response, handler, modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
       System.out.println("@@@@@@@@@@@@XplatformInterceptor afterCompletion메서드 접근");
       PlatformData resData = (PlatformData) request.getAttribute("resData");
        if(resData==null){
           return;
        }
        VariableList variableList = resData.getVariableList();
        if (exception != null) {
            exception.printStackTrace();
            variableList.add("ErrorCode", -1);
            variableList.add("ErrorMsg", exception.getMessage());
        } else {
            variableList.add("ErrorCode", 0);
            variableList.add("ErrorMsg", "success");
        }
        HttpPlatformResponse httpPlatformResponse = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8");
        httpPlatformResponse.setData(resData);
        httpPlatformResponse.sendData();
        debug(resData.getDataSetList(), resData.getVariableList());
        resData = null;
        super.afterCompletion(request, response, handler, exception);
       System.out.println("@@@@@@@@@@@@XplatformInterceptor afterCompletion메서드 종료");
    }
    private void debug(DataSetList dataSetList, VariableList variableList) {
       System.out.println("@@@@@@@@@@@@XplatformInterceptor debug메서드 접근");
        Debugger debugger = new Debugger();
        // DEBUG - DataSet
        for (int n = 0; n < dataSetList.size(); n++) {
            System.out.println("debug11@@@@@@"+debugger.detail(dataSetList.get(n)));
        }
        // DEBUG - VariableList
        for (int n = 0; n < variableList.size(); n++) {
            System.out.println("debug22@@@@@@"+debugger.detail(variableList.get(n)));
        }
       System.out.println("@@@@@@@@@@@@XplatformInterceptor debug메서드 종료");
    }
}