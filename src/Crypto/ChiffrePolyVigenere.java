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
public class ChiffrePolyVigenere implements Chiffrement 
{

    private ClePolyVigenere _cleAlberti = null;
    private String _DisqueExterieur = "ABCDEFGHIJKLMNOPQRSTUVW0123456789 ";
    private String _DisqueInterieur = " 8796543210zyxwvutsrqponmlkjihgfedcba";
    private int TailleDisque= _DisqueExterieur.length();

    private int IndicedisqueInterieur;
    private int PassageCaracSuivant;


    public Cle generateKey(int lenght) 
    {
        // Recherche de la lettre de callage
        Random rand = new Random();

        char[] randomChars;
        // Génerer une clé de longueur lenght
        randomChars=new char[lenght];
       
        // Pour la clé Alberti, on a besoin de : 1)Lettre de callage 2) Une clé 
        char LettreCalage = _DisqueInterieur.charAt(rand.nextInt(_DisqueInterieur.length())); //P
        
        //on cree une cle de 128
        for (int i=0;i<lenght;i++) 
        {
            // retourne une 
            randomChars[i] = _DisqueExterieur.charAt(rand.nextInt(_DisqueExterieur.length()));
        }
        String randomCle;
        randomCle = new String(randomChars);
    
        ClePolyVigenere cle = new ClePolyVigenere(LettreCalage, randomCle, 5);
        return cle;
    }

    @Override
    public void init(Cle k) 
    {
        ClePolyVigenere cle = (ClePolyVigenere) k;
        this._cleAlberti = cle;
        this.IndicedisqueInterieur = this._DisqueInterieur.indexOf(_cleAlberti.getLettreCalage());
        this.PassageCaracSuivant = this._cleAlberti.GetNbCaracAvantPassageSuivant();
        
    }

    @Override
    public String crypte(String TextClair) 
    {
        char[] TextCrypte = new char[TextClair.length()];
        int decalage = -1;
        int indiceKey = -1;
        int indiceLettreCryptee;
        
        System.out.println("chiffrage Poly !!! ");
        
  
        for (int i=0;i<TextClair.length();i++) 
        {
            if (i%this.PassageCaracSuivant== 0) //si ==0 alors on change la lettre dans key(on decale les disques)
            {
                System.out.println("yo");
                indiceKey++;
               // je set l'indice du disque extérieur en fonction de la clé
                int IndiceLettreDisqueExterieur =this._DisqueExterieur.indexOf(_cleAlberti.getKey().charAt(indiceKey)); //6
                
                
                //obtenir le decalage entre les deux disques
                decalage = IndicedisqueInterieur-IndiceLettreDisqueExterieur;
                if (decalage<0) 
                {
                    decalage=decalage+TailleDisque;  // pas de décalage négatif
                }
            }
            // je regarde ou se trouve la lettre a crypter sur le disque exterieur et j'ajoute le decalage = indice lettre crypte
            indiceLettreCryptee=(decalage +_DisqueExterieur.indexOf(TextClair.charAt(i))) % TailleDisque;

            if (indiceLettreCryptee<0) 
            {
                indiceLettreCryptee=decalage+TailleDisque;
            }

            TextCrypte[i] =this._DisqueInterieur.charAt(indiceLettreCryptee);
            //fin boucle
        }

        return new String(TextCrypte);
    }

    @Override
    public String decrypt(String TextCrypte) 
    {
        char[] TextClair = new char[TextCrypte.length()]; // ou l'on va mettre les lettres décryptées
        int offset = -1;
        int indiceKey = -1;
        int indiceLettreDecryptee;
        int indiceDisqueExterne;
        
        for (int i =0;i<TextCrypte.length();i++) 
        {
            if (i%PassageCaracSuivant==0) 
            {
                indiceKey++;
                indiceDisqueExterne =this._DisqueExterieur.indexOf(_cleAlberti.getKey().charAt(indiceKey));
                offset =IndicedisqueInterieur-indiceDisqueExterne;
                if (offset<0) 
                {
                    offset += TailleDisque;
                }
            }
            indiceLettreDecryptee =(_DisqueInterieur.indexOf(TextCrypte.charAt(i))-offset) ;

            if (indiceLettreDecryptee < 0) 
            {
                indiceLettreDecryptee += TailleDisque;
            }

            TextClair[i] = this._DisqueExterieur.charAt(indiceLettreDecryptee);
        }

        return new String(TextClair);
    }

    @Override
    public String getProvider() 
    {
        return "AlbertiFamily";
    }

    
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
