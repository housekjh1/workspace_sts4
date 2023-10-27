package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.DynamicBoardRepository;
import edu.pnu.persistence.DynamicMemberRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RelationMappingTest {
	
	@Autowired
	DynamicMemberRepository memberRepo;
	
	@Autowired
	DynamicBoardRepository boardRepo;
	
//	@Test
//	@Order(1)
//	public void insertMember3() {
//		for (int i = 1; i <= 2; i++) {
//			memberRepo.save(Member.builder().id("member"+i).password("1234").name("name"+i).role("role"+i).build());
//		}
//	}
//	
//	@Test
//	@Order(2)
//	public void insertBoard6() {
//		Member member = memberRepo.findById("member1").get();
//		for (int i = 1; i <= 3; i++) {
//			boardRepo.save(Board.builder().title("title"+i).content("content"+i).member(member).build());
//		}
//		Member member2 = memberRepo.findById("member2").get();
//		for (int i = 1; i <= 3; i++) {
//			boardRepo.save(Board.builder().title("title"+i).content("content"+i).member(member2).build());
//		}
//	}
	
	@Test
	@Order(1)
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle("둘리가 등록한 게시글"+i);
			board.setContent("둘리가 등록한 게시글 내용"+i);
		}
		memberRepo.save(member1);
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글"+i);
			board.setContent("도우너가 등록한 게시글 내용"+i);
		}
		memberRepo.save(member2);
	}
	
	@Test
	@Order(2)
	public void testCascadeDelete() {
		memberRepo.deleteById("member2");
	}
	
	@Test
	@Order(3)
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		System.out.println("=".repeat(30));
		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
		System.out.println("=".repeat(30));
		List<Board> list = member.getBoardList();
		for (Board board : list) {
			System.out.println(board.toString());
		}
	}
	
}
