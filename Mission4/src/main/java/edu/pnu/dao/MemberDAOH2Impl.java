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
	LogH2Impl log;

	public MemberDAOH2Impl() {
		log = new LogH2Impl();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/Mission2", "sa", "abcd");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<MemberVO> getMembers() {
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
			log.addLog("getMembers", query, true);
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
		log.addLog("getMembers", query, false);
		return null;
	}

	public MemberVO getMember(Integer id) {
		if (id == null) {
			log.addLog("getMember", "select * from member where id=" + id, false);
			return null;
		}
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
			log.addLog("getMember", "select * from member where id=" + id, true);
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
		log.addLog("getMember", "select * from member where id=" + id, false);
		return null;
	}

	public int addMember(MemberVO memberVO) {
		if (memberVO.getPass() == null || memberVO.getName() == null) {
			log.addLog("addMember",
					"insert into member (pass, name) values (" + memberVO.getPass() + ", " + memberVO.getName() + ")",
					false);
			return 0;
		}
		PreparedStatement pst = null;
		int result = 0;
		String query = "insert into member (pass, name) values (?, ?)";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, memberVO.getPass());
			pst.setString(2, memberVO.getName());
			result = pst.executeUpdate();
			log.addLog("addMember",
					"insert into member (pass, name) values (" + memberVO.getPass() + ", " + memberVO.getName() + ")",
					true);
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
		log.addLog("addMember",
				"insert into member (pass, name) values (" + memberVO.getPass() + ", " + memberVO.getName() + ")",
				false);
		return 0;
	}

	@Override
	public Map<String, Object> addMemberWithMap(MemberVO memberVO) {
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

	public int updateMember(MemberVO memberVO) {
		if (memberVO.getId() == null) {
			log.addLog("update", "update member set pass=" + memberVO.getPass() + ", name=" + memberVO.getName()
					+ " where id=" + memberVO.getId(), false);
			return 0;
		}
		PreparedStatement pst = null;
		ResultSet rs = null;
		int result = 0;
		String query = "update member set pass=?, name=? where id=?";
		String query1 = "select * from member where id=?";
		try {
			pst = con.prepareStatement(query1);
			pst.setInt(1, (int) memberVO.getId());
			rs = pst.executeQuery();
			rs.next();

			pst = con.prepareStatement(query);
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
			log.addLog("update", "update member set pass=" + memberVO.getPass() + ", name=" + memberVO.getName()
					+ " where id=" + memberVO.getId(), true);
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
		log.addLog("update", "update member set pass=" + memberVO.getPass() + ", name=" + memberVO.getName()
				+ " where id=" + memberVO.getId(), false);
		return 0;
	}

	public int removeMember(Integer id) {
		if (id == null) {
			log.addLog("remove", "delete member where id=" + id, false);
			return 0;
		}
		PreparedStatement pst = null;
		int result;
		String query = "delete member where id=?";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			result = pst.executeUpdate();
			log.addLog("remove", "delete member where id=" + id, true);
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
		log.addLog("remove", "delete member where id=" + id, false);
		return 0;
	}

}
