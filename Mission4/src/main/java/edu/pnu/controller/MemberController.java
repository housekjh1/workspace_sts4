package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	MemberService memberService;

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		log.info("getMembers() 호출");
		return memberService.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		log.info("getMember() 호출");
		return memberService.getMember(id);
	}

	@PostMapping("/member")
	public int addMember(MemberVO memberVO) {
		log.info("addMember() 호출");
		return memberService.addMember(memberVO);
	}

	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
		log.info("updateMember() 호출");
		return memberService.updateMember(memberVO);
	}

	@DeleteMapping("/member/{id}")
	public int removeMember(@PathVariable Integer id) {
		log.info("removeMember() 호출");
		return memberService.removeMember(id);
	}

}
