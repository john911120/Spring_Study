package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class SampleServiceTests {
	// (457)
	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	// (457)
	@Test
	public void testClass() throws Exception {
		log.info(service);
		log.info(service.getClass().getName());
	}
	// (458)
	@Test
	public void testAdd() throws Exception {
		log.info(service.doAdd("123", "456"));
	}
	// (460)
	@Test
	public void testAddError() throws Exception {
		// 예외 처리 결과를 보기 위해 고의적으로 예외를 발생 시켰다.
		log.info(service.doAdd("123", "NNN"));
	}
}
