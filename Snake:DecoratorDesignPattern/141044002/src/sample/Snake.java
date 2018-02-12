package sample;

import javafx.scene.shape.Rectangle;

import java.awt.*;

abstract class Snake extends Rectangle{
    public Snake(int i) {
        super(i, i);
    }
    abstract public int getCarpan();
    abstract public int getUnitSize();
    abstract public int getKacKare();
    abstract public void ekranaYaz();
}
