import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] field = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'},
        };

        getInput(field);
        printField(field);
        System.out.println(analyzeField(field));

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

    static void getInput(char[][] field) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        char[] arrayInput = input.toCharArray();
        for( int row = 0; row < field.length; row++) {
            for(int col = 0; col < field[0].length;  col++) {
                field[row][col] = arrayInput[row * 3 + col];
            }
        }


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