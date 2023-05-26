package com.changenode.frisson.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

public class Enderecos {
    private String tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private Integer cep;

    public Enderecos() {
    }

    public Enderecos(String end) {
        CamposMultiplos enderecos = new CamposMultiplos(end, ", ");
        try{
            tipo = enderecos.getUnidade(0);
            logradouro = enderecos.getUnidade(1);
            numero = Integer.getInteger(enderecos.getUnidade(2));
            complemento = enderecos.getUnidade(3);
            bairro = enderecos.getUnidade(4);
            municipio = enderecos.getUnidade(5);
            estado = enderecos.getUnidade(6);
            cep = Integer.getInteger(enderecos.getUnidade(7));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Número de campos inferiores ao necessário.\n");
        }catch (SecurityException e){
            System.out.println("Erro na conversão de campos numéricos.");
        }catch (PatternSyntaxException e){
            System.out.println("Erro na separação dos campos da String de endereços");
        }catch (Exception e){
            System.out.println("Erro não identificado. " + e);
        }
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(LogradouroEnum tipo) {
        this.tipo = tipo.getTipo();
    }
    public void setTipo(String tipo) {
        this.tipo = LogradouroEnum.valueOf(tipo).toString();
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(UFEnum estado) {
        this.estado = estado.getUf();
    }
    public void setEstado(String estado) {
        this.estado = UFEnum.valueOf(estado).toString();
    }

    public Integer getCep() {
        return cep;
    }
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enderecos that = (Enderecos) o;
        return Objects.equals(tipo, that.tipo) &&
                Objects.equals(logradouro, that.logradouro) &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(complemento, that.complemento) &&
                Objects.equals(bairro, that.bairro) &&
                Objects.equals(municipio, that.municipio) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(cep, that.cep)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            tipo,
            logradouro,
            numero,
            complemento,
            bairro,
            municipio,
            estado,
            cep
        );
    }

    // TODO: 21/05/2023
    @Override
    public String toString (){
        return String.join(", ",
                tipo,
                logradouro,
                numero.toString(),
                complemento,
                bairro,
                municipio,
                estado,
                "["+cep+"]");
    }
}
