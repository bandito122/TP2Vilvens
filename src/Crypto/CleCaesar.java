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
public class CleCaesar implements Cle
{
    private int offset;

    public CleCaesar() {
    }
    
    
    public CleCaesar(int offset)
    {
        this.offset = offset;
    }
    public int getoffset() 
    {
        return offset;
    }
    
    @Override
    public int getLongueur()
    {
        // return this.decalage;
        return this.offset/10;
    }

    @Override
    public String toString() 
    {
        return "CleCesar".toString();
    }

    @Override
    public int getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
