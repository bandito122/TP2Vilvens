/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.io.Serializable;

/**
 *
 * @author bobmastrolilli
 */
public class ClePolyVigenere implements Cle,Serializable
{
    private String key;
    private char LettreCalage;
    private int NbCaracAvantPassageSuivant; // si 3, aprés 3 carac on tourne le disque

    public ClePolyVigenere(char LC,String key, int Nb)
    {
        this.key=key;
        this.LettreCalage=LC;
        this.NbCaracAvantPassageSuivant=Nb;
    }
    public String getKey()
    {
        return key;
    }
    
    public char getLettreCalage() 
    {
        return LettreCalage;
    }
    
    public int GetNbCaracAvantPassageSuivant()
    {
        return NbCaracAvantPassageSuivant;
    }
    
    @Override
    public int getLongueur()
    {
        return key.length();
    }
    @Override
    public String toString()
    {
        return "Cle Alberti".toString();
    }

    @Override
    public int getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
