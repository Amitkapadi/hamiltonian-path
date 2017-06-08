package com.waka;

import java.util.Scanner;

/**
 * Created by canoztokmak on 07/06/2017.
 */
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter board dimension size between 5-10 ?");
        int boardSize = scanner.nextInt();
        while (10 < boardSize || boardSize < 5) {
            System.out.println("Invalid board size.. Please enter a valid board dimension size..");
            boardSize = scanner.nextInt();
        }

        System.out.println("Enter entry point ? (x,y) - Space separated two integers..");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        while ((boardSize <= x || x < 0) || (boardSize <= y || y < 0)) {
            System.out.println("Invalid (x,y) point.. Please enter a valid entry point..");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }

        long start = System.currentTimeMillis();
        final HamiltonianPath hamiltonianPath = new HamiltonianPath(boardSize);
        System.out.println("Calculating path.. Please wait, it may take a while..");
        final int[] path = hamiltonianPath.findPath(x, y);

        if (path != null) {
            HamiltonianPath.printPath(boardSize, path);
        } else {
            System.out.println("No solution..");
        }

        System.out.println("It took " + (System.currentTimeMillis() - start) + " ms to compute..");

        scanner.close();
    }
}
