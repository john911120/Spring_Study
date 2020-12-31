package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	// 댓글 처리를 위해 게시물의 여부를 확인을 하고 작성할것(383)
	private Long[] bnoArr = {1686L, 1685L, 1684L, 1683L, 1682L};
	// (380)
	@Setter(onMethod_= @Autowired)
	private ReplyMapper mapper;
	
	// (383)
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			// 게시물의 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("SampleReply" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
		
	}
	
	// (385) 댓글 조회확인(5번 댓글을 확인한다.)
	@Test
	public void testRead() {
			Long targetRno = 5L;
			
			ReplyVO vo = mapper.read(targetRno);
			
			log.info(vo);
		}
	
	// (380)
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	// (386) 1번 댓글을 삭제한다.
	@Test
	public void testDelete() {
			Long targetRno = 1L;
			
			mapper.delete(targetRno);
		}
	
	// (387) reply Update
	@Test
	public void testUpdate() {
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update된 댓글");
		
		int count = mapper.update(vo);
		
		log.info("Update Count : " + count);
	}
	
	// (389)
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
		
	}
	
	// (432)
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);
		
		// 1686L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 1686L);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
