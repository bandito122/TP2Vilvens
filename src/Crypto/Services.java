/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;



import Utils.FichierConfig;
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
  /* Properties qui  utilisant un fichier (config.properties) dans lequel on trouve 
     le nom du provider et le nom de classe qu'il propose comme implémentation de service.   */

    static void register(Provider p)
    {
        // TO DO
    }
    
  public Service newInstance (String nom) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        
        //soit j'utilise le fichier properties et alors plus besoin de la classe cryptoprovider
        //soit j'utilise le crypto provider et alors plus besoin de fichier properties étant donné
        //que c'est ce fichier qui me donne la classe pour le chiffrement
        //nom = nom du provider donc crypto.triumvirat
        
        //crypto.triumvirat Crypto.Triumvirat
        System.out.println("NOM = "  + FichierConfig.getPropertyProviderChiffrement(nom));
        Class cl = Class.forName(nom); // j'ai un cryptoprovider crypto.triumvirat
        
        CryptoProvider cp = (CryptoProvider)cl.newInstance();

        System.out.println("NOM = "  + FichierConfig.getPropertyProviderChiffrement(nom));
        return cp.newService(FichierConfig.getPropertyProviderChiffrement(nom)); // newService cryptocaeasre
    }
    public String getClassName(String nom)
    {
        String name = null ; 
        //name = fich.getProperty(nom);
        return name;
    }
    
}
