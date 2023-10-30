package edu.pnu.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

import edu.pnu.domain.Member;

@Repository
public class MemberH2Impl implements MemberInterface {

	@Autowired
	private MemberInterface memberInterface;

	public Map<String, Object> getMembers() {
		String method = "GET";
		String sql = "select * from member";
		Map<String, Object> map = new HashMap<>();
		List<Member> list = (List<Member>) memberInterface.findAll();
		if (!list.isEmpty()) {
			map.put("method", method);
			map.put("sql", sql);
			map.put("result", list);
		} else {
			map.put("method", method);
			map.put("sql", sql);
			map.put("result", null);
		}
		return map;
	}

	public Map<String, Object> getMember(Integer id) {
		String method = "GET";
		String sql = "select * from member where id=" + id;
		Map<String, Object> map = new HashMap<>();
		if (!memberInterface.findById(id).isEmpty()) {
			Member tmp = memberInterface.findById(id).get();
			map.put("method", method);
			map.put("sql", sql);
			map.put("result", tmp);
		} else {
			map.put("method", method);
			map.put("sql", sql);
			map.put("result", null);
		}
		return map;
	}

	public Map<String, Object> addMember(Member member) {
		String method = "POST";
		String sql = "insert into member (pass, name) values (" + member.getPass() + ", " + member.getName() + ")";
		Map<String, Object> map = new HashMap<>();
		if (member.getPass() != null && member.getName() != null) {
			map.put("method", method);
			map.put("sql", sql);
			Member tmp = Member.builder().pass(member.getPass()).name(member.getName()).build();
			map.put("result", tmp);
			memberInterface.save(tmp);
		} else {
			map.put("method", method);
			map.put("sql", sql);
			map.put("result", null);
		}
		return map;
	}

	public Map<String, Object> updateMember(Member member) {
		String method = "PUT";
		String sql = "update member set pass=" + member.getPass() + ", name=" + member.getName() + " where id="
				+ member.getId();
		Map<String, Object> map = new HashMap<>();
		if (!memberInterface.findById(member.getId()).isEmpty()) {
			map.put("method", method);
			map.put("sql", sql);
			Member tmp = memberInterface.findById(member.getId()).get();
			if (member.getPass() != null)
				tmp.setPass(member.getPass());
			if (member.getName() != null)
				tmp.setName(member.getName());
			map.put("result", tmp);
			memberInterface.save(tmp);
		} else {
			map.put("method", method);
			map.put("sql", sql);
			map.put("result", null);
		}
		return map;
	}

	public Map<String, Object> removeMember(Integer id) {
		String method = "DELETE";
		String sql = "delete from member where id=" + id;
		Map<String, Object> map = new HashMap<>();
		if (!memberInterface.findById(id).isEmpty()) {
			map.put("method", method);
			map.put("sql", sql);
			Member tmp = memberInterface.findById(id).get();
			map.put("result", tmp);
			memberInterface.deleteById(id);
		} else {
			map.put("method", method);
			map.put("sql", sql);
			map.put("result", null);
		}
		return map;
	}

	@Override
	public <S extends Member> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Member> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Member> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Member> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Member entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Member> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Member> findOne(Predicate predicate) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Iterable<Member> findAll(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Member> findAll(Predicate predicate, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Member> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Member> findAll(OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Member> findAll(Predicate predicate, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Predicate predicate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Predicate predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Member, R> R findBy(Predicate predicate, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
