package com.reto5;

import com.reto5.coffee.*;
import com.reto5.topping.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== RETO 5: Café Personalizado (Decorator) ===");

        System.out.print("¿Cuántos cafés vas a pedir?: ");
        int n = readInt(sc, 1, 100);

        List<Coffee> coffees = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Café #" + i + " ---");
            Coffee coffee = chooseBaseCoffee(sc);

            System.out.print("¿Cuántos toppings quieres para este café?: ");
            int t = readInt(sc, 0, 50);

            for (int j = 1; j <= t; j++) {
                coffee = chooseTopping(sc, coffee);
            }

            coffees.add(coffee);

            System.out.println("\n✅ Resumen del Café #" + i);
            System.out.println("Descripción: " + coffee.description());
            System.out.println("Precio: $" + (int) coffee.cost());
        }

        double total = coffees.stream()
                .mapToDouble(Coffee::cost)
                .sum();

        System.out.println("\n=== FACTURA FINAL ===");
        for (int i = 0; i < coffees.size(); i++) {
            Coffee c = coffees.get(i);
            System.out.println((i + 1) + ") " + c.description() + " -> $" + (int) c.cost());
        }
        System.out.println("----------------------");
        System.out.println("TOTAL A PAGAR: $" + (int) total);
        System.out.println("¡Gracias por tu compra!");
    }

    private static Coffee chooseBaseCoffee(Scanner sc) {
        System.out.println("Selecciona el café base:");
        System.out.println("1) Americano ($5000)");
        System.out.println("2) Espresso ($4500)");
        System.out.print("Opción: ");
        int opt = readInt(sc, 1, 2);

        return (opt == 1) ? new Americano() : new Espresso();
    }

    private static Coffee chooseTopping(Scanner sc, Coffee coffee) {
        System.out.println("\nSelecciona un topping:");
        System.out.println("1) Leche ($1000)");
        System.out.println("2) Chocolate ($1500)");
        System.out.println("3) Caramelo ($1200)");
        System.out.println("4) Crema Batida ($2000)");
        System.out.println("5) Menta ($1300)");
        System.out.print("Opción: ");
        int opt = readInt(sc, 1, 5);

        return switch (opt) {
            case 1 -> new Leche(coffee);
            case 2 -> new Chocolate(coffee);
            case 3 -> new Caramelo(coffee);
            case 4 -> new CremaBatida(coffee);
            default -> new Menta(coffee);
        };
    }

    private static int readInt(Scanner sc, int min, int max) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.print("Valor inválido. Rango [" + min + ".." + max + "]. Intenta: ");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intenta: ");
            }
        }
    }
}