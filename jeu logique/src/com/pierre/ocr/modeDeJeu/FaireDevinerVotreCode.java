package com.pierre.ocr.modeDeJeu;

import com.pierre.ocr.Gestion.Menu;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FaireDevinerVotreCode {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = "\n";
    static String nbOrdi = "";
    static String verif = "";
    static String codePourOrdi = "";
    static int count = 0;
    static Map<Integer,String> map = new HashMap<>();

    /**
     * Saisi du code que l'ordinateur doit trouver
     **/
    public static void saisi(){
        for (int i = 0; i < 4; i++) {
            nbOrdi += Integer.toString((int)(Math.random() * 9));
            map.put(i, Character.toString(nbOrdi.charAt(i)));
        }
        System.out.println("Ecrire votre code secret à 4 chiffre pour l'ordinateur");
        codePourOrdi = sc.next();
        if (codePourOrdi.intern() == "stop"){
            Menu.menu();
        }
            for (int i = 0; i < 4; i++){
            if ((int)codePourOrdi.charAt(i) < 48 || (int)codePourOrdi.charAt(i) > 57){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 9999" + sautLigne);
                saisi();
            }
        }
        testOrdi();
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
                "écrire un code a 4 chiffre pour aider l'ordinateur : " + sautLigne + "0 - Mauvais" + sautLigne + "1 - Bon");
        verif = sc.next();
        if (verif.intern() == "stop"){
            Menu.menu();
        }
        for (int i = 0; i < 4; i++){
            if (verif.charAt(i) < '0' || verif.charAt(i) > '1'){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 1111" + sautLigne);
                testOrdi();
            }
        }

        for (int i = 0; i < 4; i++){
            if ((int)verif.charAt(i) == 48){
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

        testOrdi();
    }

    public static void fin(){
        System.out.println("L'ordinateur a trouvé votre code secret en : " + count + " coups." + nbOrdi);
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

