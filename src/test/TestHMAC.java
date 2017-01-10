/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Authenticate.Authentication;
import Crypto.Chiffrement;
import Crypto.Cle;
import Crypto.CryptoManager;
import Crypto.Service;
import UtilsCrypto.ByteArrayList;
import UtilsCrypto.FichierConfig;
import static UtilsCrypto.FichierConfig.getUserdir;
import UtilsCrypto.ManipFichierCrypto;
import java.io.IOException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;



/**
 *
 * @author bobmastrolilli
 */
public class TestHMAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException 
    { 
        String nomFichier = getUserdir()+ "Provider.properties";
        System.out.println("path =" + nomFichier);
        //Security.addProvider(new BouncyCastleProvider());
        Service service;
        Cle cle;
        CryptoManager cm = new CryptoManager(); //CryptoManager est un "services"
        
        service = cm.newInstance("BC"); // on obtient en fonction de TriumVirat, le chemin de la class (Crypto.Triumvirat)
//        
        //cle = cm.genereCle("BC"); // on obtient une clé classe CleCaesar
//      
        System.out.println("service = " + service);
        //cle = service.generateKey(128);
        Authentication authen;
        authen = (Authentication) service ; 

       Security.addProvider(new BouncyCastleProvider());
 
       String secret="secret pour générer clé";
       ByteArrayList secretBytes = new ByteArrayList();
       secretBytes.add(secret.getBytes());
       cle = authen.GenerateKey(secretBytes, "DES");
       ManipFichierCrypto mp = new ManipFichierCrypto();
       mp.CreateFileKey("CleHMAC",cle);
            
       Cle cleFichier= mp.ReadFileKey("CleHMAC");
       System.out.println("CLE = " + cle);
       authen.init(cleFichier);
       byte [] hmac = authen.AddAuth("helloworld");
        System.out.println("hmac : " + new String(hmac));
        boolean ok = authen.verifyAuth("helloworld", hmac);
        System.out.println("HMAC"+ok + " pour  " + "helloworld" );
        
        
       
    }
    
}
