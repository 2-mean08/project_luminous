package com.luminous.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luminous.domain.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ItemRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Item item) {
		if(item.getItem_id() == null) {
			em.persist(item);
		} else {
			em.merge(item);
		}
	}
	public Item findOne(Long item_id) {
		return em.find(Item.class, item_id);
	}
	public List<Item> findAll(){
		return em.createQuery("select i from Item i", Item.class)
				.getResultList();
	}
}
