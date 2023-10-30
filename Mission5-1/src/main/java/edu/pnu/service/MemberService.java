package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;

	public List<Member> getMembers() {
		return memberRepo.findAll();
	}

	public Member getMember(Integer id) {
		Optional<Member> opt = memberRepo.findById(id);
		if (!opt.isPresent()) return null;
		return opt.get();
	}

	public Member addMember(Member member) {
		memberRepo.save(member);
		Member tmp = memberRepo.findById(member.getId()).get();
		return tmp;
	}

	public Member updateMember(Member member) {
		Member tmp = memberRepo.findById(member.getId()).get();
		if (tmp == null) return null;
		if (member.getPass() != null) tmp.setPass(member.getPass());
		if (member.getName() != null) tmp.setName(member.getName());
		memberRepo.save(tmp);
		return tmp;
	}

	public Member removeMember(Integer id) {
		if (!memberRepo.findById(id).isPresent()) return null;
		Member tmp = memberRepo.findById(id).get();
		memberRepo.deleteById(id);
		return tmp;
	}
}
