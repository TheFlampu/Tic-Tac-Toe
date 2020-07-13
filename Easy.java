package tictactoe;

public class Easy extends Player{
    public Easy(char sign) {
        super(sign);
    }

    @Override
    void turn() {
        System.out.println("Making move level \"easy\"");
        while (true) {
            int y = random.nextInt(3);
            int x = random.nextInt(3);

            if (TicTacToe.checkOccupied(TicTacToe.getCell(), x, y)) continue;

            TicTacToe.turn(x, y, sign);
            break;
        }
    }
}
