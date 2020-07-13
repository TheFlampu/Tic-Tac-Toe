package tictactoe;


public class Medium extends Player {
    public Medium(char sign) {
        super(sign);
    }

    @Override
    void turn() {
        System.out.println("Making move level \"medium\"");

        char enemySign = sign == 'O' ? 'X' : 'O';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[][] copyCell = TicTacToe.getCell();
                if (!TicTacToe.checkOccupied(TicTacToe.getCell(), i, j)) {
                    copyCell[i][j] =  sign;
                    if (TicTacToe.checkWin(sign, copyCell)) {
                        TicTacToe.turn(i, j, sign);
                        return;
                    }
                    copyCell[i][j] = enemySign;
                    if (TicTacToe.checkWin(enemySign, copyCell)) {
                        TicTacToe.turn(i, j, sign);
                        return;
                    }
                }
            }
        }
        while (true) {
            int y = random.nextInt(3);
            int x = random.nextInt(3);

            if (TicTacToe.checkOccupied(TicTacToe.getCell(), x, y)) continue;

            TicTacToe.turn(x, y, sign);
            break;
        }
    }
}

