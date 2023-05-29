package com.changenode.frisson.enums;

public enum CondicoesEnum {

    nao_declarado,
    novo("NOVO"),
    seminovo("SEMINOVO"),
    usado("USADO"),
    sem_capa("SEM_CAPA"),
    rasgado("RASGADO"),
    rasurado("RASURADO"),
    incompleto("INCOMPLETO"),
    extraviado("EXTRAVIADO");

    private String value;
    CondicoesEnum (String value) {this.value = value;}

    CondicoesEnum() {}
}
