package com.pierre.ocr.JeuUn.Gestion;

import com.pierre.ocr.JeuUn.modeDeJeu.duel;
import com.pierre.ocr.JeuUn.modeDeJeu.defender;
import com.pierre.ocr.JeuUn.modeDeJeu.challenger;
import com.pierre.ocr.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        String sautLigne = "\n";
        System.out.println("Jeu de logique : " + sautLigne + sautLigne + "1 - Challenger" + sautLigne +
                "2 - Duel" + sautLigne + "3 - Defender" + sautLigne + sautLigne +
                "4 - Revenir au menu du jeu" + sautLigne + "5 - fermer l'application" + sautLigne);
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
                        defender.generation();
                        break;
                    case 4:
                        main.jeuMenu();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Entrer un chiffre entre 1 et 5 :");
                        break;
                }
            }while (choix < 1 || choix > 5);
        }catch (InputMismatchException e){
            System.out.println("ERREUR, entrer un chiffre entre 1 et 5 pour séléctionner un jeu ou quitter !");
            menuChoix();
        }
    }
}

