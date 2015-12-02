package com.company;

public enum Fruit implements Product{
    Apple(100), Banana(150), Cherry(75),
    Manzana(Apple.getValue()), Apfel(Apple.getValue());

    private Integer value;

    Fruit(Integer value) {

        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
