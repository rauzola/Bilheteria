package com.bilheteria.bilheteria.Classes;

/**
 *
 * @author raul_
 */

public class MetodoPagamento {
    public int id;    
    public String nome;
    
    public static MetodoPagamento criar(int pId, String pNome){
        MetodoPagamento objeto = new MetodoPagamento();
        objeto.id = pId;
        objeto.nome = pNome;
        
        return objeto;
    }
}
