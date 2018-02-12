package sample;

import javafx.scene.shape.Rectangle;

import java.awt.*;

class SnakePython extends Snake {
    public SnakePython() {
        super(40);
    }

    public int getUnitSize(){
        return 40;
    }

    @Override
    public int getKacKare() {
        return 16;
    }

    @Override
    public void ekranaYaz() {
        System.out.println("A snaki yem yedi");
    }

    public int getCarpan(){
        return 1;
    }
}