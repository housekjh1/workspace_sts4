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
	
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		int idx = -1;
		for (MemberVO m : list) {
			if (idx < m.getId()) idx = m.getId();
		}
		if (list.isEmpty()) idx = 1;
		else idx++;
		
		if (memberVO.getPass() == null || memberVO.getName() == null) return null;
		
		MemberVO tmp = MemberVO.builder()
								.id(idx)
								.pass(memberVO.getPass())
								.name(memberVO.getName())
								.regidate(new Date())
								.build();
		list.add(tmp);
		return tmp;
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) {
				if (memberVO.getPass() != null) m.setPass(memberVO.getPass());
				if (memberVO.getName() != null) m.setName(memberVO.getName());
				return m;
			}
		}
		return null;
	}
	
	public MemberVO removeMember(Integer id) {
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
