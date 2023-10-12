package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	List<MemberVO> list = new ArrayList<>();
	MemberService memberService = new MemberService();

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		list = memberService.getMembers();
		return list;
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}

		return null;
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		int idx = -1;
		for (MemberVO m : list) {
			if (idx < m.getId()) {
				idx = m.getId();
			}
		}

		if (list.isEmpty())
			idx = 1;
		else
			idx++;

		if (memberVO.getPass() == null || memberVO.getName() == null)
			return null;

		MemberVO tmp = new MemberVO();
		tmp.setId(idx);
		tmp.setPass(memberVO.getPass());
		tmp.setName(memberVO.getName());
		tmp.setRegidate(new Date());
		list.add(tmp);
		return tmp;
	}

	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) {
				m.setPass(memberVO.getPass());
				m.setName(memberVO.getName());
				return m;
			}
		}

		return null;
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				MemberVO tmp = list.get(i);
				list.remove(i);
				return tmp;
			}
		}
		return null;
	}
}
