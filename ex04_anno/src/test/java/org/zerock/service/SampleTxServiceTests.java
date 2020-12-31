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
@ContextConfiguration(classes={RootConfig.class})
/* annotation 이거 가져다 붙여놓으면 된다.
@ContextConfiguration(classes={RootConfig.class})
 */
@Log4j
public class SampleTxServiceTests {
	// (474)
	@Setter(onMethod_= {@Autowired})
	private SampleTxService service;
	
	
	/*
	 * tbl_sample1 삽입 성공
	 * tbl_sample2 ORA-12899: "SPRING"."TBL_SAMPLE2"."COL2" 열에 대한 값이 너무 큼(실제: 82, 최대값: 50)
	 */
	@Test
	public void testLong() {
		String str = "Starry\r\n" +
					"Starry night\r\n" +
					"Paint your Palette blue and grey\r\n" +
					"Look out on a summer's day";
		log.info(str.getBytes().length);
		
		service.addData(str);
	}
}
