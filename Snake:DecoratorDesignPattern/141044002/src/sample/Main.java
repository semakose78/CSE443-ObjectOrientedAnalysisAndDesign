package sample;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main extends Application {

    public int screenH = 0;
    public int screenW = 0;
    public int puan = 0;
    public int yenen = 0;
    public VBox menubox;
    Snake choosen;
    public enum Direction{
        UP, DOWN, LEFT, RIGHT
    }
    static int [] inputForGame;
    private Timeline timeline = new Timeline(); //animasyon
    private Direction direct = Direction.RIGHT; //default direction
    private boolean moved = false; //aynı anda birden fazla yöne hareket etmemek için flag

    private boolean running = false; //uygulama çalışıyor mu?

    public ObservableList<Node> snake;

    private Parent createContent(){
        screenW = choosen.getKacKare()*choosen.getUnitSize();
        screenH = choosen.getKacKare()*choosen.getUnitSize();

        Pane root = new Pane();
        root.setPrefSize(screenW, screenH);
        Group body = new Group();
        snake = body.getChildren();

        //Create food

        Food job = new FoodJob1(choosen.getUnitSize(), choosen.getUnitSize());
        job.setTranslateX((choosen.getKacKare()/2*choosen.getUnitSize())+(2*choosen.getUnitSize()));
        job.setTranslateY((choosen.getKacKare()/2*choosen.getUnitSize())+(2*choosen.getUnitSize()));

        Food food = new FoodClassic(choosen.getUnitSize(), choosen.getUnitSize());
        food.setTranslateX(choosen.getKacKare()/2*choosen.getUnitSize());
        food.setTranslateY(choosen.getKacKare()/2*choosen.getUnitSize());


        KeyFrame frame = new KeyFrame(Duration.seconds(0.3), new EventHandler<ActionEvent>(){ //oyunun bir çerçevesi
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!running)
                    return;
                boolean toRemove = snake.size() > 1;
                Node tail = toRemove ? snake.remove(snake.size()-1) : snake.get(0);

                double tailX = tail.getTranslateX();
                double tailY = tail.getTranslateY();

                switch (direct){
                    case UP:
                        tail.setTranslateX(snake.get(0).getTranslateX());
                        tail.setTranslateY(snake.get(0).getTranslateY()-choosen.getUnitSize());
                        break;
                    case DOWN:
                        tail.setTranslateX(snake.get(0).getTranslateX());
                        tail.setTranslateY(snake.get(0).getTranslateY()+choosen.getUnitSize());
                        break;
                    case LEFT:
                        tail.setTranslateX(snake.get(0).getTranslateX()-choosen.getUnitSize());
                        tail.setTranslateY(snake.get(0).getTranslateY());
                        break;
                    case RIGHT:
                        tail.setTranslateX(snake.get(0).getTranslateX()+choosen.getUnitSize());
                        tail.setTranslateY(snake.get(0).getTranslateY());
                        break;
                }
                moved = true;
                if(toRemove)
                    snake.add(0, tail);
                for(Node rect: snake){
                    if(rect != tail && tail.getTranslateX() == rect.getTranslateX()
                            && tail.getTranslateY() == rect.getTranslateY()) {
                        restartGame();
                        break;
                    }
                }
                if(tail.getTranslateX() < 0 || tail.getTranslateX() >= screenW
                        || tail.getTranslateY() < 0 || tail.getTranslateY() >= screenH){
                    restartGame();
                }
                if((tail.getTranslateX() == food.getTranslateX()) && (tail.getTranslateY() == food.getTranslateY())){
                    //choosen.ekranaYaz();
                    puan = puan + choosen.getCarpan();

                    ++yenen;
                    System.out.println("Puan : " + puan);
                    /*if(yenen == 3){
                        choosen = new Decorator3(choosen);
                        //choosen = choosen2;
                        //choosen = new Decorator3(choosen);
                    }
                    if(yenen == 5){
                        choosen = new Decorator5(choosen);
                        //choosen = choosen2;
                        //choosen = new Decorator3(choosen);
                    }*/
                    choosen = new Decorator3(choosen);
                    choosen.ekranaYaz();
                    boolean firstTime = false;
                    int x = 0;
                    int y= 0;
                    while(firstTime || ((tail.getTranslateX() == x) || (tail.getTranslateY() == y)))
                    {
                        Random rand = new Random();
                        x = (rand.nextInt(choosen.getKacKare() -1 )+ 1)*choosen.getUnitSize();
                        y = (rand.nextInt(choosen.getKacKare()- 1 )+ 1)*choosen.getUnitSize();
                    }
                    food.setTranslateX(x);
                    food.setTranslateY(y);

                    Rectangle rect = new Rectangle(choosen.getUnitSize(), choosen.getUnitSize());
                    rect.setTranslateX(tailX);
                    rect.setTranslateY(tailY);
                    snake.add(rect);
                }
                if((tail.getTranslateX() == job.getTranslateX()) && (tail.getTranslateY() == job.getTranslateY())){
                    //choosen.ekranaYaz();
                    puan = puan + choosen.getCarpan();

                    ++yenen;
                    System.out.println("Puan : " + puan);
                    /*if(yenen == 3){
                        choosen = new Decorator3(choosen);
                        //choosen = choosen2;
                        //choosen = new Decorator3(choosen);
                    }
                    if(yenen == 5){
                        choosen = new Decorator5(choosen);
                        //choosen = choosen2;
                        //choosen = new Decorator3(choosen);
                    }*/
                    choosen = new Decorator5(choosen);
                    choosen.ekranaYaz();
                    boolean firstTime = false;
                    int x = 0;
                    int y= 0;
                    while(firstTime || ((tail.getTranslateX() == x) || (tail.getTranslateY() == y)))
                    {
                        Random rand = new Random();
                        x = (rand.nextInt(choosen.getKacKare() -1 )+ 1)*choosen.getUnitSize();
                        y = (rand.nextInt(choosen.getKacKare()- 1 )+ 1)*choosen.getUnitSize();
                    }
                    job.setTranslateX(x);
                    job.setTranslateY(y);

                    Rectangle rect = new Rectangle(choosen.getUnitSize(), choosen.getUnitSize());
                    rect.setTranslateX(tailX);
                    rect.setTranslateY(tailY);
                    snake.add(rect);
                }
            }
        });
        timeline.getKeyFrames().add(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        root.getChildren().addAll(job, food, body);
        return root;

    }
    private void restartGame(){
        stopGame();
        startGame();
    }
    private void stopGame(){
        running = false;
        timeline.stop();
        snake.clear();
    }
    private void startGame(){

    puan = 0;
    yenen = 0;
    direct = Direction.RIGHT;
    snake.add(choosen);
    timeline.play();
    running = true;

    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane rt = new Pane();
        rt.setPrefSize(screenW, screenH);
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();
        /*MenuItem itemExit = new MenuItem("EXIT");
        menubox = new VBox(8); // spacing = 8
        menubox.getChildren().addAll(new Button("Anaconda"), new Button("Python"));
        menubox.setAlignment(Pos.TOP_CENTER);
        menubox.setTranslateX(360);
        menubox.setTranslateX(300);*/
        final Integer[] input = new Integer[1];

        /*Button anaconda = new Button("Anaconda");
        anaconda.setOnAction(event -> {
            input[0] = 1;});
        Button python = new Button("Python");
        python.setOnAction(event -> {
            input[0] = 2;});

        VBox vbox = new VBox(50, anaconda, python);
        vbox.setTranslateX(360);
        vbox.setTranslateY(360);*/

        //final int[] input = {0};
        //primaryStage.setTitle("JavaFX Welcome");

        Button button1 = new Button("python");
        button1.setTranslateX(screenW/2);
        button1.setTranslateY((screenH+1)/2);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                input[0] = 1;
                choosen = new SnakePython();
                Scene scene = new Scene(createContent());
                scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    public void handle(KeyEvent ke) {
                        if(!moved)
                            return;
                        if(moved){
                            switch (ke.getCode()){
                                case W:
                                    if(direct != Direction.DOWN)
                                        direct = Direction.UP;
                                    break;
                                case S:
                                    if(direct != Direction.UP)
                                        direct = Direction.DOWN;
                                    break;
                                case D:
                                    if(direct != Direction.LEFT)
                                        direct = Direction.RIGHT;
                                    break;
                                case A:
                                    if(direct != Direction.RIGHT)
                                        direct = Direction.LEFT;
                                    break;

                            }
                        }

                        moved = false;
                    }
                });
                primaryStage.setTitle("Snake");
                primaryStage.setScene(scene);
                primaryStage.show();
                startGame();
            }
        });
        Button button2 = new Button("anaconda");
        button2.setTranslateX(screenW/2);
        button2.setTranslateY(((screenH+1)/2)+100);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                input[0] = 2;
                choosen = new SnakeAnaconda();
                Scene scene = new Scene(createContent());
                scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    public void handle(KeyEvent ke) {
                        if(!moved)
                            return;
                        if(moved){
                            switch (ke.getCode()){
                                case W:
                                    if(direct != Direction.DOWN)
                                        direct = Direction.UP;
                                    break;
                                case S:
                                    if(direct != Direction.UP)
                                        direct = Direction.DOWN;
                                    break;
                                case D:
                                    if(direct != Direction.LEFT)
                                        direct = Direction.RIGHT;
                                    break;
                                case A:
                                    if(direct != Direction.RIGHT)
                                        direct = Direction.LEFT;
                                    break;

                            }
                        }

                        moved = false;
                    }
                });
                primaryStage.setTitle("Snake");
                primaryStage.setScene(scene);
                primaryStage.show();
                startGame();
            }
        });
        rt.getChildren().addAll(button1,button2);
        Scene scene = new Scene(rt);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        menu.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        menu.add(userName, 0, 1);

        TextField userTextField = new TextField();
        menu.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        menu.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        menu.add(pwBox, 1, 2);*/


       /*System.out.println("Python or Anaconda?");
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();*/
        /*switch (input[0]){
            case 1:
                choosen = new SnakePython();
                break;
            case 2:
                choosen = new SnakeAnaconda();
                break;
        }*/

    }
    private static class MenuButton extends StackPane{
        Text text;
        public MenuButton(String name){
            text = new Text(name);
            Button but = new Button(name);
            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(but, text);
            but.setOnAction(event -> {
                if(name.equals("anaconda"))
                    inputForGame[0] = 2;
                else if(name.equals("python"))
                    inputForGame[0] = 1;
            });
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
