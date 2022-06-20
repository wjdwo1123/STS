package kr.co.insaPrj5.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.insaPrj5.common.interceptor.XplatformInterceptor;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); //5 * 1024 * 1024 (5mb)
		return commonsMultipartResolver;
	}
	
	@Autowired 
	XplatformInterceptor xplatformInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		
		registry.addInterceptor(xplatformInterceptor);
		
	}
}
