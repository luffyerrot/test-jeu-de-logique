package com.pierre.ocr.JeuUn.Gestion;

import com.pierre.ocr.main;

public class Utils {

    static String sautLigne = "\n";
    static int tailleCode = main.tailleCode();
    static String ponctuation;
    static String debut;

    /**
     * Regarde si le chiffre en position i est plus petit que celui à trouver.
     **/
    public static String plusPetit(String conclusion, int i) {
       if (i == (tailleCode - 1)){
           ponctuation = ".";
       }else{
           ponctuation = ",";
       }
       if (i == 0){
           debut = "Le";
       }else{
           debut = "le";
       }
       conclusion += (debut + " " + (i + 1) + " chiffre(s) est plus petit" + ponctuation + sautLigne);
       return conclusion;
    }

    /**
     * Regarde si le chiffre en position i est plus grand que celui à trouver.
     **/
    public static String plusGrand(String conclusion, int i) {
        if (i == (tailleCode - 1)){
            ponctuation = ".";
        }else{
            ponctuation = ",";
        }
        if (i == 0){
            debut = "Le";
        }else{
            debut = "le";
        }
        conclusion += (debut + " " + (i + 1) + " chiffre(s) est plus grand" + ponctuation + sautLigne);
        return conclusion;
    }

    /**
     * Regarde si le chiffre en position i est correct.
     **/
    public static String Correct(String conclusion, int i) {
        if (i == (tailleCode - 1)){
            ponctuation = ".";
        }else{
            ponctuation = ",";
        }
        if (i == 0){
            debut = "Le";
        }else{
            debut = "le";
        }
        conclusion += (debut + " " + (i + 1) + " chiffre(s) est correct" + ponctuation + sautLigne);
        return conclusion;
    }
}
