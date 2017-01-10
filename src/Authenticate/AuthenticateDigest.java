/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authenticate;

import UtilsCrypto.ByteArrayList;
import Crypto.Cle;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author bobmastrolilli
 */
public class AuthenticateDigest implements Authentication
{
    protected Mac hmac=null;

    public AuthenticateDigest() 
    {
   
        
    
    }


    
    
    @Override
    public void init(Cle k) 
    {
       CleSymetrique cleSecrete;
       cleSecrete = (CleSymetrique)k;
       
        try 
        {
            this.hmac.init(cleSecrete.getCleSecrete());
        } 
        catch (InvalidKeyException ex) 
        {
            Logger.getLogger(AuthenticateDigest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public byte [] AddAuth(String message) 
    {
        this.hmac.reset();
        this.hmac.update(message.getBytes());
        return this.hmac.doFinal();
    }

    @Override
    public boolean verifyAuth(String msg,byte[] hmac) 
    {
        this.hmac.reset();
        
        return MessageDigest.isEqual(this.hmac.doFinal(msg.getBytes()), hmac);
        
    }

    @Override
    public String getProvider() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public Cle GenerateKey(ByteArrayList mySecret, String algo) 
    {
       SecretKey secretKey = new SecretKeySpec(mySecret.getArray(),algo);
       return new CleSymetrique(mySecret.size(),secretKey);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cle generateKey(int longueur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   

    
    
}
