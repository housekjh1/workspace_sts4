package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {
	public List<MemberVO> getMembers();

	public MemberVO getMember(Integer id);

	public int addMember(MemberVO memberVO);

	public int updateMember(MemberVO memberVO);

	public int removeMember(Integer id);

}
