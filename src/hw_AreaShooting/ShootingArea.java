package hw_AreaShooting;

import java.util.Arrays;
import java.util.Scanner;

public class ShootingArea {
    static int fieldSize = 5;
    static int[][] gameField = new int[fieldSize][fieldSize];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PrintField printField = new PrintField(fieldSize, gameField);
        setTarget();

        System.out.println("All Set. Get ready to rumble!");
        printField.print();

        while (true) {
            int row = scanCoordToShoot(true);
            int column = scanCoordToShoot(false);
            boolean isTargetHit = shoot(row, column);

            printField.print();

            if (isTargetHit) {
                System.out.println("You have won!");
                return;
            }
        }
    }

    static private int scanCoordToShoot(boolean isRow) {
        while (true) {
            System.out.printf("Enter %s to shoot: \n", isRow ? "row" : "column");
            String enteredValue = scanner.nextLine();

            if (Validator.isInt(enteredValue)) {
                int enteredNumber = Integer.parseInt(enteredValue);

                if (enteredNumber > 0 && enteredNumber <= fieldSize) {
                    return enteredNumber - 1;
                }
            }
        }
    }

    static private boolean shoot(int row, int column) {
        boolean isTargetCoords = gameField[row][column] == CellCodes.targetCode;
        gameField[row][column] = isTargetCoords ? CellCodes.hitCode : CellCodes.shotCode;

        return isTargetCoords;
    }

    private static void setTarget() {
        int randomRow = (int) (Math.random() * 4) + 1;
        int randomColumn = (int) (Math.random() * 4) + 1;

        for (int row = 0; row < fieldSize; row++) {
            Arrays.fill(gameField[row], 0);
            if (row == randomRow) {
                gameField[randomRow][randomColumn] = CellCodes.targetCode;
            }
        }
    }


}
