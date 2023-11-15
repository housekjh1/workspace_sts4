package edu.pnu.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.board.domain.Board;
import edu.pnu.board.domain.Search;
import edu.pnu.board.security.SecurityUser;
import edu.pnu.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService boardServ;

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Search search, @AuthenticationPrincipal OAuth2User principal) {
		if (search.getSearchCondition() == null) {
			search.setSearchCondition("TITLE");
		}
		if (search.getSearchKeyword() == null) {
			search.setSearchKeyword("");
		}
		Page<Board> boardList = boardServ.getBoardList(search);
//		model.addAttribute("name", principal.getAttribute("name"));
		model.addAttribute("boardList", boardList);
		return "board/getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardServ.getBoard(board));
		return "board/getBoard";
	}

	@GetMapping("/insertBoard")
	public String insertBoardView(Model model, @AuthenticationPrincipal OAuth2User principal) {
//		model.addAttribute("name", principal.getAttribute("name"));
		return "/board/insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
		board.setMember(principal.getMember());
		boardServ.insertBoard(board);
		return "redirect:getBoardList";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardServ.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardServ.deleteBoard(board);
		return "forward:getBoardList";
	}
}
