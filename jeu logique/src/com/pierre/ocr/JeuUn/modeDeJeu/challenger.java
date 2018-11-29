package com.pierre.ocr.JeuUn.modeDeJeu;

import com.pierre.ocr.JeuUn.Gestion.Menu;
import com.pierre.ocr.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.pierre.ocr.JeuUn.Gestion.Utils.Correct;
import static com.pierre.ocr.JeuUn.Gestion.Utils.plusGrand;
import static com.pierre.ocr.JeuUn.Gestion.Utils.plusPetit;

public class challenger {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = "\n";
    static String combATrouver;
    static String totalNum = "";
    static int tailleCode = main.tailleCode();
    static int coupsMax = main.coupsMax();

    /**
     * Génère un code à 4 chiffres aléatoire
     **/
    public static void generationRandom(){
        combATrouver = "";
        for (int i = 0; i < tailleCode; i++) {
            combATrouver += (int) ((Math.random()) * 9);
        }
        if (main.admin() == true){
            System.out.println(combATrouver);
        }
        jeu();
    }

    /**
     * Demande au joueur un code pour trouver celui de l'ordinateur
     **/
    public static void jeu() {
        if (coupsMax == 0){
            finPerdu();
        }else{
            System.out.println("Il vous reste " + coupsMax + " coups");
        }
        System.out.println("Ecrire votre code à " + tailleCode + " chiffre(s) : ");
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
                    jeu();
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Attention, entrer un code à " + tailleCode + " chiffre(s)");
            jeu();
        }
        testCombinaison();
    }

    /**
     * Renvoi à Utils pour indiquer l'état des chiffres du code
     **/
    public static void testCombinaison() {
        String conclusion = "";
        if (totalNum.intern() == combATrouver.intern()){
            System.out.println("Bravo," + sautLigne + "Vous avez gagné, le code secret est : " +
                    combATrouver + sautLigne);
            fin();
        }else for (int i = 0; i < tailleCode; i++){
            if (totalNum.charAt(i) > combATrouver.charAt(i)){
                conclusion = plusPetit(conclusion, i);
            } else if (totalNum.charAt(i) < combATrouver.charAt(i)){
                conclusion = plusGrand(conclusion, i);
            }else if (totalNum.charAt(i) == combATrouver.charAt(i)){
                conclusion = Correct(conclusion, i);
            }
        }
        System.out.println(conclusion);
        coupsMax -= 1;
        jeu();
    }

    public static void finPerdu(){
        System.out.println("Vous avez perdu vous n'avez plus de coups, le code était : " + combATrouver + sautLigne);
        fin();
    }

    public static void fin(){
        System.out.println("1 - Recommencer" + sautLigne + "2 - Revenir à la séléction du mode de jeu" + sautLigne +
                "3 - Revenir à la séléction du jeu" + sautLigne + "4 - fermer l'application" + sautLigne);
        finChoix();
    }

    public static void finChoix(){

        int finChoix;
            try {
                do {
                finChoix = sc.nextInt();
                switch (finChoix) {
                    case 1:
                        generationRandom();
                        break;
                    case 2:
                        Menu.menu();
                        break;
                    case 3:
                        main.jeuMenu();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        finChoix();
                        break;
                    }
                }while (finChoix < 1 || finChoix > 4);
            }catch(InputMismatchException e){
                System.out.println("ERREUR, entrer un chiffre entre 1 et 4 pour séléctionner une option !");
                finChoix();
            }
    }
}
