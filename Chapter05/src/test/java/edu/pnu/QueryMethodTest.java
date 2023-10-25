package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepo;

//	@Test
//	public void dataPrepare() {
//		for (int i = 1; i <= 200; i++) {
//			Board board = new Board();
//			board.setTitle("title"+i);
//			board.setWriter("writer"+i);
//			board.setContent("content"+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}

//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("title10");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}

//	@Test
//	public void testFindByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}

//	@Test
//	public void testFindByContent() {
//		List<Board> boardList = boardRepo.findByContent("content17");
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}

//	@Test
//	public void testFindByTitleOrContentContianing() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("18", "17");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}

//	-------------------------------------------------------------

//	@Test
//	public void Insert100() {
//		Random rd = new Random();
//		for (int i = 1; i <= 100; i++) {
//			boardRepo.save(Board.builder().title("제목"+i).writer("작성자"+i).content("내용"+i).createDate(new Date()).cnt(rd.nextLong(0,101)).build());
//		}
//	}

//	@Test
//	public void testFindByTitleContaining() {
//		List<Board> boardList = boardRepo.findByTitleContaining("1");
//		for (Board board : boardList) {
//			System.out.println("'1' 검색 결과 ---> " + board.toString());
//		}
//	}
//	
//	@Test
//	public void testFindByTCCGT() {
//		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
//		for (Board board : boardList) {
//			System.out.println("'1' 제목 & 50 조회수 초과 검색 결과 ---> " + board.toString());
//		}
//	}
//	
//	@Test
//	public void testFindByCGTECLTE() {
////		List<Board> boardList = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(10L, 50L);
//		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeq(10L, 50L);
//		for (Board board : boardList) {
//			System.out.println("10이상 50이하 조회수 seq 오름차순 검색 결과 ---> " + board.toString());
//		}
//	}
//	
//	@Test
//	public void testFindByTCCC() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
//		for (Board board : boardList) {
//			System.out.println("제목 10 포함 또는 내용 2 포함 seq 내림차순 검색 결과 ---> " + board.toString());
//		}
//	}

//	-------------------------------------------------------------

//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}

//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
//		System.out.println("PAGE SIZE: " + pageInfo.getSize());
//		System.out.println("TOTAL PAGES: " + pageInfo.getTotalPages());
//		System.out.println("TOTAL COUNT: " + pageInfo.getTotalElements());
//		System.out.println("NEXT: " + pageInfo.nextPageable());
//
//		System.out.println("검색 결과");
////		for (Board board : pageInfo) {
//		for (Board board : pageInfo.getContent()) {
//			System.out.println("---> " + board.toString());
//		}
//	}

	
	
}
