package com.magueye.web;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.magueye.dao.InterfaceProduit;
import com.magueye.entity.Produit;

@ManagedBean(name="ControleP")
@RequestScoped
public class MBproduit {
	Produit produit = new Produit();
	List<Produit> produits = new ArrayList<>();
	@EJB
	InterfaceProduit interfaceProduit;
	
	public String ajouter() {
		interfaceProduit.add(produit);
		return"success";
	}
	
	public List<Produit> ListProduit(){
		return interfaceProduit.GetAllproduit();
		}
	
	public String suprimer(Long id) {
		interfaceProduit.delete(id);
		return"success";
	}
	
	public String modifierView(Produit produit) {
		this.produit=produit;
		return"edit";
	   }
	
	public String modifier() {
		interfaceProduit.update(produit);
		return"create";
	   }
	
	public String NavigatToHome() {
		return"index";
	}
	
	public String rechercher() {
		interfaceProduit.GetProduiParMC(null);
		return "list";
	}
	
	public MBproduit() {
		super();
	}



	public Produit getProduit() {
		return produit;
	}



	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public InterfaceProduit getInterfaceProduit() {
		return interfaceProduit;
	}



	public void setInterfaceProduit(InterfaceProduit interfaceProduit) {
		this.interfaceProduit = interfaceProduit;
	}
	
}
