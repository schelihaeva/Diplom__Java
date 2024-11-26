package gb.intermediate.example;

import java.util.*;

public class Product implements Plant, Comparable<Plant>{
    private String name;
    private final int nameLength;

    private static Map<String, Product> product;
    static {
      product = new HashMap<>();
    }

    private Product(String name) {
        this.name = name;
        nameLength = name.length();
    }

    /**
     * Метод фабрика
     * @param name  название товара
     * @return экземпляр класса Product
     */
    public static Product getProductInstance(String name){
        return product.getOrDefault(name, new Product(name));
    }

    public String getName() {
        return name;
    }

    @Override
    public int getNameLength() {
        return nameLength;
    }

    @Override
    public int compareTo(Plant o) {
        int otherNameLength = o.getNameLength();
        return Integer.compare(this.nameLength, otherNameLength);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Товар %s",name);
    }
}