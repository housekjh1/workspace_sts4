package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDAOListImpl implements MemberInterface {

	private List<MemberVO> list;

	public MemberDAOListImpl() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			MemberVO m = new MemberVO();
			m = MemberVO.builder().id(i).pass("pass" + i).name("name" + i).regidate(new Date()).build();
			list.add(m);
		}
	}

	public Map<String, Object> getMembers() {
		return null;
	}

	public Map<String, Object> getMember(Integer id) {
//		for (MemberVO m : list) {
//			if (m.getId() == id) {
//				return m;
//			}
//		}
		return null;
	}

	public Map<String, Object> addMember(MemberVO memberVO) {
		if (memberVO.getPass() == null || memberVO.getName() == null)
			return null;
		int idx = -1;
		for (MemberVO m : list) {
			if (idx < m.getId())
				idx = m.getId();
		}
		if (list.isEmpty())
			idx = 1;
		else
			idx++;
		MemberVO tmp = MemberVO.builder().id(idx).pass(memberVO.getPass()).name(memberVO.getName()).regidate(new Date())
				.build();
		list.add(tmp);
		return null;
	}

	public Map<String, Object> updateMember(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) {
				if (memberVO.getPass() != null)
					m.setPass(memberVO.getPass());
				if (memberVO.getName() != null)
					m.setName(memberVO.getName());
				return null;
			}
		}
		return null;
	}

	public Map<String, Object> removeMember(Integer id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				return null;
			}
		}
		return null;
	}

}
