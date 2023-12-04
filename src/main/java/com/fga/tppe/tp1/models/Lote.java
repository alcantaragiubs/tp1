package com.fga.tppe.tp1.models;

import java.math.BigDecimal;
import java.util.Date;

public class Lote {
    private Integer id;
    private String nome;
    private Date validade;



    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
    public Date getValidade() {
        return validade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public boolean confereValidade(){
        return true;
    }
}
