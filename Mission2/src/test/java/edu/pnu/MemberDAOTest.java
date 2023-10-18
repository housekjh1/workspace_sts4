package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberDAOTest {

	@DisplayName("MemberDAO Select All Test")
	@Test
	@Order(0)
	public void testSelectAll() {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.getMembers();
		for (MemberVO m : list) {
			System.out.println(m);
		}
		System.out.println("=".repeat(30));
	}
	
	@DisplayName("MemberDAO Select Test")
	@Test
	@Order(1)
	public void testSelect() {
		MemberDAO dao = new MemberDAO();
		MemberVO m = dao.getMember(1);
		System.out.println(m);
		System.out.println("=".repeat(30));
	}
	
//	@DisplayName("MemberDAO Insert Test")
//	@Test
//	@Order(2)
//	public void testInsert() {
//		MemberDAO dao = new MemberDAO();
//		int ret = dao.addMember(MemberVO.builder().pass("1234").name("홍길동").build());
//		System.out.println("ret : " + ret);
//	}
	
//	@DisplayName("MemberDAO Update Test")
//	@Test
//	@Order(3)
//	public void testUpdate() {
//		MemberDAO dao = new MemberDAO();
//		int result = dao.updateMember(MemberVO.builder().id(19).pass("1234").name("수정").build());
//		System.out.println("result : " + result);
//	}
	
//	@DisplayName("MemberDAO Remove Test")
//	@Test
//	@Order(4)
//	public void testRemove() {
//		MemberDAO dao = new MemberDAO();
//		int result = dao.removeMember(19);
//		System.out.println("result : " + result);
//	}
}
