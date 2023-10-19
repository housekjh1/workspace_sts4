package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public int addMember(MemberVO memberVO) {
		if (memberVO.getPass() == null || memberVO.getName() == null)
			return 0;
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
		return 1;
	}

	public int updateMember(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) {
				if (memberVO.getPass() != null)
					m.setPass(memberVO.getPass());
				if (memberVO.getName() != null)
					m.setName(memberVO.getName());
				return 1;
			}
		}
		return 0;
	}

	public int removeMember(Integer id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				return 1;
			}
		}
		return 0;
	}

}
