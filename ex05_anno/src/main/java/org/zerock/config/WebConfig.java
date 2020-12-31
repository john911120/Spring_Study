package org.zerock.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// web.xml을 대신한 파일(44~45) : 모든 사용자(controller, servlet)에게 적용되는 내용
// 117
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	// filter 기능 추가(나중에는 복사에서 집어만 넣으면 된다.)
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter c = new CharacterEncodingFilter();
		c.setEncoding("UTF-8");
		c.setForceEncoding(true);
		return new Filter[] {c};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class}; // RootConfig.java 연결하여 사용하겠다.
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	// (493) multipart-config 태그를 자바로 사용하려면 아래와 같이 작성을 해야한다.
	// https://docs.oracle.com/javaee/7/api/javax/servlet/MultipartConfigElement.html API 자료이다.
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		
		MultipartConfigElement multipartConfig = 
				new MultipartConfigElement("C:\\upload\\temp", 20971520, 41943040, 20971520);
		registration.setMultipartConfig(multipartConfig);
	}
	
}