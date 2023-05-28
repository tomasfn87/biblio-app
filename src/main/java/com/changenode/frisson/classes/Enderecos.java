package com.changenode.frisson.classes;

import com.changenode.frisson.enums.LogradouroEnum;
import com.changenode.frisson.enums.UFEnum;

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
        CamposMultiplos enderecos = new CamposMultiplos(end, "; ");
        try{
            setTipo(enderecos.getUnidade(0));
            logradouro = enderecos.getUnidade(1);
            setNumero(enderecos.getUnidade(2));
            complemento = enderecos.getUnidade(3);
            bairro = enderecos.getUnidade(4);
            municipio = enderecos.getUnidade(5);
            setEstado(enderecos.getUnidade(6));
            setCep(enderecos.getUnidade(7));
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
        this.tipo = tipo.name();
    }
    public void setTipo(String tipo) {
        if(!tipo.isBlank())
            this.tipo = LogradouroEnum.valueOf(tipo).name();
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
    public void setNumero(String numero) {
        if(!numero.isBlank() && !numero.isEmpty())
            this.numero = Integer.valueOf(numero);
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
        this.estado = estado.name();
    }
    public void setEstado(String estado) {
        if(!estado.isBlank())
            this.estado = UFEnum.valueOf(estado).name();
    }

    public Integer getCep() {
        return cep;
    }
    public void setCep(Integer cep) {
        this.cep = cep;
    }
    public void setCep(String cep) {
        if(!cep.isBlank() && !cep.isEmpty())
            this.cep = Integer.valueOf(cep);
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
        return String.join("; ",
                tipo,
                logradouro,
                (numero==null?"":numero.toString()),
                complemento,
                bairro,
                municipio,
                estado,
                "["+(cep==null?"":cep.toString())+"]");
    }
}
