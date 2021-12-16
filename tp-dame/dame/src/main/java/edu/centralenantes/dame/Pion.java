/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.dame;

/**
 *
 * @author uble
 */
public class Pion {
   boolean dame;

   public boolean isDame() {
      return dame;
   }

   public void setDame(boolean dame) {
      this.dame = dame;
   }
   
   public void makeDame(){
      this.dame=true;
   }
}
