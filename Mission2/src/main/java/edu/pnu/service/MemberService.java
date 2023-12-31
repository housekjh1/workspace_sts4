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

import edu.pnu.dao.MemberDAOListImpl;
import edu.pnu.domain.MemberVO;

public class MemberService {
	Connection con = null;
	MemberDAOListImpl memberDAOListImpl;

	public MemberService() {
		memberDAOListImpl = new MemberDAOListImpl();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/Mission2", "sa", "abcd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResponseEntity<?> getMembers() {
		List<MemberVO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				MemberVO tmp = new MemberVO();
				tmp = MemberVO.builder().id(rs.getInt(1)).pass(rs.getString(2)).name(rs.getString(3))
						.regidate(rs.getDate(4)).build();
				list.add(tmp);
			}
			return ResponseEntity.ok(list);
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
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	public ResponseEntity<?> getMember(Integer id) {
		if (id == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from member where id=?";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			rs.next();
			MemberVO tmp = MemberVO.builder().id(rs.getInt(1)).pass(rs.getString(2)).name(rs.getString(3))
					.regidate(rs.getDate(4)).build();
			return ResponseEntity.ok(tmp);
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
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	public int addMember(MemberVO memberVO) {
		if (memberVO.getPass() == null || memberVO.getName() == null)
			return 0;
		PreparedStatement pst = null;
		int result = 0;
		String query = "insert into member (pass, name) values (?, ?)";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, memberVO.getPass());
			pst.setString(2, memberVO.getName());
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

	public int updateMember(MemberVO memberVO) {
		PreparedStatement pst = null;
		int result = 0;
		String query = "update member set pass=?, name=? where id=?";
		try {
			pst = con.prepareStatement(query);
			if (memberVO.getPass() != null)
				pst.setString(1, memberVO.getPass());
			if (memberVO.getName() != null)
				pst.setString(2, memberVO.getName());
			pst.setInt(3, memberVO.getId());
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

	public int removeMember(Integer id) {
		PreparedStatement pst = null;
		int result = 0;
		String query = "delete member where id=?";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
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

	public List<MemberVO> getMembers1() {
		return memberDAOListImpl.getMembers1();
	}

	public MemberVO getMember1(Integer id) {
		return memberDAOListImpl.getMember1(id);
	}

	public MemberVO addMember1(MemberVO memberVO) {
		return memberDAOListImpl.addMember1(memberVO);
	}

	public MemberVO updateMember1(MemberVO memberVO) {
		return memberDAOListImpl.updateMember1(memberVO);
	}

	public MemberVO removeMember1(Integer id) {
		return memberDAOListImpl.removeMember1(id);
	}
}
