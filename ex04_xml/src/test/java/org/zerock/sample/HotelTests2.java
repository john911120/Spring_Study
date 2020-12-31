package org.zerock.sample;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HotelTests2 {
	
	// Junit Test에서는 @Autowired를 사용한다.(69)
	@Setter(onMethod_ = {@Autowired})
	private SampleHotel2 hotel2;
	
	@Test
	public void test() {
		
		assertNotNull(hotel2);
		
		log.info(hotel2);
		log.info("--------------------------");
		log.info(hotel2.getChef());
	}

}
