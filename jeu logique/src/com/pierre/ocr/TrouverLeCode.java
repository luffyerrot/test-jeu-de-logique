package com.pierre.ocr;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrouverLeCode {

    static Scanner sc = new Scanner(System.in);
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
    try {
        totalNum = sc.next();
    }catch(InputMismatchException e){
        System.out.println("ERREUR, entrer un code à 4 chiffres !");
        jeu();
    }
        testCombinaison();
    }

    public static void testCombinaison() {

        String conclusion = "";
        if (totalNum.intern() == combATrouver.intern()){
            System.out.println("Bravo, ");
            System.out.println("Vous avez gagné, le code secret est : " + combATrouver);
            fin();
        }else for (int i = 0; i < 4; i++){
            if (totalNum.charAt(i) > combATrouver.charAt(i)){
                switch (i){
                    case 0 :
                        conclusion += "Le premier chiffre est plus petit, ";
                        break;
                    case 1 :
                        conclusion += "le deuxieme chiffre est plus petit, ";
                        break;
                    case 2 :
                        conclusion += "le troisieme chiffre est plus petit, ";
                        break;
                    case 3 :
                        conclusion += "le quatrieme chiffre est plus petit.";
                        break;
                }
            } else if (totalNum.charAt(i) < combATrouver.charAt(i)){
                switch (i){
                    case 0 :
                        conclusion += "Le premier chiffre est plus grand, ";
                        break;
                    case 1 :
                        conclusion += "le deuxieme chiffre est plus grand, ";
                        break;
                    case 2 :
                        conclusion += "le troisieme chiffre est plus grand, ";
                        break;
                    case 3 :
                        conclusion += "le quatrieme chiffre est plus grand.";
                        break;
                }
            }else if (totalNum.charAt(i) == combATrouver.charAt(i)){
                switch (i){
                    case 0 :
                        conclusion += "Le premier chiffre est correct, ";
                        break;
                    case 1 :
                        conclusion += "le deuxieme chiffre est correct, ";
                        break;
                    case 2 :
                        conclusion += "le troisieme chiffre est correct, ";
                        break;
                    case 3 :
                        conclusion += "le quatrieme chiffre est correct.";
                        break;
                }
            }
        }
        System.out.println(conclusion);
        jeu();
    }

    public static void fin(){
        System.out.println("1 - Recommencer");
        System.out.println("2 - Retour au menu");
        System.out.println("3 - Fermer le jeu");
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
