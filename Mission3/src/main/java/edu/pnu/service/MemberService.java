package edu.pnu.service;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDAOH2Impl;
import edu.pnu.dao.MemberDAOListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	private MemberInterface dao;

	public MemberService(Environment environment) {
		String type = environment.getProperty("mywebservice.data.type");

		if (type.equals("h2")) {
			System.out.println("H2 Service");
			dao = new MemberDAOH2Impl();
		} else {
			System.out.println("List Service");
			dao = new MemberDAOListImpl();
		}
	}

	public List<MemberVO> getMembers() {
		return dao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		if (id == null)
			return null;
		return dao.getMember(id);
	}

	public int addMember(MemberVO memberVO) {
		if (memberVO.getPass() == null || memberVO.getName() == null)
			return 0;
		return dao.addMember(memberVO);
	}

	public int updateMember(MemberVO memberVO) {
		if (memberVO.getId() == null)
			return 0;
		return dao.updateMember(memberVO);
	}

	public int removeMember(Integer id) {
		if (id == null)
			return 0;
		return dao.removeMember(id);
	}

}
