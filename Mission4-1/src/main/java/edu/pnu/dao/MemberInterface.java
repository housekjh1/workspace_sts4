package edu.pnu.dao;

import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {
	public Map<String, Object> getMembers();

	public Map<String, Object> getMember(Integer id);

	public Map<String, Object> addMember(MemberVO memberVO);

	public Map<String, Object> updateMember(MemberVO memberVO);

	public Map<String, Object> removeMember(Integer id);

}
