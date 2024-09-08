public class Main {
    public static void main(String[] args) {
        char[][] field = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'},
        };

        printField(field);
    }

    static void printField(char[][] field) {
        for(int row = 0; row < field.length; row++) {
            for(int col = 0; col < field[0].length; col++) {
                System.out.printf("%c ", field[row][col] );
            }
            System.out.println();
        }
    }

}