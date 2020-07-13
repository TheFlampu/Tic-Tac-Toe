package tictactoe;

import java.util.Random;
import java.util.Scanner;

abstract class Player {
    protected char sign;
    protected Scanner scanner = new Scanner(System.in);
    protected Random random = new Random();

    public Player(char sign) {
        this.sign = sign;
    }

    abstract void turn();
}
