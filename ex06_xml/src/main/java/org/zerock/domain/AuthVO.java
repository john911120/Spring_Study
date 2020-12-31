package org.zerock.domain;

import lombok.Data;

@Data
public class AuthVO {
	// (661) 회원 도메인 및 맵퍼 설계하기
	private String userid;
	private String auth;
}
