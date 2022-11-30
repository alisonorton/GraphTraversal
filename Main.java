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
       
    }

    //Pass in starter node
    public static void depthFirst(Node startNode){
        String output = "";
        startNode.visit();
        System.out.print(startNode.key + " ");
        for(var node : startNode.neighbors){
            if(!node.visited){
                //node.visit();
                output += node.key + " ";
                depthFirst(node);
            }
        }
    }


    //q.offer(node);
    //!q.isEmpty();
    //q.peek();
    //for(Node n : front.getNeighbors()) {Will need to make this method}



    public static void breadthFirst(Node starNode) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(starNode);
        starNode.visit();
        System.out.print(starNode.key + " ");


       while(!q.isEmpty()){
            Node front = q.peek();
            Node test = front.getNeighbor();
            //System.out.println(test.key);

            for(Node n : front.neighbors){
                if(!n.visited){
                    n.visit();
                    System.out.print(n.key + " ");
                    q.offer(n);
                }
                n = front.getNeighbor();
                
           }
           q.poll();
        }


        // List<Node> queue = new ArrayList<>();
        // System.out.println(starNode.key);
        // starNode.visit();
        // queue.add(starNode);

        // while(!queue.isEmpty()){
        //     for(var n : starNode.neighbors){
        //         if(!n.visited){
        //             System.out.print(n.key + " ");
        //             //Adding element to the end of the list
        //             queue.add(n);
        //         }
        //     }
        //     //Dequeue. This ends the while loop
        //     queue.clear();
        // }

       // System.out.println(queue);
       //breadthFirst(starNode.neighbors.get(0));
        
    }
}

