package com.example.entity;

import java.math.BigDecimal;
import org.joda.time.DateTime;

public class Jovem extends Dependente {
    
    private final static BigDecimal CUSTO = new BigDecimal(22.00);
    
    public Jovem(String nome, DateTime dataNascimento) {
        super(nome, dataNascimento);
    }  

    @Override
    public BigDecimal getCusto() {
        return CUSTO;
    }
}
