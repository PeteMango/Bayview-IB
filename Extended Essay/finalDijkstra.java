import java.util.*;
import java.io.*;

class Graph {
    class Edge implements Comparable<Edge>{
        int node;
        int weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    int N;
    ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
    boolean[] visited;
    int[] distance;
    //	HashMap<Edge,Integer> dup = new HashMap<>();
    Graph(int N) {
        this.N = N;
        visited = new boolean[N];
        distance = new int[N];
        for (int i = 0; i < N; i++) {
            adj.add(new LinkedList<>());
        }
    }
    void add(int source, int dest, int weight) {
//		dup.put(new Edge(source,dest),weight);
        adj.get(source).add(new Edge(dest,weight));
        adj.get(dest).add(new Edge(source,weight));
        //prune input as it comes in
    }
    void dijkstra(int root) {
        PriorityQueue<Edge> q = new PriorityQueue<>();

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[root] = 0;
        q.add(new Edge(root,0));

        while (!q.isEmpty()) {
            int a = q.remove().node;
            if (visited[a]) continue;
            visited[a] = true;

            for (Edge e: adj.get(a)) {
                int b = e.node;
                int w = e.weight;
                if (distance[a] +w < distance[b]) {
                    distance[b] = distance[a] + w;
                    q.add(new Edge(b,distance[b]));
                }
            }
        }
    }
}

public class finalDijkstra {
    public static final int mx = (int) Math.pow(10, 3) - 1, d = (int) Math.pow(10, 3) - 1;
    public static double sum = 0.0;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double trials = in.nextDouble();
        for(int f = 0; f < (int) trials; f++) {
            PrintWriter pw = new PrintWriter("test-data.txt");
            pw.println(mx +  " " + mx);

            for(int i = 0; i < mx; i++) {
                pw.println(GenerateRandInt(mx) + " " + GenerateRandInt(mx) + " " + GenerateRandInt(d));
            }
            pw.close();

            long start = System.nanoTime(); // track start time
            long initialMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // track start memory
            Scanner sc = new Scanner(new File("test-data.txt"));
            int N = sc.nextInt(), M = sc.nextInt();
            Graph g = new Graph(N+1);
//		g.dijkstra(2);
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
                g.add(u,v,w);
            }

            g.dijkstra(1);
//            for (int i = 1; i <= N; i++) {
//                if (g.distance[i] == Integer.MAX_VALUE) {
//                    System.out.println(-1);
//                }
//                else {
//                    System.out.println(g.distance[i]);
//                }
//            }
            long end = System.nanoTime(); // track the final time
            long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // track final memory
            System.out.println("Trial: " + f);
            System.out.println(roundNum((end-start)/Math.pow(10, 9)));
            System.out.println("Memory: " + (finalMemory - initialMemory));
            sum += (end-start)/Math.pow(10, 9);
            System.out.println();
        }
        System.out.println("Average: " + roundNum(sum/trials));
    }
    public static double roundNum (double x) {
        return Math.round(x * 100000.0) / 100000.0;
    }
    public static int GenerateRandInt(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }
}