import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] field = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        getLayout(field, scanner);
        printField(field);
        makeMove(field, 'X', scanner);
        printField(field);

//        System.out.println(analyzeField(field));

        scanner.close();
    }

    static void getLayout(char[][] field, Scanner scanner) {

        String input = scanner.nextLine();

        char[] arrayInput = input.toCharArray();
        for( int row = 0; row < field.length; row++) {
            for(int col = 0; col < field[0].length;  col++) {
                field[row][col] = arrayInput[row * 3 + col];
            }
        }
    }


    static void makeMove(char[][] field, char character, Scanner scanner) {
        while(true) {
            String move = scanner.nextLine();
            String[] splitMove = move.split(" ");

            if (splitMove.length > 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row;
            int col;

            try {
                row = Integer.parseInt(splitMove[0]);
                col = Integer.parseInt(splitMove[1]);

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (col > 3 || col < 1 || row > 3 || row < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if(field[row - 1][col - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            field[row - 1][col - 1] = character;
            break;
        }

    }

    static String analyzeField(char[][] field) {
        boolean xWin = false;
        boolean oWin = false;
        int xCount = 0;
        int oCount = 0;

        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[0].length; j++) {
                if(field[i][j] == 'X') {
                    xCount++;
                } else if (field[i][j] == 'O') {
                    oCount++;
                }
            }
            if(field[i][0] == 'X' && field[i][1] == 'X' && field[i][2] == 'X' ) {
                xWin = true;
            } else if (field[0][i] == 'X' && field[1][i] == 'X' && field[2][i] == 'X' ){
                xWin = true;
            }
            if(field[i][0] == 'O' && field[i][1] == 'O' && field[i][2] == 'O' ) {
                oWin = true;
            } else if(field[0][i] == 'O' && field[1][i] == 'O' && field[2][i] == 'O' ) {
                oWin = true;
            }
        }
        if((field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') || (field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X') ) {
            xWin = true;
        }
        if((field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') || (field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O') ) {
            oWin = true;
        }

        if((xWin && oWin) || (Math.abs(xCount - oCount) > 1 )) {
            return "Impossible";
        }
        if(xWin) {
            return "X wins";
        } else if(oWin) {
            return  "O wins";
        }
        if(xCount + oCount != 9){
            return "Game not finished";
        }
        return "Draw";
    }


    static void printField(char[][] field) {
        System.out.println("---------");
        for(int row = 0; row < field.length; row++) {
            System.out.print("| ");
            for(int col = 0; col < field[0].length; col++) {
                System.out.printf("%c ", field[row][col] );
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

}