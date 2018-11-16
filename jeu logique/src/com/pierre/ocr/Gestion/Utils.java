package com.pierre.ocr.Gestion;

public class Utils {

    static String sautLigne = "\n";

    /**
     * Regarde si le chiffre en position i est plus petit que celui à trouver.
     **/
    public static String plusPetit(String conclusion, int i) {
        if (i == 0) {
            conclusion += "Le premier chiffre est plus petit, ";
        }else if (i == 1){
            conclusion += (sautLigne + "le deuxieme chiffre est plus petit, ");
        }else if (i == 2){
            conclusion += (sautLigne + "le troisieme chiffre est plus petit, ");
        }else if (i == 3){
            conclusion += (sautLigne + "le quatrieme chiffre est plus petit.");
        }
        return conclusion;
    }

    /**
     * Regarde si le chiffre en position i est plus grand que celui à trouver.
     **/
    public static String plusGrand(String conclusion, int i) {
        if (i == 0) {
            conclusion += "Le premier chiffre est plus grand, ";
        }else if (i == 1){
            conclusion += (sautLigne + "le deuxieme chiffre est plus grand, ");
        }else if (i == 2){
            conclusion += (sautLigne + "le troisieme chiffre est plus grand, ");
        }else if (i == 3){
            conclusion += (sautLigne + "le quatrieme chiffre est plus grand.");
        }
        return conclusion;
    }

    /**
     * Regarde si le chiffre en position i est correct.
     **/
    public static String Correct(String conclusion, int i) {
        if (i == 0) {
            conclusion += "Le premier chiffre est correct, ";
        }else if (i == 1){
            conclusion += (sautLigne + "le deuxieme chiffre est correct, ");
        }else if (i == 2){
            conclusion += (sautLigne + "le troisieme chiffre est correct, ");
        }else if (i == 3){
            conclusion += (sautLigne + "le quatrieme chiffre est correct.");
        }
        return conclusion;
    }
}
