package gb.intermediate.project;

import gb.intermediate.example.Kit;
import gb.intermediate.example.Product;
import gb.intermediate.example.ProductComparator;

import java.util.Optional;

/**
 * Класс для вывода самого длинного названия товара в наборе для посылки
 */
public class GameVirtualLongProductName implements Calculate<Kit>{

    @Override
    public void calculate(Kit kit) {
        Optional<Product> maxProduct = kit.getKit().keySet().stream().max(new ProductComparator());
        System.out.printf("Самое длинное название - %s, его длина %s символов%n", maxProduct.get().getName(),maxProduct.get().getNameLength());
    }
}