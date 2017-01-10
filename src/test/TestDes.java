/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Crypto.Chiffrement;
import Crypto.Cle;
import Crypto.CleDES;
import Crypto.CryptoManager;
import Crypto.Service;
import UtilsCrypto.ManipFichierCrypto;
import java.io.IOException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author bobmastrolilli
 */
public class TestDes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try {
            Security.addProvider(new BouncyCastleProvider());
            Provider prov[] = Security.getProviders();
            int i;
            for(i=0 ; i < prov.length ;i++)
            {
                System.out.println(prov[i].getName()+"/"+prov[i].getVersion());
            }
            CryptoManager cm = new CryptoManager();
            Service s = cm.newInstance("DES");
            Chiffrement c = (Chiffrement)s ;
            Cle cle = cm.genereCle("DES"); // j'obtiens une clé DES
            
            
            
            cle = c.generateKey(128);
            ManipFichierCrypto mp = new ManipFichierCrypto();
            mp.CreateFileKey("CleDES",cle);
            
            Cle cleFichier= mp.ReadFileKey("CleDES");
            System.out.println("cle" + cleFichier);
            c.init(cleFichier);
            String chaine = "Bonjour";
            String cipher = c.crypte(chaine);
            
            System.out.println("Cipher = " + cipher);
            
            String chaineDecrypte= c.decrypt(cipher);
            System.out.println("Chaine decryptée  = " + chaineDecrypte);
          
        } catch (IOException ex) {
            Logger.getLogger(TestDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TestDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestDes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
