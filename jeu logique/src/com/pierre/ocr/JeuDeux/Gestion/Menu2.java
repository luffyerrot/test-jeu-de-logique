package com.pierre.ocr.JeuDeux.Gestion;

import com.pierre.ocr.JeuDeux.modeDeJeu.challenger;
import com.pierre.ocr.JeuDeux.modeDeJeu.duel;
import com.pierre.ocr.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu2 {

    public static void menu() {
        String sautLigne = "\n";
        System.out.println("Mastermind : " + sautLigne + sautLigne + "1 - Challenger" + sautLigne +
                "2 - Duel" + sautLigne + sautLigne + "3 - Revenir au menu du jeu" + sautLigne +
                "4 - fermer l'application" + sautLigne);
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
                        duel.generation();
                        break;
                    case 3:
                        main.jeuMenu();
                        break;
                    case 4 :
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
