/*
Name: Peter Wang
Date: August 25th, 2021
School: Bayview Secondary School
Subject: Extended Essay
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.math.*;

public class finalSPFA {
    public static final int mx = (int) Math.pow(10, 3) - 1, d = (int) Math.pow(10, 3) - 1;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double trials = in.nextDouble(), sum = 0.00;
        for(int f = 0; f < (int) trials; f++) {
            PrintWriter pw = new PrintWriter("test-data.txt");
            pw.println(mx +  " " + mx);

            for(int i = 0; i < mx; i++) {
                pw.println(GenerateRandInt(mx) + " " + GenerateRandInt(mx) + " " + GenerateRandInt(d));
            }
            pw.close();

            long start = System.nanoTime();
            long initialMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            Scanner sc = new Scanner(new File("test-data.txt"));

            int V = sc.nextInt(), E = sc.nextInt();
            ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<Edge>());
            }
            int dis[] = new int[V + 1];
            Arrays.fill(dis, 0x3f3f3f3f);
            boolean inQ[] = new boolean[V + 1];
            Arrays.fill(inQ, false);

            for (int i = 1; i <= E; i++) {
                int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
                adj.get(u).add(new Edge(v, w));
                adj.get(v).add(new Edge(u, w));
            }

            LinkedList<Integer> q = new LinkedList<Integer>();
            dis[1] = 0;
            inQ[1] = true;
            q.add(1);

            while (!q.isEmpty()) {
                int u = q.poll();
                inQ[u] = false;
                for (Edge e : adj.get(u)) {
                    if (dis[u] + e.w < dis[e.v]) {
                        dis[e.v] = dis[u] + e.w;
                        if(inQ[e.v] == false) {
                            q.add(e.v);
                            inQ[e.v] = true;
                        }
                    }
                }
            }
//            for (int i = 0; i < V; i++) {
//                if(dis[i] == 0x3f3f3f3f) {
//                    System.out.println("Dist to " + i + " is: " + -1);
//                }
//            else System.out.println("Dist to " + i + " is: " + dis[i]);
//            }
            long end = System.nanoTime();
            long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
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
    public static class Edge {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
