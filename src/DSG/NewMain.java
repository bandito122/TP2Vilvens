/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSG;

import Utils.FichierConfig;
import static Utils.FichierConfig.getUserdir;



/**
 *
 * @author bobmastrolilli
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nomFichier = getUserdir()+ "Provider.properties";
        System.out.println("path =" + FichierConfig.getPropertyProviderClass("Triumvirat"));
    }
    
}
