package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
/*/
this class reads in a csv file
after reading the csv file it starts building the graph by connecting
all actors who worked in the same movie
 */

public class Movies {
//    Graph<String> graph = new Graph<String>();

    /*/
    main class reads in csv file
    builds graph
    and calls breadth firast search on graph
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Graph graph = new Graph(args);
//        JSONParser jsonParser = new JSONParser();
        Graph<String> graph = new Graph<String>();
        //GraphBfss gb = new GraphBfss(graph);
//        List<String> adjList = new ArrayList<String>();
        //if graph.adjlist.doesnot contain actor
        //add the actor

        try {
            Reader reader = new FileReader(args[0]);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            JSONParser jsonParser = new JSONParser();
            int movies = 0;

            for (CSVRecord csvRecord : csvParser) {
                if (movies >= 1) {
                    String title = csvRecord.get(1);
                    String castJSON = csvRecord.get(2);
                    // [] = array
                    // { } = "object" / "dictionary" / "hashtable" -- key "name": value

                    //System.out.println("Title: " + title);
                    Object object = jsonParser.parse(castJSON);
                    JSONArray jsonArray = (JSONArray) object;

                    HashSet<String> seen = new HashSet<>();

                    for (int r = 0; r < jsonArray.size(); r++) {
                        //trying to get actors into graph
                        //i wsnat the actors ot be the vertexes
                        //and the movies thdey worked in to be the edges
                        JSONObject jsonObject = (JSONObject) jsonArray.get(r);
                        String actor = (String) jsonObject.get("name");
                        //build graph
                        for (String seenActor : seen) {
                            if(!seenActor.equals(actor))
                                graph.addEdge(actor, seenActor, true);
                        }
                        seen.add(actor);
                    }
                }
                ++movies;
            }
            csvParser.close();
            //System.out.println(graph);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("File " + args[0] + " is invalid or is in the wrong format.");

        }
        //by using .nextLine we are able to account for spacing
        Scanner scanner = new Scanner(System.in);
        String last, name;
        System.out.println("please enter name: ");
        name = scanner.nextLine();
        //have to check for both first and last name of actors
        //account for space as well
        if (graph.hasVertex(name)) {
            System.out.print("Enter the last vertix of path: ");
            last = scanner.nextLine();
            scanner.close();
            if (graph.hasVertex(last)) {
                graph.bfs(graph,name, last);
            }

            } else {
                System.out.println("no actor with such name");
            }



        }

    }

