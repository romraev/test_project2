package org.example;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements DataInput{
    Scanner scanner = new Scanner(System.in);
    @Override
    public String inputName() {
        return processInput("Как тебя зовут?: ");
    }

    @Override
    public String processInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void welcome() {
        System.out.println("Добро пожаловать!");
    }

    @Override
    public int menuChoice() {
        while(true){
            try {
                return Integer.parseInt(processInput("\nВыберете пункт меню: \n 1. Играть \n 2. Показать мой выигрыш \n 3. Сохранить выигрыш \n 4. Показать количество игрушек в автомате \n 5. Доложить игрушки \n 6. Выйти"));
            } catch (RuntimeException e) {
                System.out.println("Ошибка ввода, введите число от 1 до 6");
            }
        }
    }

    @Override
    public int toyChoice() throws RuntimeException {
        try {
            return Integer.parseInt(processInput("\nКакую игрушку вы хотите доложить?: \n 1. Слона \n 2. Тигра \n 3. Медвежонка \n 4. Какашку \n 5. Выйти"));
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void goodbye() {
        System.out.println("До свидания!");
    }

    @Override
    public void addSuccessful() {
        System.out.println("Игрушка успешно добавлена!");
    }

    @Override
    public void start() {
        System.out.println("Запускаем игру!");
    }

    @Override
    public void congrats(String toyName) {
        System.out.println("\nПоздравляем! Вы выиграли: " + toyName);
    }

    @Override
    public void sorry() {
        System.out.println("Кажется игрушек осталось мало :(\nУдачи в следующий раз!");
    }

    @Override
    public void inputError() {
        System.out.println("Ошибка ввода, введите цифру из меню!");
    }

    @Override
    public void showList(List<Toy> toyList) {
        for (Toy toy : toyList) {
            System.out.println(String.format("Игрушка: %s, Количество: %d", toy.getName(), toy.getCount()));
        }
    }

}
