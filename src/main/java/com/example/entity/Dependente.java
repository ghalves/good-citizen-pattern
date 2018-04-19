package com.example.entity;

import java.math.BigDecimal;
import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.joda.time.Period;

public abstract class Dependente {

    protected String nome;
    protected DateTime dataNascimento;

    public Dependente(String nome, DateTime dataNascimento) {
        setNome(nome);
        setDataNascimento(dataNascimento);
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

    public DateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(DateTime dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfterNow()) {
            throw new IllegalArgumentException("Data de nascimento invalida");
        }
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        Period period = new Period(dataNascimento, DateTime.now());
        return period.get(DurationFieldType.years());
    }

    public abstract BigDecimal getCusto();
}
