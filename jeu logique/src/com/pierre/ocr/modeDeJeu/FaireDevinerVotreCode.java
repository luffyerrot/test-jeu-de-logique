package com.pierre.ocr.modeDeJeu;

import com.pierre.ocr.Gestion.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FaireDevinerVotreCode {

    static Scanner sc = new Scanner(System.in);
    static String sautLigne = "\n";
    static String nbOrdi = "";
    static String verif = "";
    static String codePourOrdi = "";
    static int count = 0;
    static String[] blacklist = {"","","",""};

    public static void saisi(){
        for (int i = 0; i < 4; i++) {
            nbOrdi += (int) ((Math.random()) * 9);
            blacklist[i] += (nbOrdi.charAt(i));
        }
        System.out.println("Ecrire votre code secret à 4 chiffre pour l'ordinateur");
        codePourOrdi = sc.next();
        for (int i = 0; i < 4; i++){
            if (codePourOrdi.intern() == "stop"){
                return;
            }else if ((int)codePourOrdi.charAt(i) < 48 || (int)codePourOrdi.charAt(i) > 57){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 9999" + sautLigne);
                saisi();
            }
        }
        testOrdi();
    }

    public static void testOrdi(){
        StringBuffer buffer = new StringBuffer(nbOrdi);
        if(nbOrdi.intern() == codePourOrdi.intern()){
            fin();
        }
        System.out.println("Votre adversaire propose : " + nbOrdi + sautLigne +
                "écrire un code a 4 chiffre pour aider l'ordinateur : " + sautLigne + "0 - Mauvais" + sautLigne + "1 - Bon");
        verif = sc.next();
        for (int i = 0; i < 4; i++){
            if (verif.intern() == "stop"){
                return;
            }else if ((int)verif.charAt(i) < 48 || (int)verif.charAt(i) > 49){
                System.out.println("Selectioner une combinaison comprise entre 0000 et 1111" + sautLigne);
                testOrdi();
            }
        }

        for (int i = 0; i < 4; i++){
            if (verif.charAt(i) == 48){
                if(blacklist[i].contains(Character.toString(nbOrdi.charAt(i)))){
                    buffer.setCharAt(i, ((char)((int)Math.random() * 9)));
                }
            }
        }

        testOrdi();
    }

    public static void fin(){
        System.out.println("L'ordinateur a trouvé votre code secret en : " + count + "coups." + nbOrdi);
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

