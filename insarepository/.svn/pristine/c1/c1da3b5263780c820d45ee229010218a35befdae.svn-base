package kr.co.insaPrj5;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import kr.co.insaPrj5.common.filter.SiteMeshFilter;

@SpringBootApplication
public class InsaPrj5Application {

	public static void main(String[] args) {
		SpringApplication.run(InsaPrj5Application.class, args);
	}

	@Bean
	public FilterRegistrationBean<Filter> siteMeshFilter() {
	FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
	filter.setFilter(new SiteMeshFilter());

	return filter;
	}
}
