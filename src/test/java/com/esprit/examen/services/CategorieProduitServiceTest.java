package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Operateur;

@SpringBootTest
public class CategorieProduitServiceTest {
@Autowired
ICategorieProduitService categorieService; 
@Test
public void testAddProduit() {

	CategorieProduit s = new CategorieProduit("cat1 ","1test");
	CategorieProduit savedCat=categorieService.addCategorieProduit(s) ;
	assertNotNull(savedCat.getCodeCategorie());
	assertNotNull(savedCat.getLibelleCategorie());
	
}

@Test
public void testAddProductOptimized() {

	CategorieProduit s = new CategorieProduit("cat1","1test");
	CategorieProduit savedCat=categorieService.addCategorieProduit(s) ;
	assertNotNull(savedCat.getSerialversionuid());
	assertSame("cat1", savedCat.getCodeCategorie());
	assertSame("1test", savedCat.getLibelleCategorie());
	
}
@Test
public void testDeleteStock() {

	CategorieProduit s = new CategorieProduit("cat1 ","1test");
	CategorieProduit savedCat=categorieService.addCategorieProduit(s) ;
	categorieService.deleteCategorieProduit(savedCat.getSerialversionuid());
	assertNull(categorieService.retrieveCategorieProduit(savedCat.getSerialversionuid()));
}

}
