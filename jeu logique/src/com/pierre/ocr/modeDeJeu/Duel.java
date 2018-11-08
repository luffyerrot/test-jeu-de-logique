package com.pierre.ocr.modeDeJeu;

import com.pierre.ocr.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Duel {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = System.getProperty("line.separator");
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
        System.out.println("Ecrire votre code secret à 4 chiffre pour l'ordinateur");
        codePourOrdi = sc.next();
        for (int i = 0; i < 4; i++){
            if (codePourOrdi.intern() == "stop"){
                return;
            }else if ((int)codePourOrdi.charAt(i) < 48 || (int)codePourOrdi.charAt(i) > 57){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 9999" + sautLigne);
                saisi();
            }else {
                randomPourCommencer();
            }
        }
    }

    public static void randomPourCommencer(){
        int rand = (int) ((Math.random()) * 2);
        switch (rand){
            case 0:
                System.out.println("Vous commencer :");
                choixJoueur();
                break;
            case 1:
                testOrdi();
                break;
            default :
                randomPourCommencer();
                break;
        }
    }
    public static void choixJoueur() {
        System.out.println("Ecrire un code à 4 chiffres : ");
        totalNum = sc.next();
        for (int i = 0; i < 4; i++){
            if (totalNum.intern() == "stop"){
                return;
            }else if ((int)totalNum.charAt(i) < 48 || (int)totalNum.charAt(i) > 57){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 9999" + sautLigne);
                choixJoueur();
            }else {
                testJoueur();
            }
        }
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
        testOrdi();
    }

    public static void testOrdi(){
        System.out.println("Votre adversaire propose : " + nbOrdi + sautLigne +
                "écrire un code a 4 chiffre pour aider l'ordinateur : " + sautLigne + "0 - Mauvais" + sautLigne +"1 - Bon");
        verif = sc.next();
        for (int i = 0; i < 4; i++){
            if (verif.intern() == "stop"){
                return;
            }else if ((int)verif.charAt(i) < 48 || (int)verif.charAt(i) > 49){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 1111" + sautLigne);
                testOrdi();
            }
        }
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
        System.out.println("Bravo," + sautLigne + "Vous avez trouvé le code secret de l'ordinateur : " + nbATrouver);
        finChoix();
    }
    public static void finChoix(){
        System.out.println("1 - Recommencer" + sautLigne + "2 - Retour au menu" + sautLigne + "3 - Fermer le jeu");

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