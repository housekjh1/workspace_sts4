package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
public class MemberDAOTest {

//	@DisplayName("MemberDAO Insert Test")
//	@Test
//	public void testInsert() {
//		MemberDAO dao = new MemberDAO();
//		int ret = dao.addMember(MemberVO.builder().pass("1234").name("강감찬").build());
//		System.out.println("ret : " + ret);
//	}
	
//	@DisplayName("MemberDAO Select All Test")
//	@Test
//	public void testSelectAll() {
//		MemberDAO dao = new MemberDAO();
//		List<MemberVO> list = dao.getMembers();
//		for (MemberVO m : list) {
//			System.out.println(m);
//		}
//	}
	
//	@DisplayName("MemberDAO Select Test")
//	@Test
//	public void testSelect() {
//		MemberDAO dao = new MemberDAO();
//		MemberVO m = dao.getMember(1);
//		System.out.println(m);
//	}
	
//	@DisplayName("MemberDAO Update Test")
//	@Test
//	public void testUpdate() {
//		MemberDAO dao = new MemberDAO();
//		int result = dao.updateMember(MemberVO.builder().id(1).pass("수정").name("수정").build());
//		System.out.println(result);
//	}
	
	@DisplayName("MemberDAO Remove Test")
	@Test
	public void testRemove() {
		MemberDAO dao = new MemberDAO();
		int result = dao.removeMember(1);
		System.out.println(result);
	}
}
