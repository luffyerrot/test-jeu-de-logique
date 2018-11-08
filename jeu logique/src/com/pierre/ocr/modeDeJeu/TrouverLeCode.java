package com.pierre.ocr.modeDeJeu;

import com.pierre.ocr.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrouverLeCode {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = System.getProperty("line.separator");
    static String combATrouver = "";
    static String totalNum = "";
    public static void generationRandom(){

        for (int i = 0; i < 4; i++) {
            combATrouver += (int) ((Math.random()) * 9);
        }
        jeu();
    }

    public static void jeu() {
        System.out.println("Ecrire votre code à 4 chiffres : ");
        totalNum = sc.next();
        for (int i = 0; i < 4; i++){
            if (totalNum.intern() == "stop"){
                return;
            }else if ((int)totalNum.charAt(i) < 48 || (int)totalNum.charAt(i) > 57){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 9999" + sautLigne);
                jeu();
            }else {
                testCombinaison();
            }
        }
    }

    public static void testCombinaison() {

        String conclusion = "";
        if (totalNum.intern() == combATrouver.intern()){
            System.out.println("Bravo, " + sautLigne + "Vous avez gagné, le code secret est : " + combATrouver);
            fin();
        }else for (int i = 0; i < 4; i++){
            if (totalNum.charAt(i) > combATrouver.charAt(i)){
                switch (i){
                    case 0 :
                        conclusion += "Le premier chiffre est plus petit, ";
                        break;
                    case 1 :
                        conclusion += (sautLigne + "le deuxieme chiffre est plus petit, ");
                        break;
                    case 2 :
                        conclusion += (sautLigne + "le troisieme chiffre est plus petit, ");
                        break;
                    case 3 :
                        conclusion += (sautLigne + "le quatrieme chiffre est plus petit.");
                        break;
                }
            } else if (totalNum.charAt(i) < combATrouver.charAt(i)){
                switch (i){
                    case 0 :
                        conclusion += "Le premier chiffre est plus grand, ";
                        break;
                    case 1 :
                        conclusion += (sautLigne + "le deuxieme chiffre est plus grand, ");
                        break;
                    case 2 :
                        conclusion += (sautLigne + "le troisieme chiffre est plus grand, ");
                        break;
                    case 3 :
                        conclusion += (sautLigne + "le quatrieme chiffre est plus grand.");
                        break;
                }
            }else if (totalNum.charAt(i) == combATrouver.charAt(i)){
                switch (i){
                    case 0 :
                        conclusion += "Le premier chiffre est correct, ";
                        break;
                    case 1 :
                        conclusion += (sautLigne + "le deuxieme chiffre est correct, ");
                        break;
                    case 2 :
                        conclusion += (sautLigne + "le troisieme chiffre est correct, ");
                        break;
                    case 3 :
                        conclusion += (sautLigne + "le quatrieme chiffre est correct.");
                        break;
                }
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
