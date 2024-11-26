package gb.intermediate.project;

import gb.intermediate.example.ProductKit;
import gb.intermediate.example.Kit;
import gb.intermediate.example.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для вывода набора
 */
public class GameVirtualProductKit implements Calculate<Kit> {
    @Override
    public void calculate(Kit kit) {
        List<String> allProduct = getGameVirtualProductkit(kit);
        for (String product: allProduct) System.out.println(product);

    }


    private List<String> getGameVirtualProductkit(Kit<Product> kit) {
        List<String> result = new ArrayList<>();
        for (Product product : kit) {
            //    System.out.println(fruit.getName() + "   ");
            ProductKit basket = new ProductKit();
            result.add(String.format("%s - %s шт.", product.getName(), kit.getPlantAmount(product)));

        }
        return result;
    }
}