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
   boolean Dame;

    public Element(boolean equipe, boolean Dame) {
        this.equipe = equipe;
        this.Dame = Dame;
    }
   
   public boolean isEquipe() {
      return equipe;
   }

   public void setEquipe(boolean equipe) {
      this.equipe = equipe;
   }

    public boolean isDame() {
        return Dame;
    }

    public void setDame(boolean Dame) {
        this.Dame = Dame;
    }
   
   
   
   
   
}
