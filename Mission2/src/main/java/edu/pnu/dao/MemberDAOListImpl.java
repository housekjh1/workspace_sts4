package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDAOListImpl implements MemberInterface {

	List<MemberVO> list;

	public MemberDAOListImpl() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			MemberVO m = new MemberVO();
			m = MemberVO.builder().id(i).pass("pass" + i).name("name" + i).regidate(new Date()).build();
			list.add(m);
		}
	}

	public List<MemberVO> getMembers1() {
		return list;
	}

	public MemberVO getMember1(int id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	public MemberVO addMember1(MemberVO memberVO) {
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
		return tmp;
	}

	public MemberVO updateMember1(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) {
				if (memberVO.getPass() != null)
					m.setPass(memberVO.getPass());
				if (memberVO.getName() != null)
					m.setName(memberVO.getName());
				MemberVO tmp = MemberVO.builder().id(m.getId()).pass(m.getPass()).name(m.getName())
						.regidate(m.getRegidate()).build();
				return tmp;
			}
		}
		return null;
	}

	public MemberVO removeMember1(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				MemberVO tmp = list.get(i);
				list.remove(i);
				return tmp;
			}
		}
		return null;
	}

	@Override
	public List<MemberVO> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMember(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
