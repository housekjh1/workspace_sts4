package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {
	public List<MemberVO> getMembers();

	public MemberVO getMember(int id);

	public int addMember(MemberVO memberVO);

	public int updateMember(MemberVO memberVO);

	public int removeMember(int id);

	public List<MemberVO> getMembers1();

	public MemberVO getMember1(int id);

	public MemberVO addMember1(MemberVO memberVO);

	public MemberVO updateMember1(MemberVO memberVO);

	public MemberVO removeMember1(int id);
}
