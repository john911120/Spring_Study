package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {
	// (473)
	@Setter(onMethod_= {@Autowired})
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_= {@Autowired})
	private Sample2Mapper mapper2;
	
	// (476) 트랜잭션 어노테이션 추가하기
	@Transactional
	@Override
	public void addData(String value) {
		log.info("mapper1...........");
		mapper1.insertCol1(value);
		
		log.info("mapper2...........");
		mapper2.insertCol2(value);
		
		log.info("end...............");
		/*
		 * @Transactional 추가된 이후에는 실행시 rollback()이 되며 샘플 테이블에는
		 * 아무런 데이터가 추가가 되지 않았다.
		 */
	}

}
