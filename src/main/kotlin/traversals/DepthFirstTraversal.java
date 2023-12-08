package traversals;

import models.Graph;
import models.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

// A stack to store and monitor
// A stack employs LI-Fo - The last element t the stack is the first to be retrieved
// Types of graph
// 1. connected
// 2. Discon


public class DepthFirstTraversal {
    public static void main(String[] args) {
        File file = new File("traversal");

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

                DepthFirst(graph, graph.getNodes()[0]);

                //printing the neighbors
                for (int i = 0; i < graph.getNodes().length; i++) {
                    Node current = graph.getNodes()[i];
                    for (int j = 0; j <  current.getNeighbors().size(); j++) {
                        Node neighbor =  current.getNeighbors().get(j);
                        System.out.println("Current " + current.getName() + " neighbor " +  (j + 1) + "->" + neighbor.getName());
                    }
                }

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void DepthFirst(Graph graph, Node node){
        //initialise our stack
        Stack<Node> stack = new Stack<>();

        //add start node in the stack
        stack.add(node);

        //condition that performs the traversal
        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.println(current.getName());
            for (int i = 0; i < current.getNeighbors().size(); i++) {
                Node neighbor = current.getNeighbors().get(i);
                stack.push(neighbor);
            }
        }
    }
}
