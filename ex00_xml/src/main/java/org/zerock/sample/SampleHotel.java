package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
public class SampleHotel {
	// 스프링 4.3이후로는 자동으로 @autowired 주입된다.(68)
	private Chef chef;

	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
}
