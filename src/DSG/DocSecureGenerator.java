/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSG;



import Crypto.Chiffrement;
import Crypto.Cle;
import Crypto.CryptoManager;
import Crypto.Service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author bobmastrolilli
 */
public class DocSecureGenerator
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        Security.addProvider(new BouncyCastleProvider());
        Service chiffrement;
        Cle cle;
        chiffrement = CryptoManager.NewInstance("Triumvirat");
        cle = chiffrement.generateKey(128);
        
        Chiffrement chif;
        chif = (Chiffrement)chiffrement;
        chif.init(cle);
        String msg = "bobi";

        System.out.println("Message clair    : " + msg);
        msg = (String) chif.crypte(msg);
        System.out.println("Message crypté   : " + msg);
        
        msg = (String) chif.decrypt(msg);
        System.out.println("Message décrypté : " + msg);
        
        
        
    }
    
}
