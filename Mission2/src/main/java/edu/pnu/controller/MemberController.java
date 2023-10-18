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

@RestController
public class MemberController {
	MemberService memberService = new MemberService();
	
	
	@GetMapping("/member")
	public ResponseEntity<?> getMembers() {
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public ResponseEntity<?> getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public int addMember(MemberVO memberVO) {
		return memberService.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
		return memberService.updateMember(memberVO);
	}
	
	@DeleteMapping("/member/{id}")
	public int removeMember(@PathVariable Integer id) {
		return memberService.removeMember(id);
	}
}
