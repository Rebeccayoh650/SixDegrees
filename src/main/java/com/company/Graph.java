package com.company;// Java program to implement Graph
// with the help of Generics

import java.util.*;

/**
 * this class build the graph using a generic type
 * graph using hashmap and adjaceny list
 * @param <T>
 */


class Graph<T> {


    // We use Hashmap to store the edges in the graph
    public Map<T, Set<T>> adjList = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s) {
        adjList.put(s, new HashSet<>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source, T destination, boolean bidirectional) {

        // 1 -> 2, 3,4
        // 2 -> 3,4, 5

        if (!adjList.containsKey(source))
            addVertex(source);

//        if (!adjList.containsKey(destination))
//            addVertex(destination);

//        if (!adjList.get(source).contains(destination)) {
            adjList.get(source).add(destination);
//        }
//        if (bidirectional == true && !adjList.get(destination).contains(source)) {
//            adjList.get(destination).add(source);
//        }
    }

    //index of grpah elements
    public int getIndex(String vertex) {
        //System.out.println(Arrays.toString(names));
        //System.out.println(vertex);
        for (int i = 0; i < adjList.size(); i++)
            if (vertex.equals(adjList.get(i)))
                return i;

        return -1;
    }






    // This function gives whether
    // a vertex is present or not.
    public boolean hasVertex(T s) {
        if (adjList.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
            return true;
        } else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
        return false;
    }




    // Prints the adjancency list of each vertex.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : adjList.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : adjList.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }


    public Set<T> get(T key) {
        if (key == null) throw new IllegalArgumentException("called get() with null key");
        return adjList.get(key);
    }


    //breadth first search b eing performed on graph
    //given parameters will be the graph and two strings
    public void bfs(Graph graph, String source, String destination) {


        Hashtable<String, String> alreadyVisited = new Hashtable<String, String>();
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> shortestPath = new ArrayList<String>();
        Hashtable<String, Boolean> seen = new Hashtable<String, Boolean>();

        String current = source;
//        queue.enqueue(current);
        queue.add(current);
        seen.put(current, true);


        while (!queue.isEmpty()) {
//
            current = (String) queue.poll();

            if (!current.equals(destination)) {

                for (Object neighbour : graph.get(current)) {

                    if (seen.get(neighbour) == null ||seen.get(neighbour) == false) {
                        queue.add((String) neighbour);
                        //testing
                        //queue.add((String) neighbour);
                        seen.put((String) neighbour, true);
                        alreadyVisited.put((String) neighbour, current);
                        //testing
                        //shortestPath.add((String) neighbour);
                    }
                }
            }
            //testing
            // Jake Sully
            // Sam Worthington
            else {
                return;
            }
        }
        String destinationNew = destination;
        shortestPath.add(destination);
        destinationNew = alreadyVisited.get(destinationNew);

        //since void function ill be printing the shortest path
        System.out.println(shortestPath);;

    }

}
//check Check if addiction to linked list ifin
//Debug for neighbour


// key [value ]
//rebecca yohannnes: [hiking, reading]
// rak abc :[hiking, reading]
//Jared Leto
//Josh Brolin
//seen.get(neighbour) == false

