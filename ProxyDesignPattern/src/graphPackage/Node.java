package graphPackage;

import java.util.ArrayList;

public class Node {
    public Node(String label){
        this.neighbours = new ArrayList<Edge>();
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }
    public ArrayList<Edge> getNeighbours() {
        return this.neighbours;
    }
    public Edge getNeighbour(int index){
        return this.neighbours.get(index);
    }
    public boolean containsNeighbour(Edge nb){
        return this.neighbours.contains(nb);
    }
    public void addNeighbour(Edge edge){
        if(this.neighbours.contains(edge)){
            return;
        }else{
            this.neighbours.add(edge);
        }
    }
    public Edge removeNeighbour(int index){
        return this.neighbours.remove(index);
    }
    public void removeNeighbour(Edge edge){
        this.neighbours.remove(edge);
    }
    public int neighbourCount(){
        return this.neighbours.size();
    }
    public String toString(){
        String name = "Node " + label;
        return name;
    }
    public int hashCode(){
        return this.label.hashCode();
    }
    public boolean equals(Object obj){
        if(!(obj instanceof Node))
            return false;
        else{
            Node n = (Node)obj;
            return (this.label.equals(n.label));
        }
    }
    private String label;
    private ArrayList<Edge> neighbours;
}
