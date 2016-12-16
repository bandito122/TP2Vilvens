/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_CryptoLibrary;



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
  

    static Properties propConfig;

    static{
        propConfig = new Properties();
        try
        {
            propConfig.load(new FileInputStream(getNomFichierConfig()));
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
        return propConfig.getProperty(key);
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
        
    }
}
