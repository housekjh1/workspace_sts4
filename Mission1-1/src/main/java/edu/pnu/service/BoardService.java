package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.pnu.domain.BoardVO;

public class BoardService {
	private List<BoardVO> list;
	
	public BoardService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
		list.add(BoardVO.builder()
					.seq(i)
					.title("title"+i)
					.writer("writer"+i)
					.content("content"+i)
					.createDate(new Date())
					.cnt(0)
					.build()
				);
		}
	}
	
	public List<BoardVO> getBoards() {
		return list;
	}
	
	public BoardVO getBoard(Integer seq) {
		for (BoardVO b : list) {
			if (b.getSeq() == seq) {
				return b;
			}
		}
		return null;
	}
	
	public BoardVO addBoard(BoardVO boardVO) {
		int idx = -1;
		for (BoardVO b : list) {
			if (idx < b.getSeq()) idx = b.getSeq();
		}
		if (list.isEmpty()) idx = 1;
		else idx++;
		
		if (boardVO.getTitle() == null || boardVO.getWriter() == null || boardVO.getContent() == null) return null;
		
		BoardVO tmp = BoardVO.builder()
							.seq(idx)
							.title(boardVO.getTitle())
							.writer(boardVO.getWriter())
							.content(boardVO.getContent())
							.createDate(new Date())
							.cnt(0)
							.build();
		list.add(tmp);
		return tmp;
	}
	
	public BoardVO updateBoard(BoardVO boardVO) {
		for (BoardVO b : list) {
			if (b.getSeq() == boardVO.getSeq()) {
				if (boardVO.getTitle() != null) b.setTitle(boardVO.getTitle());
				if (boardVO.getWriter() != null) b.setWriter(boardVO.getWriter());
				if (boardVO.getContent() != null) b.setContent(boardVO.getContent());
				return b;
			}
		}
		return null;
	}
	
	public ResponseEntity<?> removeBoard(Integer seq) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSeq() == seq) {
				BoardVO tmp = list.get(i);
				list.remove(i);
				return ResponseEntity.ok(tmp);
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
