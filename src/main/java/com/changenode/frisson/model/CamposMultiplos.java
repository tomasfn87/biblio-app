package com.changenode.frisson.model;

import java.util.List;

public class CamposMultiplos {
    private List<String> unidade;

    public CamposMultiplos() { }
    public CamposMultiplos(List<String> unidade) {
        setUnidade(unidade);
    }
    public CamposMultiplos(String unidade, String delim) {
        setUnidade(unidade, delim);
    }

    public String getUnidade (int indice){ return unidade.get(indice); };
    public void setUnidade (List<String> str){
        if (str != null)
            str.forEach(s->s.toLowerCase());
        this.unidade = str;
    }
    public void setUnidade (String str, String delim){ this.unidade = List.of(str.split(delim)); }

    @Override
    public String toString (){
        return String.join("; ",
               this.unidade);
    }
}
