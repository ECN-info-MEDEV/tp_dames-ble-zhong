/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.dame;

import java.util.Scanner;

/**
 *
 * @author uble
 */
public class Jouer {
   
    public static void main(String[] args) {
        
        Plateau plat = new Plateau();
        
        System.out.println("Bienvenue au jeu de dames. Plateau crééé");
        
        while (true){
            tourDeJeu(plat);
            
            
        }
        
        
    }
    
    /**
     *
     * @param pla plateau de jeu
     */
    public static void tourDeJeu(Plateau pla){
        Scanner keyboard = new Scanner(System.in);
        String answer;
        System.out.println("Tour du Joueur 1");
        
        System.out.println("Souhaitez-vous déplacer ou prendre un pion? d/p");
        do {
            answer = keyboard.nextLine();
        } while (!answer.equals("d") && !answer.equals("p"));
        
        if ("d".equals(answer)){
            System.out.println("Coordonnées du pion à déplacer? ");
            int x;
            int y;
            
            while (true){
                System.out.println("x ?");
                x = keyboard.nextInt();
                
                System.out.println("y ?");
                y= keyboard.nextInt();
                
                if (x<10 && x>=0 && y<10 && y>=0){
                    break;  // sort de la boucle si les valeurs sont bonnes
                }
                
                
            }
            
            ;
            
            
        }
        
        
    }
    
    public boolean Changement(Plateau p,int x, int y){
       boolean etat =false;
       if(!(p.getGrille()[x][y].isDame())){
          if (p.getGrille()[x][y].isEquipe() && y==9){
             p.getGrille()[x][y].setDame(true);
             etat =true;
          }
          else if(!(p.getGrille()[x][y].isEquipe()) && y==0){
             p.getGrille()[x][y].setDame(true);
             etat=true;
          }
       }
       return(etat);
    }
    
}
