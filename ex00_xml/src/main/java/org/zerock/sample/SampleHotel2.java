package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel2 {
	// 스프링 4.3이후로는 자동으로 @autowired 주입된다.(68)
	private Chef chef;

// @AllArgsConstructor : 생성자 파라미터를 생략
//	public SampleHotel2(Chef chef) {
//		this.chef = chef;
//	}
	
}
