package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {
	private List<MemberVO> list;

	public MemberService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
//			MemberVO m = new MemberVO();
//			m.setId(i);
//			m.setPass("pass" + i);
//			m.setName("name" + i);
//			m.setRegidate(new Date());
//			list.add(m);
			list.add(MemberVO.builder()
						.id(i)
						.pass("pass"+i)
						.name("name"+i)
						.regidate(new Date())
						.build()
					);
		}
	}

	public List<MemberVO> getMembers() {
		return list;
	}
}
