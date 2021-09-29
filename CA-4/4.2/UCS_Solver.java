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
 *          javac UCS_Solver.java
 * 
 *      Execution :
 *          java UCS_Solver
 * 
 *      Sample Input :
 *          1 2 3
 *          8 6 4
 *          7 5 0
 * 
 *          1 2 3
 *          8 0 4
 *          7 6 5
 * 
 *      Sample Output :
 *          States from start to goal :
 *          1 2 3 
 *          8 6 4
 *          7 5 0
 * 
 *          1 2 3
 *          8 6 4
 *          7 0 5
 *          
 *          1 2 3
 *          8 0 4
 *          7 6 5
 *          
 *          Total no. of moves to solve the puzzle : 2
*/

import java.util.*;
import java.io.*;

public class UCS_Solver {
    private ArrayList<BoardState> path = null;

    private class StateNode implements Comparable<StateNode> {
        final BoardState board;
        final int moves;
        final StateNode prev;
        final int priority;

        StateNode(BoardState board, int moves, StateNode prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            this.priority = moves;
        }

        @Override
        public int compareTo(StateNode that) {
            return Integer.compare(this.priority, that.priority);
        }
    }

    public UCS_Solver(BoardState start, BoardState goal) {
        PriorityQueue<StateNode> pq = new PriorityQueue<>();
        pq.offer(new StateNode(start, 0, null));
        
        PriorityQueue<StateNode> twin_pq = new PriorityQueue<>();
        twin_pq.offer(new StateNode(start.twin(), 0, null));

        while (!pq.isEmpty()) {
            StateNode curr_state = pq.poll();
            if (curr_state.board.equals(goal)) {
                path = new ArrayList<>();
                for (StateNode i = curr_state; i != null; i = i.prev) 
                    path.add(i.board);
                Collections.reverse(path);
                break;
            }

            for (BoardState nbr : curr_state.board.neighbors()) {
                if (curr_state.prev == null || !nbr.equals(curr_state.prev.board)) {
                    pq.offer(new StateNode(nbr, curr_state.moves + 1, curr_state));
                }
            }

            curr_state = twin_pq.poll();

            if (curr_state.board.equals(goal)) {
                break;
            }

            for (BoardState nbr : curr_state.board.neighbors()) {
                if (curr_state.prev == null || !nbr.equals(curr_state.prev.board)) {
                    twin_pq.offer(new StateNode(nbr, curr_state.moves + 1, curr_state));
                }
            }
        }
    }

    public boolean hasPath() {
        return path != null;
    }
    
    public List<BoardState> getPath() {
        return path;
    }

    public int getMoves() {
        if (path == null) return -1;
        return path.size() - 1;
    }

    public static void main(String args[]) throws FileNotFoundException {
        File input_file = new File("input_file.txt");
        Scanner sc = new Scanner(input_file);
        
        int[][] start_state = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                start_state[i][j] = sc.nextInt(); 
            }
        }

        int[][] end_state = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                end_state[i][j] = sc.nextInt(); 
            }
        }
        sc.close();

        UCS_Solver solver = new UCS_Solver(new BoardState(start_state), new BoardState(end_state));
        if (solver.hasPath()) {
            System.out.println("States from start to goal :");
            for (BoardState b: solver.path)
                System.out.println(b);
            System.out.println("Total no. of moves to solve the puzzle : " + solver.getMoves());
        } else {
            System.out.println("Puzzle can not be solved!");
        }
    }
}
