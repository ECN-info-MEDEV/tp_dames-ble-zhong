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
      for (int i=0;i<4;i++){
         for (int j=0;j<grille.length;j++){
            if((i+j)%2==1){
               grille[i][j]= new Element(true,false);
            }
         }
      }
      for (int i=6;i<10;i++){
         for (int j=0;j<grille.length;j++){
            if((i+j)%2==1){
               grille[i][j]= new Element(false,false);
            }
         }
      }
   }
   
   public void afficher(){
      System.out.println("Etat actuel  du plateau");
      String[][] grid = new String[grille.length][grille[0].length];
      for (int i=0;i<grille.length;i++){
         for (int j=0;j<grille[0].length;j++){
            if(grille[i][j]!= null && grille[i][j].isEquipe() && grille[i][j].isDame()){
               grid[i][j]= " N ";
            }
            else if(grille[i][j]!= null && grille[i][j].isEquipe() && !(grille[i][j].isDame())){
               grid[i][j]= " n ";
            }
            else if(grille[i][j]!= null && !(grille[i][j].isEquipe()) && !(grille[i][j].isDame())){
               grid[i][j]= " b ";
            }
            else if(grille[i][j]!= null && !(grille[i][j].isEquipe()) && (grille[i][j].isDame())){
               grid[i][j]= " B ";
            }
            else {
               grid[i][j]= " - ";
            }
            
         }
      }
     for (int k = 0; k < grille.length; k++) {
            for (int j = 0; j < grille[0].length; j++) {
                System.out.print(grid[k][j]);
            }
            System.out.println(" ");
        }

   }

    public Element[][] getGrille() {
        return grille;
    }

    public void setGrille(Element[][] grille) {
        this.grille = grille;
    }
   
   
   
   
}
