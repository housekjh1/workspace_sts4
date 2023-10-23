package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
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
//		for (int i = 0; i < 100; i++) {
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
	@DisplayName("보드 여러개 입력 테스트2")
	public void BoardInsertMany2() {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			boardRepo.save(Board.builder()
					.title("title"+i)
					.writer("writer"+i)
					.content("content"+i)
					.build());
		}
	}
}
