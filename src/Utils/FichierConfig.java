/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bob
 */
public class FichierConfig 
{
    
    static Properties propConfigProviderChiffrement; // fichier properties Provider -> chiffrement
    static Properties propConfigCle; // fichier properties Provider -> cle
    static Properties propConfigProviderClass ; // fichier properties Provider -> classprovider

    static
    {
        propConfigProviderChiffrement = new Properties();
        propConfigCle = new Properties();
        propConfigProviderClass = new Properties();

        try
        {
            propConfigProviderChiffrement.load(new FileInputStream(getNomFichierConfigProviderChiffrement()));
            propConfigCle.load(new FileInputStream(getNomFichierConfigCle()));
            propConfigProviderClass.load(new FileInputStream(getNomFichierConfigProviderClass()));
        }
        catch (FileNotFoundException e) { System.out.println("Fichier de propriétés non trouvé !");}
        catch (IOException e) { System.out.println("Aie : " + e.getMessage()); }
    }
    
    public Properties getPropConfigProviderChiffrement() {
        return propConfigProviderChiffrement;
    }

    public void setPropConfigProviderChiffrement(Properties propConfigProviderChiffrement) {
        this.propConfigProviderChiffrement = propConfigProviderChiffrement;
    }

    public Properties getPropConfigCle() {
        return propConfigCle;
    }

    public void setPropConfigCle(Properties propConfigCle) {
        this.propConfigCle = propConfigCle;
    }

    public Properties getPropConfigProviderClass() {
        return propConfigProviderClass;
    }

    public void setPropConfigProviderClass(Properties propConfigProviderClass) {
        this.propConfigProviderClass = propConfigProviderClass;
    }

    

    /**
     *
     * @param key
     * @return
     */
    public static String getPropertyProviderClass(String key)
    {
        return propConfigProviderClass.getProperty(key);
    }
    public static  String getPropertyProviderChiffrement(String key)
    {
        return propConfigProviderChiffrement.getProperty(key);
    }
    public static String getPropertyClassCle(String key)
    {
        return propConfigCle.getProperty(key);
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
    public static String getNomFichierConfigProviderChiffrement()
    {
       String nomFichier = getUserdir()+ "config.properties";
       System.out.println("path =" + nomFichier);
       return nomFichier;
    }
    public static String getNomFichierConfigCle()
    {
       String nomFichier = getUserdir()+ "cle.properties";
       System.out.println("path =" + nomFichier);
       return nomFichier;
    }
    public static String getNomFichierConfigProviderClass()
    {
       
       String nomFichier = getUserdir()+ "Provider.properties";
        System.out.println("path =" + nomFichier);
       return nomFichier;
    }
}
