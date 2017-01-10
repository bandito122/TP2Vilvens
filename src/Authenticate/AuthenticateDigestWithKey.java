/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authenticate;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;

/**
 *
 * @author bobmastrolilli
 */
public class AuthenticateDigestWithKey extends AuthenticateDigest
{
        public AuthenticateDigestWithKey() 
    {
         try 
        {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            this.hmac = Mac.getInstance("HMAC-SHA1","BC");
        } 
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(AuthenticateDigest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (NoSuchProviderException ex) 
        {
            Logger.getLogger(AuthenticateDigest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
