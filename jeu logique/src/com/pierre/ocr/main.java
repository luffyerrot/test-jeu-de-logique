package com.pierre.ocr;

import com.pierre.ocr.JeuDeux.Gestion.Menu2;
import com.pierre.ocr.JeuUn.Gestion.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    static String sautLigne = "\n";
    static Boolean adminVersion = false;
    static String indAdminVersion;
    static int tailleCode = 4;

    public static void main(String[] args) {
        jeuMenu();
    }

    public static void jeuMenu() {

        indAdminVersion = "";
        if (adminVersion){
            indAdminVersion = "activé";
        }else{
            indAdminVersion = "désactivé";
        }
        System.out.println("Jeux : " + sautLigne + sautLigne + "1 - Jeu de logique" + sautLigne +
                "2 - Mastermind" + sautLigne + "3 - fermer l'application" + sautLigne + sautLigne + "4 - Version Admin (" + indAdminVersion + ")" + sautLigne +
                "5 - Taille du code (" + tailleCode + ")" + sautLigne);
        jeuMenuChoix();
    }

    public static void jeuMenuChoix(){
        Scanner sc = new Scanner(System.in);
        int choix;
        try {
            do {
                choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        Menu menu = new Menu();
                        menu.menu();
                        break;
                    case 2:
                        Menu2 menu2 = new Menu2();
                        menu2.menu();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    case 4:
                        if (adminVersion == false) {
                            adminVersion = true;
                        } else if (adminVersion == true) {
                            adminVersion = false;
                        }
                        jeuMenu();
                        break;
                    case 5:
                        System.out.println("Changer la taille du code (min = 1) (max = 50) :");
                        try {
                            do {
                                tailleCode = sc.nextInt();
                            }while (tailleCode < 1 || tailleCode > 50);
                        }catch (InputMismatchException e){
                            System.out.println("ERREUR, entrer un chiffre entre 1 et 50 pour séléctionner une taille !");
                        }
                        jeuMenu();
                        break;
                    default:
                        System.out.println("Entrer un chiffre entre 1 et 5 :");
                        break;
                }
            }while (choix < 1 || choix > 5);
        }catch (InputMismatchException e){
            System.out.println("ERREUR, entrer un chiffre entre 1 et 5 pour séléctionner un jeu ou quitter !");
            jeuMenuChoix();
        }
    }

    public static Boolean admin(){
        return adminVersion;
    }

    public static int tailleCode(){
        return tailleCode;
    }
}
