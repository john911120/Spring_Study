package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller 
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	// 136 코드를 먼저 선행으로 실행하겠다. (method1 = method2를 실행 하려면 27~31라인의 코드를 주석 처리하면 된다.)
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	
// A. VOID를 사용 - 리턴값이 읎어서 mapping된 jsp의 값을 찾아서간다.
	
	// (127) http://localhost:8080/sample/ -> /WEB-INF/views/sample/basic.jsp
	@RequestMapping("")
	public void basic() {
		log.info("basic sample text message.......");
	}
	
	// 128
	// http://localhost:8080/sample/basic -> /WEB-INF/views/sample/basic.jsp
	// http://localhost:8080/sample/sample(basic)
	@RequestMapping(value="/basic",  method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic sample message2......");
	}
	// (127) http://localhost:8080/sample/basicOnlyGet -> /WEB-INF/views/sample/basicOnlyGet.jsp
	@RequestMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic getOnly sample text message.......");
	}

// B. String을 사용 - 리턴된 문자열의 경로값 찾아서 따라간다.
	
	// 130
	// http://localhost:8080/sample/ex01?name=hong&age=20
	// Parameter type : 소문자로 시작한다.(SampleDTO -> sampleDTO)
	@RequestMapping("/ex01") 
	public String ex01(SampleDTO dto) { // dto는 지역변수이다. ${sampleDTO.name }
		log.info("SampleDTO" + dto);
		return "ex01";
	}
	// 130
	// http://localhost:8080/sample/ex011?name=jackson&age=22
	@RequestMapping("/ex011")
	public String ex011(SampleDTO dto) {
		log.info("SampleDTO" + dto);
		return "sample/ex011";
	}
	@RequestMapping("/ex012") 
	public String ex012(SampleDTO dto, Model model) { // dto는 지역변수이다. ${sampleDTO.name }
		model.addAttribute(dto);
		log.info("SampleDTO" + dto);
		return "ex012";
	}
	//131
	@RequestMapping("/ex02") 
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age, Model model) { // dto는 지역변수이다. ${sampleDTO.name }
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
	
	// 132
	// http://localhost:8080/sample/ex02List?ids=753&ids=270&ids=172&ids=704
	@RequestMapping("/ex02List") 
	public String ex02List(@RequestParam("ids") ArrayList<String> ids, Model model) { // dto는 지역변수이다. ${sampleDTO.name }
		
		model.addAttribute("ids", ids);
		log.info("ids : " + ids);
		return "ex02List";
	}
	
	// 133
	//http://localhost:8080/sample/ex02Array?ids=753&ids=270&ids=172&ids=704
	@RequestMapping("/ex02Array") 
	public String ex02Array(@RequestParam("ids") String[] ids, Model model) { // dto는 지역변수이다. ${sampleDTO.name }
		model.addAttribute("ids", ids);
		log.info("arrays ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	// 134
	//http://localhost:8080/sample/ex02Bean?list[0].name=aaa&list[2].name=bbb -> 이렇게 작성하면 에러 발생한다.
	//http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B2%5D.name=bbb -> 이렇게 작성하면 에러가 안난다.
	@GetMapping("/ex02Bean") 
	public String ex02Bean(SampleDTOList list, Model model) { 
		model.addAttribute(list);
		log.info("list dtos : " + list);
		return "ex02Bean";
	}
	
	// 137 - 날짜를 인식하기위한 코드 (method1 날짜 파라미터 넘기는 방법 : @InitBinder)
	// http://localhost:8080/sample/ex03?title=dodo&dueDate=2019-11-21
	// 이 코드를 테스트 해보려면 method2코드를 실행하기위해 주석처리 된 부분을 해제하고 import까지 해야 정상작동한다.
	@GetMapping("/ex03") 
	public String ex03(TodoDTO todo, Model model) { 
		model.addAttribute(todo);
		log.info("todo : " + todo);
		return "ex03";
	}
	
	// 137 - 날짜를 인식하기위한 코드 (method2 날짜 파라미터 넘기는 방법 : @DateTimeFormat)
	// http://localhost:8080/sample/ex033?title=dodo&dueDate=2019/11/21
	// 이 코드를 테스트를 해보려면 반드시 이 파일 위 부분의 method1코드를 주석을 달고 실행을 해야한다.
	@GetMapping("/ex033") 
	public String ex033(TodoDTO todo, Model model) { 
		model.addAttribute(todo);
		log.info("todo : " + todo);
		return "ex033";
	}
	// 139 - 142
	//http://localhost:8080/sample/ex04?name=gin&page=4
	// 페이지는 전달이 안된다. @ModelAttribute를 통해서 전달해야한다.
	@GetMapping("/ex04") 
	public String ex04(SampleDTO dto, int page) { 
		
		log.info("dto : " +  dto);
		log.info("page : " +  page);
		return "/sample/ex04"; // View에 sampleDTO만 전달
	}
	
	// http://localhost:8080/sample/ex044?name=gin&page=4
	@GetMapping("/ex044") 
	public String ex044(SampleDTO dto, @ModelAttribute("page") int page) { 
		
		log.info("dto : " +  dto);
		log.info("page : " +  page);
		return "/sample/ex044"; // SampleDTO, Page 모두 전달 
	}
	
	// 143 (jsp에서의 sendredirect와 같은 개념으로 일회성으로 데이터를 전달하는 개념이다.)
	//http://localhost:8080/sample/redirectAttribute?attr=Veronica
	@GetMapping("/redirect") 
	public String redirect(RedirectAttributes rttr) { 
		rttr.addFlashAttribute("msg", "Veronica");
		rttr.addAttribute("attr", "Veronica");
		log.info("RedirectAttributes.......");
		return "redirect:/sample/redirectAttribute"; //
	}
	
	// 144
	//http://localhost:8080/sample/ex05
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05.......");
	}
	// 146
	// http://localhost:8080/sample/ex06
	// @ResponseBody : header + data 동시에 전달하는 목적을 지닌 어노테이션
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.......");
		SampleDTO dto = new SampleDTO();
		dto.setName("Spongebob");
		dto.setAge(33);
		
		return dto;
		// jsp파일을 생성하지 않았는데도 웹브라우저에서는 json방식으로 값이 전달되어 출력된 신형 방식이다.
	}
	
	
	// @ResponseEntity : header + data 동시에 전달하는 목적을 지닌 어노테이션
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07.......");
		
		String msg = "{\"name\": \"aaa\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	// 149 - 152
	//http://localhost:8080/sample/exUpload
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload.......");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		// Use The Lambda Expression
		files.forEach(file -> {
			log.info("------------------------------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			log.info("------------------------------------------------");
		});
	}
	
}
