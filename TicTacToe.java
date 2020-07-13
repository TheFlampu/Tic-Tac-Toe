package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private static char[][] cell;
    private Scanner scanner = new Scanner(System.in);

    public void play() {
        while (!action()) {
            while (true) {
                player1.turn();
                drawCell();
                if (checkWin('X', cell)) {
                    System.out.println("X wins");
                    break;
                }
                if (checkFull(cell)) {
                    System.out.println("Draw!");
                    break;
                }


                player2.turn();
                drawCell();
                if (checkWin('O', cell)) {
                    System.out.println("O wins");
                    break;
                }
                if (checkFull(cell)) {
                    System.out.println("Draw!");
                    break;
                }
            }
        }
    }

    public boolean action() {
        cell = new char[][] {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        while (true) {
            String action;
            String arg1 ;
            String arg2;
            System.out.println("Input command: ");
            String[] command = scanner.nextLine().split(" ");
            try {
                action = command[0];
                if (action.equals("exit")) return true;
                arg1 = command[1];
                arg2 = command[2];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Bad parameters!");
                continue;
            }

            if ("start".equals(action)) {
                player1 = createPlayer(arg1, 'X');
                player2 = createPlayer(arg2, 'O');
            }

            drawCell();
            return false;
        }
    }

    private Player createPlayer(String name, char sign) {
        switch (name) {
            case "easy" : return new Easy(sign);
            case "medium" : return new Medium(sign);
            case "hard" : return new Hard(sign);
            default: return new Human(sign);
        }
    }

    private void drawCell() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print( " " + cell[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static boolean checkOccupied(char[][] board, int x, int y) {
        return board[x][y] != ' ';
    }

    public static void turn(int x, int y, char sign) {
        cell[x][y] = sign;
    }

    public static char[][] getCell() {
        char[][] copyCell = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(cell[i], 0, copyCell[i], 0, 3);
        }
        return copyCell;
    }

    public static boolean checkFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkOccupied(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char sing, char[][] cell) {
        for (int i = 0; i < 3; i++) {
            if ((cell[0][i] == sing && cell[1][i] == sing && cell[2][i] == sing) ||
                    (cell[i][0] == sing && cell[i][1] == sing && cell[i][2] == sing) ||
                    (cell[0][0] == sing && cell[1][1] == sing && cell[2][2] == sing) ||
                    (cell[0][2] == sing && cell[1][1] == sing && cell[2][0] == sing)) {
                return true;
            }
        }
        return false;
    }
}