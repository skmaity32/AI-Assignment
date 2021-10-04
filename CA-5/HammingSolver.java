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
 *          javac HammingSolver.java
 *      
 *      Execution :
 *          java HammingSolver
 * 
 *      Sample Input :
 *          1 2 3
 *          8 6 4
 *          7 5 0
 * 
 *          0 2 8
 *          1 4 3
 *          7 6 5
 * 
 *      Sample Output :
 *          Iteration #1     -->     h2(n) + g(n) = 6
 *          Iteration #2     -->     h2(n) + g(n) = 6
 *          Iteration #3     -->     h2(n) + g(n) = 6
 *          Iteration #4     -->     h2(n) + g(n) = 6
 *          Iteration #5     -->     h2(n) + g(n) = 6
 *          Iteration #6     -->     h2(n) + g(n) = 7
 *          Iteration #7     -->     h2(n) + g(n) = 7
 *          Iteration #8     -->     h2(n) + g(n) = 7
 *          Iteration #9     -->     h2(n) + g(n) = 7
 *          Iteration #10    -->     h2(n) + g(n) = 8
 *          Iteration #11    -->     h2(n) + g(n) = 8
 *          Iteration #12    -->     h2(n) + g(n) = 8
 *          Iteration #13    -->     h2(n) + g(n) = 8
 *          Iteration #14    -->     h2(n) + g(n) = 8
 *          Iteration #15    -->     h2(n) + g(n) = 9
 *          Iteration #16    -->     h2(n) + g(n) = 9
 *          Iteration #17    -->     h2(n) + g(n) = 9
 *          Iteration #18    -->     h2(n) + g(n) = 9
 *          Iteration #19    -->     h2(n) + g(n) = 9
 *          Iteration #20    -->     h2(n) + g(n) = 9
 *          Iteration #21    -->     h2(n) + g(n) = 9
 *          Iteration #22    -->     h2(n) + g(n) = 9
 *          Iteration #23    -->     h2(n) + g(n) = 9
 *          Iteration #24    -->     h2(n) + g(n) = 9
 *          Iteration #25    -->     h2(n) + g(n) = 9
 *          Iteration #26    -->     h2(n) + g(n) = 10
 *          Iteration #27    -->     h2(n) + g(n) = 10
 *          Iteration #28    -->     h2(n) + g(n) = 10
 *          Iteration #29    -->     h2(n) + g(n) = 10
 *          Iteration #30    -->     h2(n) + g(n) = 10
 *          Iteration #31    -->     h2(n) + g(n) = 10
 *          Iteration #32    -->     h2(n) + g(n) = 10
 *          Iteration #33    -->     h2(n) + g(n) = 10
 *          Iteration #34    -->     h2(n) + g(n) = 10
 *          Iteration #35    -->     h2(n) + g(n) = 10
 *          Iteration #36    -->     h2(n) + g(n) = 10
 *          Iteration #37    -->     h2(n) + g(n) = 10
 *          Iteration #38    -->     h2(n) + g(n) = 10
 *          Iteration #39    -->     h2(n) + g(n) = 10
 *          Iteration #40    -->     h2(n) + g(n) = 10
 *          Iteration #41    -->     h2(n) + g(n) = 10
 *          Iteration #42    -->     h2(n) + g(n) = 10
 *          Iteration #43    -->     h2(n) + g(n) = 10
 *          Total no. of Iterations : 43
 * 
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
 *          1 2 3
 *          0 8 4
 *          7 6 5
 * 
 *          0 2 3
 *          1 8 4
 *          7 6 5
 * 
 *          2 0 3 
 *          1 8 4
 *          7 6 5
 * 
 *          2 8 3
 *          1 0 4
 *          7 6 5
 * 
 *          2 8 3
 *          1 4 0
 *          7 6 5
 * 
 *          2 8 0
 *          1 4 3
 *          7 6 5
 * 
 *          2 0 8
 *          1 4 3
 *          7 6 5
 * 
 *          0 2 8
 *          1 4 3
 *          7 6 5
 * 
 *          Total no. of moves to solve the puzzle : 10
*/

import java.util.*;
import java.io.*;

public class HammingSolver {
    private ArrayList<BoardState> path = null;

    private class StateNode implements Comparable<StateNode> {
        final BoardState board;
        final int moves;
        final StateNode prev;
        final int priority;

        StateNode(BoardState board, int moves, BoardState goal, StateNode prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            this.priority = board.hamming(goal) + moves;
        }

        @Override
        public int compareTo(StateNode state) {
            return Integer.compare(this.priority, state.priority);
        }
    }

    public HammingSolver(BoardState start, BoardState goal) {
        PriorityQueue<StateNode> pq = new PriorityQueue<>();
        pq.offer(new StateNode(start, 0, goal, null));
        
        PriorityQueue<StateNode> twin_pq = new PriorityQueue<>();
        twin_pq.offer(new StateNode(start.twin(), 0, goal, null));

        int iteration = 0;
        
        while (!pq.isEmpty()) {
            iteration++;
            StateNode curr_state = pq.poll();
            System.out.println("Iteration #" + iteration + "\t -->\t h2(n) + g(n) = " + curr_state.priority);

            if (curr_state.board.equals(goal)) {
                path = new ArrayList<>();
                for (StateNode i = curr_state; i != null; i = i.prev) 
                    path.add(i.board);
                Collections.reverse(path);
                break;
            }

            for (BoardState nbr : curr_state.board.neighbors()) {
                if (curr_state.prev == null || !nbr.equals(curr_state.prev.board)) {
                    pq.offer(new StateNode(nbr, curr_state.moves + 1, goal, curr_state));
                }
            }

            curr_state = twin_pq.poll();

            if (curr_state.board.equals(goal)) {
                break;
            }

            for (BoardState nbr : curr_state.board.neighbors()) {
                if (curr_state.prev == null || !nbr.equals(curr_state.prev.board)) {
                    twin_pq.offer(new StateNode(nbr, curr_state.moves + 1, goal, curr_state));
                }
            }
        }
        System.out.println("Total no. of Iterations : " + iteration + "\n");
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

        HammingSolver solver = new HammingSolver(new BoardState(start_state), new BoardState(end_state));
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

