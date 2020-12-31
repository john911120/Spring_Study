package org.zerock.domain;
// 183
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Long rno;
	private Long bno;

	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	
	//(481) 댓글과 댓글 수 처리
	private int replyCnt;
	
	// (552) BoardAttachVO를 처리할 수 있도록 코드 추가
	private List<BoardAttachVO> attachList;
}
