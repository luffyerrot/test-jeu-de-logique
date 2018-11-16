package com.pierre.ocr.modeDeJeu;

import com.pierre.ocr.Gestion.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.pierre.ocr.Gestion.Utils.Correct;
import static com.pierre.ocr.Gestion.Utils.plusGrand;
import static com.pierre.ocr.Gestion.Utils.plusPetit;

public class TrouverLeCode {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = "\n";
    static String combATrouver = "";
    static String totalNum = "";

    /**
     * Génère un code à 4 chiffres aléatoire
     **/
    public static void generationRandom(){
        for (int i = 0; i < 4; i++) {
            combATrouver += (int) ((Math.random()) * 9);
        }
        jeu();
    }

    /**
     * Demande au joueur un code pour trouver celui de l'ordinateur
     **/
    public static void jeu() {
        System.out.println("Ecrire votre code à 4 chiffres : ");
        totalNum = sc.next();
        for (int i = 0; i < 4; i++){
            if (sortie(i, totalNum)) return;
        }
    }

    public static boolean sortie(int i, String totalNum) {
        if (totalNum.intern() == "stop"){
            Menu.menu();
            return true;
        }else if ((int)totalNum.charAt(i) < 48 || (int)totalNum.charAt(i) > 57){ //48 et 57 corresponds à 0 et 9 dans le tableau ASCII.
            System.out.println("Selectioner une combinaison comprise entre 0000 et 9999" + sautLigne);
            jeu();
        }else {
            testCombinaison();
        }
        return false;
    }

    /**
     * Renvoi à Utils pour indiquer l'état des chiffres du code
     **/
    public static void testCombinaison() {
        String conclusion = "";
        if (totalNum.intern() == combATrouver.intern()){
            System.out.println("Bravo, " + sautLigne + "Vous avez gagné, le code secret est : " + combATrouver);
            fin();
        }else for (int i = 0; i < 4; i++){
            if (totalNum.charAt(i) > combATrouver.charAt(i)){
                conclusion = plusPetit(conclusion, i);
            } else if (totalNum.charAt(i) < combATrouver.charAt(i)){
                conclusion = plusGrand(conclusion, i);
            }else if (totalNum.charAt(i) == combATrouver.charAt(i)){
                conclusion = Correct(conclusion, i);
            }
        }
        System.out.println(conclusion);
        jeu();
    }

    public static void fin(){
        System.out.println("1 - Recommencer" + sautLigne + "2 - Retour au menu" + sautLigne + "3 - Fermer le jeu");
        finChoix();
    }

    public static void finChoix(){
        try {
            int finChoix = sc.nextInt();
            switch (finChoix){
                case 1:
                    generationRandom();
                    break;
                case 2:
                    Menu.menu();
                    break;
                case 3:
                    return;
            }
        }catch(InputMismatchException e){
            System.out.println("ERREUR, entrer un chiffre entre 1 et 3 pour séléctionner une option !");
            finChoix();
        }
    }
}
