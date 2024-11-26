package gb.intermediate.project;

import gb.intermediate.example.Kit;

/**
 * показываем перечень товаров для послыки
 */
public class GameVirtualCountProduct implements Calculate<Kit> {

    @Override
    public void calculate(Kit kit) {
        System.out.printf("Перечень товаров для послыки - %s%n", kit.getKitSize());
    }

}