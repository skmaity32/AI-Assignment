/**
 *      Name : Sandip Kumar Maity
 *      Roll : 001911001032
 *      Department : Information Technology (UG-3)
 *      Semester : 5
 *      Assignment 4.1: UCS and Iterative lengthening Search
 * 
 *      Program Description :
 *          Implement both the algorithms and apply them to instances of the graph given for the traveling 
 *          in Romania problems. Compare the algorithm's performance between uniform-cost search and 
 *          Iterative Lengthening search, and comment on your results.
 * 
 *          Things to do:
 *          1. Implement both the algorithms
 *          2. Execute both the implementations on traveling in Romania problem.
 *          3. Write a document based on your observations of outputs of point 2 and compare and comment on the output.
 * 
 *      Compilation :
 *          javac ILS.java
 * 
 *      Execution :
 *          java ILS
 * 
 *      Sample Input :
 *          20
 *          Arad Bucharest
 *          Arad              0   75    0  118    0    0    0  140    0    0    0    0    0    0    0    0    0    0    0    0
 *          Zerind           75    0   71    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0
 *          Oradea            0   71    0    0    0    0    0  151    0    0    0    0    0    0    0    0    0    0    0    0
 *          Timisoara       118    0    0    0  111    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0
 *          Lugoj             0    0    0  111    0   70    0    0    0    0    0    0    0    0    0    0    0    0    0    0
 *          Mehadia           0    0    0    0   70    0   75    0    0    0    0    0    0    0    0    0    0    0    0    0
 *          Dobreata          0    0    0    0    0   75    0    0    0    0  120    0    0    0    0    0    0    0    0    0
 *          Shibiu          140    0  151    0    0    0    0    0   80    0    0   99    0    0    0    0    0    0    0    0
 *          Rimnicu-Vilcea    0    0    0    0    0    0    0   80    0   97  146    0    0    0    0    0    0    0    0    0
 *          Pitesti           0    0    0    0    0    0    0    0   97    0  138    0  101    0    0    0    0    0    0    0
 *          Craiova           0    0    0    0    0    0  120    0  146  138    0    0    0    0    0    0    0    0    0    0
 *          Fagaras           0    0    0    0    0    0    0   99    0    0    0    0  211    0    0    0    0    0    0    0
 *          Bucharest         0    0    0    0    0    0    0    0    0  101    0  211    0   90   85    0    0    0    0    0
 *          Giurgiu           0    0    0    0    0    0    0    0    0    0    0    0   90    0    0    0    0    0    0    0
 *          Urziceni          0    0    0    0    0    0    0    0    0    0    0    0   85    0    0  142    0    0   98    0
 *          Vaslui            0    0    0    0    0    0    0    0    0    0    0    0    0    0  142    0   92    0    0    0
 *          Iasi              0    0    0    0    0    0    0    0    0    0    0    0    0    0    0   92    0   87    0    0
 *          Neamt             0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0   87    0    0    0
 *          Hirsova           0    0    0    0    0    0    0    0    0    0    0    0    0    0   98    0    0    0    0   86
 *          Eforie            0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0   86    0
 * 
 *      Sample Output :
 *          Total number of nodes : 20
 *          List of nodes :
 *          Arad (0)
 *          Zerind (1)
 *          Oradea (2)
 *          Timisoara (3)
 *          Lugoj (4)
 *          Mehadia (5)
 *          Dobreata (6)
 *          Shibiu (7)
 *          Rimnicu-Vilcea (8)
 *          Pitesti (9)
 *          Craiova (10)
 *          Fagaras (11)
 *          Bucharest (12)
 *          Giurgiu (13)
 *          Urziceni (14)
 *          Vaslui (15)
 *          Iasi (16)
 *          Neamt (17)
 *          Hirsova (18)
 *          Eforie (19)
 * 
 *          Source      : Arad
 *          Destination : Bucharest
 * 
 *          <<< Cost Limit : 0 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 * 
 *          Average size of priority queue per iterations : 1.0
 * 
 *          <<< Cost Limit : 75 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Processed node : Zerind
 * 
 *          Average size of priority queue per iterations : 1.0
 * 
 *          <<< Cost Limit : 118 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Processed node : Zerind
 *          Processed node : Timisoara
 * 
 *          Average size of priority queue per iterations : 1.3333333333333333
 * 
 *          <<< Cost Limit : 140 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Processed node : Timisoara
 *          Processed node : Shibiu
 * 
 *          Average size of priority queue per iterations : 1.75
 * 
 *          <<< Cost Limit : 146 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Processed node : Shibiu
 *          Processed node : Oradea
 * 
 *          Average size of priority queue per iterations : 2.0
 * 
 *          <<< Cost Limit : 220 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Processed node : Shibiu
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 * 
 *          Average size of priority queue per iterations : 2.0
 * 
 *          <<< Cost Limit : 229 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Processed node : Lugoj
 * 
 *          Average size of priority queue per iterations : 2.2857142857142856
 * 
 *          <<< Cost Limit : 239 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Added node : Fagaras => Cost : 239
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Processed node : Lugoj
 *          Processed node : Fagaras
 * 
 *          Average size of priority queue per iterations : 2.5
 * 
 *          <<< Cost Limit : 291 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Oradea => Cost : 291
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Added node : Fagaras => Cost : 239
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Processed node : Lugoj
 *          Processed node : Fagaras
 * 
 *          Average size of priority queue per iterations : 2.7777777777777777
 * 
 *          <<< Cost Limit : 299 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Oradea => Cost : 291
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Added node : Fagaras => Cost : 239
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Processed node : Lugoj
 *          Added node : Mehadia => Cost : 299
 *          Processed node : Fagaras
 *          Processed node : Mehadia
 * 
 *          Average size of priority queue per iterations : 2.8
 * 
 *          <<< Cost Limit : 317 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Oradea => Cost : 291
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Added node : Fagaras => Cost : 239
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Added node : Pitesti => Cost : 317
 *          Processed node : Lugoj
 *          Added node : Mehadia => Cost : 299
 *          Processed node : Fagaras
 *          Processed node : Mehadia
 *          Processed node : Pitesti
 * 
 *          Average size of priority queue per iterations : 3.0
 * 
 *          <<< Cost Limit : 366 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Oradea => Cost : 291
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Added node : Fagaras => Cost : 239
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Added node : Pitesti => Cost : 317
 *          Added node : Craiova => Cost : 366
 *          Processed node : Lugoj
 *          Added node : Mehadia => Cost : 299
 *          Processed node : Fagaras
 *          Processed node : Mehadia
 *          Processed node : Pitesti
 *          Processed node : Craiova
 * 
 *          Average size of priority queue per iterations : 3.25
 * 
 *          <<< Cost Limit : 374 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Oradea => Cost : 291
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Added node : Fagaras => Cost : 239
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Added node : Pitesti => Cost : 317
 *          Added node : Craiova => Cost : 366
 *          Processed node : Lugoj
 *          Added node : Mehadia => Cost : 299
 *          Processed node : Fagaras
 *          Processed node : Mehadia
 *          Added node : Dobreata => Cost : 374
 *          Processed node : Pitesti
 *          Processed node : Craiova
 *          Processed node : Dobreata
 * 
 *          Average size of priority queue per iterations : 3.230769230769231
 * 
 *          <<< Cost Limit : 418 >>>
 *          Added node : Arad => Cost : 0
 *          Processed node : Arad
 *          Added node : Zerind => Cost : 75
 *          Added node : Timisoara => Cost : 118
 *          Added node : Shibiu => Cost : 140
 *          Processed node : Zerind
 *          Added node : Oradea => Cost : 146
 *          Processed node : Timisoara
 *          Added node : Lugoj => Cost : 229
 *          Processed node : Shibiu
 *          Added node : Oradea => Cost : 291
 *          Added node : Rimnicu-Vilcea => Cost : 220
 *          Added node : Fagaras => Cost : 239
 *          Processed node : Oradea
 *          Processed node : Rimnicu-Vilcea
 *          Added node : Pitesti => Cost : 317
 *          Added node : Craiova => Cost : 366
 *          Processed node : Lugoj
 *          Added node : Mehadia => Cost : 299
 *          Processed node : Fagaras
 *          Processed node : Mehadia
 *          Added node : Dobreata => Cost : 374
 *          Processed node : Pitesti
 *          Added node : Bucharest => Cost : 418
 *          Processed node : Craiova
 *          Processed node : Dobreata
 *          Processed node : Bucharest
 * 
 *          Average size of priority queue per iterations : 3.2142857142857144
 * 
 *          Cost : 418
 *          Required Path : Arad --> Shibiu --> Rimnicu-Vilcea --> Pitesti --> Bucharest
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ILS {
    private static class Node implements Comparable<Node> {
        private int cost;
        private int u;
        private int v;

        public Node(int cost, int u, int v) {
            this.cost = cost;
            this.u = u;
            this.v = v;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }
    
    public static int solve_ucs(int adj_matrix[][], int vertices, int src_idx, int dest_idx, String[] nodes, int cost_limit, Bool flag) {
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        
        boolean[] visited = new boolean[vertices];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, -1, src_idx));
        System.out.println("\nAdded node : " + nodes[src_idx] + " => Cost : " + 0);
        
        int cost = 0;
        int total_size_of_pq = 0;
        int total_iterations = 0;
        int min_rejected_cost = 0;

        while (!pq.isEmpty()) {
            total_size_of_pq += pq.size();
            total_iterations++;

            Node node = pq.poll();
            if (visited[node.v])
                continue;
            
            visited[node.v] = true;
            System.out.println("Processed node : " + nodes[node.v]);
            int u = node.v;
            parent[node.v] = node.u;

            if (u == dest_idx) {
                cost = node.cost;
                flag.val = true;
                break;
            }

            for (int v = 0; v < vertices; v++) {
                if (adj_matrix[u][v] != 0 && !visited[v]) {
                    if (node.cost + adj_matrix[u][v] > cost_limit) {
                        if (min_rejected_cost == 0)
                            min_rejected_cost = node.cost + adj_matrix[u][v];
                        else 
                            min_rejected_cost = Math.min(min_rejected_cost, node.cost + adj_matrix[u][v]);
                    }
                    else {
                        pq.offer(new Node(node.cost + adj_matrix[u][v], u, v));
                        System.out.println("Added node : " + nodes[v] + " => Cost : " + (node.cost + adj_matrix[u][v]));
                    }
                }
            }
        }
        System.out.println("\nAverage size of priority queue per iterations : " + (double)total_size_of_pq/total_iterations);

        if (!visited[dest_idx] || cost > min_rejected_cost) {
            return min_rejected_cost;
        }

        ArrayList<String> path = new ArrayList<>();
        int i = dest_idx;
        
        while (i != src_idx) {
            path.add(nodes[i]);
            i = parent[i];
        }
        path.add(nodes[src_idx]);

        Collections.reverse(path);
        System.out.println("\nCost : " + cost);
        System.out.print("Required Path : ");

        for (int j = 0; j < path.size(); j++) {
            System.out.print(path.get(j));
            if (j < path.size() - 1)
                System.out.print(" --> ");
        }
        System.out.println();
        return min_rejected_cost;
    }

    private static class Bool {
        boolean val;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File input_file = new File("input_file.txt");
        Scanner sc = new Scanner(input_file);

        int vertices = sc.nextInt();
        int[][] adj_matrix = new int[vertices][vertices];

        String[] nodes = new String[vertices];
        String src = sc.next();
        String dest = sc.next();

        for(int i = 0; i < vertices; i++) {
            nodes[i] = sc.next();
            for(int j = 0; j < vertices; j++) {
                adj_matrix[i][j] = sc.nextInt();
            }
        }
        
        sc.close();

        System.out.println("Total number of nodes : " + vertices);
        System.out.print("List of nodes :\n");
        for (int i = 0; i < vertices; i++) {
            System.out.println(nodes[i] + " (" + i + ")");
        }
        System.out.println();
        System.out.println("Source      : " + src);
        System.out.println("Destination : " + dest);
        
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

        int cost_limit = 0;
        Bool flag = new Bool();
        while (!flag.val) {
            System.out.print("\n<<< Cost Limit : " + cost_limit + " >>>");
            cost_limit = solve_ucs(adj_matrix, vertices, src_idx, dest_idx, nodes, cost_limit, flag);
        }
    }
}