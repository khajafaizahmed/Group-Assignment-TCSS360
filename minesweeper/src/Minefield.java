/**
 * This class represents a Minefield in the Minesweeper game.
 */
class Minefield {
    private char[][] myField;
    private final int myRows;
    private final int myCols;

    /**
     * Constructs a Minefield with the specified number of rows and columns.
     *
     * @param theRows The number of rows in the Minefield.
     * @param theCols The number of columns in the Minefield.
     */
    public Minefield(int theRows, int theCols) {
        myRows = theRows;
        myCols = theCols;
        myField = new char[myRows][myCols];
    }

    /**
     * Sets the field configuration of the Minefield.
     *
     * @param theField The field configuration represented as a 2D char array.
     */
    public void setField(char[][] theField) {
        myField = theField;
    }

    /**
     * Calculates the hints for the Minefield based on mine positions.
     *
     * @return A string representation of the hints for each cell in the Minefield.
     */
    public String calculateHints() {
        StringBuilder hints = new StringBuilder();
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myCols; j++) {
                if (myField[i][j] == '*') {
                    hints.append("*");
                } else {
                    hints.append(countMines(i, j));
                }
            }
            hints.append("\n");
        }
        return hints.toString();
    }

    private int countMines(int theRow, int theCol) {
        int count = 0;
        for (int i = Math.max(0, theRow - 1); i <= Math.min(myRows - 1, theRow + 1); i++) {
            for (int j = Math.max(0, theCol - 1); j <= Math.min(myCols - 1, theCol + 1); j++) {
                if (myField[i][j] == '*' && !(i == theRow && j == theCol)) {
                    count++;
                }
            }
        }
        return count;
    }
}