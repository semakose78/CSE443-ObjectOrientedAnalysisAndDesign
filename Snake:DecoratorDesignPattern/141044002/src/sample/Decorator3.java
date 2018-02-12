package sample;

public class Decorator3 extends SnakeDecorator {
    public Decorator3(Snake decoratedSnake) {
        super(decoratedSnake);
    }

    @Override
    public int getCarpan() {
        return decoratedSnake.getCarpan()*3;
    }

    @Override
    public int getUnitSize() {
        return decoratedSnake.getUnitSize();
    }

    @Override
    public int getKacKare() {
        return decoratedSnake.getKacKare();
    }

    @Override
    public void ekranaYaz() {
        //decoratedSnake.ekranaYaz();
        System.out.println("Normal yem yedi");
    }
}
