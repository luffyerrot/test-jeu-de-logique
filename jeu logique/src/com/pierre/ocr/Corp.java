package com.pierre.ocr;

import java.util.Scanner;

public class Corp {

    static String combATrouver = "";
   String totalNum = "";
   int nbChiffreCode = 4;

    public void combinaison() {
        for (int i = 0; i < nbChiffreCode; i++) {
            combATrouver += (int) ((Math.random()) * 9);
        }
        System.out.println(combATrouver);
        this.jeu();
    }

    public void jeu() {
        System.out.println("Ecrire votre code à " + nbChiffreCode + " chiffres : ");
        Scanner sc = new Scanner(System.in);
        totalNum = sc.next();
        testCombinaison();
    }

    public void testCombinaison() {

        String conclusion = "";
        if (totalNum.intern() == combATrouver.intern()){
            System.out.println("Bravo, ");
            System.out.println("Vous avez gagné, le code secret est : " + combATrouver);
            return;
        }else for (int i = 0; i < nbChiffreCode; i++){
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
}


