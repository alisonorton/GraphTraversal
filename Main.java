import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Node> nodes;
        nodes = new HashMap<>(); 
        Scanner s = new Scanner(System.in);
        String[] nodeNames = s.nextLine().split(" ");
        String starterKey = s.nextLine();
        
        //Storing nodes in hashmap
        for(var key : nodeNames){
            Node n = new Node(key);
            nodes.put(key, n);
        }

        
        Node startNode = nodes.get(starterKey); //starter node

        //looping through to add neighbors to each node
        //nodes are neighbors to EACH OTHER so be sure to add both
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

        //Display
        System.out.println("\n\nNode Neighbors:");
        for(Node n : nodes.values()){
            n.printNeighbors();
        }
        
        System.out.println("\nDepth-First Search:");
        depthFirst(startNode);

        for(Node n :nodes.values()){
            n.unVisit();
        }

        System.out.println("\n\nBreadth-First Search:");
        breadthFirst(startNode);
        System.out.println("");
       
    }

/*****************************************************
 * Function that traverses a graph using depth frist
 * method
 *****************************************************/
    public static void depthFirst(Node startNode){
        String output = ""; //string for output
        startNode.visit(); //mark as visited
        System.out.print(startNode.key + " "); //print first value

        //loop through the neighbors of each node
        for(var node : startNode.neighbors){
            if(!node.visited){
                output += node.key + " "; //add value to output string
                depthFirst(node); //recall function to loop through all the unvisited neighbors
            }
        }
    }




/*****************************************************
 * Function that traverses a graph using breadth frist
 * method
 *****************************************************/

    public static void breadthFirst(Node starNode) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(starNode); //add to queue
        starNode.visit(); //mark as visited
        System.out.print(starNode.key + " "); //print value


       while(!q.isEmpty()){
            Node front = q.peek(); //get first element of queue

            //loop through the neighbors of the first element in the queue
            for(Node n : front.neighbors){
                if(!n.visited){
                    n.visit(); //mark as visited
                    System.out.print(n.key + " "); //print value
                    q.offer(n); //add new node to the queue
                }
                
           }
           q.poll(); //delete queue
        }

    }
}

