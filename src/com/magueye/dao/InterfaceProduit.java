package com.magueye.dao;

import java.util.List;

import javax.ejb.Local;

import com.magueye.entity.Produit;

@Local
public interface InterfaceProduit {

	public void add(Produit produit);
	public List<Produit> GetAllproduit();
	public void delete(Long id);
	public void update(Produit produit);
	public  List<Produit> GetProduiParMC(String mc);
	public Produit GetProduit(Long id);
}
