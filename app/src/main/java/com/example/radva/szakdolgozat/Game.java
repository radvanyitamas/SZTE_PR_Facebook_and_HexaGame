package com.example.radva.szakdolgozat;

import java.util.HashMap;

public class Game {

    int id;
    int GameNumber;
    String validMezo;

    public Game() {}


    public Game(int id, int gameNumber, String validMezo) {
        this.id = id;
        GameNumber = gameNumber;
        this.validMezo = validMezo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameNumber() {
        return GameNumber;
    }

    public void setGameNumber(int gameNumber) {
        GameNumber = gameNumber;
    }

    public String getValidMezo() {
        return validMezo;
    }

    public void setValidMezo(String validMezo) {
        this.validMezo = validMezo;
    }

}
