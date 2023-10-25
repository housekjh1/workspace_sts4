package edu.pnu;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("10");
		System.out.println("검색결과 Test1");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	@Test
	public void testQueryAnnotationTest2() {
		List<Board> boardList = boardRepo.queryAnnotationTest2("10");
		System.out.println("=".repeat(30));
		System.out.println("검색결과 Test2");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	@Test
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("10");
		System.out.println("=".repeat(30));
		System.out.println("검색결과 Test3");
		for (Object[] row : boardList) {
			System.out.println("---> " + Arrays.toString(row));
		}
	}
	
	@Test
	public void testQueryAnnotationTest4() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest4("10");
		System.out.println("=".repeat(30));
		System.out.println("검색결과 Test4");
		for (Object[] row : boardList) {
			System.out.println("---> " + Arrays.toString(row));
		}
	}
	
	@Test
	public void testQueryAnnotationTest5() {
		Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq");
		List<Board> boardList = boardRepo.queryAnnotationTest5(paging);
		System.out.println("=".repeat(30));
		System.out.println("검색결과 Test5");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
