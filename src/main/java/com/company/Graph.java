package com.company;// Java program to implement Graph
// with the help of Generics

import java.util.*;

class Graph<T> {


    // We use Hashmap to store the edges in the graph
    private Map<T, List<T> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source, T destination, boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        if(!map.get(source).contains(destination)){
            map.get(source).add(destination);
        }


        if (bidirectional == true && !map.get(destination).contains(source) ){
            map.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount()
    {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public boolean hasVertex(T s)
    {
        if (map.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
            return true;
        }
        else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
        return false;
    }


    // This function gives whether an edge is present or not.
    public boolean hasEdge(T s, T d)
    {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
        return true;
    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }


    public boolean areConnected(String vert1, String vert2)
    {
        ArrayList<String> edges = findEdges(vert1);
        return edges.contains(vert2);
    }

    public ArrayList<String> findEdges(String str)
    {
        List<String> edges = (ArrayList<String>) map.get(str);

        if(edges == null)
            throw new RuntimeException(str + " not found in the graph!");

        return (ArrayList<String>) edges;
    }
    public int minDistance(String source, String destination){
        if(source == destination){
            return 0;
        }
        return 0;
    }


    public List<T> get(T key) {
        if (key == null) throw new IllegalArgumentException("called get() with null key");
        return map.get(key);
    }
    public boolean contains(T key) {
        if (key == null) throw new IllegalArgumentException("called contains() with null key");
        return map.containsKey(key);
    }





}


// key [value ]
//rebecca yohannnes: [hiking, reading]
// rak abc :[hiking, reading]


