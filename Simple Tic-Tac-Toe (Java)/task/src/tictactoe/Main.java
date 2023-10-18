package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String symbolsString = "_________";
        int xCount = 0;
        int oCount = 0;
        boolean winnerFound = false;
        int xWinCount = 0;
        int oWinCount = 0;
        char whosTurn = 'X';
        boolean validInput = true;
        for (int i = 0; i < symbolsString.length(); i++) {
            if (symbolsString.charAt(i) == 'X') {
                xCount++;
            }
            if (symbolsString.charAt(i) == 'O') {
                oCount++;
            }
        }

        char[] symbolArr = symbolsString.toCharArray();
        for (int i = 0; i < symbolArr.length; i++) {
            if (symbolArr[i] == '_') {
                symbolArr[i] = ' ';
            }
        }
        char[][] arrSymbols2D = new char[3][3];

        int x = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrSymbols2D[i][j] = symbolArr[x++];
            }
        }

        printGrid(arrSymbols2D);
        String coordinate = "";
        while (true) {

            coordinate = scanner.nextLine();

            try {
                Integer.parseInt(coordinate.replace(" ", ""));
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }


            do {
                int row = Integer.parseInt(String.valueOf(coordinate.charAt(0)));
                int col = Integer.parseInt(String.valueOf(coordinate.charAt(2)));
                if ((row < 1 || row > 3) || (col < 0 || col > 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    coordinate = scanner.nextLine();
                } else {
                    break;
                }
            } while (true);


            validInput = turn(coordinate, arrSymbols2D, whosTurn, validInput);
            if (!validInput) {
                continue;
            } else {
                printGrid(arrSymbols2D);
            }
            whosTurn = whosTurn == 'X' ? 'O' : 'X';

            //check horizontal win
            if (arrSymbols2D[0][0] != ' ' && arrSymbols2D[0][0] == arrSymbols2D[0][1] && arrSymbols2D[0][1] == arrSymbols2D[0][2]) {
                winnerFound = true;
                if (arrSymbols2D[0][0] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            if (arrSymbols2D[1][0] != ' ' && arrSymbols2D[1][0] == arrSymbols2D[1][1] && arrSymbols2D[1][1] == arrSymbols2D[1][2]) {
                winnerFound = true;
                if (arrSymbols2D[1][0] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            if (arrSymbols2D[2][0] != ' ' && arrSymbols2D[2][0] == arrSymbols2D[2][1] && arrSymbols2D[2][1] == arrSymbols2D[2][2]) {
                winnerFound = true;
                if (arrSymbols2D[2][0] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            // check vertical win
            if (arrSymbols2D[0][0] != ' ' && arrSymbols2D[0][0] == arrSymbols2D[1][0] && arrSymbols2D[1][0] == arrSymbols2D[2][0]) {
                winnerFound = true;
                if (arrSymbols2D[0][0] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            if (arrSymbols2D[0][1] != ' ' && arrSymbols2D[0][1] == arrSymbols2D[1][1] && arrSymbols2D[1][1] == arrSymbols2D[2][1]) {
                winnerFound = true;
                if (arrSymbols2D[0][1] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            if (arrSymbols2D[0][2] != ' ' && arrSymbols2D[0][2] == arrSymbols2D[1][2] && arrSymbols2D[1][2] == arrSymbols2D[2][2]) {
                winnerFound = true;
                if (arrSymbols2D[0][2] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            // check diagonal win
            if (arrSymbols2D[0][0] != ' ' && arrSymbols2D[0][0] == arrSymbols2D[1][1] && arrSymbols2D[1][1] == arrSymbols2D[2][2]) {
                winnerFound = true;
                if (arrSymbols2D[0][0] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            if (arrSymbols2D[0][2] != ' ' && arrSymbols2D[0][2] == arrSymbols2D[1][1] && arrSymbols2D[1][1] == arrSymbols2D[2][0]) {
                winnerFound = true;
                if (arrSymbols2D[0][2] == 'X') {
                    xWinCount++;
                } else {
                    oWinCount++;
                }
                break;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(arrSymbols2D[i][j]);
                }
            }
//            System.out.println(sb);
            String symbolsStringUpdated = sb.toString();
//            System.out.println(symbolsStringUpdated);
            if (!winnerFound && !symbolsStringUpdated.contains(" ")) {
                System.out.println("Draw");
                break;
            }
        }
        if (winnerFound) {
            System.out.println(xWinCount > oWinCount ? "X wins" : "O wins");
        }

    }

    public static boolean turn(String coordinate, char[][] arrSymbols2D, char whosTurn, boolean validInput) {
        int row = Integer.parseInt(String.valueOf(coordinate.charAt(0)));
        int col = Integer.parseInt(String.valueOf(coordinate.charAt(2)));
        if (arrSymbols2D[row-1][col-1] == 'X' || arrSymbols2D[row-1][col-1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            validInput = false;
        } else {
            validInput = true;
            if (whosTurn == 'X') {
                arrSymbols2D[row-1][col-1] = 'X';
            } else {
                arrSymbols2D[row-1][col-1] = 'O';
            }
        }
        return validInput;
}

    public static char[][] printGrid( char[][] arrSymbols2D) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arrSymbols2D[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
        return arrSymbols2D;
    }
}
