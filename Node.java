import java.util.ArrayList;

public class Node {
    private String key;
   //String data;
    public ArrayList<Node> neighbors;

    public Node(String n){
        key = n;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node other){
        neighbors.add(other);
    }

    public void printNeighbors(){

    }
}
