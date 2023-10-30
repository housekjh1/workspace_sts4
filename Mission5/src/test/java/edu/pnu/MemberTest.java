package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberInterface;

@SpringBootTest
public class MemberTest {
	
	@Autowired
	private MemberInterface memberInterface;
	
	@Test
	public void insertMember() {
		for (int i = 1; i <= 5; i++) {
			memberInterface.save(Member.builder().pass("pass"+i).name("name"+i).build());
		}
	}
}
