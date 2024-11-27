package gb.intermediate.controller;

import gb.intermediate.example.Kit;
import gb.intermediate.example.Product;
import gb.intermediate.example.ProductKit;
import gb.intermediate.project.*;

/**
 * Контроллер<br>
 * Метод <strong>run()</strong> для запуска приложения
 */
public class Controller {
    private Calculate<Kit> calculate;
    private Kit<Product> kit;
    ProductKit basket;

    private static final String promptMenu = "1. Перечень товаров в наборе для посылки%n"+
            "2. Сколько всего товаров  в наборе для посылки%n"+
            "3. Самое длинное название товара наборе%n"+
            "4. Самые популярные товары в наборе%n"+
            "5. Самые редкие товары в наборе%n"+
            "0. Выход из приложения%n"+
            "Ввведите свой выбор: ";
    private GetChoice getChoice;
    public Controller() {
        basket = new ProductKit(new LoadProductFromFile("посылка для дедушки/project/input.txt").getRawProduct());
        kit = basket;
    }

    public void run(){
        Integer command = 10;
        getChoice = new GetChoice();
        while (command!=0){
            command = getChoice.getIntChoice(promptMenu);
            calculate = switch (command) {
                case 1 -> new GameVirtualProductKit();
                case 2 -> new GameVirtualCountProduct();
                case 3 -> new GameVirtualLongProductName();
                case 4 -> new GameVirtualSort(false);
                case 5 -> new GameVirtualSort(true);
                default -> null;
            };
            if (calculate!=null) calculate.calculate(kit);
        }
        getChoice.close();

    }
}