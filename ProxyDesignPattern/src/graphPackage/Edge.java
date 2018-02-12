package graphPackage;

public class Edge implements Comparable<Edge>{
    public Edge(Node first, Node second){
        this(first, second, 1);
    }
    public Edge(Node first, Node second, int weight){
        this.first = (first.getLabel().compareTo(second.getLabel()) <= 0) ? first : second;
        this.second = (this.first == first) ? second : first;
        this.weight = weight;
    }

    public Node getFirst() {
        return first;
    }

    public Node getSecond() {
        return second;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getNeighbour(Node current){
        if(!(current.equals(first) || current.equals(second))){
            return null;
        }
        return (current.equals(first)) ? second : first;
    }
    public boolean equals(Object o){
        if(!(o instanceof Edge)){
            return false;
        }
        Edge e = (Edge)o;
        return e.first.equals(this.first) && e.second.equals(this.second);
    }

    public String toString(){
        return "({" + first + ", " + second + "}, " + weight + ")";
    }

    public int hashCode(){
        return (first.getLabel() + second.getLabel()).hashCode();
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    private Node first, second;
    private int weight;
}
