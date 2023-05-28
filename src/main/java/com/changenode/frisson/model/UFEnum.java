package com.changenode.frisson.model;

public enum UFEnum {

    AC("AC"),
    AL("AL"),
    AM("AM"),
    AP("AP"),
    BA("BA"),
    CE("CE"),
    ES("ES"),
    GO("GO"),
    MA("MA"),
    MG("MG"),
    MS("MS"),
    MT("MT"),
    PA("PA"),
    PB("PB"),
    PR("PR"),
    PE("PE"),
    PI("PI"),
    RJ("RJ"),
    RN("RN"),
    RO("RO"),
    RR("RR"),
    RS("RS"),
    SC("SC"),
    SE("SE"),
    SP("SP"),
    TO("TO");

    private String uf;

    UFEnum(String uf) {this.uf = uf;}

    public String getUf(){ return this.uf;}
}
