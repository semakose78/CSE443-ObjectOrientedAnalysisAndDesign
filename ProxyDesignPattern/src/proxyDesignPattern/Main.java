package proxyDesignPattern;

import graphPackage.Graph;
import graphPackage.Node;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Create graph
        Graph g = new Graph();
        Graph g2 = new Graph();

        //create and add nodes
        Node[] nodes = new Node[5];
        Node[] nodes2 = new Node[3];
        for(int i=0; i<nodes.length; ++i){
            nodes[i] = new Node(""+i);
            g.addNode(nodes[i], true);
        }

        for(int i=0; i<nodes2.length; ++i){
            nodes2[i] = new Node(""+i+30);
            g2.addNode(nodes2[i], true);
        }

        //add edges to graph
        for(int i=0; i<nodes.length; ++i){
            for(int j=0; j<nodes.length; ++j){
                g.addEdge(nodes[i], nodes[j]);
                g.addEdge(nodes[i], nodes[j]);
                g.addEdge(nodes[j], nodes[i]);
            }
        }

        for(int i=0; i<nodes2.length; ++i){
            for(int j=0; j<nodes2.length; ++j){
                g2.addEdge(nodes2[i], nodes2[j]);
                g2.addEdge(nodes2[j], nodes2[i]);
            }
        }

        //Draw with proxy
        DrawGraph graphDrawing = new ProxyDraw(10000);
        try {
            graphDrawing.draw(nodes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Draw with proxy
        DrawGraph graphSecondDrawing = new ProxyDraw(5000);
        try {
            graphDrawing.draw(nodes2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
