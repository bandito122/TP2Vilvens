/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;


import Crypto.Services;
import java.util.Properties;

/**
 *
 * @author bobmastrolilli
 */
public class CryptoManager extends Services
{

       public static  Service NewInstance(String nom) throws ClassNotFoundException, InstantiationException, IllegalAccessException
       {

               Class cl = Class.forName(nom); // j'ai un cryptoprovider
               CryptoProvider cp = (CryptoProvider)cl.newInstance();
               return cp.newService();
               
              
          
       }
       public Cle genereCle(String nomAlgo)
       {
           Cle cle = null;
           return cle;
       }
            
           
       


   
}
