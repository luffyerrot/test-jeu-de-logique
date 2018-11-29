package com.pierre.ocr.JeuDeux.modeDeJeu;

import com.pierre.ocr.JeuDeux.Gestion.Menu2;
import com.pierre.ocr.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class duel {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = "\n";
    static String nbATrouver = "";
    static String totalNum = "";
    static String nbOrdi = "";
    static String verif = "";
    static String codePourOrdi ="";
    static String stocageNbOrdi;
    static int tailleCode = main.tailleCode();


    public static void generation(){
        stocageNbOrdi = "";
        for (int i = 0; i < tailleCode; i++) {
            nbATrouver += (int) ((Math.random()) * 9);
            stocageNbOrdi += nbATrouver.charAt(i);
        }

        if (main.admin() == true){
            System.out.println(nbATrouver);
        }
        for (int i = 0; i < tailleCode; i++) {
            nbOrdi += (int) ((Math.random()) * 9);
        }
        saisi();
    }
    /**
     * Saisi du code que l'ordinateur doit trouver
     **/
    public static void saisi(){
        System.out.println("Ecrire votre code secret à " + tailleCode + " chiffre pour l'ordinateur");
        try {
            codePourOrdi = sc.next();
            if (codePourOrdi.intern() == "stop"){
                main.jeuMenu();
            }
            for (int i = 0; i < tailleCode; i++){
                if (codePourOrdi.charAt(i) < '0' || codePourOrdi.charAt(i) > '9'){
                    String memoire1 = "";
                    String memoire2 = "";
                    for (int j = 0; j < tailleCode; j++) {
                        memoire1 += 0;
                        memoire2 += 9;
                    }
                    System.out.println("Selectioner une combinaison comprise entre " + memoire1 +
                            " et " + memoire2 + sautLigne);
                    saisi();
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Attention, entrer un code à " + tailleCode + " chiffre(s)");
            saisi();
        }
        randomPourCommencer();
    }

    /**
     * Détermine aléatoirement qui commence entre l'ordinateur et le joueur
     **/
    public static void randomPourCommencer(){
        int rand = (int) ((Math.random()) * 2);
        switch (rand){
            case 0:
                System.out.println("Vous commencer :");
                choixJoueur();
                break;
            case 1:
                System.out.println("Votre adversaire commence :");
                testOrdi();
                break;
            default :
                randomPourCommencer();
                break;
        }
    }

    /**
     * Demande un code au joueur pour deviner celui de l'ordinateur
     **/
    public static void choixJoueur() {
        System.out.println("Ecrire un code à " + tailleCode + " chiffres : ");
        try {
            totalNum = sc.next();
            if (totalNum.intern() == "stop"){
                main.jeuMenu();
            }
            for (int i = 0; i < tailleCode; i++){
                if (totalNum.charAt(i) < '0' || totalNum.charAt(i) > '9'){
                    String memoire1 = "";
                    String memoire2 = "";
                    for (int j = 0; j < tailleCode; j++){
                        memoire1 += 0;
                        memoire2 += 9;
                    }
                    System.out.println("Selectioner une combinaison comprise entre " + memoire1 +
                            " et " + memoire2 + sautLigne);
                    choixJoueur();
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Attention, entrer un code à " + tailleCode);
            choixJoueur();
        }
        testJoueur();
    }

    /**
     * Renvoi à Utils pour indiquer l'état des chiffres du code
     **/
    public static void testJoueur(){
        int nbConclusionCorrect = 0;
        int nbConclusion = 0;
        if (totalNum.intern() == nbATrouver.intern()){
            System.out.println("Bravo, tu a gagné :" + sautLigne);
            fin();
        }else {
            for (int i = 0; i < tailleCode; i++) {
                if (totalNum.charAt(i) == nbATrouver.charAt(i)) {
                    nbConclusionCorrect += 1;
                } else if (nbATrouver.contains(Character.toString(totalNum.charAt(i)))) {
                    nbConclusion += 1;
                }
            }
            System.out.println(nbConclusionCorrect + " Chiffre(s) bien Placé, " + nbConclusion +
                    " Chiffre(s) mal Placé");
            testOrdi();
        }

    }

    /**
     * Demande au joueur d'aider l'ordinateur pour trouver son code
     * Modifie le(s) chiffre(s) du code qui ne sont pas correct
     **/
    public static void testOrdi(){
        System.out.println("Votre adversaire propose : " + nbOrdi + sautLigne +
                "écrire un code à " + tailleCode + " chiffre(s) pour aider l'ordinateur : " + sautLigne +
                "0 - Mauvais" + sautLigne +"1 - Bon");
        try {
            verif = sc.next();
            if (verif.intern() == "stop"){
                main.jeuMenu();
            }
            for (int i = 0; i < tailleCode; i++){
                if (verif.charAt(i) < '0' || verif.charAt(i) > '1'){
                    String memoire1 = "";
                    String memoire2 = "";
                    for (int j = 0; j < tailleCode; j++){
                        memoire1 += 0;
                        memoire2 += 1;
                    }
                    System.out.println("Selectioner une combinaison comprise entre " + memoire1 +
                            " et " + memoire2 + sautLigne);
                    testOrdi();
                }
            }
            stocageNbOrdi = "";
            for (int i = 0; i < tailleCode; i++){
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
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Attention, entrer un code à " + tailleCode + " chiffre(s)");
            testOrdi();
        }
    }

    /**
     * Fin alternative de l'ordinateur
     **/
    public static void finOrdi(){
        System.out.println("Vous avez perdu, l'ordinateur a trouvé votre code secret : " + codePourOrdi + sautLigne);
        finChoix();
    }

    /**
     * Fin alternative du joueur
     **/
    public static void fin(){
        System.out.println("Bravo," + sautLigne + "Vous avez trouvé le code secret de l'ordinateur : " +
                nbATrouver + sautLigne);
        finChoix();
    }

    public static void finChoix(){
        System.out.println("1 - Recommencer" + sautLigne + "2 - Revenir à la séléction du mode de jeu" + sautLigne +
                "3 - Revenir à la séléction du jeu" + sautLigne + "4 - fermer l'application" + sautLigne);
        int finChoix;
        try {
            do {
                finChoix = sc.nextInt();
                switch (finChoix) {
                    case 1:
                        generation();
                        break;
                    case 2:
                        Menu2.menu();
                        break;
                    case 3:
                        main.jeuMenu();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
            }while (finChoix < 1 || finChoix > 4);
        }catch(InputMismatchException e){
            System.out.println("ERREUR, entrer un chiffre entre 1 et 4 pour séléctionner une option !");
            finChoix();
        }
    }
}
