package com.pierre.ocr.JeuDeux.Gestion;

import com.pierre.ocr.JeuDeux.modeDeJeu.challenger;
import com.pierre.ocr.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu2 {

    public static void menu() {
        String sautLigne = "\n";
        System.out.println("Mastermind : " + sautLigne + sautLigne + "1 - Challenger" + sautLigne +
                "2 - " + sautLigne + "3 - " + sautLigne + sautLigne + "4 - Revenir au menu du jeu" + sautLigne + "5 - fermer l'application" + sautLigne);
        menuChoix();

    }
    public static void menuChoix(){
        Scanner sc = new Scanner(System.in);
        int choix;
        try {
            do {
                choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        challenger.generationRandom();
                        break;
                    case 2:
                        System.out.println(2);
                        break;
                    case 3:
                        System.out.println(3);
                        break;
                    case 4:
                        main.jeuMenu();
                        break;
                    case 5 :
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Entrer un chiffre entre 1 et 4 :");
                        break;
                }
            }while (choix < 1 || choix > 4);
        }catch (InputMismatchException e){
            System.out.println("ERREUR, entrer un chiffre entre 1 et 4 pour séléctionner un jeu ou quitter !");
            menuChoix();
        }
    }
}
