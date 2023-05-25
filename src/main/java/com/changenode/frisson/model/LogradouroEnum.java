package com.changenode.frisson.model;

public enum LogradouroEnum {

    RUA("Rua"),
    AVENIDA("Avenida"),
    TRAVESSA("Travessa"),
    VIA("Via"),
    PRACA("Praça"),
    VILA("Vila"),
    VIADUTO("Viaduto"),
    RESIDENCIAL("Residencial"),
    PARQUE("Parque"),
    NUCLEO("Núcleo"),
    CONDOMINIO("Condomínio"),
    CHACARA("Chácara"),
    ALAMEDA("Alameda"),
    VIELA("Viela"),
    RODOVIA("Rodovia"),
    SITIO("Sítio"),
    LOTEAMENTO("Loteamento"),
    OUTROS("*Outros*");

    private String tipo;

    LogradouroEnum(String tipo){ this.tipo = tipo;}

    public String getTipo(){return tipo;}
}
