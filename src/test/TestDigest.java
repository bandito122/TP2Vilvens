/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bobmastrolilli
 */
public class TestDigest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try {
            String plainString = "Plaintext Secret";
            String plainString2 = "Plaintext Secret";
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] hashedString = messageDigest.digest(plainString.getBytes());
             System.out.println("digest = " + Arrays.toString(hashedString));
             
              MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-512");
            byte[] hashedString2 = messageDigest2.digest(plainString2.getBytes());
             System.out.println("digest = " + Arrays.toString(hashedString2));
             
             
             
             if(MessageDigest.isEqual(hashedString, hashedString2))
             {
                 System.out.println("true");
             }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TestDigest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }
    
}
