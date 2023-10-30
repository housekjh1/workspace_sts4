package edu.pnu.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.DBLog;

public interface LogInterface extends CrudRepository<DBLog, Integer>, QuerydslPredicateExecutor<DBLog> {

}
