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
        this.grille = new Element[10][10];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < this.grille.length; i++) {
                if ((i + j) % 2 == 1) {
                    this.grille[i][j] = new Element(true, false); // équipe des noirs
                }
            }
        }
        for (int j = 6; j < 10; j++) {
            for (int i = 0; i < this.grille.length; i++) {
                if ((i + j) % 2 == 1) {
                    this.grille[i][j] = new Element(false, false);
                }
            }
        }
    }

    public void afficher() {
        System.out.println("Etat actuel  du plateau");
        String[][] grid = new String[grille.length + 2][grille[0].length + 2];
        grid[0][0] = "   ";
        grid[0][1] = " y ";
        grid[1][0] = " x ";
        grid[1][1] = "   ";

        for (int i = 2; i < grille.length + 2; i++) {
            grid[0][i] = " " + (i - 2) + " ";
            grid[1][i] = "   ";
            grid[i][0] = " " + (i - 2) + " ";
            grid[i][1] = "   ";
        }

        for (int i = 2; i < grille.length + 2; i++) {
            for (int j = 2; j < grille[0].length + 2; j++) {
                if (grille[i - 2][j - 2] != null && grille[i - 2][j - 2].isEquipe() && grille[i - 2][j - 2].isDame()) {
                    grid[i][j] = " N ";
                } else if (grille[i - 2][j - 2] != null && grille[i - 2][j - 2].isEquipe()
                        && !(grille[i - 2][j - 2].isDame())) {
                    grid[i][j] = " n ";
                } else if (grille[i - 2][j - 2] != null && !(grille[i - 2][j - 2].isEquipe())
                        && !(grille[i - 2][j - 2].isDame())) {
                    grid[i][j] = " b ";
                } else if (grille[i - 2][j - 2] != null && !(grille[i - 2][j - 2].isEquipe())
                        && (grille[i - 2][j - 2].isDame())) {
                    grid[i][j] = " B ";
                } else {
                    grid[i][j] = " - ";
                }

            }
        }
        for (String[] grid1 : grid) {
            for (String st : grid1) {
                System.out.print(st);
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

    /**
     *
     * @param x      x initial
     * @param y      y initial
     * @param x1     x destinataire
     * @param y1     y destinataire
     * @param joueur
     * @return
     */
    public boolean[] deplacer(int x, int y, int x1, int y1, boolean joueur) {
        boolean res = true;
        boolean pris = false;
        boolean isDame = grille[x][y].isDame();
        if (isDame) {
            // faire déplacer un DAME si possible
            if (verifierDeplacerDame(x, y, x1, y1, joueur)) {
                if ((Math.abs(x1 - x) == Math.abs(y1 - y)) && (casDeplaceDame(x, y, x1, y1, joueur) == 2)) {
                    // déplacement en prenant un pion
                    prendrePion(x, y, x1, y1);
                    pris = true;
                    System.out.println("un pion a été pris");
                }
                grille[x1][y1] = grille[x][y];
                grille[x][y] = null;
                System.out.println("Déplacement réussi.");

                res = true;
            } else {
                System.out.println("On ne peut pas déplacer vers cette cellule selon les règles. Ré-essayez svp.");
                res = false;
            }
            return new boolean[] { res, pris };
        } else {
            // faire déplacer un PION si possible
            if (verifierDeplacerPion(x, y, x1, y1, joueur)) {
                if ((Math.abs(x1 - x) == Math.abs(y1 - y) && Math.abs(x1 - x) == 2)
                        && (grille[(x1 + x) / 2][(y1 + y) / 2] != null)) {
                    if (grille[(x1 + x) / 2][(y1 + y) / 2].equipe != joueur) {
                        // déplacement en prenant un pion si le pion à prendre est d'une autre équipe
                        prendrePion(x, y, x1, y1);
                        pris = true;
                        System.out.println("un pion a été pris");
                    }
                }
                grille[x1][y1] = grille[x][y];
                grille[x][y] = null;
                System.out.println("Déplacement réussi.");
                res = true;
            } else if (!verifierDeplacerPion(x, y, x1, y1, joueur)) {
                System.out.println("On ne peut pas déplacer vers cette cellule selon les règles. Ré-essayez svp.");
                res = false;
            }
            return new boolean[] { res, pris };
        }
    }

    public boolean verifierDeplacerPion(int x, int y, int x1, int y1, boolean joueur) {
        boolean res;
        /**
         * x : x initial y : y initial x1 : x destinataire y1: y destinataire
         */

        // vérifier si un déplacement est possible
        if (x1 < 0 || x1 > 9 || y1 < 0 || y1 > 9) {
            System.out.println("Destination dehors du plateau. Ré-essayer svp.");
            res = false;
        } else if (Math.abs(x1 - x) != Math.abs(y1 - y)) {
            System.out.println("Destination n'est pas dans la même ligne. Ré-essayer svp.");
            res = false;
        } else if (joueur && (y1 <= y)) { // équipe des noirs
            System.out.println("Le déplacement doit se faire vers la droite.");
            res = false;
        } else if (!joueur && (y1 >= y)) {
            System.out.println("le déplacement doit se faire vers la gauche");
            res = false;
        } else if (Math.abs(x1 - x) == Math.abs(y1 - y) && Math.abs(x1 - x) == 1) {
            // déplacement sans prendre un pion
            res = true;
        } else if (Math.abs(x1 - x) == Math.abs(y1 - y) && Math.abs(x1 - x) == 2) {
            // déplacement en prenant un pion
            if (grille[(x1 + x) / 2][(y1 + y) / 2] != null) {
                res = grille[(x1 + x) / 2][(y1 + y) / 2].equipe != joueur; // il y a un pion de l'autre joueur au milieu
            } else {
                res = false;
            }
        } else {
            System.out.println("Destination non prise en compte. Ré-essayer svp.");
            res = false;
        }
        return res;
    }

    public boolean verifierDeplacerDame(int x, int y, int x1, int y1, boolean joueur) {
        boolean res;
        /**
         * x : x initial y : y initial x1 : x destinataire y1: y destinataire
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
            res = switch (casDeplaceDame(x, y, x1, y1, joueur)) {
                case 1 -> true; // déplacer sans prendre un pion
                case 2 -> true; // déplacer en prenant un pion
                default -> false;
            };
        } else {
            System.out.println("Destination non prise en compte. Ré-essayer svp.");
            res = false;
        }
        return res;
    }

    public int casDeplaceDame(int x, int y, int x1, int y1, boolean joueur) {
        int res;
        /**
         * x : x initial y : y initial x1 : x destinataire y1: y destinataire
         */

        // detecte le cas de déplacement d'un dame
        // si c'est un déplacement sans prendre un pion, return 1
        // si c'est un déplacement en prenant un pion, return 2
        int count = 0; // compteur de fois d'apparition
        for (int i = 1; i < (x1 - x - 1); i++) {
            if (grille[x + i][y + i] != null) {
                if (grille[x + i][y + i].isEquipe() != joueur) {
                    count += 1;
                }
                if (grille[x + i][y + i].isEquipe() == joueur) {
                    count += 2; // on ne peut pas passer par dessus un pion du même joueur
                }
            }
        }
        switch (count) {
            case 0 -> res = 1;
            case 1 -> res = 2;
            default -> {
                System.out.println("Cas de déplacement d'un dame inattendu.");
                res = 0;
            }
        }
        return res;
    }

    public void prendrePion(int x, int y, int x1, int y1) {
        /**
         * x : x initial y : y initial x1 : x destinataire y1: y destinataire
         */
        // quand on appelle cet méthode, il faut s'assurer que le déplacement soit légal
        // autrement dit, on assume dans cette méthode que il existe un et seulement un
        // pion entre (x,y) et (x1,y1)
        // pour assurer ça, il faut toujours appeler cette méthode dans deplacer()
        int dist = Math.abs(x1 - x);
        int xmulti = 1;
        int ymulti = 1;
        if (x > x1) {
            xmulti = -1; // on prévoit le fait de diminuer x ou y indépendament
        }
        if (y > y1) {
            ymulti = -1;
        }
        for (int i = 1; i < dist; i++) {
            if (grille[x + i * xmulti][y + i * ymulti] != null) {
                grille[x + i * xmulti][y + i * ymulti] = null;
            }
        }
    }
}
