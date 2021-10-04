/**
 *      Name : Sandip Kumar Maity
 *      Roll : 001911001032
 *      Department : Information Technology (UG-3)
 *      Semester : 5
 *      Assignment 5: Implement A star algorithm for eight puzzle problem
 * 
 *      Program Description :
 *          Consider two heuristic functions (h1(n) and h2(n)) along with g(n) and execute the algorithm both 
 *          the times with h1 and g and then h2 and g.
 *          Compare the result of both the run and write the document.
 * 
 *          Things to submit:
 *          1. Algorithm implementation
 *          2. Screenshots of the output
 *          3. Document describing heuristic and output along with the understanding of the outputs for both the cases.
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

    public int hamming(BoardState goal) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0)
                    continue;
                if (tiles[i][j] != goal.tiles[i][j])
                    ans++;
            }
        }
        return ans;
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

