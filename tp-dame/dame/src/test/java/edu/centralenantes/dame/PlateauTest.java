/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.dame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author uble
 */
public class PlateauTest {

   public PlateauTest() {
   }

   @BeforeClass
   public static void setUpClass() {
   }

   @AfterClass
   public static void tearDownClass() {
   }

   /**
    * Test of afficher method, of class Plateau.
    */

   @Test
   public void testAfficher() {
      System.out.println("afficher");
      Plateau instance = new Plateau();
      instance.afficher();
   }

   /**
    * Test of getGrille method, of class Plateau.
    */
   @Test
   public void testGetGrille() {
      System.out.println("getGrille");
      Plateau instance = new Plateau();
      Element expResult = null;
      Element[][] result = instance.getGrille();
      assertEquals(expResult, result[0][0]);
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   /**
    * Test of setGrille method, of class Plateau.
    */
   @Test
   public void testSetGrille() {
      System.out.println("setGrille");
      Element[][] grille = null;
      Plateau instance = new Plateau();
      instance.setGrille(grille);
      assertEquals(grille, instance.getGrille());
   }

   /**
    * Test of deplacer method, of class Plateau.
    */
   @Test
   public void testDeplacer() {
      System.out.println("deplacer");
      int x = 0;
      int y = 3;
      int x1 = 1;
      int y1 = 4;
      Plateau instance = new Plateau();
      boolean[] result = instance.deplacer(x, y, x1, y1, true);
      boolean[] expResult = new boolean[] { true, false };

      assertEquals(expResult[0], result[0]);
      assertEquals(expResult[1], result[1]);
      instance.getGrille()[2][3].setDame(true);
      boolean[] result2 = instance.deplacer(2,3,0,5,true);
      boolean[] expResult2 = new boolean[] { true, false };
      assertEquals(expResult2[0], result2[0]);
      assertEquals(expResult2[1], result2[1]);
   }

   /**
    * Test of verifierDeplacerPion method, of class Plateau.
    */
   @Test
   public void testVerifierDeplacerPion() {
      System.out.println("verifierDeplacerPion");
      int x = 0;
      int y = 0;
      int x1 = 0;
      int y1 = 0;
      Plateau instance = new Plateau();
      boolean expResult = false;
      boolean result = instance.verifierDeplacerPion(x, y, x1, y1, true);
      assertEquals(expResult, result);
   }

   /**
    * Test of verifierDeplacerDame method, of class Plateau.
    */
   @Test
   public void testVerifierDeplacerDame() {
      System.out.println("verifierDeplacerDame");
      int x = 1;
      int y = 0;
      int x1 = 5;
      int y1 = 4;
      Plateau instance = new Plateau();
      boolean expResult = false;
      boolean result = instance.verifierDeplacerDame(x, y, x1, y1, true);
      assertEquals(expResult, result);
   }

   /**
    * Test of casDeplaceDame method, of class Plateau.
    */
   @Test
   public void testCasDeplaceDame() {
      System.out.println("casDeplaceDame");
      int x = 1;
      int y = 0;
      int x1 = 3;
      int y1 = 2;
      Plateau instance = new Plateau();
      int expResult = 1;
      int result = instance.casDeplaceDame(x, y, x1, y1, true);
      assertEquals(expResult, result);
   }

   /**
    * Test of casDeplaceDame method, of class Plateau.
    */
   @Test
   public void testPrendrePion() {
      System.out.println("prendrePion");
      int x = 4;
      int y = 3;
      int x1 = 1;
      int y1 = 6;
      Plateau instance = new Plateau();
      instance.deplacer(x, y, 3, 4, true);
      instance.deplacer(x1, y1, 2, 5, false);
      int expResult = 1;
      int result = instance.casDeplaceDame(3, 4, 2, 5, true);
      assertEquals(expResult, result);
   }

   /**
    * Test of renderSymbols method, of class Plateau.
    */

   @Test
   public void testRenderSymbols() {
      System.out.println("renderSymbols");
      Plateau instance = new Plateau();
      String[][] grid = new String[instance.getGrille().length + 2][instance.getGrille()[0].length + 2];
      instance.renderSymbols(grid);
      assertEquals(" - ", grid[2][2]);

   }

   /**
    * Test of partieFinie method, of class Plateau.
    */
   @Test
   public void testPartieFinie() {
      System.out.println("partieFinie");
      boolean joueur = false;
      Plateau instance = new Plateau();
      boolean expResult = false;
      boolean result = instance.partieFinie(joueur);
      assertEquals(expResult, result);

      Element[][] grilleSansEquipe1 = new Element[10][10];
      for (int j = 0; j < 4; j++) {
         for (int i = 0; i < grilleSansEquipe1.length; i++) {
            if ((i + j) % 2 == 1) {
               grilleSansEquipe1[i][j] = new Element(true, false); // équipe des noirs
            }
         }
      }
      instance.setGrille(grilleSansEquipe1);
      joueur = true;
      result = instance.partieFinie(joueur);
      assertEquals(expResult, result);
   }

}
