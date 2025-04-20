package com.luminous.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.luminous.domain.Member;
import com.luminous.repository.MemberRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	@Autowired EntityManager em;
	
	
	@Test
	public void 회원가입() throws Exception{
		Member member = new Member();
		member.setName("kim");
		
		Long saveId = memberService.join(member);
		
		em.flush();
		assertEquals(member, memberRepository.findOne(saveId));
		
	}
	@Test
	public void 중복회원예외() throws Exception{
		Member member1 = new Member();
		member1.setName("kim");
		
		Member member2 = new Member();
		member2.setName("kim");
		
		memberService.join(member1);
		try {
			memberService.join(member2);
		} catch (IllegalStateException e) {
			return;
		}
		
		
	}

}
