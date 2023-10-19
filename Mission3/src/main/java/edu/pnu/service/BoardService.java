package edu.pnu.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.pnu.domain.BoardVO;

public class BoardService {
	Connection con;

	public BoardService() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/Mission2", "sa", "abcd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> getBoards() {
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from board";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			List<BoardVO> list = new ArrayList<>();
			while (rs.next()) {
				BoardVO tmp = new BoardVO();
				tmp = BoardVO.builder().seq(rs.getLong(1)).cnt(rs.getLong(2)).content(rs.getString(3))
						.createDate(rs.getDate(4)).title(rs.getString(5)).writer(rs.getString(6)).build();
				list.add(tmp);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public BoardVO getBoard(long seq) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from board where seq=?";
		try {
			pst = con.prepareStatement(query);
			pst.setLong(1, seq);
			rs = pst.executeQuery();
			rs.next();
			BoardVO tmp = BoardVO.builder().seq(rs.getLong(1)).cnt(rs.getLong(2)).content(rs.getString(3))
					.createDate(rs.getDate(4)).title(rs.getString(5)).writer(rs.getString(6)).build();
			return tmp;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ResponseEntity<?> addBoard(BoardVO boardVO) {
		PreparedStatement pst = null;
		int result = 0;
		String query = "insert into board (content, title, writer) values (?, ?, ?)";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, boardVO.getContent());
			pst.setString(2, boardVO.getTitle());
			pst.setString(3, boardVO.getWriter());
			result = pst.executeUpdate();
			BoardVO tmp = BoardVO.builder().content(boardVO.getContent()).title(boardVO.getTitle())
					.writer(boardVO.getWriter()).build();
			return ResponseEntity.ok(tmp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	public int updateBoard(BoardVO boardVO) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		int result = 0;
		String query = "update board set content=?, title=?, writer=? where seq=?";
		String query1 = "select * from board where seq=?";
		try {
			pst = con.prepareStatement(query1);
			pst.setLong(1, boardVO.getSeq());
			rs = pst.executeQuery();
			rs.next();
			
			pst = con.prepareStatement(query);
			if (boardVO.getContent() != null)
				pst.setString(1, boardVO.getContent());
			else
				pst.setString(1, rs.getString(3));
			if (boardVO.getTitle() != null)
				pst.setString(2, boardVO.getTitle());
			else
				pst.setString(2, rs.getString(5));
			if (boardVO.getWriter() != null)
				pst.setString(3, boardVO.getWriter());
			else
				pst.setString(3, rs.getString(6));
			pst.setLong(4, boardVO.getSeq());
			result = pst.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int removeBoard(long seq) {
		PreparedStatement pst = null;
		int result = 0;
		String query = "delete board where seq=?";
		try {
			pst = con.prepareStatement(query);
			pst.setLong(1, seq);
			result = pst.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
