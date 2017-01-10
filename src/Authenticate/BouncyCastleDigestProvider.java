/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authenticate;

import Crypto.Chiffrement;
import Crypto.CryptoProvider;
import Crypto.Service;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bobmastrolilli
 */
public class BouncyCastleDigestProvider implements CryptoProvider
{


    @Override
    public Authentication newService(String c) 
    {
        try {
            Class cl = Class.forName(c);
            Authentication au = (Authentication)cl.newInstance() ;
            return au;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BouncyCastleDigestProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BouncyCastleDigestProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BouncyCastleDigestProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   


    
    
}
