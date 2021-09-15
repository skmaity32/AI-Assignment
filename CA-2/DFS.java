/**
 *      Name : Sandip Kumar Maity
 *      Roll : 001911001032
 *      Department : Information Technology (UG-3)
 *      Semester : 5
 * 
 *      Program Description :
 *          1. Draw a graph (Minimum node is 10)
 *          2. Generate adjacency matrix of the graph.
 *          2. Matrix will be written in a File and will be given as input.
 *          3. There will be one source node and one destination node as input.
 *          4. The output will be the path from source to destination following DFS.
 * 
 *      Compilation :
 *          javac DFS.java
 * 
 *      Execution :
 *          java DFS
 * 
 *      Sample Input :
 *        10
 *        0 1 0 0 1 0 0 0 0 0
 *        1 0 1 0 0 0 0 0 0 0
 *        0 1 0 1 1 0 0 0 0 0
 *        0 0 1 0 0 1 1 0 0 0
 *        1 0 1 0 0 0 0 0 0 0
 *        0 0 0 1 0 0 0 0 1 0
 *        0 0 0 1 0 0 0 1 0 0
 *        0 0 0 0 0 0 1 0 1 1
 *        0 0 0 0 0 1 0 1 0 0
 *        0 0 0 0 0 0 0 1 0 0
 *        4 9
 * 
 *      Sample Output :
 * 
 *        Total number of vertices : 10 (0 to 9)
 *        
 *        Adjacency Matix :
 *        0 1 0 0 1 0 0 0 0 0
 *        1 0 1 0 0 0 0 0 0 0
 *        0 1 0 1 1 0 0 0 0 0
 *        0 0 1 0 0 1 1 0 0 0
 *        1 0 1 0 0 0 0 0 0 0
 *        0 0 0 1 0 0 0 0 1 0
 *        0 0 0 1 0 0 0 1 0 0
 *        0 0 0 0 0 0 1 0 1 1
 *        0 0 0 0 0 1 0 1 0 0
 *        0 0 0 0 0 0 0 1 0 0
 * 
 *        Path from 4 to 9 : 4 --> 0 --> 1 --> 2 --> 3 --> 5 --> 8 --> 7 --> 9
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DFS {
    public static void get_path(int[] parent, int src, int dest, ArrayList<Integer> path) {
        if(dest == src)
            path.add(dest);
        else {
            get_path(parent, src, parent[dest], path);
            path.add(dest);
        }
    }

    public static void dfs(int vertices, int[][] adj_matrix, boolean[] visited, int src, int[] parent) {
        visited[src] = true;
        for(int i = 0; i < vertices; i++) {
            if(adj_matrix[src][i] == 1 && !visited[i]) {
                parent[i] = src;
                dfs(vertices, adj_matrix, visited, i, parent);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File input_file = new File("input_file.txt");
        
        Scanner sc = new Scanner(input_file);
        int vertices = sc.nextInt();
        int[][] adj_matrix = new int[vertices][vertices];

        System.out.println("\nTotal number of vertices : " + vertices + " (" + 0 + " to " + (vertices - 1) + ")");
        System.out.println("\nAdjacency Matix :");
        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                adj_matrix[i][j] = sc.nextInt();
                System.out.print(adj_matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        int src = sc.nextInt();
        int dest = sc.nextInt();
        sc.close();
        
        if(src < 0 || src >= vertices || dest < 0 || dest >= vertices) {
            System.out.println("\nThere is no path between " + src + " and " + dest);
            return;
        }

        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        dfs(vertices, adj_matrix, visited, src, parent);
        
        if(!visited[dest]) {
            System.out.println("\nThere is no path between " + src + " and " + dest);
        } else {
            ArrayList<Integer> path = new ArrayList<>();
            get_path(parent, src, dest, path);

            System.out.print("\nPath from " + src + " to " + dest + " : ");
            for(int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if(i != path.size() - 1)
                    System.out.print(" --> ");
            }
            System.out.println();
        }
    }
}