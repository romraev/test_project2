package org.example;

import java.util.List;

public interface DataInput {
    String inputName();
    String processInput(String message);
    void welcome();
    int menuChoice();
    int toyChoice();
    void goodbye();
    void addSuccessful();
    void start();
    void congrats(String toyName);
    void sorry();
    void inputError();
    void showList(List<Toy> toyList);

}
