package com.pierre.ocr.JeuDeux.modeDeJeu;

import com.pierre.ocr.JeuDeux.Gestion.Menu2;
import com.pierre.ocr.main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class defender {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = "\n";
    static String nbOrdi;
    static String verif = "";
    static String codePourOrdi = "";
    static int count;
    static Map<Integer,String> map = new HashMap<>();
    static int tailleCode = main.tailleCode();

    public static void generation(){
        nbOrdi = "";
        map.clear();
        count = 0;
        for (int i = 0; i < tailleCode; i++) {
            nbOrdi += Integer.toString((int)(Math.random() * 9));
            map.put(i, Character.toString(nbOrdi.charAt(i)));
        }
        saisi();
    }
    /**
     * Saisi du code que l'ordinateur doit trouver
     **/
    public static void saisi(){
        System.out.println("Ecrire votre code secret à " + tailleCode + " chiffre(s) pour l'ordinateur");
        try {
            codePourOrdi = sc.next();
            if (codePourOrdi.intern() == "stop"){
                main.jeuMenu();
            }
            for (int i = 0; i < tailleCode; i++){
                if ((int)codePourOrdi.charAt(i) < '0' || (int)codePourOrdi.charAt(i) > '9'){
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
        if (main.admin()){
            testAdmin();
        }else {
            testOrdi();
        }
    }
    /**
     * Demande au joueur d'aider l'ordinateur pour trouver son code
     * Modifie le(s) chiffre(s) du code qui ne sont pas correct
     * Enregistrement des chiffres incorrect dans une BlackList
     **/
    public static void testOrdi(){
        if(nbOrdi.intern() == codePourOrdi.intern()){
            fin();
        }
        count += 1;
        System.out.println("Votre adversaire propose : " + nbOrdi + sautLigne +
                "écrire un code à " + tailleCode + " chiffre(s) pour aider l'ordinateur : " + sautLigne +
                "0 - Mauvais" + sautLigne + "1 - Bon");
        try {
            verif = sc.next();
            if (verif.intern() == "stop"){
                main.jeuMenu();
            }
            for (int i = 0; i < 4; i++){
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
            for (int i = 0; i < tailleCode; i++){
                if (verif.charAt(i) == '0'){
                    String blacklist = map.get(i);
                    if(blacklist.contains(Character.toString(nbOrdi.charAt(i)))){
                        int randomint = (int) (Math.random() * 9);
                        char test = Integer.toString(randomint).charAt(0) ;
                        StringBuilder builder = new StringBuilder(nbOrdi);
                        builder.setCharAt(i, test);
                        nbOrdi = builder.toString();
                    }
                }
                String value = Character.toString(nbOrdi.charAt(i));
                map.put(i, map.get(i).concat(value));
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Attention, entrer un code à " + tailleCode + " chiffre(s)");
            saisi();
        }
        testOrdi();
    }

    public static void testAdmin(){
        for (int i = 0; i < tailleCode; i++){
            if (nbOrdi.intern() == codePourOrdi.intern()){
                fin();
            }else if (nbOrdi.charAt(i) != codePourOrdi.charAt(i)){
                String blacklist = map.get(i);
                do {
                    int randomint = (int) (Math.random() * 9);
                    char test = Integer.toString(randomint).charAt(0) ;
                    StringBuilder builder = new StringBuilder(nbOrdi);
                    builder.setCharAt(i, test);
                    nbOrdi = builder.toString();
                }while(blacklist.contains(Character.toString(nbOrdi.charAt(i))));
            }
            String value = Character.toString(nbOrdi.charAt(i));
            map.put(i, map.get(i).concat(value));
        }
        System.out.println(nbOrdi);
        count += 1;
        testAdmin();
    }

    public static void fin(){
        System.out.println("L'ordinateur a trouvé votre code secret en : " + count + " coups." + sautLigne);
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

