package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

//@RestController (@Controller + @ResponseBody('data')) P358
@RestController 
@RequestMapping("/sample2")
@Log4j
public class SampleController2 {
	
	 // 1. (359) - simple String return
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	 public String getText() {
		 log.info("MiME Type : " + MediaType.TEXT_PLAIN_VALUE);
		 return "HelloSpring";
	 }
	
	// 2. (360) - 객체 2개 이상인 경우 대괄호로 묶어줘야한다.
	/*
	 	http://localhost:8080/sample2/getSample => 아무것도 입력 안하면 xml으로 출력이 되고
	 	http://localhost:8080/sample2/getSample.json => json을 입력하면 json형태로 출력이 된다.
	 */
	@GetMapping(value="/getSample", produces = 
				{MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		
		return new SampleVO(172, "하계동", "상암동");
	}
	
	// 3. (363) - collection type 
	/*
	 	http://localhost:8080/sample2/getList => 아무것도 입력 안하면 xml으로 출력이 되고
	 	http://localhost:8080/sample2/getList.json => json을 입력하면 json형태로 출력이 된다.
	 */
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"First", i+"Last"))
					.collect(Collectors.toList());
	}
	// 3-1. (364) - collection type 
	/*
	 	http://localhost:8080/sample2/getList => 아무것도 입력 안하면 xml으로 출력이 되고
	 	http://localhost:8080/sample2/getList.json => json을 입력하면 json형태로 출력이 된다.
		http://localhost:8080/sample2/getMap
		http://localhost:8080/sample2/getMap.json
	 *
	 */
	
	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("a", new SampleVO(753, "연신내역","동교동"));
		map.put("b", new SampleVO(270, "동교동","이대역"));
		map.put("c", new SampleVO(172, "이대역","종로1가"));
		map.put("d", new SampleVO(704, "종로1가","연신내역"));
		map.put("e", new SampleVO(741, "연신내역","강남역"));
		map.put("f", new SampleVO(741, "강남역","연신내역"));
		
		return map;
	}
	
	// 4. ResponseEntity ( data + Http Status code) (365)
	/*
	  http://localhost:8080/sample2/check?height=140&weight=60 
	 http://localhost:8080/sample2/check.json?height=140&weight=60
	 */
	@GetMapping(value = "/check", params= {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(000, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 160) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	
	// 5. (366~7) @PathBariable : 경로+값 = 경로의 파라미터
	/*
	 	http://localhost:8080/sample2/product/ak/74(경로이름이면서 파라미터의 값이 된다.)
	 */
	@GetMapping("/product/{cat}/{gunno}")
	public String[] getPath(
				@PathVariable("cat") String cat,
				@PathVariable("gunno") Integer gunno) {
		return new String[] {"category : " + cat, "productid:" + gunno };
	}
	
	// 6. (368) @RequestBody : post방식
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert......ticket" + ticket);
		
		return ticket;
	}
}
