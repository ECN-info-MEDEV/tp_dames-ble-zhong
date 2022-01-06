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

/**
 *
 * @author uble
 */
public class ElementTest {
   
   public ElementTest() {
   }
   
   @BeforeClass
   public static void setUpClass() {
   }
   
   @AfterClass
   public static void tearDownClass() {
   }

   /**
    * Test of isEquipe method, of class Element.
    */
   @Test
   public void testIsEquipe() {
      System.out.println("isEquipe");
      Element instance = new Element();
      boolean expResult = false;
      boolean result = instance.isEquipe();
      assertEquals(expResult, result);
   }

   /**
    * Test of setEquipe method, of class Element.
    */
   @Test
   public void testSetEquipe() {
      boolean equipe = false;
      Element instance = new Element();
      instance.setEquipe(equipe);
      assertEquals(equipe, instance.isEquipe());
   }

   /**
    * Test of isDame method, of class Element.
    */
   @Test
   public void testIsDame() {
      System.out.println();
      Element instance = new Element(true,true);
      boolean expResult = true;
      boolean result = instance.isDame();
      assertEquals(expResult, result);

   }

   /**
    * Test of setDame method, of class Element.
    */
   @Test
   public void testSetDame() {
      System.out.println("setDame");
      boolean dame = true;
      Element instance = new Element();
      instance.setDame(dame);
      assertEquals(dame, instance.isDame());
   }
   
}
