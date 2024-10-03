package javaHomework.homework5;

import java.util.Scanner;

public class SeaBattleGame {

    private static final int FIELD_LENGTH = 11; /**Поменял значение с "10", чтоб не
    возникала ошибка ArrayIndexOutOfBoundsException и легче расставлять корабли с
    появившейся номерацией */

    //Массив кораблей для инициализации, элементы по такому типу {количество_палуб,
    // количество_кораблей}
    private static final int[][] SHIP_DECK_AMOUNT = {{4, 1}, {3, 2}, {2, 3}, {1, 4}};
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter first player's name");
        String playerOne = scanner.nextLine();
        System.out.println("Enter second player's name");
        String playerTwo = scanner.nextLine();

        char[][] playerFieldOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerFieldTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        SeaBattleGame seaBattleGame = new SeaBattleGame();

        System.out.println(playerOne + ", fill your field!");
        seaBattleGame.fillPlayerField(playerFieldOne);
        System.out.println();
        System.out.println();

        System.out.println(playerTwo + ", fill your field!");
        System.out.println();
        seaBattleGame.fillPlayerField(playerFieldTwo);

        System.out.println("Let the game begin!");
        seaBattleGame.startGame(playerOne, playerTwo, playerFieldOne, playerFieldTwo);
    }

    private void fillPlayerField(char[][] playerField) {
        printField(playerField);/** чтоб легче ориентироваться перед расстановкой кораблей */
        for (int i = 0; i < SHIP_DECK_AMOUNT.length; i++) {
            int shipCount = SHIP_DECK_AMOUNT[i][1];
            for (int j = 0; j < shipCount; j++) {
                System.out.println("Put " + SHIP_DECK_AMOUNT[i][0] + " deck ship. Left: "
                        + (shipCount - j));

                int result = 1;
                int x = 0;
                int y = 0;
                int direction = 0;

                while (result != 0) {
                    System.out.println("Input start x (0-9) coordinate:");
                    x = scanner.nextInt();

                    System.out.println("Input start y (0-9) coordinate:");
                    y = scanner.nextInt();

                    System.out.println("Input direction of ship: 1 - horizontal; " +
                            "2 - vertical");
                    direction = scanner.nextInt();

                    result = validateCoordinateForShip(playerField, x, y, direction,
                            SHIP_DECK_AMOUNT[i][0]);/** "i" не передаёт количество палуб,
                    поэтому заменил на SHIP_DECK_AMOUNT[i][0] */
                }

                int shipDeck = SHIP_DECK_AMOUNT[i][0];
                if (direction == 1) {
                    for (int k = 0; k < shipDeck; k++) {
                        playerField[y][x + k] = '=';
                    }
                }
                if (direction == 2) {
                    for (int k = 0; k < shipDeck; k++) {
                        playerField[y + k][x] = '=';
                    }
                }
                printField(playerField);
            }
        }
    }

    private static int validateCoordinateForShip(char[][] field, int x, int y,
                                                 int direction, int shipDeck) {
        if (direction == 1) {
            for (int i = 0; i < shipDeck; i++) /** в случае "shipDeck - 1" метод неисправен */
            {
                if (x > 0) {
                    if ('=' == field[y][x + i - 1]) {
                        return -1;
                    }
                }
                if (y > 0) {
                    if ('=' == field[y - 1][x + i]) {
                        return -1;
                    }
                }
                if ('=' == field[y][x + i] || '=' == field[y][x + i + 1]
                        || '=' == field[y + 1][x + i] || (x + i) > 9) {
                    return -1;
                }
            }
        } else if (direction == 2) {
            for (int i = 0; i < shipDeck; i++) /** то же что и выше */
            {
                if (y > 0) {
                    if ('=' == field[y + i - 1][x]) {
                        return -1;
                    }
                }
                if (x > 0) {
                    if ('=' == field[y + i][x - 1]) {
                        return -1;
                    }
                }
                if ('=' == field[y + i][x] || '=' == field[y + i + 1][x]
                        || '=' == field[y + i][x + 1] || (y + i) > 9) {
                    return -1;
                }
            }
        }
        return 0;
    }

    private void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            if (i == field.length - 1) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(j + "  ");
                }
            } else {
                for (int j = 0; j < field[i].length - 1; j++) {
                    System.out.print(field[i][j] + "  ");
                }
                System.out.print(i);
            }
            System.out.println();
        }
    }


    private void startGame(String playerOne, String playerTwo,
                           char[][] playerFieldOne,
                           char[][] playerFieldTwo) {
        char[][] playerBattleFieldOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerBattleFieldTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        String currentPlayer = playerOne;
        String nextPlayer = playerTwo;

        char[][] currentPlayerEnemyField = playerFieldTwo;
        char[][] nextPlayerEnemyField = playerFieldOne;

        char[][] currentPlayerBattleField = playerBattleFieldOne;
        char[][] nextPlayerBattleField = playerBattleFieldTwo;

        int shotCheck = 1;
        while (shotCheck == 1) {
            System.out.println(currentPlayer + " take a shot!");
            System.out.println("Input x (0-9) coordinate:");
            int x = scanner.nextInt();
            System.out.println("Input y (0-9) coordinate:");
            int y = scanner.nextInt();

            shotCheck = verificationShot(currentPlayerBattleField, currentPlayerEnemyField,
                    x, y);

            printField(currentPlayerBattleField);

            if (!isPlayerAlive(currentPlayerEnemyField)) {
                break;
            }
            if (shotCheck == 0) {

                String tempPlayer = currentPlayer;
                currentPlayer = nextPlayer;
                nextPlayer = tempPlayer;

                char[][] tempPlayerEnemyField = currentPlayerEnemyField;
                currentPlayerEnemyField = nextPlayerEnemyField;
                nextPlayerEnemyField = tempPlayerEnemyField;

                char[][] tempPlayerBattleField = currentPlayerBattleField;
                currentPlayerBattleField = nextPlayerBattleField;
                nextPlayerBattleField = tempPlayerBattleField;

                shotCheck = 1;
            }
        }

        System.out.println("Winner is " + currentPlayer);
    }

    private static int verificationShot(char[][] battleField, char[][] enemyField,
                                        int x, int y) {
        if (enemyField[y][x] == '☓' || enemyField[y][x] == '◦') {
            return 1;
        }
        if (enemyField[y][x] == '=') {
            enemyField[y][x] = '☓';
            battleField[y][x] = enemyField[y][x];
            System.out.println("HIT!");
            return 1;
        } else {
            enemyField[y][x] = '◦';
            battleField[y][x] = enemyField[y][x];
            System.out.println("PAST!");
            return 0;
        }
    }

    private static boolean isPlayerAlive(char[][] field) {
        for (char[] array : field) {
            for (char element : array) {
                if (element == '=') {
                    return true;
                }
            }
        }
        return false;
    }
}
