package com.magueye.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.magueye.entity.Produit;

@Stateless(name="PROD")
public class ImpProduit implements InterfaceProduit{
	@PersistenceContext(unitName="UP_PRODUIT")
	private EntityManager em;

	@Override
	public void add(Produit produit) {
		em.persist(produit);
		
	}

	@Override
	public List<Produit> GetAllproduit() {
		Query req=em.createQuery("select s from Produit s");
		return req.getResultList();
	}

	@Override
	public void delete(Long id) {
		Produit p=em.find(Produit.class, id);
		if(p==null) throw new RuntimeException("produit inexistant");
		em.remove(p);
		
	}

	@Override
	public void update(Produit produit) {
		Produit produit1=em.find(Produit.class, produit.getId());
		produit1.setNom(produit.getNom());
		produit1.setReference(produit.getReference());
		em.merge(produit);
		
	}

	@Override
	public List<Produit> GetProduiParMC(String mc) {
		Query req=em.createQuery
				("select s from Produit s where s.nom like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Produit GetProduit(Long id) {
		Produit p=em.find(Produit.class, id);
		return p;
	}

}
