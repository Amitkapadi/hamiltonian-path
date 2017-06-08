# hamiltonian-path

### Problem description

A pawn can move on NxN (5 <= N <= 10) chequerboard horizontally, vertically and diagonally by these rules:

1) 3 tiles moving North (N), West (W), South (S) and East (E)

2) 2 tiles moving NE, SE, SW and NW

3) Moves are only allowed if the ending tile exists on the board

4) Starting from initial position, the pawn can visit each cell only once

This repository finds at least one path for the pawn to visit all tiles on the board following the above rules, starting from any tile.

### Solution

Since, finding the Hamiltonian Path is a NP-complete problem, in the worst case running time complexity is O(N!).

Backtracking algorithm is used to find a possible path.

Initially, an adjacency matrix is generated according to the rules provided in the description section.
Then, from the user provided entry point, the algorithm tries to find a possible path using backtracking. 
If it finds a valid path, prints the results and terminates.

### Instructions

1) Clone the repository.

2) Navigate into the directory using terminal.

3) Run the below maven command.

        mvn package

4) Run the program using the command below.
        
        java -jar target/hamilton-1.0.0.jar

### Sample output

    Enter board dimension size between 5-10 ?
    8
    Enter entry point ? (x,y) - Space separated two integers..
    2 4
    Calculating path.. Please wait, it may take a while..
    (2,4) (2,1) (5,1) (3,3) (3,0) (0,0) (2,2) (4,0) (1,0) (3,2) (5,0) (2,0) (0,2) (0,5) (2,3) (0,1) (3,1) (6,1) (4,3) (1,3) (3,5) (5,3) (7,1) (4,1) (1,1) (1,4) (3,6) (0,6) (0,3) (2,5) (5,5) (7,7) (7,4) (5,2) (7,0) (7,3) (7,6) (5,4) (7,2) (7,5) (5,7) (2,7) (4,5) (6,7) (6,4) (4,6) (1,6) (3,4) (5,6) (2,6) (0,4) (0,7) (3,7) (1,5) (1,2) (4,2) (6,0) (6,3) (6,6) (4,4) (6,2) (6,5) (4,7) (1,7) 
    It took 2588 ms to compute..