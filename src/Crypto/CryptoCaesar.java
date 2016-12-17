/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.util.Random;

/**
 *
 * @author bobmastrolilli
 */
public class CryptoCaesar implements Chiffrement
{
    private CleCaesar key = null;
    
    @Override
    public Cle generateKey(int longueur) 
    {
        
        Random random = new Random();
        int decalage = random.nextInt(longueur);
        if (decalage == 0)
        {
            decalage++;
        }
        return new CleCaesar(decalage);
    }
    @Override
    public void init(Cle k) 
    {
        CleCaesar cle= (CleCaesar) k;
        this.key = cle;
    }

    @Override
    public String crypte(String textClairObj) 
    {
       System.out.println("chiffrage Caesar !!! ");
       String textClair = (String) textClairObj;
       int decalage = this.key.getoffset();
        
        char[] textCrypte = new char[textClair.length()];
        textClair.getChars(0,textClair.length(),textCrypte,0); //srcBegin,srcend,Dst,dstbegin
        
        for(int i=0;i<textClair.length();i++)
        {
            textCrypte[i] =(char)(textCrypte[i]+decalage);
        }
        return new String(textCrypte);
    }

    @Override
    public String decrypt(String textCrypteObj) 
    {
       String textCrypte =(String)textCrypteObj;
       int decalage = this.key.getoffset();
        
        char[] TextClair = new char[textCrypte.length()];
        textCrypte.getChars(0,textCrypte.length(),TextClair,0);
        
        for(int i=0;i<textCrypte.length();i++)
        {
            TextClair[i]=(char)(TextClair[i]-decalage);
        }
        return new String(TextClair);
    }

    @Override
    public String getProvider()
    {
        return "Triumvirat";
    }

    

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
