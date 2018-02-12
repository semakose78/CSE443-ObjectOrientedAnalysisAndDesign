package sample;

import javafx.scene.shape.Rectangle;

import java.awt.*;

public class SnakeAnaconda extends Snake {
    public SnakeAnaconda() {
        super(80);
    }

    public int getUnitSize(){
        return 80;
    }

    @Override
    public int getKacKare() {
        return 8;
    }

    @Override
    public void ekranaYaz() {
        System.out.println("B snaki yem yedi");
    }

    public int getCarpan(){
        return 2;
    }
}
