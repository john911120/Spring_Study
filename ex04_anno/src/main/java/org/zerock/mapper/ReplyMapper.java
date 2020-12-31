package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

//(378) ReplyMapper 인터페이스 생성
public interface ReplyMapper {
	//(381) create
	public int insert(ReplyVO vo);
	
	// (384) read
	public ReplyVO read(Long bno);
	
	// (385) delete
	public int delete(Long bno);
	
	// (386) update
	public int update(ReplyVO reply);
	
	// (387) 댓글 목록
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
	
	// (432) 댓글 숫자 파악하기
	public int getCountByBno(Long bno);
}
