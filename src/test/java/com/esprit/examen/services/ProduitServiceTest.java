package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;

@SpringBootTest
public class ProduitServiceTest {
	@Autowired
	IProduitService produitService; 
	@Test
	public void testAddProduit() {
	
		Produit s = new Produit("prod test",100);
		Produit savedProduct=produitService.addProduit(s) ;
		assertNotNull(savedProduct.getLibelleProduit());
		produitService.deleteProduit(savedProduct.getIdProduit());
		
	} 
	
	@Test
	public void testAddProductOptimized() {

		Produit s = new Produit("prod test",100);
		Produit savedProduct=produitService.addProduit(s) ;
		assertNotNull(savedProduct.getIdProduit());
		assertSame("prod test", savedProduct.getLibelleProduit());
		produitService.deleteProduit(savedProduct.getIdProduit());
		
	} 
		@Test
	public void testDeleteStock() {
		Produit s = new Produit("prod test",100);
		Produit savedProduct=produitService.addProduit(s) ;
		produitService.deleteProduit(savedProduct.getIdProduit());
		assertNull(produitService.retrieveProduit(savedProduct.getIdProduit()));
	}
}
