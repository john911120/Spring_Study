package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	// 4.3 이상에서는 자동 처리가 가능하게 되어졌다.
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	// (566) BoardServiceImpl를 처리하기 위한 setter 메서드 추가
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	// (204)
	// (566) BoardServiceImpl
	@Transactional
	@Override
	public void register(BoardVO board) {
		log.info("register....." + board);
		mapper.insertSelectKey(board);
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("Get List with criteria : " + cri);
		return mapper.getListWithPaging(cri);
	}
//	@Override
//	public List<BoardVO> getList() {
//		log.info("GetList...........");
//		return mapper.getlist();
//	}
	
	@Override
	public BoardVO get(Long bno) {
		log.info("get..." + bno);
		return mapper.read(bno);
	}
	
	// (591) 서버 측 게시물 수정과 첨부파일 관련 코드 수정
	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..." + board);
		
		attachMapper.deleteAll(board.getBno());
		
		boolean modifyResult = mapper.update(board) == 1;
		if(modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0) {
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;
	}
	
	// (579) BoardServiceImpl 변경
	@Transactional
	@Override
	public boolean remove(Long bno) {
		log.info("remove..." + bno);

		attachMapper.deleteAll(bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	// (569) 게시물의 첨부파일의 목록을 가져오게 한다.
	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("get Attach list by bno : " + bno);
		return attachMapper.findByBno(bno);
	}

}
