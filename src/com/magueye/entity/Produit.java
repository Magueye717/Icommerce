package com.magueye.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "Pro", schema = "PRODUCTION")
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String reference;
	private double prix;
	private int quantite;
	@Column(name="catégorie")
	private String quategorie;
	
	public Produit() {
		super();
	}
	
	public Produit(String nom, String reference, double prix, int quantite, String quategorie) {
		super();
		this.nom = nom;
		this.reference = reference;
		this.prix = prix;
		this.quantite = quantite;
		this.quategorie = quategorie;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getQuategorie() {
		return quategorie;
	}

	public void setQuategorie(String quategorie) {
		this.quategorie = quategorie;
	}
	
}
