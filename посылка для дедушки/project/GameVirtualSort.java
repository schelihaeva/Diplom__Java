package gb.intermediate.project;

import gb.intermediate.example.Kit;
import gb.intermediate.example.Product;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;


/**
 * сортировка содержимого в наборе
 */
public class GameVirtualSort implements Calculate<Kit> {
    private static boolean ascending = false;

    public GameVirtualSort() {
    }

    public GameVirtualSort(boolean ascending) {
        GameVirtualSort.ascending = ascending;}

    @Override
    public void calculate(Kit kit) {
        Map<Product, Integer> sorted = sortKit(kit);
        for (Product product: sorted.keySet()) {
            System.out.printf("'%s' = %s%n",product.getName(),kit.getPlantAmount(product));
        }

    }
    private Map<Product, Integer> sortKit(Kit<Product> kit){
        Map<Product, Integer> sorted = kit.getKit();

        if (!ascending) {
            sorted = sorted
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        } else {
            sorted = sorted
                    .entrySet()
                    .stream()
                    .sorted(comparingByValue())
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        }
        return sorted;
    }
    public static void setAscending(boolean ascending){ GameVirtualSort.ascending = ascending;}
}