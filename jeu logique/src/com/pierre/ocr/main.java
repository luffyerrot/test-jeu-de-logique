package com.pierre.ocr;

import com.pierre.ocr.JeuDeux.Gestion.Menu2;
import com.pierre.ocr.JeuUn.Gestion.Menu;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class main {

    static String sautLigne = "\n";
    static Boolean adminVersion;
    static String indAdminVersion;
    static int tailleCode;
    static int coupsMax;
    static InputStream input;
    protected static Properties prop = new Properties();

    public static void main(String[] args) {
        jeuMenu();
    }

    public static void jeuMenu(){

        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            tailleCode = Integer.valueOf(prop.getProperty("tailleDuCode"));
            adminVersion = Boolean.valueOf(prop.getProperty("admin"));
            coupsMax = Integer.valueOf(prop.getProperty("nombreDeCoupsMax"));
        }catch (Exception e){
        }
        indAdminVersion = "";
        if (adminVersion){
            indAdminVersion = "activé";
        }else{
            indAdminVersion = "désactivé";
        }
        System.out.println("Jeux : " + sautLigne + sautLigne + "1 - Jeu de logique" + sautLigne +
                "2 - Mastermind" + sautLigne + "3 - fermer l'application" + sautLigne + sautLigne +
                "Version Admin (" + indAdminVersion + ")" + sautLigne + "Taille du code : " + tailleCode + sautLigne);
        jeuMenuChoix();
    }

    public static void jeuMenuChoix(){
        Scanner sc = new Scanner(System.in);
        int choix;
        try {
            do {
                choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        Menu menu = new Menu();
                        menu.menu();
                        break;
                    case 2:
                        Menu2 menu2 = new Menu2();
                        menu2.menu();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Entrer un chiffre entre 1 et 3 :");
                        break;
                }
            }while (choix < 1 || choix > 4);
        }catch (InputMismatchException e){
            System.out.println("ERREUR, entrer un chiffre entre 1 et 3 pour séléctionner un jeu ou quitter !");
            jeuMenuChoix();
        }
    }

    public static Boolean admin(){
        return adminVersion;
    }

    public static int tailleCode(){
        return tailleCode;
    }

    public static int coupsMax(){ return coupsMax; }
}
