package traversals;

import models.Graph;
import models.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirst {

    public static void main(String[] args) {
        File file = new File("depthfirst");

        try{
            if(file.exists()){
                FileReader reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);

                int rows = Integer.parseInt(buffer.readLine()); //we are reading the first line in the file
                int columns = Integer.parseInt(buffer.readLine()); //we are reading the second line in the file

                Node[] nodes = new Node[rows];

                for (int i = 0; i < rows; i++) {
                    String name = buffer.readLine();
                    char nodeName = name.charAt(0);
                    Node node = new Node(nodeName);
                    nodes[i] = node;
                    //System.out.println(i + "->" + nodes[i].getName());
                }

                //Graph
                Graph graph = new Graph(nodes);

                //initialise
                String[][] matrix = new String[rows][columns];

                for (int i = 0; i < rows; i++) {
                    String[] row = buffer.readLine().split(" ");
                    Node current = graph.getNodes()[i];
                    for (int j = 0; j < row.length; j++) {
                        Node columnNode = graph.getNodes()[j];
                        matrix[i][j] = row[j];
                        //System.out.println(row[j]);
                        if (!matrix[i][j].equals("0")){
                            graph.getNodes()[i].addNeighbor(graph.getNodes()[j]);
                        }
                    }

                }

                //DepthFirstTraversal(graph, graph.getNodes()[0]);
                //recursiveDepthFirst(graph, graph.getNodes()[0]);
                breathFirst(graph.getNodes()[0]);
                //printing the neighbors
                for (int i = 0; i < graph.getNodes().length; i++) {
                    Node current = graph.getNodes()[i];
                    for (int j = 0; j <  current.getNeighbors().size(); j++) {
                        Node neighbor =  current.getNeighbors().get(j);
                        //System.out.println("Current " + current.getName() + " neighbor " +  (j + 1) + "->" + neighbor.getName());
                    }
                }

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void DepthFirstTraversal(Graph graph, Node start){
        //initialise our stack
        Stack<Node> nodes = new Stack<Node>();

        //add our start node in the stack
        nodes.add(start);

        //run the condition that performs the traversal
        while(!nodes.isEmpty()){
            Node current = nodes.pop();
            System.out.println(current.getName());
            for (int i = 0; i < current.getNeighbors().size(); i++) {
                Node neighbor = current.getNeighbors().get(i);
                nodes.push(neighbor);
            }
        }

    }

    private static void recursiveDepthFirst(Graph graph, Node start){
        System.out.println(start.getName());
        for (int i = 0; i < start.getNeighbors().size(); i++) {
            recursiveDepthFirst(graph, start.getNeighbors().get(i));
        }
    }

    private static void breathFirst(Node start){
        //initialise the queue
        Queue<Node> q = new LinkedList<>();

        //add the start node inside the queue - Fifo
        q.add(start);

        //execute the condition that performs the travasal
        while(!q.isEmpty()){
            Node current = q.poll();
            System.out.println(current.getName());
            for (int i = 0; i < current.getNeighbors().size(); i++) {
                Node neighbor = current.getNeighbors().get(i);
                q.add(neighbor);
            }
        }
    }


}

