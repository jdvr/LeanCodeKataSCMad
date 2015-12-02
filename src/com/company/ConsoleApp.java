package com.company;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        new ConsoleApp().csvInput();
    }

    private void csvInput() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        CashRegister cashRegister = new CashRegister();
        while (true) {
            String rawInput = scanner.nextLine();
            String[] rawFruits = rawInput.split(",");
            Arrays.stream(rawFruits).forEach(
                    (rawFruit) -> {
                        Fruit fruit = Fruit.valueOf(rawFruit);
                        cashRegister.add(fruit);
                    }
            );
            System.out.println(cashRegister.total());
        }
    }

    private  void multilineInput(){
        CashRegister cashRegister = new CashRegister();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        while (true) {
            String rawInput = scanner.nextLine();
            Fruit fruit = Fruit.valueOf(rawInput);
            cashRegister.add(fruit);
            System.out.println(cashRegister.total());
        }
    }
}
