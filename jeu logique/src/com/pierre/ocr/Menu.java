package com.pierre.ocr;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        System.out.println("1 - Trouver le code de l'ordinateur");
        System.out.println("2 - Jouer en duel contre l'ordinateur");
        System.out.println("3 - L'ordinateur cherche votre code secret");
        System.out.println("Choisir votre mode de jeu :");
        menuChoix();

    }
    public static void menuChoix(){
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        try {
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
            }
        }catch (InputMismatchException e){
            System.out.println("ERREUR, entrer un chiffre entre 1 et 3 pour séléctionner un jeu !");
            menuChoix();
        }
    }
}
