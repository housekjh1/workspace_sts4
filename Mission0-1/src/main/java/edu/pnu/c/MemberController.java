package edu.pnu.c;

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

import edu.pnu.d.MemberVO;

@RestController
public class MemberController {
	List<MemberVO> list = new ArrayList<>();

	public MemberController() {
		int idx = 1;
		for (int i = 1; i <= 5; i++) {
			// 기본 생성자
			MemberVO m = new MemberVO();
			m.setId(idx);
			m.setPass("pass" + idx);
			m.setName("name" + idx);
			m.setRegidate(new Date());
			list.add(m);
			idx++;
			
			// 모든 어규먼트 생성자
			MemberVO m1 = new MemberVO(idx, "pass" + idx, "name" + idx, new Date());
			list.add(m1);
			idx++;
			
			// 빌더 패턴 생성
			list.add(MemberVO.builder()
						.id(idx)
						.name("name" + idx)
						.pass("pass" + idx)
						.regidate(new Date())
						.build()
					);
			idx++;
		}
	}

	@GetMapping("/member")
	public ResponseEntity<?> getMs() {
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/member/{id}")
	public ResponseEntity<?> getM(@PathVariable Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				return ResponseEntity.ok(m);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	@PostMapping("/member")
	public ResponseEntity<?> addM(MemberVO m) {
		if (m.getPass() == null || m.getName() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		int n = -1;
		for (MemberVO tmp : list) {
			if (n < tmp.getId())
				n = tmp.getId();
		}
		n++;
		m.setId(n);
		m.setRegidate(new Date());
		list.add(m);
		return ResponseEntity.ok(m);
	}

	@PutMapping("/member")
	public ResponseEntity<?> updateM(MemberVO m) {
		MemberVO mm = null;
		for (MemberVO tmp : list) {
			if (tmp.getId() == m.getId())
				mm = tmp;
		}
		if (mm != null) {
			if (m.getPass() != null)
				mm.setPass(m.getPass());
			if (m.getName() != null)
				mm.setName(m.getName());

			return ResponseEntity.ok(mm);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	@DeleteMapping("/member/{id}")
	public ResponseEntity<?> removeM(@PathVariable Integer id) {
		for (int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if (m.getId() == id) {
				list.remove(i);
				return ResponseEntity.ok(m);
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
