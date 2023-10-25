package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByTitle(String title);
	List<Board> findByTitleContaining(String keyword);
//	List<Board> findByTitleContaining(String keyword, Pageable paging);
	Page<Board> findByTitleContaining(String keyword, Pageable paging);
	List<Board> findByContentContaining(String keyword);
	List<Board> findByContent(String content);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingAndCntGreaterThan(String title, Long cnt);
	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(Long cntG, Long cntL);
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	List<Board> findByCntBetweenOrderBySeq(Long cnt1, Long cnt2);
	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	@Query("select b from Board b where b.title like %?1% order by b.seq desc")
	List<Board> queryAnnotationTest2(String searchKeyword);
	@Query("select b.seq, b.title, b.writer, b.content from Board b where b.title like %:searchKeyword% order by b.seq desc")
	List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);
	@Query(value="select seq, title, writer, create_date from board where title like '%'||:searchKeyword||'%' order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest4(@Param("searchKeyword") String searchKeyword);
	@Query("select b from Board b order by b.seq desc")
	List<Board> queryAnnotationTest5(Pageable paging);
}
