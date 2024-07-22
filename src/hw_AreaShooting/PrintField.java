package hw_AreaShooting;

public class PrintField {
    private int fieldSize;
    private int[][] gameField;

    PrintField(int fieldSize, int[][] gameField){
        this.fieldSize = fieldSize;
        this.gameField = gameField;
    }

    public void print() {
        for (int row = 0; row < fieldSize; row++) {
            if (row == 0) printHeading();
            printRow(row);
        }
    }

    private void printHeading() {
        StringBuilder stringToPrint = new StringBuilder(transformCellForPrint(String.valueOf(0)));

        for (int column = 0; column < fieldSize; column++) {
            stringToPrint.append(transformCellForPrint(String.valueOf(column + 1)));
        }

        System.out.println(stringToPrint);
    }

    private void printRow(int row) {
        String rowIdxToPrint = String.valueOf(row + 1);

        StringBuilder stringToPrint = new StringBuilder(transformCellForPrint(rowIdxToPrint));

        for (int column = 0; column < fieldSize; column++) {
            stringToPrint.append(transformCellForPrint(getCellValueToPrint(gameField[row][column])));
        }

        System.out.println(stringToPrint);
    }

    public static String getCellValueToPrint(int cellValue) {
        if (cellValue == CellCodes.shotCode) {
            return "*";
        }
        if (cellValue == CellCodes.hitCode) {
            return "X";
        }
        return "-";

    }

    private static String transformCellForPrint(String value) {
        return String.format("%s | ", value);
    }

}
