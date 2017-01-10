/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;


import Crypto.Services;
import UtilsCrypto.FichierConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author bobmastrolilli
 */
public class CryptoManager extends Services
{
    //Properties propertiesClassCle ; // Properties utilisant un fichier dans lequel on trouve une classe implémentant Cle en fonction du nom du provider.
    
 
       public Cle genereCle(String nomAlgo) throws ClassNotFoundException, InstantiationException, IllegalAccessException
       {
           String nomClassCle = FichierConfig.getPropertyClassCle(nomAlgo);
           Class cl = Class.forName(nomClassCle);
           System.out.println("nom class cle = " + nomClassCle);
           Cle cle = (Cle) cl.newInstance();
           
           return cle; // retourne la clé en fonction du nom de l'algo
       }
            
           
       


   
}
