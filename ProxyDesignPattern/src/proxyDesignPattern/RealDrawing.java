package proxyDesignPattern;

import graphPackage.Node;

public class RealDrawing implements DrawGraph {
    @Override
    public void draw(Node[] nodes) {
        for(int i=0; i<nodes.length; ++i){
            System.out.println(nodes[i]);
            for(int j=0; j<nodes[i].neighbourCount(); ++j){
                System.out.println(nodes[i].getNeighbour(j));
            }
            System.out.println();
        }
    }
}
