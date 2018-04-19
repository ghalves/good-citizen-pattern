package com.example.entity;

import java.math.BigDecimal;
import org.joda.time.DateTime;

public class Adulto extends Dependente {

    private final static BigDecimal CUSTO = new BigDecimal(150.00);

    public Adulto(String nome, DateTime dataNascimento) {
        super(nome, dataNascimento);
    }

    @Override
    public BigDecimal getCusto() {
        return CUSTO;
    }

}
