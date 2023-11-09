package org.example;

public abstract class Toy {
    private final int id;
    private final String name;
    private int count;
    private int winChance;

    protected Toy(int id, String name, int winChance) {
        this.id = id;
        this.name = name;
        this.winChance = winChance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWinChance() {
        return winChance;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public void reduceCount(){
        this.count--;
    }
    public void raiseCount() {
        this.count++;
    }
    public String toString(){
        return String.format("\"%s\"\n\"Артикул\":\"№%d\"\n", this.getName(), this.getId());
    }
}
