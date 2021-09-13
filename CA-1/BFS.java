/**
 *      Name : Sandip Kumar Maity
 *      Roll : 001911001032
 *      Department : Information Technology (UG-3)
 *      Semester : 5
 * 
 *      Program Description :
 *          1. You have to consider an adjacency matrix of your own choice. (minimum number of node is 7). 
 *          2. Matrix will be written in a File and will be given as input. 
 *          3. There will be one source node and one destination node as input. 
 *          4. The output will be the path from source to destination following BFS.
 * 
 *      Compilation :
 *          javac BFS.java
 * 
 *      Execution :
 *          java BFS
 * 
 *      Sample Input :
 *        8
 *        0 1 1 0 0 1 1 0
 *        1 0 0 1 1 0 1 0
 *        0 0 0 0 1 0 1 0
 *        0 0 0 0 1 1 0 0
 *        0 1 1 1 0 1 0 0
 *        0 0 0 1 1 0 0 0
 *        1 1 1 0 0 0 0 0
 *        0 0 0 0 0 0 0 0
 *        2 5
 * 
 *      Sample Output :
 *        Total number of vertices : 8 (0 to 7)
 *        Adjacency Matix :
 *        0 1 1 0 0 1 1 0
 *        1 0 0 1 1 0 1 0
 *        0 0 0 0 1 0 1 0
 *        0 0 0 0 1 1 0 0
 *        0 1 1 1 0 1 0 0
 *        0 0 0 1 1 0 0 0
 *        1 1 1 0 0 0 0 0
 *        0 0 0 0 0 0 0 0
 *        Path from 2 to 5 : 2 --> 4 --> 5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BFS {
    public static void get_path(int[] parent, int src, int dest, ArrayList<Integer> path) {
        if(dest == src)
            path.add(dest);
        else {
            get_path(parent, src, parent[dest], path);
            path.add(dest);
        }
    }

    public static ArrayList<Integer> bfs_path(int vertices, int[][] adj_matrix, int src, int dest) {
        if(src < 0 || src >= vertices || dest < 0 || dest >= vertices)
            return null;
        
        boolean[] visited = new boolean[vertices];

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()) {
            int i = q.poll();
            if(i == dest)
                break;
            else {
                for(int j = 0; j < vertices; j++) {
                    if(adj_matrix[i][j] == 1 && !visited[j]) {
                        parent[j] = i;
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }

        if(!visited[dest])
            return null;    
        ArrayList<Integer> path = new ArrayList<>();
        get_path(parent, src, dest, path);
        return path;
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

        ArrayList<Integer> path = bfs_path(vertices, adj_matrix, src, dest);
        if(path == null) {
            System.out.println("\nThere is no path between " + src + " and " + dest);
        } else {
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