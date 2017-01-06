
package Crypto;

public interface CryptoProvider extends Provider
{

    @Override
    public Chiffrement newService(String c);
 
}
