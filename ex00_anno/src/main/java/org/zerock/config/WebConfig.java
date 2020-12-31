package org.zerock.config;

import javax.servlet.Filter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// web.xml을 대신한 파일(44~45) : 모든 사용자(controller, servlet)에게 적용되는 내용


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

		@Override
		protected void customizeRegistration(ServletRegistration.Dynamic registration) {
			registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		}

}
