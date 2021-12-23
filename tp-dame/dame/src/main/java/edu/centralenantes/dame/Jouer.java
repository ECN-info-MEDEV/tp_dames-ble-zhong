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
            tourDeJeu(plat, true);   
            tourDeJeu(plat, false);        }
    }
    
    /**
     *
     * @param pla plateau de jeu
     * @param joueur
     */
    public static void tourDeJeu(Plateau pla, bool joueur){
        Scanner keyboard = new Scanner(System.in);
        String answer;
        System.out.println("Tour du Joueur "+joueur+". Equipe noirs");
        System.out.println("Souhaitez-vous déplacer ou prendre un pion? d/p");
        do {
            answer = keyboard.nextLine();
        } while (!answer.equals("d") && !answer.equals("p"));
        
        while (true){
            System.out.println("Coordonnées du pion à déplacer? ");
            int x;
            int y;

            while (true){
                System.out.println("x ?");
                x = keyboard.nextInt();

                System.out.println("y ?");
                y= keyboard.nextInt();

                if (x<10 && x>=0 && y<10 && y>=0 && (pla.getGrille()[x][y].isEquipe()==joueur)){  // equipe==true --> équipe des noirs
                    break;  // sort de la boucle si les valeurs sont bonnes
                }
            }

            System.out.println("Coordonnées cible? ");
            int x1;
            int y1;

            while (true){
                System.out.println("x1 ?");
                x1 = keyboard.nextInt();

                System.out.println("y1 ?");
                y1= keyboard.nextInt();

                if (x<10 && x>=0 && y<10 && y>=0 && (pla.getGrille()[x][y].isEquipe()==joueur) && x1!=x && y1!=y){  // equipe==true --> équipe des noirs
                    break;  // sort de la boucle si les valeurs sont bonnes
                }
            }

            boolean reussi;
            
            if (answer.equals("d")){
                reussi = pla.deplacer(x,y,x1,y1);              
            }
            else{
                reussi = pla.prendrePion(x,y,x1,y1);
                System.out.println("Reprendre un autre pion? y/n");
                do {
                    answer = keyboard.nextLine();
                } while (!answer.equals("y") && !answer.equals("n"));
                
                if (answer.equals("y")){
                    reussi=false;
                }
            }
            if (reussi){  // sort de la boucle si on ne veut plus prendre de pion ou si on voulait juste se déplacer
                break;
            }
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
