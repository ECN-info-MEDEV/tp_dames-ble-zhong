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
public class Element {
   boolean equipe;
   boolean dame;

    public Element() {
        this.equipe=false;
        this.dame=false;
    }
    
    public Element(boolean equipe, boolean dame) {
        this.equipe = equipe;
        this.dame = dame;
    }
   
   public boolean isEquipe() {
      return equipe;
   }

   public void setEquipe(boolean equipe) {
      this.equipe = equipe;
   }

    public boolean isDame() {
        return dame;
    }

    public void setDame(boolean dame) {
        this.dame = dame;
    }
   
   
   
   
   
}
