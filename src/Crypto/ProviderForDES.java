/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bobmastrolilli
 */
public class ProviderForDES implements CryptoProvider
{
    @Override
    public Chiffrement newService(String nom) 
    {
        try 
        {
            //System.out.println("NOM = " + nom );
            Class cl = Class.forName(nom);
            Chiffrement ch = (Chiffrement)cl.newInstance() ;
            return ch;
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Triumvirat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Triumvirat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Triumvirat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
