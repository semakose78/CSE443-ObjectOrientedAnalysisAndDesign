package graphPackage;

public class Main {
    public static void main(String[] args){
        //Create graph
        Graph g = new Graph();

        //create and add nodes
        Node[] nodes = new Node[5];
        for(int i=0; i<nodes.length; ++i){
            nodes[i] = new Node(""+i);
            g.addNode(nodes[i], true);
        }

        //add edges to graph
        for(int i=0; i<nodes.length; ++i){
            for(int j=0; j<nodes.length; ++j){
                g.addEdge(nodes[i], nodes[j]);
                g.addEdge(nodes[i], nodes[j]);
                g.addEdge(nodes[j], nodes[i]);
            }
        }

        //print out nodes and neighbours
        /*for(int i=0; i<nodes.length; ++i){
            System.out.println(nodes[i]);
            for(int j=0; j<nodes[i].neighbourCount(); ++j){
                System.out.println(nodes[i].getNeighbour(j));
            }
            System.out.println();
        }*/
        for(int i=0; i<nodes.length; ++i){
            System.out.println(nodes[i]);
            for(int j=0; j<nodes[i].neighbourCount(); ++j){
                System.out.println(nodes[i].getNeighbour(j));
            }
            System.out.println();
        }
    }
}
