package edu.pnu.board.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.board.domain.Member;
import edu.pnu.board.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> opt = memRepo.findById(username);
		if (!opt.isPresent()) {
			throw new UsernameNotFoundException(username + "사용자 없음");
		} else {
			Member member = opt.get();
			return new SecurityUser(member);
		}
	}
}