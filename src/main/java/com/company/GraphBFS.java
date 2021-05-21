package com.company;
import java.util.Queue;

import java.util.*;
public class GraphBFS {
    Graph<String> graphNow = new Graph<String>();
    private Graph graph = null;

    public GraphBFS(Graph grf) {
        graph = grf;
    }

    // prev[v] = previous vertex on shortest path from s to v
    // dist[v] = length of shortest path from s to v
    private HashMap<String, String>  prev = new HashMap<>();
    private HashMap<String, Integer> dist = new HashMap<>();
    private int[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue

    // repeated remove next vertex v from queue and insert
// all its neighbors, provided they haven't yet been visited

    // Utility function to return the size of the queue
    public int size() {
        return count;
    }



    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        return (size() == 0);
    }
    public void dequeue()
    {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing " + arr[front]);

        front = (front + 1) % capacity;
        count--;
    }
    public void enqueue(String item)
    {
        // check for queue overflow
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting " + item);

        rear = (rear + 1) % capacity;
        arr[rear] = Integer.parseInt(item);
        count++;
    }
    // Utility function to check if the queue is full or not
    public Boolean isFull() {
        return (size() == capacity);
    }
    /**
     * Returns the set of vertices adjacent to v in this graph.
     *
     * @param  v the vertex
     * @return the set of vertices adjacent to vertex {@code v} in this graph
     * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
     */
    public Iterable<String> adjacentTo(String v) {
        validateVertex(v);
        return graph.get(v);
    }
    // throw an exception if v is not a vertex
    private void validateVertex(String v) {
        if (!graph.hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }
    // function to print the shortest distance and path
    // between source vertex and destination vertex
    public static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, String source, int destination, int v) {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        String pred[] = new String[0];
        int dist[] = new int[v];

//        if (BFS(adj, source, destination, v, pred, dist) == false) {
//            System.out.println("Given source and destination" +
//                    "are not connected");
//            return;
//        }

        // LinkedList to store path
//        LinkedList<String> path = new LinkedList<String>();
//        int crawl = destination;
//        path.add(crawl);
//        while (pred[crawl] != null) {
//            path.add(pred[crawl]);
//            crawl = pred[crawl];
//        }
//
//        // Print distance
//        System.out.println("Shortest path length is: " + dist[Integer.parseInt(destination)]);

//        // Print path
//        System.out.println("Path is ::");
//        for (int i = path.size() - 1; i >= 0; i--) {
//            System.out.print(path.get(i) + " ");
//        }
    }
    // a modified version of BFS that stores predecessor
//    // of each vertex in array pred
//    // and its distance from source in array dist
    public static boolean BFS(ArrayList<ArrayList<Integer>> adj, String src, String dest, int v, int pred[], int dist[]) {
        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean visited[] = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
//        visited[src] = true;
//        dist[src] = 0;
//        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    // stopping condition (when we find
                    // our destination)
//                    if (adj.get(u).get(i) == dest)
//                        return true;
                }
            }
        }
        return false;

    }


    // run BFS in graph G from given source vertex s
    public GraphBFS(Graph G, String s) {

        // put source on the queue
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> distance =  new LinkedList<>();
        //boolean visited[] = new boolean[v];


        enqueue(s);
        dist.put(s, 0);

        while (!queue.isEmpty()) {
            String v = queue.poll();
            for (String w : adjacentTo(v)) {
                if (!dist.containsKey(w)) {
                    enqueue(w);
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
        }
    }

    // is v reachable from the source s?
    public boolean hasPathTo(String v) {
        return dist.containsKey(v);
    }

    // return the length of the shortest path from v to s
    public int distanceTo(String v) {
        if (!hasPathTo(v)) return Integer.MAX_VALUE;
        return dist.get(v);
    }
    // return the length of the shortest path from v to s
//    public ArrayList distanceToo(String v) {
//        if (!hasPathTo(v)) return ;
//        return dist.get(v);
    //}

    // return the shortest path from v to s as an Iterable
    public Iterable<String> pathTo(String v) {
        Stack<String> path = new Stack<String>();
        while (v != null && dist.containsKey(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }


    public static void main(String[] args) {
//        String filename  = args[0];
//        String delimiter = args[1];
//        Graph G = new Graph(filename, delimiter);
//        String s = args[2];
//        PathFinder pf = new PathFinder(G, s);
//        while (!StdIn.isEmpty()) {
//            String t = StdIn.readLine();
//            for (String v : pf.pathTo(t)) {
//                StdOut.println("   " + v);
//            }
//            StdOut.println("distance " + pf.distanceTo(t));
//        }
    }

}

