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
public class Plateau {
   private Element[][] grille;
   
   public Plateau(){
      grille = new Element[10][10];
      for (int j=0;j<4;j++){
         for (int i=0;i<grille.length;j++){
            if(i+j%2==1){
               grille[i][j]= new Element(true,false);
            }
         }
      }
      for (int j=6;j<10;j++){
         for (int i=0;i<grille.length;j++){
            if(i+j%2==1){
               grille[i][j]= new Element(false,false);
            }
         }
      }
   }
   
   public void afficher(){
      System.out.println("Etate actuel  du plateau");
   }

    public Element[][] getGrille() {
        return grille;
    }

    public void setGrille(Element[][] grille) {
        this.grille = grille;
    }
   
   
   
   
}
