package com.luminous;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MembersRepository {
    @PersistenceContext
    EntityManager em;
    public Long save(Members members) {
        em.persist(members);
        return members.getId();
    }
    public Members find(Long id) {
        return em.find(Members.class, id);
    }
}
