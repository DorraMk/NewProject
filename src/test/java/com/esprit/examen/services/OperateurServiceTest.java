package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;

@SpringBootTest
public class OperateurServiceTest {
	@Autowired
	IOperateurService operateurService; 
	
	@Test
	public void testAddProduit() {
	
		Operateur s = new Operateur("operateur ","1nom","prenom");
		Operateur savedOp=operateurService.addOperateur(s) ;
		assertNotNull(savedOp.getNom());
		assertNotNull(savedOp.getPrenom());
		assertNotNull(savedOp.getPassword());
		operateurService.deleteOperateur(savedOp.getIdOperateur());
	} 
	
	@Test
	public void testAddProductOptimized() {

		Operateur s = new Operateur("operateur","1nom","prenom");
		Operateur savedOp=operateurService.addOperateur(s) ;
		assertNotNull(savedOp.getIdOperateur());
		assertSame("operateur", savedOp.getNom());
		assertSame("1nom", savedOp.getPrenom());
		assertSame("prenom", savedOp.getPassword());
		operateurService.deleteOperateur(savedOp.getIdOperateur());
	} 
	@Test
	public void testDeleteStock() {

		Operateur s = new Operateur("operateur ","1nom","prenom");
		Operateur savedOp=operateurService.addOperateur(s) ;
		operateurService.deleteOperateur(savedOp.getIdOperateur());
		assertNull(operateurService.retrieveOperateur(savedOp.getIdOperateur()));
	}
}
