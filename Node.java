import java.util.ArrayList;
import java.util.Collections;

public class Node implements Comparable<Node>{
    public String key;
    public ArrayList<Node> neighbors;
    public boolean visited;

    //Constructor
    public Node(String n){
        key = n;
        neighbors = new ArrayList<>();
        visited = false;
    }

    //Add node to the list of nodes next to this node
    public void addNeighbor(Node other){
        neighbors.add(other);
        Collections.sort(neighbors);
    }

    //This node has been visited while traversing through the graph
    public void visit(){
        visited = true;
    }

    //Unmark as visited
    public void unVisit(){
        visited = false;
    }

    //Get the next first neighbor
    public Node getNeighbor(){
        return neighbors.get(0);
    }

    //Print the complete list of neighbors
    public void printNeighbors(){
        String output = "";
        output += key + ": ";

        for(var node : neighbors){
            output += node.key + " ";
        }
        System.out.println(output);
    }

    //comparing names of nodes to alphebatize
    @Override
    public int compareTo(Node other) {
        return key.compareTo(other.key);
    }
}
