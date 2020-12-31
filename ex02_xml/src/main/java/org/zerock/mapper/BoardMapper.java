package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
		
	// Method1 : xml을 사용하지 않는 방법
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getlist();
	
	// 294
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// Insert
	public void insert(BoardVO board);
	
	// 294
	public Integer insertSelectKey(BoardVO board);

	// Read
	public BoardVO read(Long bno);
	
	// Delete
	public int delete(Long bno);
	
	// Update
	public int update(BoardVO board);
	
	// p322 마이바티스에서 전체 데이터 개수 처리를 확인하는 방법
	public int getTotalCount(Criteria cri);
}
