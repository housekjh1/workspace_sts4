package edu.pnu.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Member;

public interface MemberInterface extends CrudRepository<Member, Integer>, QuerydslPredicateExecutor<Member> {

}
