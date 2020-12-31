package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@RequiredArgsConstructor
// @RequiredArgsConstructor : @NonNull, Final이 붙은 변수에 대한 생성자를 만든다.

public class SampleHotel3 {
	// 스프링 4.3이후로는 자동으로 @autowired 주입된다.(70)
	@NonNull
	private Chef chef;

//	public SampleHotel3(Chef chef) {
//		this.chef = chef;
//	}
}
