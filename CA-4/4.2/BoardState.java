/**
 *      Name : Sandip Kumar Maity
 *      Roll : 001911001032
 *      Department : Information Technology (UG-3)
 *      Semester : 5
 *      Assignment 4.2: Use previously developed UCS and Implement BFS (Best First Search)
 * 
 *      Program Description :
 *          Use UCS and BFS (Best FS) to solve 8 puzzle problems.
 *          Where Goal State is:
 *          1 2 3
 *          8 0 4
 *          7 6 5
 *          
 *          Start State is:
 *          1 2 3
 *          8 6 4
 *          7 5 0
 *          
 *          Other example state s can be:
 *          5 4 0
 *          6 1 8
 *          7 3 2
 *          
 *          Heuristic cost functions can be :
 *          h1(N) = Number of misplaced tiles (doesn't include empty tile)
 *          h2(N) = Number of tiles out of rows + Number of tiles out of columns
 *          h3(N) = Sum of the (Manhattan) distances of every tile 
 *                  to its goal position (doesn't include empty tile)
 *          h4(N) = Sum of Eucledian distances of the tiles from their 
 *                  goal positions (doesn't include empty tile)
 * 
 *      Compilation :
 *          javac BoardState.java
*/

import java.util.*;

public class BoardState {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    private final int[][] tiles;
    private final int n;

    public BoardState(int[][] tiles) {
        if (tiles == null)
            throw new IllegalArgumentException("Array cannot be null!");
        n = tiles.length;
        this.tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.tiles[i][j] = tiles[i][j];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public int manhattan(BoardState goal) {
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) 
                    continue;
                map.put(tiles[i][j], i * n + j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (goal.tiles[i][j] == 0) 
                    continue;
                int idx = map.get(goal.tiles[i][j]);
                int dist = Math.abs(i - (idx / n));
                dist += Math.abs(j - (idx % n));
                total += dist;
            }
        } 
        return total;
    }

    public boolean equals(BoardState that) {
        if (this == that) 
            return true;

        if (this.n != that.n) 
            return false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (this.tiles[i][j] != that.tiles[i][j])
                    return false;

        return true;
    }

    public ArrayList<BoardState> neighbors() {
        ArrayList<BoardState> list = new ArrayList<>();
        int x = -1, y = -1;
        for (int i = 0; i < n && x == -1; i++) {
            for (int j = 0; j < n && x == -1; j++) {
                if (tiles[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        for (int k = 0; k < dx.length; k++) {
            int i = x + dx[k];
            int j = y + dy[k];
            if (i < 0 || i >= n || j < 0 || j >= n)
                continue;
            int[][] copy = copyTiles();
            copy[x][y] = copy[i][j];
            copy[i][j] = 0;
            list.add(new BoardState(copy));
        }

        return list;
    }

    public BoardState twin() {
        int[][] copy = copyTiles();

        int one = copy[0][0];
        int two = copy[0][1];
        int three = copy[1][0];

        if (one == 0) {
            copy[1][0] = two;
            copy[0][1] = three;
        } else if (two == 0) {
            copy[0][0] = three;
            copy[1][0] = one;
        } else {
            copy[0][0] = two;
            copy[0][1] = one;
        }

        return new BoardState(copy);
    }

    private int[][] copyTiles() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = tiles[i][j];
            }
        }
        return copy;
    }
}
