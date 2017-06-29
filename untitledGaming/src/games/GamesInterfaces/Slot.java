package games.GamesInterfaces;

import business.implementation.Interfaces.Game;

public class Slot implements Game {

    private int XP;

    @Override
    public int getXP() {
        return this.XP;
    }

    @Override
    public void setXP(int xp) {
        this.XP = xp;
    }
}
