package tictactoe;

import java.util.InputMismatchException;

public class Human extends Player {
    public Human(char sign) {
        super(sign);
    }

    @Override
    void turn() {
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int y = scanner.nextInt();
                int x = scanner.nextInt();

                if (x > 3 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                y = Math.abs(y - 1);
                x = Math.abs(x - 3);

                if (TicTacToe.checkOccupied(TicTacToe.getCell(), x, y)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                TicTacToe.turn(x, y, this.sign);
                break;

            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }
}
