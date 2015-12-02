package com.company;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by JuanDavid on 12/2/2015.
 */
public class CashRegisterShould {

    @Test
    public void return_the_correct_price_for_apple() throws Exception{
        CashRegister cashRegister = new CashRegister();
        cashRegister.add(Fruit.Apple);
        Integer price = cashRegister.total();
        assertThat(price, is(100));
    }

    @Test
    public void return_the_correct_price_for_banana() throws Exception{
        CashRegister cashRegister = new CashRegister();
        cashRegister.add(Fruit.Apple);
        cashRegister.add(Fruit.Banana);
        cashRegister.add(Fruit.Cherry);
        Integer price = cashRegister.total();
        assertThat(price, is(325));
    }

    @Test
    public void apply_correct_price_when_add_two_cherry() throws Exception{
        CashRegister cashRegister = new CashRegister();
        cashRegister.add(Fruit.Apple);
        cashRegister.add(Fruit.Cherry);
        cashRegister.add(Fruit.Cherry);
        Integer price = cashRegister.total();
        assertThat(price, is(230));
    }
    @Test
    public void apply_correct_price_when_add_two_banana() throws Exception{
        CashRegister cashRegister = new CashRegister();
        cashRegister.add(Fruit.Apple);
        cashRegister.add(Fruit.Banana);
        cashRegister.add(Fruit.Banana);
        Integer price = cashRegister.total();
        assertThat(price, is(250));
    }




}
