package com.example.entity;

import java.math.BigDecimal;
import java.util.List;

public class Titular {
    private List<Dependente> dependentes;
    private Integer matricula;
    private String nome;
    
    public Titular(Integer matricula, String nome, List<Dependente> dependentes) {
        setMatricula(matricula);
        setNome(nome);
        this.dependentes = dependentes;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("Matricula nao pode ser nula.");
        }
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.length() < 3) {
            throw new IllegalArgumentException("Nome invalido");
        }
        this.nome = nome;
    }
    
    public BigDecimal calcularCustoDependentes() {
        BigDecimal total = BigDecimal.ZERO;

        if (dependentes == null) {
            return BigDecimal.ZERO;
        }

        for (Dependente dependente : dependentes) {
            total = total.add(dependente.getCusto());
        }

        return total;
    }

}
