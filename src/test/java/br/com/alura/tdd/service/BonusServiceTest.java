package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {
    
    @Test
    public void bonusZeroParaSalarioMaiorQue10000() {

        BonusService bonus = new BonusService();
        //var valorBonus = bonus.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal("20000")));
        assertThrows(IllegalArgumentException.class
                    ,()-> bonus.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal("20000")))
                    );
        //assertEquals(new BigDecimal("0.00"), valorBonus);
    }

    @Test
    public void bonusDe10PorCentoParaSalarioAte10000() {

        BonusService bonus = new BonusService();
        var valorBonus = bonus.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), valorBonus);
    }

    @Test
    public void bonusDe10PorCentoParaSalarioigual10000() {
        
        BonusService bonus = new BonusService();
        var valorBonus = bonus.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), valorBonus);
    }

}
