import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main{

    //private HashMap<String, Node> nodes;

    public Main(){
        // nodes = new HashMap<>(); 
        // Scanner s = new Scanner(System.in);
        // String[] nodeNames = s.nextLine().split(" ");
        // String starterKey = s.nextLine();

        // for(var key : nodeNames){
        //     Node n = new Node(key);
        //     nodes.put(key, n);
        // }

        // Node startNode = nodes.get(starterKey);

        // System.out.println(nodes);
    }
    public static void main(String[] args) {
        HashMap<String, Node> nodes;
        nodes = new HashMap<>(); 
        Scanner s = new Scanner(System.in);
        String[] nodeNames = s.nextLine().split(" ");
        String starterKey = s.nextLine();

        for(var key : nodeNames){
            Node n = new Node(key);
            nodes.put(key, n);
        }

        //Starter node
        Node startNode = nodes.get(starterKey);

        while(true){
            String a = s.next();
            if(a.equals("***")){
                break;
            }
            Node n1 = nodes.get(a);
            String b = s.next();
            Node n2 = nodes.get(b);
            n1.addNeighbor(n2);
            n2.addNeighbor(n1);

        }
        s.close();

        for(Node n : nodes.values()){
            //Print neighbors
            //loop through with values
            n.printNeighbors();
            //System.out.println(nodes.keySet());
        }
    }
}

