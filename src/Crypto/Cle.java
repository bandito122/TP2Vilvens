/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2_CryptoLibrary;


/**
 *
 * @author bobmastrolilli
 */
public interface Cle 
{
    int getLongueur();
    int getType() ; // Valeurs possibles : SECRETE, PUBLIQUE, PRIVEE = variables membres statiques de la classe Constantes);
}
