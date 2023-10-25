package edu.pnu;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BoardTest {

	@Autowired
	private BoardRepository boardRepo;

//	@Test
//	@DisplayName("보드 한 개 입력 테스트")
//	public void BoardInsertOne() {
//		
//		Board board = new Board();
//		board.setTitle("title");
//		board.setWriter("writer");
//		board.setContent("content");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepo.save(board);
//	}
//	
//	@Test
//	@DisplayName("보드 여러개 입력 테스트")
//	public void BoardInsertMany() {
//		Random rd = new Random();
//		for (int i = 0; i < 10; i++) {
//			Board board = Board.builder()
//								.title("title"+i)
//								.writer("writer"+i)
//								.content("content"+i)
//								.createDate(new Date())
//								.cnt(rd.nextLong(50))
//								.build();
//			boardRepo.save(board);
//		}
//	}

	@Test
	@Order(1)
	@DisplayName("보드 여러개 입력 테스트2")
	public void BoardInsertMany2() {
		Random rd = new Random();
		for (int i = 0; i < 10; i++) {
			boardRepo.save(Board.builder().title("title" + i).writer("writer" + i).content("content" + i).build());
		}
	}

	@Test
	@Order(2)
	@DisplayName("1번 게시글 조회")
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}

	@Test
	@Order(3)
	@DisplayName("1번 게시글 수정")
	public void testUpdateBoard() {
		System.out.println("=== 1번 게시글 조회 ===");
		Board board = boardRepo.findById(1L).get();
		System.out.println("=== 1번 게시글 제목 수정 ===");
		board.setTitle("제목을 수정했습니다.");
		boardRepo.save(board);
	}

	@Test
	@Order(4)
	@DisplayName("2번 게시글 삭제")
	public void testDeleteBoard() {
		System.out.println("=== 2번 게시글 삭제 ===");
		boardRepo.deleteById(2L);
	}
}
