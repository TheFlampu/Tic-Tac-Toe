package tictactoe;

public class Hard extends Player {
    char enemySign = sign == 'O' ? 'X' : 'O';
    public Hard(char sign) {
        super(sign);
    }

    @Override
    void turn() {
        int bestVal = Integer.MIN_VALUE;
        int bestX = -1;
        int bestY = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(!TicTacToe.checkOccupied(TicTacToe.getCell(), i, j)) {
                    TicTacToe.turn(i, j, sign);

                    int moveVal = minIMax(TicTacToe.getCell(), false);

                    TicTacToe.turn(i, j, ' ');

                    if (moveVal > bestVal) {
                        bestX = i;
                        bestY = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        System.out.println("Лучший ход " + bestVal + " " + bestX + " " + bestY);

        TicTacToe.turn(bestX, bestY, sign);
    }

    int minIMax (char[][] board, boolean isMax) {
        if (TicTacToe.checkWin(sign, board)) {
            return 10;
        } else if (TicTacToe.checkWin(enemySign, board)) {
            return -10;
        } else if (TicTacToe.checkFull(board)) {
            return 0;
        }

        if (isMax) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!TicTacToe.checkOccupied(board, i, j)) {
                        board[i][j] = sign;
                        best = Math.max(best, minIMax(board, false));
                        board[i][j] = ' ';
                    }
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!TicTacToe.checkOccupied(board, i, j)) {
                        board[i][j] = enemySign;
                        best = Math.min(best, minIMax(board, true));
                        board[i][j] = ' ';
                    }
                }
            }
            return best;
        }
    }
}