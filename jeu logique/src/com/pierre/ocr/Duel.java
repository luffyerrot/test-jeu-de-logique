package com.pierre.ocr;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Duel {

    static Scanner sc = new Scanner(System.in);
    static String nbATrouver = "";
    static String totalNum = "";
    static String nbOrdi = "";
    static String verif = "";
    static String codePourOrdi ="";
    static String stocageNbOrdi = "";

    public static void saisi(){

        for (int i = 0; i < 4; i++) {
            nbATrouver += (int) ((Math.random()) * 9);
            stocageNbOrdi += nbATrouver.charAt(i);
        }

        for (int i = 0; i < 4; i++) {
            nbOrdi += (int) ((Math.random()) * 9);
        }
        try {
            System.out.println("Ecrire votre code secret à 4 chiffre pour l'ordinateur");
            codePourOrdi = sc.next();
        }catch(InputMismatchException e){
            System.out.println("ERREUR, entrer votre code à 4 chiffres");
            saisi();
        }
        randomPourCommencer();
    }

    public static void randomPourCommencer(){
        int rand = (int) ((Math.random()) * 2);
        switch (rand){
            case 0:
                System.out.println("Vous commencer :");
                System.out.println();
                choixJoueur();
                break;
            case 1:
                System.out.println("L'ordinateur commence");
                System.out.println();
                System.out.println("Votre adversaire propose : " + nbOrdi);
                System.out.println("Ecrire un code a 4 chiffre pour aider l'ordinateur");
                System.out.println("0 - Mauvais");
                System.out.println("1 - Bon");
                System.out.println("Attention ne tricher pas");
                verif = sc.next();
                testOrdi();
                break;
            default :
                randomPourCommencer();
                break;
        }
    }
    public static void choixJoueur() {
        System.out.println("Ecrire un code à 4 chiffres : ");
        try {
            totalNum = sc.next();
        }catch(InputMismatchException e){
            System.out.println("ERREUR, entrer un code à 4 chiffres !");
            choixJoueur();
        }
        testJoueur();
    }

    public static void testJoueur(){
        String conclusion = "";
        if (totalNum.intern() == nbATrouver.intern()){
            fin();
        }else for (int i = 0; i < 4; i++){
            if (totalNum.charAt(i) > nbATrouver.charAt(i)){
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
            } else if (totalNum.charAt(i) < nbATrouver.charAt(i)){
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
            }else if (totalNum.charAt(i) == nbATrouver.charAt(i)){
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
        System.out.println();
        System.out.println("Votre adversaire propose : " + nbOrdi);
        System.out.println("Ecrire un code a 4 chiffre pour aider l'ordinateur");
        System.out.println("0 - Mauvais");
        System.out.println("1 - Bon");
        System.out.println("Attention ne tricher pas");
        verif = sc.next();
        testOrdi();
    }

    public static void testOrdi(){
        stocageNbOrdi = "";
        for (int i = 0; i < 4; i++){
            switch (verif.charAt(i)){
                case 48:
                    stocageNbOrdi += (int)((Math.random()) * 9);
                    break;
                case 49:
                    stocageNbOrdi += nbOrdi.charAt(i);
                    break;
            }
        }
        nbOrdi = stocageNbOrdi;
        if(nbOrdi.intern() == codePourOrdi.intern()){
            finOrdi();
        }else{
            choixJoueur();
        }
    }
    public static void finOrdi(){
        System.out.println("Vous avez perdu l'ordinateur a trouvé votre code secret : " + codePourOrdi);
        finChoix();
    }

    public static void fin(){
        System.out.println("Bravo,");
        System.out.println("Vous avez trouvé le code secret de l'ordinateur : " + nbATrouver);
        finChoix();
    }
    public static void finChoix(){
        System.out.println("1 - Recommencer");
        System.out.println("2 - Retour au menu");
        System.out.println("3 - Fermer le jeu");

        try {
            int finChoix = sc.nextInt();
            switch (finChoix){
                case 1:
                    saisi();
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