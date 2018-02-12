package graphPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    public Graph(ArrayList<Node> corners){
        this.corners = new HashMap<String, Node>();
        this.edges = new HashMap<Integer, Edge>();

        for(Node n: corners){
            this.corners.put(n.getLabel(),n);
        }
    }

    public Graph() {
        this.corners = new HashMap<String, Node>();
        this.edges = new HashMap<Integer, Edge>();
    }

    public Node getNode(String label){
        return corners.get(label);
    }
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
    public Set<String> nodeKeys(){
        return this.corners.keySet();
    }
    public boolean addEdge(Node first, Node second){
        return addEdge(first, second, 1);
    }

    private boolean addEdge(Node first, Node second, int i) {
        if(first.equals(second))
            return false;
        Edge e = new Edge(first, second, i);
        if(edges.containsKey(e.hashCode()))
            return false;
        else if(first.containsNeighbour(e) || second.containsNeighbour(e))
            return false;
        edges.put(e.hashCode(), e);
        first.addNeighbour(e);
        second.addNeighbour(e);
        return true;
    }
    public boolean addNode(Node node, boolean overwriteExisting){
        Node n = this.corners.get(node.getLabel());
        if(n != null){
            if(!overwriteExisting){
                return false;
            }
            while(n.neighbourCount() > 0){
                this.removeEdge(n.getNeighbour(0));
            }
        }
        corners.put(node.getLabel(), node);
        return true;
    }
    public Edge removeEdge(Edge e){
        e.getFirst().removeNeighbour(e);
        e.getSecond().removeNeighbour(e);
        return this.edges.remove(e.hashCode());
    }
    public Node removeNode(String label){
        Node n = corners.remove(label);
        while(n.neighbourCount() > 0){
            this.removeEdge(n.getNeighbour((0)));
        }
        return n;
    }
    public boolean containsEdge(Edge e){
        if(e.getFirst() == null || e.getSecond() == null)
            return false;
        return this.edges.containsKey(e.hashCode());
    }
    public boolean containsNode(Node n){
        return this.corners.get(n.getLabel()) != null;
    }
    private HashMap<String, Node> corners;
    private HashMap<Integer, Edge> edges;
}
