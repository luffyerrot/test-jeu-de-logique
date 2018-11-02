package com.pierre.ocr;

import java.util.Scanner;

public class Corp {

    static int[] combATrouver = new int[4];
    int[] totalNum = new int[4];

    public void combinaison() {


        for (int i = 0; i < combATrouver.length; i++) {
            combATrouver[i] = (int) ((Math.random()) * 9);
        }
        this.jeu();
    }

    public void jeu() {
        System.out.println("Ecrire votre code un chiffre par un chiffre : ");
        Scanner sc = new Scanner(System.in);
        int num = 0;

        for (int i = 0; i < 4; i++) {
            num = sc.nextInt();
            totalNum[i] = num;
        }
        testCombinaison();
        testFin();
    }

    public void testCombinaison() {

        if (totalNum[0] == combATrouver[0]) {
            System.out.println("Le premier chiffre est Correct");
        } else if (totalNum[0] > combATrouver[0]) {
            System.out.println("Le premier chiffre est plus petit");
        } else if (totalNum[0] < combATrouver[0]) {
            System.out.println("Le premier chiffre est plus grand");
        }
        if (totalNum[1] == combATrouver[1]) {
            System.out.println("Le deuxieme chiffre est Correct");
        } else if (totalNum[1] > combATrouver[1]) {
            System.out.println("Le deuxieme chiffre est plus petit");
        } else if (totalNum[1] < combATrouver[1]) {
            System.out.println("Le deuxieme chiffre est plus grand");
        }
        if (totalNum[2] == combATrouver[2]) {
            System.out.println("Le troisieme chiffre est Correct");
        } else if (totalNum[2] > combATrouver[2]) {
            System.out.println("Le troisieme chiffre est plus petit");
        } else if (totalNum[2] < combATrouver[2]) {
            System.out.println("Le troisieme chiffre est plus grand");
        }
        if (totalNum[3] == combATrouver[3]) {
            System.out.println("Le quatrieme chiffre est Correct");
        } else if (totalNum[3] > combATrouver[3]) {
            System.out.println("Le quatrieme chiffre est plus petit");
        } else if (totalNum[3] < combATrouver[3]) {
            System.out.println("Le quatrieme chiffre est plus grand");
        }
    }

    public void testFin(){

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (totalNum[i] == combATrouver[i]) {
                count += 1;
            }else{
                this.jeu();
            }

            if (count == 4){
                System.out.println("Vous avez gagné, le code secret est : " + combATrouver[0] + combATrouver[1] + combATrouver[2] + combATrouver[3]);
            }
        }
    }
}


