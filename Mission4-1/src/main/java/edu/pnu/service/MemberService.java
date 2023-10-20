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
		Map<String, Object> map = dao.getMembers();
		List<MemberVO> result = (List<MemberVO>) map.get("result");
		log.addLog("GET", (String) map.get("sql"), !result.isEmpty() ? true : false);
		return result;
	}

	public MemberVO getMember(Integer id) {
		Map<String, Object> map = dao.getMember(id);
		MemberVO result = (MemberVO) map.get("result");
		log.addLog("GET", (String) map.get("sql"), !(result == null) ? true : false);
		return result;
	}

	public int addMember(MemberVO memberVO) {
		Map<String, Object> map = dao.addMember(memberVO);
		int result = (int) map.get("result");
		log.addLog("POST", (String) map.get("sql"), result == 1 ? true : false);
		return result;
	}

	public int updateMember(MemberVO memberVO) {
		Map<String, Object> map = dao.updateMember(memberVO);
		int result = 0;
		if (map.get("result") != null) {
			result = (int) map.get("result");
		}
		log.addLog("PUT", (String) map.get("sql"), map.get("result") != null ? true : false);
		return result;
	}

	public int removeMember(Integer id) {
		Map<String, Object> map = dao.removeMember(id);
		int result = (int) map.get("result");
		log.addLog("DELETE", (String) map.get("sql"), result == 1 ? true : false);
		return result;
	}

}
