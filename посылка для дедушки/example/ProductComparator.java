package gb.intermediate.example;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getNameLength(),o2.getNameLength());
    }
}