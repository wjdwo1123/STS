package kr.co.insaPrj5.common.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class homeController extends WebMvcConfigurerAdapter{
       @Override
       public void addViewControllers(ViewControllerRegistry registry ) {
           registry.addViewController( "/" ).setViewName( "redirect:/main.html" );
           registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
           super.addViewControllers( registry );
       }
}