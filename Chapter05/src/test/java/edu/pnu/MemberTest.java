package edu.pnu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberTest {

	@Autowired
	MemberRepository memRepo;

	@Test
	@Order(1)
	@DisplayName("멤버 입력")
	public void InsertMember() {
		for (int i = 0; i < 10; i++) {
			memRepo.save(
					Member.builder().id("id" + i).password("password" + i).name("name" + i).role("role" + i).build());
		}
	}

	@Test
	@Order(2)
	@DisplayName("0번 멤버 조회")
	public void getMember() {
		Member member = memRepo.findById("id0").get();
		System.out.println(member.toString());
	}

	@Test
	@Order(3)
	@DisplayName("0번 멤버 수정")
	public void updateMember() {
		Member member = memRepo.findById("id0").get();
		member.setPassword("수정");
		member.setName("수정");
		member.setRole("수정");
		memRepo.save(member);
	}

	@Test
	@Order(4)
	@DisplayName("1번 멤버 삭제")
	public void deleteMember() {
		memRepo.deleteById("id1");
	}

}
