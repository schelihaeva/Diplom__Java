package gb.intermediate.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductKit implements Kit<Product>, Iterable<Product> {
    private Map<Product, Integer> basket;
    private HashMap kit = new HashMap();

    public ProductKit() {
        kit = new HashMap<>();
    }

    public ProductKit(Map<Product, Integer> basket) {
        this.kit = (HashMap) basket;
    }

    public ProductKit(List<String> rawData) {
        kit = new HashMap<>();
        if (rawData == null) {
            System.err.println("Набор пуст.");
            return;
        }
        for (String product : rawData) {
            if (!product.isEmpty()) {
                addToKit(Product.getProductInstance(product));
    ;        }
        }
    }

    public Map<Product, Integer> getKit() {
        return kit;
    }

    @Override
    public int getKitSize() {
        return this.kit.size();
    }

    @Override
    public void addToKit(Product plant) {
        if (plant == null) throw new RuntimeException(" в наборе должны находиься товары");
        int count = (int) this.kit.getOrDefault(plant, 0);
        Integer put = (Integer) kit.put(plant, ++count);

    }

    @Override
    public Integer getPlantAmount(Product product) {
        return (Integer) kit.get(product);
    }


    @Override
    public Iterator<Product> iterator() {
        return kit.keySet().iterator();
    }
}