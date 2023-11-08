package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import jakarta.validation.Valid;

@RestController
public class MemberController {
	private MemberService memberService = new MemberService();

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return memberService.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
	}

	@PostMapping("/member")
	public ResponseEntity<?> addMember(@Valid MemberVO memberVO, BindingResult bind) {
		if (bind.hasErrors()) {
			return ResponseEntity.badRequest().body(bind.getAllErrors());
		}
		return ResponseEntity.ok(memberService.addMember(memberVO));
	}

	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		return memberService.updateMember(memberVO);
	}

	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		return memberService.removeMember(id);
	}
}
