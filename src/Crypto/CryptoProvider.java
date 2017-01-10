
package Crypto;

public interface CryptoProvider extends Provider
{

    @Override
    public Service newService(String c);
 
}
