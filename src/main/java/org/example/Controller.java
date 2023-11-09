package org.example;

public class Controller {

    public static void start(){
        DataInput input = new ConsoleInput();
        DataSaver saver = new JsonSaver();
        LotteryMachine lm = new LotteryMachine(input);
        input.welcome();
        Player player = new Player(input.inputName());
        boolean flag = true;
        while(flag){
            int choice = input.menuChoice();
            switch (choice){
                case 1 -> {
                    if(!lm.play(player)) input.sorry();
                }
                case 2 -> input.showList(player.getWinList());
                case 3 -> saver.savePrize(player);
                case 4 -> input.showList(lm.getToys());
                case 5 -> lm.addToy();
                case 6 -> {
                    input.goodbye();
                    flag = false;
                }
                default -> input.inputError();
            }
        }

    }
}
