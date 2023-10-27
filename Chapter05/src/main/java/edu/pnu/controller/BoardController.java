package edu.pnu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public List<Board> getMembers() {
		return boardService.getMembers();
	}
	
	@GetMapping("/board/{seq}")
	public List<Board> getMember(@PathVariable Long seq) {
		return boardService.getMember(seq);
	}
	
	@PostMapping("/board")
	public Board addMember(Board board) {
		return boardService.addMember(board);
	}
	
	@PutMapping("/board")
	public Board updateMember(Board board) {
		return boardService.updateMember(board);
	}
	
	@DeleteMapping("/board/{seq}")
	public Board removeMember(@PathVariable Long seq) {
		return boardService.removeMember(seq);
	}
}
