package org.zerock.sample;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j 
public class HotelTests3 {
	
	// Junit Test에서는 @Autowired를 사용한다.(69)
	@Setter(onMethod_ = {@Autowired})
	private SampleHotel3 hotel3;
	
	@Test
	public void test() {
		
		assertNotNull(hotel3);
		
		log.info(hotel3);
		log.info("--------------------------");
		log.info(hotel3.getChef());
	}

}
