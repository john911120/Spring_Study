package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	public void register(BoardVO board); // insert
	
	public BoardVO get(Long bno); // select
	
	public boolean modify(BoardVO board); // update

	public boolean remove(Long bno); // delete
	
	public List<BoardVO> getList(Criteria cri); // select *
	
	public int getTotal(Criteria cri); // p323
	
	// (569) 게시물 조회와 첨부파일을 위한 코드 추가
	public List<BoardAttachVO> getAttachList(Long bno);
}
