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

        while (true) {
            tourDeJeu(plat, true);
            tourDeJeu(plat, false);
        }
    }

    /**
     *
     * @param pla    plateau de jeu
     * @param joueur
     */
    public static void tourDeJeu(Plateau pla, boolean joueur) {
        Scanner keyboard = new Scanner(System.in);
        if (joueur) { // true = noirs
            System.out.println("Tour du Joueur 1. Equipe noirs");
        } else {
            System.out.println("Tour du Joueur 2. Equipe blancs");
        }
        pla.afficher();
        boolean[] reussi = new boolean[] { false, false };
        int x = 0;
        int y = 0;
        int x1;
        int y1;
        boolean priseObligee = false;

        while (true) {
            if (!priseObligee) {
                System.out.println("Coordonnées du pion à déplacer? ");
                while (true) {
                    System.out.println("x ?");
                    x = keyboard.nextInt();

                    System.out.println("y ?");
                    y = keyboard.nextInt();

                    if ((x <= 9 && x >= 0 && y <= 9 && y >= 0)
                            && (pla.getGrille()[x][y] != null)
                            && (pla.getGrille()[x][y].isEquipe() == joueur)) {
                        // equipe==true --> équipe des noirs
                        // sort de la boucle si les valeurs sont bonnes
                        break;
                    }
                }
            }

            System.out.println("Coordonnées cible? ");
            while (true) {
                System.out.println("x1 ?");
                x1 = keyboard.nextInt();

                System.out.println("y1 ?");
                y1 = keyboard.nextInt();
                System.out.println("x : " + x + "y : " + y);
                System.out.println("x1 : " + x1 + "y1 : " + y1);
                if ((x1 <= 9 && x1 >= 0 && y1 <= 9 && y1 >= 0)
                        && ((pla.getGrille()[x1][y1] == null) && (x1 != x || y1 != y))) {
                    break; // sort de la boucle si les valeurs sont bonnes
                }

            }

            if (!priseObligee) {
                reussi = pla.deplacer(x, y, x1, y1, joueur);
            } else {
                if (pla.getGrille()[x][y].isDame()) {
                    if (pla.casDeplaceDame(x, y, x1, y1, joueur) != 2) {
                        System.out.println("Prise impossible");
                    } else {
                        reussi = pla.deplacer(x, y, x1, y1, joueur);
                    }
                } else {
                    if ((Math.abs(x1 - x) == Math.abs(y1 - y) && Math.abs(x1 - x) == 2)
                            && (pla.getGrille()[(x1 + x) / 2][(y1 + y) / 2] != null)) {
                        if (pla.getGrille()[(x1 + x) / 2][(y1 + y) / 2].equipe != joueur) {
                            reussi = pla.deplacer(x, y, x1, y1, joueur);
                        } else {
                            System.out.println("Prise impossible");
                        }
                    } else {
                        System.out.println("Prise impossible");
                    }
                }
            }

            if (reussi[0]) {
                changement(pla, x1, y1); // vérifier si le pion est transformé en dame
            }

            if (reussi[1]) { // un pion a été pris, on refait un tour de jeu si besoin
                pla.afficher();

                System.out.println("Réessayer de prendre un pion? [y/n]");
                String reponse;
                do {
                    reponse = keyboard.nextLine();
                } while (!reponse.equals("y") && !reponse.equals("n"));

                if ("n".equals(reponse)) {
                    break;
                } else {
                    if (reussi[0]) { // on change les coordonnées initiales s'il y a eu un déplacement
                        x = x1;
                        y = y1;
                    }
                    priseObligee = true;
                    reussi[0] = false;
                    continue;
                }
            }

            if (reussi[0]) { // sort de la boucle si on ne veut plus prendre de pion ou si on voulait juste
                             // se déplacer
                break;
            }
        }
    }

    public static boolean changement(Plateau p, int x, int y) {
        boolean etat = false;
        if ((!(p.getGrille()[x][y].isDame()))
                && ((p.getGrille()[x][y].isEquipe() && x == 9) || (!(p.getGrille()[x][y].isEquipe()) && x == 0))) {
            p.getGrille()[x][y].setDame(true);
            etat = true;
        }
        return (etat);
    }

}
