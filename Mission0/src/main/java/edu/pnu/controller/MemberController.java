package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {

	List<MemberVO> list;

	public MemberController() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
		}
	}

	@GetMapping("/member") // http://localhost:8080/member
	public List<MemberVO> getMembers() {
		return list;
	}

	private MemberVO findMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}

	// MemberVO에서 id가 {id}인 데이터를 찾아서 리턴
	@GetMapping("/member/{id}") // http://localhost:8080/member/5 ==> id가 5인 데이터를 찾아서 리턴
	public MemberVO getMember(@PathVariable Integer id) {
		return findMember(id);
	}

	// 현재 입력되어 있는 객체들의 id를 조사해서 최댓값에 1을 더해 리턴
	private int getNextId() {
		int mid = -1;
		for (MemberVO m : list) {
			if (mid < m.getId())
				mid = m.getId();
		}
		return mid + 1;
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO m) {
		if (m.getName() == null || m.getPass() == null)
			return null;
		m.setId(getNextId());
		m.setRegidate(new Date());
		list.add(m);
		return m;

	}

	@PostMapping("/member1")
	public ResponseEntity<?> addMember1(MemberVO m) {

		if (m.getName() == null || m.getPass() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);

		m.setId(getNextId());
		m.setRegidate(new Date());
		list.add(m);

//		return ResponseEntity.status(HttpStatus.OK).body(m);
		return ResponseEntity.ok(m);
	}

	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO m) {
		MemberVO m1 = findMember(m.getId());
		if (m1.getName() != null)
			m1.setName(m.getName());
		if (m1.getPass() != null)
			m1.setPass(m.getPass());

		return m1;
	}

	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {

		for (int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if (m.getId() == id) {
				list.remove(i);
				return m;
			}
		}
		return null;
	}
}
