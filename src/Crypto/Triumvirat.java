/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

/**
 *
 * @author bobmastrolilli
 */
public class Triumvirat implements CryptoProvider
{

    @Override
    public Chiffrement newService() 
    {
        return new CryptoCaesar();
    }
    
}
