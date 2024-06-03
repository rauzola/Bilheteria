package com.bilheteria.bilheteria.Classes;

/**
 *
 * @author raul_
 */

public class Estado {
    public int id;
    public String sigla;
    public String nome;

    public static Estado criar(int pId, String pNome, String pSigla){
        Estado objeto = new Estado();
        objeto.id = pId;
        objeto.nome = pNome;
        objeto.sigla = pSigla;
        
        return objeto;
    }
}
