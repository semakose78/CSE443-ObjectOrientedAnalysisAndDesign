package proxyDesignPattern;

import graphPackage.Node;

public class ProxyDraw implements DrawGraph {
    private boolean dump;
    private DrawGraph graph;
    public ProxyDraw(int timer) throws InterruptedException {
        System.out.println("Waiting for "+timer+" seconds...");
        Thread.sleep(timer);
        while(timer>0){
            --timer;
            if(timer==0){
                dump = true;
                break;
            }
        }
        graph = new RealDrawing();
    }
    @Override
    public void draw(Node[] nodes) throws Exception {
        if(dump){
            graph.draw(nodes);
        }else{
            throw new Exception();
        }
    }
}
