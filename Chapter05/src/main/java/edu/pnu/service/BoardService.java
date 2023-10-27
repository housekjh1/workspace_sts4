package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.DynamicBoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private DynamicBoardRepository boardRepo;
	
	public List<Board> getMembers() {
		List<Board> boardList = (List<Board>) boardRepo.findAll();
		return boardList;
	}

	public List<Board> getMember(Long seq) {
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board;
		Pageable paging = PageRequest.of(0, 5);
		builder.and(qboard.seq.eq(seq));
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		List<Board> result = boardList.getContent();
		return result;
	}

	public Board addMember(Board board) {
		Board result = boardRepo.save(Board.builder().title(board.getTitle()).writer(board.getWriter()).content(board.getContent()).build());
		return result;
	}

	public Board updateMember(Board board) {
		Board tmp = boardRepo.findById(board.getSeq()).get();
		if (board.getTitle() != null) tmp.setTitle(board.getTitle());
		if (board.getWriter() != null) tmp.setWriter(board.getWriter());
		if (board.getContent() != null) tmp.setContent(board.getContent());
		return boardRepo.save(tmp);
	}

	public Board removeMember(Long seq) {
		Board tmp = boardRepo.findById(seq).get();
		boardRepo.deleteById(seq);
		return tmp;
	}
}

