package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private List<Toy> winList = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        this.winList.add(new Elefants(0));
        this.winList.add(new Tigers(0));
        this.winList.add(new TeddyBear(0));
        this.winList.add(new Poop(0));
    }

    public String getName() {
        return name;
    }

    public List<Toy> getWinList() {
        return winList;
    }

}
