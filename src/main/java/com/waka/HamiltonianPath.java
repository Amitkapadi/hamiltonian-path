package com.waka;

import java.util.Arrays;

/**
 * Created by canoztokmak on 07/06/2017.
 */
public class HamiltonianPath {
    private final int boardSize;
    private final int vertexCount;
    private final boolean[][] adjacencyMatrix;

    private boolean[] visited;

    public HamiltonianPath(int boardSize) {
        this.boardSize = boardSize;
        this.vertexCount = boardSize * boardSize;
        this.adjacencyMatrix = generateAdjacencyMatrix();
    }

    public static void printPath(int boardSize, int path[]) {
        for (int i : path) {
            int x = i % boardSize;
            int y = i / boardSize;
            System.out.print("(" + x + "," + y + ") ");
        }
        System.out.println();
    }

    private boolean solver(int[] path, int position) {
        // base case for recursion.. path completed if vertexCount is equal to position
        if (position == vertexCount) {
            return true;
        }

        for (int v = 0; v < vertexCount; v++) {
            // check if v can be added to path
            if (isSafe(v, path, position)) {
                // add v to path
                path[position] = v;
                visited[v] = true;

                // recursively solve for next position
                if (solver(path, position+1)) {
                    return true;
                }

                // backtrack if no vertex can be added to path after v
                path[position] = -1;
                visited[v] = false;
            }
        }

        return false;
    }

    int[] findPath(int x, int y) {
        // reset visited array
        visited = new boolean[this.vertexCount];
        int[] path = new int[vertexCount];

        Arrays.fill(path, -1);

        path[0] = positionToVertex(x, y);
        visited[path[0]] = true;

        if (!solver(path, 1)) {
            return null;
        } else {
            return path;
        }
    }

    private int positionToVertex(int x, int y) {
        return y * boardSize + x;
    }

    private boolean isSafe(int v, int[] path, int position) {
        // safe, if two vertices are adjacent and the target is not visited..
        return adjacencyMatrix[path[position-1]][v] && !visited[v];
    }

    // generate adjacency matrix for given board size
    private boolean[][] generateAdjacencyMatrix() {
        boolean[][] adjMatrix = new boolean[vertexCount][vertexCount];

        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (0 <= x - 3) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x-3, y)] = true;
                }

                if (x + 3 < boardSize) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x+3, y)] = true;
                }

                if (0 <= y - 3) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x, y-3)] = true;
                }

                if (y + 3 < boardSize) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x, y+3)] = true;
                }

                if (0 <= x - 2 && 0 <= y - 2) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x-2, y-2)] = true;
                }

                if (0 <= x - 2 && y + 2 < boardSize) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x-2, y+2)] = true;
                }

                if (x + 2 < boardSize && 0 <= y - 2) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x+2, y-2)] = true;
                }

                if (x + 2 < boardSize && y + 2 < boardSize) {
                    adjMatrix[positionToVertex(x, y)][positionToVertex(x+2, y+2)] = true;
                }
            }
        }

        return adjMatrix;
    }
}
