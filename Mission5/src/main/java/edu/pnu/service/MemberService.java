package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.LogH2Impl;
import edu.pnu.persistence.MemberH2Impl;

@Service
public class MemberService {

	@Autowired
	private MemberH2Impl memberH2Impl;

	@Autowired
	private LogH2Impl logH2Impl;

	public List<Member> getMembers() {
		Map<String, Object> map = memberH2Impl.getMembers();
		List<Member> list = (List<Member>) map.get("result");
		logH2Impl.add((String) map.get("method"), (String) map.get("sql"), list != null ? true : false);
		return list;
	}

	public Member getMember(Integer id) {
		Map<String, Object> map = memberH2Impl.getMember(id);
		Member result = (Member) map.get("result");
		logH2Impl.add((String) map.get("method"), (String) map.get("sql"), result != null ? true : false);
		return result;
	}

	public Member addMember(Member member) {
		Map<String, Object> map = memberH2Impl.addMember(member);
		Member result = (Member) map.get("result");
		logH2Impl.add((String) map.get("method"), (String) map.get("sql"), result != null ? true : false);
		return result;
	}

	public Member updateMember(Member member) {
		Map<String, Object> map = memberH2Impl.updateMember(member);
		Member result = (Member) map.get("result");
		logH2Impl.add((String) map.get("method"), (String) map.get("sql"), result != null ? true : false);
		return result;
	}

	public Member removeMember(Integer id) {
		Map<String, Object> map = memberH2Impl.removeMember(id);
		Member result = (Member) map.get("result");
		logH2Impl.add((String) map.get("method"), (String) map.get("sql"), result != null ? true : false);
		return result;
	}
}
