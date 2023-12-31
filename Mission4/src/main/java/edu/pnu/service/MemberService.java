package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogH2Impl;
import edu.pnu.dao.LogInterface;
import edu.pnu.dao.MemberDAOH2Impl;
import edu.pnu.dao.MemberDAOListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	private MemberInterface dao;
	LogInterface log;

	public MemberService(Environment environment) {
		String type = environment.getProperty("mywebservice.data.type");

		if (type.equals("h2")) {
			System.out.println("H2 Service");
			dao = new MemberDAOH2Impl();
		} else {
			System.out.println("List Service");
			dao = new MemberDAOListImpl();
		}

		log = new LogH2Impl();
	}

	public List<MemberVO> getMembers() {
		return dao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return dao.getMember(id);
	}

	public int addMember(MemberVO memberVO) {
//		return dao.addMember(memberVO);
		Map<String, Object> map = dao.addMemberWithMap(memberVO);
		int result = (int) map.get("result");
		log.addLog("post", (String) map.get("sql"), result == 1 ? true : false);
		return result;
	}

	public int updateMember(MemberVO memberVO) {
		return dao.updateMember(memberVO);
	}

	public int removeMember(Integer id) {
		return dao.removeMember(id);
	}

}
