/**
 *      Name : Sandip Kumar Maity
 *      Roll : 001911001032
 *      Department : Information Technology (UG-3)
 *      Semester : 5
 * 
 *      Program Description :
 *          1. Implement the iterative deepening algorithm
 *          2. Execute the implementation on the attached graph with depth 5
 *          3. Execute the previously implemented DFS with depth 5 on the same graph presented here.
 *          4. For both points 2 and 3, the graph will be written in a file and not in the program implementation
 *          5. Write a document based on your observations of output 2 and the difference between the outputs of points 2 and 3.
 * 
 *      Compilation :
 *          javac DFS.java
 * 
 *      Execution :
 *          java DFS
 * 
 *      Sample Input :
 *        12 5
 *        a  0  0  0  0  0  0  0  0  0  0  0  0
 *        b  1  0  0  0  0  0  0  0  0  0  0  0
 *        c  1  0  0  0  0  0  0  0  0  0  0  0
 *        d  0  1  1  0  1  0  0  0  0  0  0  0
 *        e  0  0  0  0  0  0  0  1  0  0  1  0
 *        f  0  0  1  0  0  0  1  0  0  0  0  0
 *        G  0  0  0  0  0  0  0  0  0  0  0  0
 *        h  0  0  0  0  0  0  0  0  1  1  0  0
 *        p  0  0  0  0  0  0  0  0  0  1  0  0
 *        q  0  0  0  0  0  0  0  0  0  0  0  0
 *        r  0  0  0  0  0  1  0  0  0  0  0  0
 *        S  0  0  0  1  1  0  0  0  1  0  0  0
 *        S G
 * 
 *      Sample Output :
 *        Total number of nodes : 12
 *        List of nodes : a(0), b(1), c(2), d(3), e(4), f(5), G(6), h(7), p(8), q(9), r(10), S(11)
 * 
 *        Source :      S
 *        Destination : G
 * 
 *        Adjacency Matix :
 *        0 0 0 0 0 0 0 0 0 0 0 0
 *        1 0 0 0 0 0 0 0 0 0 0 0
 *        1 0 0 0 0 0 0 0 0 0 0 0
 *        0 1 1 0 1 0 0 0 0 0 0 0
 *        0 0 0 0 0 0 0 1 0 0 1 0
 *        0 0 1 0 0 0 1 0 0 0 0 0 
 *        0 0 0 0 0 0 0 0 0 0 0 0
 *        0 0 0 0 0 0 0 0 1 1 0 0
 *        0 0 0 0 0 0 0 0 0 1 0 0
 *        0 0 0 0 0 0 0 0 0 0 0 0
 *        0 0 0 0 0 1 0 0 0 0 0 0
 *        0 0 0 1 1 0 0 0 1 0 0 0
 * 
 *        S --> depth: 0
 *        d --> depth: 1
 *        b --> depth: 2
 *        a --> depth: 3
 *        c --> depth: 2
 *        e --> depth: 2
 *        h --> depth: 3
 *        p --> depth: 4
 *        q --> depth: 4
 *        r --> depth: 3
 *        f --> depth: 4
 *        G not found!
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DFS {
    public static boolean dfs(int vertices, int[][] adj_matrix, boolean[] visited, int src, int dest, int depth, int max_depth, String[] nodes) {
        if (depth > max_depth)
            return false;
        
        visited[src] = true;
        System.out.println(nodes[src] + " --> depth: " + depth);
        
        if (src == dest) {
            System.out.println(nodes[dest] + " found!");
            return true;
        }

        if (depth == max_depth)
            return false;
        
        for(int i = 0; i < vertices; i++) {
            if(adj_matrix[src][i] == 1 && !visited[i]) {
                if (dfs(vertices, adj_matrix, visited, i, dest, depth + 1, max_depth, nodes))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File input_file = new File("input_file.txt");
        Scanner sc = new Scanner(input_file);

        int vertices = sc.nextInt();
        int max_depth = sc.nextInt();
        int[][] adj_matrix = new int[vertices][vertices];

        String[] nodes = new String[vertices];
        for(int i = 0; i < vertices; i++) {
            nodes[i] = sc.next();
            for(int j = 0; j < vertices; j++) {
                adj_matrix[i][j] = sc.nextInt();
            }
        }
        
        String src = sc.next();
        String dest = sc.next();
        sc.close();

        System.out.println("Total number of nodes : " + vertices);
        System.out.print("List of nodes         : ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(nodes[i] + "(" + i + ")");
            if (i != vertices - 1)
                System.out.print(", ");
        }
        System.out.println();
        System.out.println("\nSource      : " + src);
        System.out.println("Destination : " + dest);

        System.out.println("\nAdjacency Matix :");
        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                System.out.print(adj_matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        int src_idx = -1;
        int dest_idx = -1;
        for (int i = 0; i < vertices; i++) {
            if (nodes[i].equals(src))
                src_idx = i;
            if (nodes[i].equals(dest))
                dest_idx = i;
        }

        if (src_idx == -1 || dest_idx == -1) {
            System.out.println("\nThere is no path between " + src + " and " + dest);
            return;
        }

        boolean[] visited = new boolean[vertices];
        if (!dfs(vertices, adj_matrix, visited, src_idx, dest_idx, 0, max_depth - 1, nodes)) {
            System.out.println(dest + " not found!");
        } 
    }
}
