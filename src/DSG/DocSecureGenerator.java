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
import Crypto.Services;
import Utils.FichierConfig;
import static Utils.FichierConfig.getUserdir;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.Security;
import java.util.Properties;
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
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException 
    {
        String nomFichier = getUserdir()+ "Provider.properties";
        System.out.println("path =" + nomFichier);
        //Security.addProvider(new BouncyCastleProvider());
        Service service;
        Cle cle;
        CryptoManager cm = new CryptoManager(); //CryptoManager est un "services"
        
        service = cm.newInstance(FichierConfig.getPropertyProviderClass("Vigenere")); // on obtient en fonction de TriumVirat, le chemin de la class (Crypto.Triumvirat)
        cle = cm.genereCle("Vigenere"); // on obtient une clé classe CleCaesar
        cle = service.generateKey(128);
        
        Chiffrement chif;
        chif = (Chiffrement)service;
        chif.init(cle);
        String msg = "BOBI";

        System.out.println("Message clair    : " + msg);
        msg = (String) chif.crypte(msg);
        System.out.println("Message crypté   : " + msg);
        BufferedWriter fichier = new BufferedWriter(new FileWriter("/Users/bobmastrolilli/Desktop/lab2/testc.txt"));
        fichier.write(msg);
        BufferedReader fich = new BufferedReader(new FileReader("/Users/bobmastrolilli/Desktop/lab2/testc.txt"));
        fichier.close();
        String msg_read = fich.readLine();
        msg = (String) chif.decrypt(msg_read);
        fich.close();
        System.out.println("Message décrypté : " + msg);
        
    }
    
}
