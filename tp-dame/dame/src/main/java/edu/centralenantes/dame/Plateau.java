/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.dame;

/**
 *
 * @author uble, zijie
 * @version 1.0
 */
public class Plateau {
   private Element[][] grille;

   public Plateau() {
      grille = new Element[10][10];
      for (int j = 0; j < 4; j++) {
         for (int i = 0; i < grille.length; j++) {
            if (i + j % 2 == 1) {
               grille[i][j] = new Element(true, false);
            }
         }
      }
      for (int j = 6; j < 10; j++) {
         for (int i = 0; i < grille.length; j++) {
            if (i + j % 2 == 1) {
               grille[i][j] = new Element(false, false);
            }
         }
      }
   }

   public void afficher() {
      System.out.println("Etat actuel  du plateau");
      String[][] grid = new String[grille.length][grille[0].length];
      for (int i = 0; i < grille.length; i++) {
         for (int j = 0; j < grille[0].length; j++) {
            if (grille[i][j] != null && grille[i][j].isEquipe() && grille[i][j].isDame()) {
               grid[i][j] = " N ";
            } else if (grille[i][j] != null && grille[i][j].isEquipe() && !(grille[i][j].isDame())) {
               grid[i][j] = " n ";
            } else if (grille[i][j] != null && !(grille[i][j].isEquipe()) && !(grille[i][j].isDame())) {
               grid[i][j] = " b ";
            } else if (grille[i][j] != null && !(grille[i][j].isEquipe()) && (grille[i][j].isDame())) {
               grid[i][j] = " B ";
            } else {
               grid[i][j] = " - ";
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

   public boolean deplacer(int x, int y, int x1, int y1) {
      boolean res = true;
      /**
       * x : x initial
       * y : y initial
       * x1 : x destinataire
       * y1: y destinataire
       */
      boolean isDame = grille[x][y].isDame();
      if (isDame == true) {
         // faire déplacer un DAME si possible
         if (verifierDeplacerDame(x, y, x1, y1) == true) {
            if ((Math.abs(x1 - x) == Math.abs(y1 - y) && Math.abs(x1 - x) == 2) && (grille[x + (x1 - x) / 2][y
                  + (y1 - y) / 2] != null)) {
               // déplacement en prenant un pion
               prendrePion(x, y, x1, y1);
            }
            grille[x1][y1] = grille[x][y];
            grille[x][y] = null;
            System.out.println("Déplacement réussi.");

            res = true;
         } else if (verifierDeplacerDame(x, y, x1, y1) == false) {
            System.out.println("On ne peut pas déplacer vers cette cellule selon les règles. Ré-essayez svp.");
            res = false;
         }
         return res;
      } else {
         // faire déplacer un PION si possible
         if (verifierDeplacerPion(x, y, x1, y1) == true) {
            if ((Math.abs(x1 - x) == Math.abs(y1 - y)) && (casDeplaceDame(x, y, x1, y1) == 2)) {
               // déplacement en prenant un pion
               prendrePion(x, y, x1, y1);
            }
            grille[x1][y1] = grille[x][y];
            grille[x][y] = null;
            System.out.println("Déplacement réussi.");
            res = true;
         } else if (verifierDeplacerPion(x, y, x1, y1) == false) {
            System.out.println("On ne peut pas déplacer vers cette cellule selon les règles. Ré-essayez svp.");
            res = false;
         }
         return res;
      }

   }

   public boolean verifierDeplacerPion(int x, int y, int x1, int y1) {
      boolean res = true;
      /**
       * x : x initial
       * y : y initial
       * x1 : x destinataire
       * y1: y destinataire
       */

      // vérifier si un déplacement est possible
      if (x1 < 0 || x1 > 9 || y1 < 0 || y1 > 9) {
         System.out.println("Destination dehors du plateau. Ré-essayer svp.");
         res = false;
      } else if (Math.abs(x1 - x) != Math.abs(y1 - y)) {
         System.out.println("Destination n'est pas dans la même ligne. Ré-essayer svp.");
         res = false;
      } else if (Math.abs(x1 - x) == Math.abs(y1 - y) && Math.abs(x1 - x) == 1) {
         // déplacement sans prendre un pion
         res = true;
      } else if (Math.abs(x1 - x) == Math.abs(y1 - y) && Math.abs(x1 - x) == 2) {
         // déplacement en prenant un pion
         if (grille[x + (x1 - x) / 2][y + (y1 - y) / 2] != null) {
            // il y a un pion au milieu
            res = true;
         } else {
            res = false;
         }
      } else {
         System.out.println("Destination non prise en compte. Ré-essayer svp.");
         res = false;
      }
      return res;
   }

   public boolean verifierDeplacerDame(int x, int y, int x1, int y1) {
      boolean res = true;
      /**
       * x : x initial
       * y : y initial
       * x1 : x destinataire
       * y1: y destinataire
       */

      // vérifier si un déplacement est possible
      if (x1 < 0 || x1 > 9 || y1 < 0 || y1 > 9) {
         System.out.println("Destination dehors du plateau. Ré-essayer svp.");
         res = false;
      } else if ((Math.abs(x1 - x) != Math.abs(y1 - y)) && ((x1 != x) && (y1 != y))) {
         System.out.println("Destination n'est pas dans la même ligne. Ré-essayer svp.");
         res = false;
      } else if (Math.abs(x1 - x) == Math.abs(y1 - y)) {
         // déplacement dans une ligne
         if (casDeplaceDame(x, y, x1, y1) == 1) {
            // déplacer sans prenant un pion
            res = true;
         } else if (casDeplaceDame(x, y, x1, y1) == 2) {
            // déplacer en prenant un pion
            res = true;
         } else {
            res = false;
         }
      } else {
         System.out.println("Destination non prise en compte. Ré-essayer svp.");
         res = false;
      }
      return res;
   }

   public int casDeplaceDame(int x, int y, int x1, int y1) {
      int res = 0;
      /**
       * x : x initial
       * y : y initial
       * x1 : x destinataire
       * y1: y destinataire
       */

      // detecte le cas de déplacement d'un dame
      // si c'est un déplacement sans prendre un pion, return 1
      // si c'est un déplacement en prenant un pion, return 2
      int count = 0; // compteur de fois d'apparition
      for (int i = 1; i < (x1 - x - 1); i++) {
         if (grille[x + i][y + i] != null) {
            count += 1;
         }
      }
      if (count == 0) {
         res = 1;
      } else if (count == 1) {
         res = 2;
      } else {
         System.out.println("Cas de déplacement d'un dame inattendu.");
         res = 0;
      }
      return res;
   }

   public void prendrePion(int x, int y, int x1, int y1) {

      /**
       * x : x initial
       * y : y initial
       * x1 : x destinataire
       * y1: y destinataire
       */

      // quand on appelle cet méthode, il faut s'assurer que le déplacement soit légal
      // autrement dit, on assume dans cette méthode que il existe un et seulement un
      // pion entre (x,y) et (x1,y1)

      // pour assurer ça, il faut toujours appeler cette méthode dans deplacer()
      for (int i = 1; i < (x1 - x - 1); i++) {
         if (grille[x + i][y + i] != null) {
            grille[x + i][y + i] = null;
         }
      }
   }
}
