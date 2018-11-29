package com.pierre.ocr.JeuDeux.modeDeJeu;

import com.pierre.ocr.JeuDeux.Gestion.Menu2;
import com.pierre.ocr.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class challenger {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = "\n";
    static String nbOrdi;
    static String nbJoueur = "";
    static int nbConclusionCorrect;
    static int nbConclusion;
    static int tailleCode = main.tailleCode();
    static int coupsMax = main.coupsMax();

    public static void generationRandom(){
        nbOrdi = "";
        for (int i = 0; i < tailleCode; i++){
            nbOrdi += Integer.toString((int) (Math.random() * 9));
        }
        if (main.admin()){
            System.out.println(nbOrdi);
        }
        saisi();
    }

    public static void saisi(){
        if (coupsMax == 0){
            finPerdu();
        }else{
            System.out.println("Il vous reste " + coupsMax + " coups");
        }
        System.out.println("Ecrire le code à " + tailleCode + " Chiffre(s) : ");
        try {
            nbJoueur = sc.next();
            if (nbJoueur.intern() == "stop"){
                main.jeuMenu();
            }
            for (int i = 0; i < tailleCode; i++){
                if (nbJoueur.charAt(i) < '0' || nbJoueur.charAt(i) > '9'){
                    String memoire1 = "";
                    String memoire2 = "";
                    for (int j = 0; j < tailleCode; j++){
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
        testJoueur();
    }

    public static void testJoueur(){
        nbConclusionCorrect = 0;
        nbConclusion = 0;
        if (nbJoueur.intern() == nbOrdi.intern()){
            System.out.println("Bravo, tu a gagné :" + sautLigne);
            fin();
        }else{
            for (int i = 0; i < tailleCode; i++){
                if (nbJoueur.charAt(i) == nbOrdi.charAt(i)){
                    nbConclusionCorrect += 1;
                }else if (nbOrdi.contains(Character.toString(nbJoueur.charAt(i)))){
                    nbConclusion += 1;
                }
            }
            System.out.println(nbConclusionCorrect + " Chiffre(s) bien Placé, " + nbConclusion +
                    " Chiffre(s) mal Placé");
            coupsMax -= 1;
            saisi();
        }
    }

    public static void finPerdu(){
        System.out.println("Vous avez perdu vous n'avez plus de coups, le code était : " + nbOrdi + sautLigne);
        fin();
    }

    public static void fin () {
        System.out.println("1 - Recommencer" + sautLigne + "2 - Revenir à la séléction du mode de jeu" + sautLigne +
                "3 - Revenir à la séléction du jeu" + sautLigne + "4 - fermer l'application" + sautLigne);
        finChoix();
    }

    public static void finChoix () {
        int finChoix;
        try {
            do {
                finChoix = sc.nextInt();
                switch (finChoix) {
                    case 1:
                        generationRandom();
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
            } while (finChoix < 1 || finChoix > 4);
        } catch (InputMismatchException e) {
            System.out.println("ERREUR, entrer un chiffre entre 1 et 4 pour séléctionner une option !");
            finChoix();
        }
    }
}