import java.util.Scanner;

/**
 * This class represents a Minesweeper game.
 */
public class Minesweeper {
    /**
     * The main method to run the Minesweeper game.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldNumber = 1;

        while (true) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            if (rows == 0 && cols == 0) break;

            scanner.nextLine(); // Consume newline character
            char[][] field = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                field[i] = line.toCharArray();
            }

            Minefield minefield = new Minefield(rows, cols);
            minefield.setField(field);

            System.out.println("Field #" + fieldNumber + ":");
            System.out.print(minefield.calculateHints());

            fieldNumber++;
        }

        scanner.close();
    }
}