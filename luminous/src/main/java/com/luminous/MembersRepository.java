package com.luminous;

import com.luminous.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MembersRepository {
    @PersistenceContext
    EntityManager em;
    public int save(Member member) {
        em.persist(member);
        return member.getMember_id();
    }
    public Member find(Integer Member_id) {
        return em.find(Member.class, Member_id);
    }
}
