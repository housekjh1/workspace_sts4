package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardController {
	
	public BoardController() {
		
		log.info("BoardController 생성자 호출");
		
//		System.out.println("BoardController 생성자 호출");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		
		log.info("Hello 호출 : param=" + name);
		
		return "Hello : " + name;
	}
}
