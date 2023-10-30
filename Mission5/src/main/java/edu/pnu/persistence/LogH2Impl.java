package edu.pnu.persistence;

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

import edu.pnu.domain.DBLog;

@Repository
public class LogH2Impl implements LogInterface {

	@Autowired
	private LogInterface logInterface;
	
	public void add(String method, String sqlstring, boolean success) {
		logInterface.save(DBLog.builder().method(method).sqlstring(sqlstring).success(success).build());
		return;
	}
	
	
	@Override
	public <S extends DBLog> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DBLog> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DBLog> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<DBLog> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<DBLog> findAllById(Iterable<Integer> ids) {
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
	public void delete(DBLog entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends DBLog> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<DBLog> findOne(Predicate predicate) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Iterable<DBLog> findAll(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<DBLog> findAll(Predicate predicate, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<DBLog> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<DBLog> findAll(OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DBLog> findAll(Predicate predicate, Pageable pageable) {
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
	public <S extends DBLog, R> R findBy(Predicate predicate, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
