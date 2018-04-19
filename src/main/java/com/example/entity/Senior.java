package com.example.entity;

import java.math.BigDecimal;
import org.joda.time.DateTime;

public class Senior extends Dependente {

    private final static BigDecimal CUSTO = new BigDecimal(320.00);

    public Senior(String nome, DateTime dataNascimento) {
        super(nome, dataNascimento);
    }

    @Override
    public BigDecimal getCusto() {
        return CUSTO;
    }

}
