package com.luminous.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luminous.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
	public Member findOne(Long member_id) {
		return em.find(Member.class, member_id);
	}
	
	public List<Member> findAll() {
		return em.createQuery("select m from Member m", Member.class)
				.getResultList();
	}
	
	public List<Member> findByName(String nickname){
		return em.createQuery("select m from Member m where m.nickname = :nickname", Member.class)
		.setParameter("nickname", nickname)
		.getResultList();
		
	}
	
}
