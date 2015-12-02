package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CashRegister {
    public static final int CherryDiscountValue = 20;
    private static final int BananaDiscountValue = Fruit.Banana.getValue();
    private static  final int ManzanaDiscountValue = 100;
    private static final int ApfelDiscountValue = 150;

    private final HashMap<Product, Discount> discounts = new HashMap<Product, Discount>(){{
        put(Fruit.Cherry, (numberOfCherrys) -> numberOfCherrys / 2 * CherryDiscountValue);
        put(Fruit.Banana, (numberOfBananas) -> numberOfBananas / 2 * BananaDiscountValue);
        put(Fruit.Manzana, (numberOfManzanas) -> numberOfManzanas / 3 * ManzanaDiscountValue);
        put(Fruit.Apfel, (numberOfApfel) -> numberOfApfel / 2 * ApfelDiscountValue);
        put(Fruit.Apple, NullDiscount);
        put(GroupedFruits.AppleGroups, (totalApples) -> totalApples >= 4 ? 100 : 0);
    }};

    private Integer total = 0;
    private Map<Product, Integer> numberOfFruit = new HashMap<>();

    public void add(Fruit fruit) {
        this.total += fruit.getValue();
        numberOfFruit.put(fruit, getNumberOf(fruit) + 1);
    }

    private void applyDiscounts() {
        total -= applyDiscountsForTotalFruits();
        for (Product product : discounts.keySet()) {
            total -= discounts.get(product).getAmountToDiscount(getNumberOf(product));
        }
    }

    private Integer applyDiscountsForTotalFruits() {
        Integer totalFruits = count(numberOfFruit);
        return  totalFruits >= 5 ? 200 : 0;
    }

    private Integer count(Map<Product, Integer> numberOfFruit) {
        Integer count = 0;
        for (Map.Entry<Product, Integer> fruitIntegerEntry : numberOfFruit.entrySet()) {
            count += fruitIntegerEntry.getValue();
        }
        return count;
    }


    private Integer getNumberOf(Product fruit) {
        return numberOfFruit.get(fruit) == null ? 0 : numberOfFruit.get(fruit);
    }


    public Integer total() {
        applyDiscounts();
        return total;
    }

    public interface Discount{
        Integer getAmountToDiscount(Integer countedFruit);
    }

    private Discount NullDiscount = (n) -> 0;

}
