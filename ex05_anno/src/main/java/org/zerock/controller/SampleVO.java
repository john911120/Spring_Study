package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@AllArgsConstructor : 파라미터 모두가 들어있는 기본 생성자 (P360)
//@NoArgsConstructor : 파라미터가 비어 있는 생성자
public class SampleVO {
	
	private Integer mno;
	private String firstName;
	private String lastName;
}
