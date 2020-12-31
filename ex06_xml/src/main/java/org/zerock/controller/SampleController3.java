package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller 
@RequestMapping("/sample/*")
@Log4j
public class SampleController3 {
	
	// 스프링 시큐리티 예제(613)
	/*
	 * sample/all => 로그인하지 않은 사용자도 접근이 가능하다.
	 * sample/member -> 로그인한 사용자만 접근 가능하다.
	 * sample/admin -> 로그인 한 사용자들 중에서 관리자 권한을 가진 사용자만 접근 할 수 있는 URI
	 */
	 
	@GetMapping("/all")
	public void doAll() {
		log.info("모든 사용자가 접근 가능합니다.");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("로그인 된 회원만 접근 가능합니다.");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("관리자만 접근 가능합니다.");
	}
}
