package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.DBLog;
import edu.pnu.domain.Member;

public interface LogRepository extends JpaRepository<DBLog, Integer> {

}
