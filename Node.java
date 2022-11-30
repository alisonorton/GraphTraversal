import java.util.ArrayList;
import java.util.Collections;

public class Node implements Comparable<Node>{
    public String key;
   //String data;
    public ArrayList<Node> neighbors;
    public boolean visited;

    public Node(String n){
        key = n;
        neighbors = new ArrayList<>();
        visited = false;
    }

    public void addNeighbor(Node other){
        neighbors.add(other);
        Collections.sort(neighbors);
    }

    public void visit(){
        visited = true;
    }

    public void unVisit(){
        visited = false;
    }

    

    public void printNeighbors(){
        String output = "";
        output += key + ": ";

        for(var node : neighbors){
            output += node.key + " ";
        }
        System.out.println(output);
    }

    @Override
    public int compareTo(Node other) {
        return key.compareTo(other.key);
    }
}
