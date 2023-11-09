package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LotteryMachine {
    private DataInput input;
    private ArrayList<Toy> toys = new ArrayList<>();
    private Random randomizer = new Random();

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public LotteryMachine(DataInput input) {
        this.input = input;
        this.toys.add(new Elefants(5));
        this.toys.add(new Tigers(5));
        this.toys.add(new TeddyBear(5));
        this.toys.add(new Poop(5));
    }

    public boolean play(Player player) {
        this.input.start();
        int[] ranges = new int[this.toys.size() + 1];
        for (int i = 1; i < ranges.length; i++) {
            ranges[i] = ((this.toys.get(i - 1).getCount() + 1) * this.toys.get(i - 1).getWinChance()) + ranges[i - 1];
        }
        int chance = randomizer.nextInt(ranges[ranges.length - 1]);
        for (int i = 1; i < ranges.length; i++) {
            if (chance > ranges[i - 1] && chance < ranges[i] && this.toys.get(i - 1).getCount() > 0) {
                player.getWinList().get(i-1).raiseCount();
                this.input.congrats(this.toys.get(i - 1).getName());
                this.toys.get(i - 1).reduceCount();
                return true;
            }
        }
        return false;
    }

    public void addToy() {
        while (true){
            try{
                int choice = this.input.toyChoice();
                switch (choice){
                    case 1 -> {
                        this.toys.get(0).raiseCount();
                        this.input.addSuccessful();
                    }
                    case 2 -> {
                        this.toys.get(1).raiseCount();
                        this.input.addSuccessful();
                    }
                    case 3 -> {
                        this.toys.get(2).raiseCount();
                        this.input.addSuccessful();
                    }
                    case 4 -> {
                        this.toys.get(3).raiseCount();
                        this.input.addSuccessful();
                    }
                    case 5 -> throw new IOException();
                }
            } catch (RuntimeException e){
                input.inputError();
            } catch (IOException e) {
                break;
            }

        }
    }
    

}
