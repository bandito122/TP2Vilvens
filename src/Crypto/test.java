/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import static Crypto.Services.getUserdir;

/**
 *
 * @author Bandito
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomFichier = getUserdir()+ "config.properties";
        System.out.println("nom fichier = "  + nomFichier);
    }
     public static String getUserdir()
    {
        return System.getProperty("user.dir") + System.getProperty("file.separator")
                + "src" + System.getProperty("file.separator")
                + "Utils" + System.getProperty("file.separator");
    }
    
}
