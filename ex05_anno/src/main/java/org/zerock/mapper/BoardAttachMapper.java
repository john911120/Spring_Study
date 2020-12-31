package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;

public interface BoardAttachMapper {
	// (552) 첨부파일 처리를 위한 mapper
	public void insert(BoardAttachVO vo);
	
	public void delete(String uuid);
	
	public List<BoardAttachVO> findByBno(Long bno);
	
	// (578) 첨부파일 삭제 처리
	public void deleteAll(Long bno);
	
	// (600) 데이터베이스에 저장된 모든 파일의 목록을 사용하기 위한 코드 추가
	public List<BoardAttachVO> getOldFiles();
}
