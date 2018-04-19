package com.example.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestaTitular {

    @Test
    public void TestaBomCidadao() {
        Titular titular = new Titular(1, "Ana", null);
        assertEquals(BigDecimal.ZERO, titular.calcularCustoDependentes());
    }

    @Test
    public void TestaBomCidadaoRefatorado() {
        List<Dependente> dependentes = new ArrayList<>();

        DateTime dataNascimento1 = new DateTime().withDate(1994, 03, 12);
        assertEquals("12-mar-1994", dataNascimento1.toString("dd-MMM-yyyy"));
        Dependente jovem = new Jovem("Camila", dataNascimento1);
        assertTrue(dependentes.add(jovem));

        DateTime dataNascimento2 = new DateTime().withDate(1986, 07, 22);
        assertEquals("22-jul-1986", dataNascimento2.toString("dd-MMM-yyyy"));
        Dependente medio = new Medio("Joao", dataNascimento2);
        assertTrue(dependentes.add(medio));

        DateTime dataNascimento3 = new DateTime().withDate(1976, 01, 01);
        assertEquals("01-jan-1976", dataNascimento3.toString("dd-MMM-yyyy"));
        Dependente adulto = new Adulto("Gilmar", dataNascimento3);
        assertTrue(dependentes.add(adulto));

        DateTime dataNascimento4 = new DateTime().withDate(1940, 12, 25);
        assertEquals("25-dez-1940", dataNascimento4.toString("dd-MMM-yyyy"));
        Dependente senior = new Senior("Erivaldo", dataNascimento4);
        assertTrue(dependentes.add(senior));

        Titular titular = new Titular(2, "Pedro", dependentes);
        assertEquals(new BigDecimal(542), titular.calcularCustoDependentes());
    }
    
    @Test
    public void TestaIdadeDeDependente() {
        Dependente bebe = new Jovem("Sofia", new DateTime().withDate(2017, 01, 01));
        assertEquals(1, bebe.getIdade());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void TestaDataDeNascimentoImprovavel() {
        Dependente viajanteDoTempo = new Jovem("Viajante", new DateTime().withDate(2038, 05, 19));
    }
   
     @Test(expected = IllegalArgumentException.class) 
    public void TestaDataDeNascimentoNula() {
        Dependente dependente = new Jovem("Hellen", null);
    }
}
