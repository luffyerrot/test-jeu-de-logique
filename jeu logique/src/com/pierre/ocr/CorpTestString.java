package com.pierre.ocr;

import java.util.Scanner;

public class CorpTestString {

    static String combATrouver = "ABCD";

    public static void jeu(){
        System.out.println("Ecrire votre code a 4 lettres : ");
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();

        if (code.charAt(0) == combATrouver.charAt(0)){
            System.out.println("C'est la bonne Lettre");
            System.out.println(combATrouver.charAt(0) + 2);
        }else{
            System.out.println("Ce n'est pas la bonne lettre");
        }
        if (code.charAt(1) == combATrouver.charAt(1)){
            System.out.println("C'est la bonne Lettre");
        }else{
            System.out.println("Ce n'est pas la bonne lettre");
        }
        if (code.charAt(2) == combATrouver.charAt(2)){
            System.out.println("C'est la bonne Lettre");
        }else{
            System.out.println("Ce n'est pas la bonne lettre");
        }
        if (code.charAt(3) == combATrouver.charAt(3)){
            System.out.println("C'est la bonne Lettre");
        }else{
            System.out.println("Ce n'est pas la bonne lettre");
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (code.charAt(i) == combATrouver.charAt(i)) {
                count += 1;
            }else{
                jeu();
                return;
            }

            if (count == 4){
                System.out.println("Vous avez gagné, le code secret est : " + combATrouver);
            }
        }
    }
}
