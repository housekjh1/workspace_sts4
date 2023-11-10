package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member member = memRepo.findById(username).orElseThrow(()->
					new UsernameNotFoundException("Not Found!"));
	
		
	}

}
