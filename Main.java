import java.util.ArrayList;
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

        //Print neighbors
        for(Node n : nodes.values()){
            n.printNeighbors();
        }
        
        System.out.println("\n\n");
        System.out.println(startNode.key);
        System.out.println("Depth-First Search:");
        depthFirst(startNode);

        for(Node n :nodes.values()){
            n.unVisit();
        }

        System.out.println("\n\n");
        breadthFirst(startNode);
       
    }

    //Pass in starter node
    public static void depthFirst(Node startNode){
        String output = "";
        startNode.visit();
        System.out.println(startNode.key);
        for(var node : startNode.neighbors){
            if(!node.visited){
                //node.visit();
                output += node.key + " ";
                depthFirst(node);
            }
        }
    }

    public static void breadthFirst(Node starNode) {
        List<Node> queue = new ArrayList<>();
        System.out.println(starNode.key);
        starNode.visit();
        queue.add(starNode);

        while(!queue.isEmpty()){
            for(var n : starNode.neighbors){
                if(!n.visited){
                    System.out.println("For loop: " + n.key);
                    //Adding element to the end of the list
                    queue.add(n);
                }
            }
            //Dequeue. This ends the while loop
            queue.clear();
        }

        System.out.println(queue);
       //breadthFirst(starNode.neighbors.get(0));
        
    }
}

