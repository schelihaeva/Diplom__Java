package gb.intermediate.controller;


import java.util.Scanner;

public class GetChoice {
    static Scanner scanner = new Scanner(System.in);
    /**
     * Пользователь делает выбор
     *
     * @param prompt приглашение к выбору
     * @return Integer | null
     */
    public Integer getIntChoice(String prompt) {
        System.out.printf(prompt);
        String choice = scanner.next();
        if (choice.matches("\\d+")) {
            return Integer.parseInt(choice);
        }
        return null;
    }

    public String getStrChoice(String prompt){
        System.out.printf(prompt);
        return scanner.next();
    }


    public void close(){
        scanner.close();
    }


}