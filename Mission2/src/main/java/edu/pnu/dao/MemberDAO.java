package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;

public class MemberDAO {

	Connection con;
	List<MemberVO> list;

	public MemberDAO() {
		list = new ArrayList<>();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/Mission2", "sa", "abcd");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<MemberVO> getMembers() {
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				MemberVO tmp = new MemberVO();
				tmp.setId(rs.getInt(1));
				tmp.setPass(rs.getString(2));
				tmp.setName(rs.getString(3));
				tmp.setRegidate(rs.getDate(4));
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

	public MemberVO getMember(int id) {
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from member where id=" + id;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			MemberVO tmp = new MemberVO();
			tmp.setId(rs.getInt(1));
			tmp.setPass(rs.getString(2));
			tmp.setName(rs.getString(3));
			tmp.setRegidate(rs.getDate(4));
			return tmp;
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

	public int addMember(MemberVO memberVO) {

		String query = "insert into member (pass, name) values (?, ?)";
		PreparedStatement pst = null;
		int result;
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
		int result;
		String query = "update member set pass=?, name=? where id=?";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, memberVO.getPass());
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

	public int removeMember(int id) {
		PreparedStatement pst = null;
		int result;
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
}
