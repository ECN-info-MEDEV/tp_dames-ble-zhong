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
   @Ignore
   @Test
   public void testAfficher() {
      System.out.println("afficher");
      Plateau instance = new Plateau();
      instance.afficher();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getGrille method, of class Plateau.
    */
   @Ignore
   @Test
   public void testGetGrille() {
      System.out.println("getGrille");
      Plateau instance = new Plateau();
      Element[][] expResult = null;
      Element[][] result = instance.getGrille();
      assertArrayEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of setGrille method, of class Plateau.
    */
   @Ignore
   @Test
   public void testSetGrille() {
      System.out.println("setGrille");
      Element[][] grille = null;
      Plateau instance = new Plateau();
      instance.setGrille(grille);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
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
      boolean[] expResult = new boolean[]{true, false};
      boolean[] result = instance.deplacer(x, y, x1, y1, true);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of verifierDeplacerPion method, of class Plateau.
    */
   @Ignore
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
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of verifierDeplacerDame method, of class Plateau.
    */
   @Ignore
   @Test
   public void testVerifierDeplacerDame() {
      System.out.println("verifierDeplacerDame");
      int x = 0;
      int y = 0;
      int x1 = 0;
      int y1 = 0;
      Plateau instance = new Plateau();
      boolean expResult = false;
      boolean result = instance.verifierDeplacerDame(x, y, x1, y1, true);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   /**
    * Test of casDeplaceDame method, of class Plateau.
    */
   @Ignore
   @Test
   public void testCasDeplaceDame() {
      System.out.println("casDeplaceDame");
      int x = 0;
      int y = 0;
      int x1 = 0;
      int y1 = 0;
      Plateau instance = new Plateau();
      int expResult = 0;
      int result = instance.casDeplaceDame(x, y, x1, y1, true);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }
   
}
