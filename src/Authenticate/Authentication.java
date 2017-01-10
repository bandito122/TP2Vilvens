/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authenticate;

import Crypto.Cle;
import Crypto.Service;
import UtilsCrypto.ByteArrayList;

/**
 *
 * @author bobmastrolilli
 */
public interface Authentication extends Service
{
    void init(Cle k);
    byte [] AddAuth(String message);
    public boolean verifyAuth(String msg,byte[] hmac) ;
    String getProvider();
    Cle GenerateKey(ByteArrayList mySecret,String algo);
}
