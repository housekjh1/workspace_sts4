package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;

public class MemberDAOH2Impl implements MemberInterface {

	private Connection con;

	public MemberDAOH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/Mission2", "sa", "abcd");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, Object> getMembers() {
		String sql = "select * from member";
		List<MemberVO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				MemberVO tmp = new MemberVO();
				tmp = MemberVO.builder().id(rs.getInt(1)).pass(rs.getString(2)).name(rs.getString(3))
						.regidate(rs.getDate(4)).build();
				list.add(tmp);
			}
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sql);
			map.put("result", list);
			return map;
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

	public Map<String, Object> getMember(Integer id) {
		String sql = String.format("select * from member where id=%d", id);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			Map<String, Object> map = new HashMap<>();
			if (!rs.next()) {
				map.put("sql", sql);
				map.put("result", null);
				return map;
			}
			MemberVO tmp = MemberVO.builder().id(rs.getInt(1)).pass(rs.getString(2)).name(rs.getString(3))
					.regidate(rs.getDate(4)).build();
			map.put("sql", sql);
			map.put("result", tmp);
			return map;
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

	public Map<String, Object> addMember(MemberVO memberVO) {
		String sql = String.format("insert into member (pass, name) values ('%s', '%s')", memberVO.getPass(),
				memberVO.getName());
		Statement st = null;
		int result = 0;
		try {
			st = con.createStatement();
			result = st.executeUpdate(sql);
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sql);
			map.put("result", result);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Map<String, Object> updateMember(MemberVO memberVO) {
		String sql = "update member set pass=?, name=? where id=?";
		String sql1 = String.format("select * from member where id=%d", memberVO.getId());
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		int result = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			Map<String, Object> map = new HashMap<>();
			if (!rs.next()) {
				map.put("sql", String.format("update member set pass=%s, name=%s where id=%d", memberVO.getPass(),
						memberVO.getName(), memberVO.getId()));
				map.put("result", null);
				return map;
			}

			pst = con.prepareStatement(sql);

			if (memberVO.getPass() != null)
				pst.setString(1, memberVO.getPass());
			else
				pst.setString(1, rs.getString(2));
			if (memberVO.getName() != null)
				pst.setString(2, memberVO.getName());
			else
				pst.setString(2, rs.getString(3));

			pst.setInt(3, memberVO.getId());
			result = pst.executeUpdate();
			map.put("sql", String.format("update member set pass=%s, name=%s where id=%d", memberVO.getPass(),
					memberVO.getName(), memberVO.getId()));
			map.put("result", result);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Map<String, Object> removeMember(Integer id) {
		String sql = String.format("delete member where id=%d", id);
		Statement st = null;
		int result = 0;
		try {
			st = con.createStatement();
			result = st.executeUpdate(sql);
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sql);
			map.put("result", result);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
