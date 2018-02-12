package sample;

public class Decorator5 extends SnakeDecorator {
    public Decorator5(Snake decoratedSnake) {
        super(decoratedSnake);
    }

    @Override
    public int getCarpan() {
        return decoratedSnake.getCarpan()*5;
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
       // decoratedSnake.ekranaYaz();
        System.out.println("Job yedi");
    }
}
