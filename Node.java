import java.util.ArrayList;
import java.util.Collections;

public class Node implements Comparable<Node>{
    public String key;
   //String data;
    private ArrayList<Node> neighbors;

    public Node(String n){
        key = n;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node other){
        neighbors.add(other);
        Collections.sort(neighbors);
    }

    

    public void printNeighbors(){
        String output = "";
        output += key + ": ";

        for(var node : neighbors){
            output += node.key + " ";
        }
        System.out.println(output);

    //    for(int i = 0; i < neighbors.size(); i++){
    //     output = ;

    //    }
    }

    @Override
    public int compareTo(Node other) {
        return key.compareTo(other.key);
    }
}
