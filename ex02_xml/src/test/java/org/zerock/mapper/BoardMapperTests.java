package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getlist().forEach(board -> log.info(board)); // 람다식으로 작성되어 있다.
	}
	// Insert 처리
	@Test
	public void testinsert() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 제목3");
		board.setContent("테스트 내용4");
		board.setWriter("user03");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testinsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 제목5");
		board.setContent("테스트 내용6");
		board.setWriter("user05");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	// Read 처리
	@Test
	public void testRead() {
		BoardVO board = mapper.read(4L);
		
		log.info(board);
	}
	
	// Delete 처리
	@Test
	public void testDelete() {
		log.info("Delete Count : " + mapper.delete(8L)); // 실존하는 bno 숫자를 확인하고 실행하기
	}
	
	// Update 처리
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(12L);
		board.setTitle("테스트 제목5");
		board.setContent("테스트 내용6");
		board.setWriter("user05");
		
		int count = mapper.update(board);
		
		log.info("Update Count : " + count);
	}
	
	// p295
	// p297 정상 작동 되면 수정을 한다.(페이지 수를 추가)
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		// 10개의 게시글을 3페이지씩 출력
//		cri.setPageNum(1);
//		cri.setAmount(10);
//		cri.setPageNum(2);
//		cri.setAmount(10);
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
	//p 336
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("테스트");
		cri.setType("TC");
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
}
