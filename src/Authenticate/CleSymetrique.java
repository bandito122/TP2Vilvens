/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authenticate;

import Crypto.Cle;
import java.io.Serializable;
import javax.crypto.SecretKey;

/**
 *
 * @author bobmastrolilli
 */
public class CleSymetrique implements Cle,Serializable
{

    public CleSymetrique(int taille,SecretKey cle) 
    {
        this.taille = taille;
        cleSecrete = cle;
    }
    
    private SecretKey cleSecrete=null;

    public SecretKey getCleSecrete() {
        return cleSecrete;
    }

    public void setCleSecrete(SecretKey cleSecrete) {
        this.cleSecrete = cleSecrete;
    }
    private int taille;
    @Override
    public int getLongueur() 
    {
        return this.taille;
    }

    @Override
    public int getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
