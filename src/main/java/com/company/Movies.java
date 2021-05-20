//package com.company;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.Reader;
//import java.util.*;
//
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//
//
//
//import org.json.simple.parser.JSONParser;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//
//public class Movies {
//    Graph<String> graph = new Graph<String>();
//    GraphBFS gb = new GraphBFS(graph);
//
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//
//        //Graph graph = new Graph(args);
////        JSONParser jsonParser = new JSONParser();
//        Graph<String> graph = new Graph<String>();
//        GraphBFS gb = new GraphBFS(graph);
//        List<String> adjList = new ArrayList<String>();
//        //if graph.adjlist.doesnot contain actor
//        //add the actor
//
//
//        try {
//            Reader reader = new FileReader(args[0]);
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//            JSONParser jsonParser = new JSONParser();
//            int movies = 0;
//
//
//            for (CSVRecord csvRecord : csvParser) {
//                if (movies >= 1) {
//                    String title = csvRecord.get(1);
//                    String castJSON = csvRecord.get(2);
//                    // [] = array
//                    // { } = "object" / "dictionary" / "hashtable" -- key "name": value
//
//
//                    //System.out.println("Title: " + title);
//                    Object object = jsonParser.parse(castJSON);
//                    JSONArray jsonArray = (JSONArray) object;
//
//
//                    for (int p = 0; p < jsonArray.size(); p++) {
//                        int count = 0;
//                        //String actor = (JSONObject) jsonArray.get(p);
//                        JSONObject jsonObject = (JSONObject) jsonArray.get(p);
//                        String actor = (String) jsonObject.get(p);
//                        //System.out.println(" * " + jsonObject.get("name"));
//
//                    }
//                    System.out.println(" ");
//
//
//                    //getting user input
//                    HashSet<String> seen = new HashSet<>();
//
////                    Graph<String> graph = new Graph<String>();
//                    for (int r = 0; r < jsonArray.size(); r++) {
//                        //trying to get actors into graph
//                        //i wsnat the actors ot be the vertexes
//                        //and the movies thdey worked in to be the edges
//                        JSONObject jsonObject = (JSONObject) jsonArray.get(r);
//                        String actor = (String) jsonObject.get("name");
//                        for (String seenActor : seen) {
//                            graph.addEdge(actor, seenActor, true);
//                        }
//                        seen.add(actor);
//                        //temporary dtat structure hash set
//                        //haved not seen remaining actor
//                        //skip first actor annd second actor
//                        //build graph
//                        //graph.addEdge(actor, title, true);
////                        if(!actor.equals(actor)){
////                            graph.addEdge(actor,title, true);
////                        }
//                        //System.out.println(graph);
//
//                        //System.out.println();
//
//                    }
//
//
//                    //checks if actor exists
////                    int checkActor1 =0;
////                    //c hecks if actor 2 exists
////                    int checkActor2 =0;
////                    //closes scanner
////                    scanner.close();
////                    boolean actor1Flag = adjList.contains(first);
////                    boolean actor2Flag = adjList.contains(last);
////
////                    if(actor1Flag){
////                        checkActor1 =1;
////                    }
////                    if(actor2Flag){
////                        checkActor2 =1;
////                    }
////                    //list of actor names
////
////                    // checks if actor1 exists in the file & if not, sets the flag value to 0
////                    if (checkActor1 == 0) {
////                        System.out.println("This actor does not exist.");
////                        return;
////                    }
////                    // checks if actor2 exists in the file & if not, sets the flag value to 0
////                    if (checkActor2 == 0) {
////                        System.out.println("This actor does not exist.");
////                        return;
////                    }
//
//                    //if -1, there is no connection
//                    // print the existing path
//
//
//                }
//                ++movies;
//
//
//            }
//            csvParser.close();
//            System.out.println(graph);
//
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            System.out.println("File " + args[0] + " is invalid or is in the wrong format.");
//
//        }
//        Scanner scanner = new Scanner(System.in);
//        String last, name;
//        System.out.println("please enter name: ");
//        name = scanner.nextLine();
////        System.out.print("Enter the first vertix of path: ");
////        first = scanner.next();
////        System.out.print("Enter the last name of  vertix of path: ");
////        last = scanner.next();
//        //have to check for both first and last name of actors
//        //account for space as well
//        if (graph.hasVertex(name)) {
//
//            System.out.print("Enter the last vertix of path: ");
//            last = scanner.nextLine();
//            scanner.close();
//            if (graph.hasVertex(last)) {
//
//                //ArrayList<String> shortestPath = gb.hasPathTo(name);
//
////                for (String v : gb.pathTo(name)) {
////                    System.out.println("   " + v);
////                }
////                System.out.println("distance " + gb.distanceTo(last));
////                StdOut.println("   " + v);
////            }
////            String t = StdIn.readLine();
////            for (String v : pf.pathTo(t)) {
////                StdOut.println("   " + v);
////            }
////            StdOut.println("distance " + pf.distanceTo(t));
////        }
//                //List<Node> shortestPath = gb.constructPath(name, last);
//                //List<> shortestPath = new ArrayList<String>(Arrays.asList(gb.findShortestPath(name, last));
//
////                System.out.println("\nSrortest path between '" + name + "' and '" + last + "':");
////                for(int i = 0; i < shortestPath.size(); i++)
////                {
////                    System.out.print(shortestPath.get(i));
////
////                    if(i < shortestPath.size() - 1)
////                        System.out.print(" -> ");
////                }
////                System.out.println();
////            }
//
//            } else {
//                System.out.println("no actor with such name");
//            }
//
//
//            // create the graph
//
//
//            //ArrayList<String> shortestPath = gb.findShortestPath(first, last);
//
//
//        }
//
//    }
//}
