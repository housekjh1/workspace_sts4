package edu.pnu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberController {
	MemberService memberService = new MemberService();

	@GetMapping("/member")
	public ResponseEntity<?> getMembers() {
		log.info("H2 getMembers() 호출");
		return memberService.getMembers();
	}

	@GetMapping("/member/{id}")
	public ResponseEntity<?> getMember(@PathVariable Integer id) {
		log.info("H2 getMember() 호출");
		return memberService.getMember(id);
	}

	@PostMapping("/member")
	public int addMember(MemberVO memberVO) {
		log.info("H2 addMember() 호출");
		return memberService.addMember(memberVO);
	}

	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
		log.info("H2 updateMember() 호출");
		return memberService.updateMember(memberVO);
	}

	@DeleteMapping("/member/{id}")
	public int removeMember(@PathVariable Integer id) {
		log.info("H2 removeMember() 호출");
		return memberService.removeMember(id);
	}

	@GetMapping("/memberlist")
	public List<MemberVO> getMembers1() {
		log.info("List getMembers1() 호출");
		return memberService.getMembers1();
	}

	@GetMapping("/memberlist/{id}")
	public MemberVO getMember1(@PathVariable Integer id) {
		log.info("List getMember1() 호출");
		return memberService.getMember1(id);
	}

	@PostMapping("/memberlist")
	public MemberVO addMember1(MemberVO memberVO) {
		log.info("List addMember1() 호출");
		return memberService.addMember1(memberVO);
	}

	@PutMapping("/memberlist")
	public MemberVO updateMember1(MemberVO memberVO) {
		log.info("List updateMember1() 호출");
		return memberService.updateMember1(memberVO);
	}

	@DeleteMapping("/memberlist/{id}")
	public MemberVO removeMember1(@PathVariable Integer id) {
		log.info("List removeMember1() 호출");
		return memberService.removeMember1(id);
	}
}
