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
 * @author uble, zijie
 */
public class JouerTest {

   @BeforeClass
   public static void setUpClass() throws Exception {
   }

   @AfterClass
   public static void tearDownClass() throws Exception{
   }

   /**
    * Test of main method, of class Jouer.
    */
   @Ignore("pas encore implémenté")
   @Test
   public void testMain() {
      System.out.println("main");
      String[] args = null;
      Jouer.main(args);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of tourDeJeu method, of class Jouer.
    */
   @Ignore("pas encore implémenté")
   @Test
   public void testTourDeJeu() {
      System.out.println("tourDeJeu");
      Plateau pla = new Plateau();

      Jouer.tourDeJeu(pla, true);
      Jouer.tourDeJeu(pla, false);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of Changement method, of class Jouer.
    */
   @Test
   public void testChangement() {
      System.out.println("Changement");
      Plateau p = new Plateau();
      p.getGrille()[9][1] = new Element(false, false);
      p.getGrille()[9][2] = new Element(true, false);
      p.getGrille()[9][3] = new Element(false, true);
      p.getGrille()[9][4] = new Element(true, true);

      // cas changement 9,1 donc pion blanc dans son camp
      boolean expResult = false;
      boolean result = Jouer.changement(p, 9, 1);
      assertEquals(expResult, result);

      // cas changement 9,2 donc pion noir dans le camp adverse
      expResult = true;
      result = Jouer.changement(p, 9, 2);
      assertEquals(expResult, result);

      // cas changement 9,3 donc dame blanche dans son camp
      expResult = false;
      result = Jouer.changement(p, 9, 3);
      assertEquals(expResult, result);

      // cas changement 9,4 donc dame noire dans le camp adverse
      expResult = false;
      result = Jouer.changement(p, 9, 4);
      assertEquals(expResult, result);

   }

}
