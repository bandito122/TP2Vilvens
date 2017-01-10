/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.io.Serializable;
import javax.crypto.SecretKey;

/**
 *
 * @author bobmastrolilli
 */
public class CleDES implements Cle,Serializable
{
    private SecretKey secretKey = null;
    private int TailleCle = 0;

    public CleDES() {
    }
    
    
    public CleDES(SecretKey secretKey, int sizeKey)    
    {
        this.secretKey = secretKey;
        this.TailleCle = sizeKey;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public int getTailleCle() {
        return TailleCle;
    }

    public void setTailleCle(int TailleCle) {
        this.TailleCle = TailleCle;
    }
    
    @Override
    public int getLongueur() 
    {
        return TailleCle;
    }

    @Override
    public int getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
