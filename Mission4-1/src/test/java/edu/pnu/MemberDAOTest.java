package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAOH2Impl;
import edu.pnu.domain.MemberVO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberDAOTest {
	
//	@BeforeAll
//	public static void beforeAll() {
//		System.out.println("ba--".repeat(20));
//	}
//	
//	@AfterAll
//	public static void afterAll() {
//		System.out.println("aa--".repeat(20));
//	}
//	
//	@BeforeEach
//	public void beforeEach() {
//		System.out.println("be--".repeat(20));
//	}
//	
//	@AfterEach
//	public void afterEach() {
//		System.out.println("ae--".repeat(20));
//	}
//
//	@DisplayName("MemberDAO Select All Test")
//	@Test
//	@Order(0)
//	public void testSelectAll() {
//		MemberDAOH2Impl dao = new MemberDAOH2Impl();
//		List<MemberVO> list = dao.getMembers();
//		for (MemberVO m : list) {
//			System.out.println(m);
//		}
//		System.out.println("=".repeat(30));
//	}
//	
//	@DisplayName("MemberDAO Select Test")
//	@Test
//	@Order(1)
//	public void testSelect() {
//		MemberDAOH2Impl dao = new MemberDAOH2Impl();
//		MemberVO m = dao.getMember(1);
//		System.out.println(m);
//		System.out.println("=".repeat(30));
//	}
//	
//	@DisplayName("MemberDAO Insert Test")
//	@Test
//	@Order(2)
//	public void testInsert() {
//		MemberDAOH2Impl dao = new MemberDAOH2Impl();
//		int ret = dao.addMember(MemberVO.builder().pass("1234").name("홍길동").build());
//		System.out.println("ret : " + ret);
//	}
//	
//	@DisplayName("MemberDAO Update Test")
//	@Test
//	@Order(3)
//	public void testUpdate() {
//		MemberDAOH2Impl dao = new MemberDAOH2Impl();
//		int result = dao.updateMember(MemberVO.builder().id(19).pass("1234").name("수정").build());
//		System.out.println("result : " + result);
//	}
//	
//	@DisplayName("MemberDAO Remove Test")
//	@Test
//	@Order(4)
//	public void testRemove() {
//		MemberDAOH2Impl dao = new MemberDAOH2Impl();
//		int result = dao.removeMember(19);
//		System.out.println("result : " + result);
//	}
}
