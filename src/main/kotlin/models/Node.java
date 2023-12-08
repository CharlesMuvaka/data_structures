package models;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private char name;
    private List<Node> neighbors;

    public Node(char name){
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node node){
        this.neighbors.add(node);
    }

    public char getName() {
        return name;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }


}
