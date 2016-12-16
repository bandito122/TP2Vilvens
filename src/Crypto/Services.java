/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;



import TP2_CryptoLibrary.Provider;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author bobmastrolilli
 */
public class Services
{
  

    static Properties propertiesNomProvider_Class; // Properties qui  utilisant un fichier dans lequel on trouve le nom du provider et le nom de classe correspondant.
    static Properties propertiesClassCle ; // Properties utilisant un fichier dans lequel on trouve une classe implémentant Cle en fonction du nom du provider.
    
    static{
        propertiesNomProvider_Class = new Properties();
        propertiesClassCle = new Properties();
        try
        {
            propertiesNomProvider_Class.load(new FileInputStream(getNomFichierConfig()));
            propertiesClassCle.load(new FileInputStream(getNomFichierConfig()));
        }
        catch (FileNotFoundException e) { System.out.println("Fichier de propriétés non trouvé !");}
        catch (IOException e) { System.out.println("Aie : " + e.getMessage()); }
    }

    /**
     *
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return propertiesNomProvider_Class.getProperty(key);
    }

    /**
     *
     * @return
     */
    public static String getUserdir()
    {
        return System.getProperty("user.dir") + System.getProperty("file.separator")
                + "src" + System.getProperty("file.separator")
                + "Utils" + System.getProperty("file.separator");
    }
    /**
     *
     * @return
     */
    public static String getNomFichierConfig()
    {
       String nomFichier = getUserdir()+ "config.properties";
       return nomFichier;
    }
    
    static void register(Provider p)
    {
        // TO DO
    }
    
    static void newInstance (String nom)
    {
        //TO DO
    }
}
