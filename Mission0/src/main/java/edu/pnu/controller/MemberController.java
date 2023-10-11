package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {
	List<MemberVO> list;

	public MemberController() {
		list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
		}
	}

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return list;
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		if (id == null) {
			System.out.println("아이디를 입력하세요.");
			return null;
		}
		if (list.get(id).getId() == id) {
			System.out.println("회원이 존재합니다.");
			return list.get(id);
		} else {
			System.out.println("존재하지 않는 회원입니다.");
			return null;
		}
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO m) {
		if (list.get(m.getId()).getId() == m.getId()) {
			System.out.println("이미 존재하는 회원입니다.");
			return null;
		} else {
			list.add(m);
			return list.get(m.getId());
		}

	}
}
