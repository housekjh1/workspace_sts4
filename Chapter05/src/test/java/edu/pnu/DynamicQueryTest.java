package edu.pnu;

import java.util.Random;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.DynamicBoardRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DynamicQueryTest {
	@Autowired
	private DynamicBoardRepository boardRepo;
	
	@Test
	@Order(1)
	public void insert100() {
		Random rd = new Random();
		for (int i = 1; i <= 100; i++) {
			boardRepo.save(Board.builder().title("title"+i).writer("writer"+i).content("content"+i).cnt(rd.nextLong(101)).build());
		}
	}
	
	@Test
	@Order(2)
	public void testDynamicQuery1() {
		System.out.println("=".repeat(50));
		String searchKeyword = "title10";
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board;
		builder.and(qboard.title.like("%"+searchKeyword+"%"));
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		System.out.println("'title1' 검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	@Order(3)
	public void testDynamicQuery2() {
		System.out.println("=".repeat(50));
		Long searchCntNum = 50L;
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board;
		builder.and(qboard.cnt.gt(searchCntNum));
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		System.out.println("'조회수 50초과' 검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	@Order(4)
	public void testDynamicQuery3() {
		
	}

	@Test
	@Order(5)
	public void testDynamicQuery4() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	public void testDynamicQuery() {
//		String searchCondition = "TITLE";
//		String searchKeyword = "제목10";
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		
//		QBoard qboard = QBoard.board;
//		
//		if (searchCondition.equals("TITLE")) {
//			builder.and(qboard.title.like("%" + searchKeyword + "%"));
//		} else if (searchCondition.equals("CONTENT")) {
//			builder.and(qboard.content.like("%" + searchKeyword + "%"));
//		}
//		
//		Pageable paging = PageRequest.of(0, 5);
//		
//		Page<Board> boardList = boardRepo.findAll(builder, paging);
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
}
