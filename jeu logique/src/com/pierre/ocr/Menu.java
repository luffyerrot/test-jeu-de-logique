package com.pierre.ocr;

import com.pierre.ocr.modeDeJeu.Duel;
import com.pierre.ocr.modeDeJeu.FaireDevinerVotreCode;
import com.pierre.ocr.modeDeJeu.TrouverLeCode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        String sautLigne = System.getProperty("line.separator");
        System.out.println("Jeu de logique : " + sautLigne + sautLigne + "1 - Trouver le code de l'ordinateur" + sautLigne +
                "2 - Jouer en duel contre l'ordinateur" + sautLigne + "3 - L'ordinateur cherche votre code secret" + sautLigne + "4 - Fermer le jeu");
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
                        TrouverLeCode.generationRandom();
                        break;
                    case 2:
                        Duel.saisi();
                        break;
                    case 3:
                        FaireDevinerVotreCode.saisi();
                        break;
                    case 4:
                        return;
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

