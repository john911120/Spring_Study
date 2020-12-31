package org.zerock.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	// method2
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String title;
	private Date dueDate;
}
