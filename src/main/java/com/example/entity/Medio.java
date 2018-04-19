package com.example.entity;

import java.math.BigDecimal;
import org.joda.time.DateTime;

public class Medio extends Dependente {

    private final static BigDecimal CUSTO = new BigDecimal(50.00);

    public Medio(String nome, DateTime dataNascimento) {
        super(nome, dataNascimento);
    }

    @Override
    public BigDecimal getCusto() {
        return CUSTO;
    }

}
