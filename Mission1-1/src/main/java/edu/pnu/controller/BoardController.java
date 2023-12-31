package edu.pnu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	private BoardService boardService = new BoardService();

	@GetMapping("/board")
	public List<BoardVO> getBoards() {
		return boardService.getBoards();
	}

	@GetMapping("/board/{seq}")
	public BoardVO getBoard(@PathVariable Integer seq) {
		return boardService.getBoard(seq);
	}

	@GetMapping("/getboard")
	public BoardVO getBoard1(Integer seq) {
		return boardService.getBoard(seq);
	}

	@PostMapping("/board")
	public BoardVO addBoard(BoardVO boardVO) {
		return boardService.addBoard(boardVO);
	}

	@PutMapping("/board")
	public BoardVO updateBoard(BoardVO boardVO) {
		return boardService.updateBoard(boardVO);
	}

	@DeleteMapping("/board/{seq}")
	public ResponseEntity<?> removeBoard(@PathVariable Integer seq) {
		return boardService.removeBoard(seq);
	}

	@DeleteMapping("/board")
	public ResponseEntity<?> removeBoard1(Integer seq) {
		return boardService.removeBoard(seq);
	}
}
