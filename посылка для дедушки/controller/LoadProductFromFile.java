package gb.intermediate.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoadProductFromFile {
    private String fileName;

    public LoadProductFromFile(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getRawProduct() {
        List<String> productList = new ArrayList<>();
        try {
            // Чтение всего содержимого файла в строку
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            // Разделение строки на слова по пробелам
            String[] productArray = content.split("\\s+");

            // Добавляем каждое слово в список
            for (String product : productArray) {
                productList.add(product);
            }

        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок
        }

        return productList;
    }
}


