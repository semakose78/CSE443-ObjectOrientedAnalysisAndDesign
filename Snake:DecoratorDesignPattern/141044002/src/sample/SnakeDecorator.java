package sample;

abstract class SnakeDecorator extends Snake{
    protected Snake decoratedSnake;

    public SnakeDecorator(Snake decoratedSnake) {
        super(decoratedSnake.getUnitSize());
        this.decoratedSnake = decoratedSnake;
    }

    public SnakeDecorator(int i) {
        super(i);
    }
}
