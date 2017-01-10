/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author bobmastrolilli
 */
public class ChiffreDES implements Chiffrement
{
    private KeyGenerator cleGen;
    private Cipher chiffrement;
    
    private CleDES Cle = null;

    public ChiffreDES() {
    }

    public Cle generateKey(int longueur) 
    {
        try 
        {
            //GENERATION DE CLE
            cleGen = KeyGenerator.getInstance("DES","BC");
            cleGen.init(new SecureRandom());
            SecretKey Cle = cleGen.generateKey();
            return new CleDES(Cle, longueur);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }

    @Override
    public void init(Cle k) 
    {
        Security.addProvider(new BouncyCastleProvider());
        this.Cle = (CleDES) k;
    }

    @Override
    public String crypte(String plainTextObj) // passer un String et return des bytes
    {
        Security.addProvider(new BouncyCastleProvider());
        String plainText = (String) plainTextObj;
        String textCr=null;
        byte []texteCrypte=null;
        byte [] encodedBytes = null;
        try {
            Cipher chiffrement = Cipher.getInstance("DES/ECB/PKCS5Padding","BC");
            chiffrement.init(Cipher.ENCRYPT_MODE, this.Cle.getSecretKey());
            byte []texteClair = plainText.getBytes();
            byte[] ciphertext=  chiffrement.doFinal(texteClair);
            encodedBytes= Base64.encodeBase64(ciphertext);
            System.out.println("EncodedBytes" + new String(encodedBytes));
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return new String(encodedBytes);
    }

    @Override
    public String decrypt(String cipherText) //passer des bytes
    {
        String TextClairDecrypte=null;
        try {
            Cipher chiffrementD = Cipher.getInstance("DES/ECB/PKCS5Padding","BC");
            chiffrementD.init(Cipher.DECRYPT_MODE, Cle.getSecretKey());
            byte [] DecodedBytes = cipherText.getBytes();
            byte [] DecodedBytes64 = Base64.decodeBase64(DecodedBytes);
            byte [] textDecode = chiffrementD.doFinal(DecodedBytes64);
            TextClairDecrypte = new String(textDecode);
            System.out.println("Test Décrypté = " + TextClairDecrypte);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(ChiffreDES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TextClairDecrypte;
    }

    @Override
    public String getProvider() 
    {
        return "ProCrypto";
    }

   

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
