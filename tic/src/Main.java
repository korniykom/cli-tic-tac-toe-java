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