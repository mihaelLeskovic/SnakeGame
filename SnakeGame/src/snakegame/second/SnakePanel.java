package snakegame.second;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakePanel extends JPanel {
    JPanel panelHolder[][] = new JPanel[SnakeFrame.getGrid()][SnakeFrame.getGrid()];
    Point head;
    Point food;
    LinkedList<Point> restOfSnake = new LinkedList<>();
    int snakeLength = 1;
    static Movement lastMove;
    static Color headColor = new Color(33,77,34);
    static Color bodyColor = new Color(92,154,99);

    public SnakePanel() {
        setLayout(new GridLayout(SnakeFrame.getGrid(), SnakeFrame.getGrid(), 2, 2));
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        fill();
        placeFood();
    }

    void fill(){    //fills in panels at the start of the game; adds head to middle
        for(int i=0; i<SnakeFrame.getGrid(); i++){
            for(int j=0; j<SnakeFrame.getGrid(); j++){
                JPanel panel = new JPanel();
                panel.setBackground(Color.lightGray);
                if(i==SnakeFrame.getGrid()/2 && j==SnakeFrame.getGrid()/2){
                    head = new Point(i, j);
                    panel.setBackground(headColor);
                }
                panelHolder[i][j] = panel;
                this.add(panelHolder[i][j]);
            }
        }
    }

    void placeFood(){   //places food somewhere randomly
        int x=(new Random()).nextInt(SnakeFrame.getGrid());
        int y=(new Random()).nextInt(SnakeFrame.getGrid());
        while(restOfSnake.contains(new Point(x, y)) || this.head.equals(new Point(x,y))){
            x=(new Random()).nextInt(SnakeFrame.getGrid());
            y=(new Random()).nextInt(SnakeFrame.getGrid());
        }
        food = new Point(x, y);
        colorPanelHolder(food, Color.RED);
    }

    void colorPanelHolder(Point p, Color c){
        panelHolder[p.x][p.y].setBackground(c);
    }

    void feed(){
        placeFood();
        snakeLength++;
        SnakePanelWithScore.scoreLabel
                .setText(String.valueOf(Integer.parseInt(SnakePanelWithScore.scoreLabel.getText())+1));
    }

    void moveDown(){
        if(lastMove != Movement.UP){
            if ((head.x + 1 < SnakeFrame.getGrid())) head.x++;
            else head.x = 0;
            lastMove = Movement.DOWN;
        } else moveUp();
    }

    void moveUp(){
        if(lastMove != Movement.DOWN){
            if ((head.x > 0)) head.x--;
            else head.x = SnakeFrame.getGrid() - 1;
            lastMove = Movement.UP;
        } else moveDown();
    }

    void moveRight(){
        if(lastMove != Movement.LEFT){
            if ((head.y + 1 < SnakeFrame.getGrid())) head.y++;
            else head.y = 0;
            lastMove = Movement.RIGHT;
        } else moveLeft();
    }

    void moveLeft(){
        if(lastMove != Movement.RIGHT){
            if ((head.y > 0)) head.y--;
            else head.y = SnakeFrame.getGrid() - 1;
            lastMove = Movement.LEFT;
        } else moveRight();
    }

    void move(Movement move){
        if(move != Movement.NULL){
            Point oldHead = new Point(head);
            restOfSnake.add(oldHead);
            colorPanelHolder(oldHead, bodyColor);       //System.out.println("first good");
            switch (move) {
                case DOWN -> {
                    moveDown();
                    break;
                }
                case UP -> {
                    moveUp();
                    break;
                }
                case LEFT -> {
                    moveLeft();
                    break;
                }
                case RIGHT -> {
                    moveRight();
                    break;
                }
            }
            if(head.equals(food)) feed();
            if (restOfSnake.size() + 1 > snakeLength) {
                colorPanelHolder(restOfSnake.poll(), Color.lightGray);
            }
            if(restOfSnake.contains(head)){
                SnakeFrame.setGameOn(false);
//                System.out.println(snakeLength);
            }
            colorPanelHolder(head, headColor);          //System.out.println("second good");

//            System.out.println(head.toString());
        }

    }


    public void reset() {
        for(int i=0; i<SnakeFrame.getGrid(); i++){
            for(int j=0; j<SnakeFrame.getGrid(); j++){
                panelHolder[i][j].setBackground(Color.lightGray);
                if(i==SnakeFrame.getGrid()/2 && j==SnakeFrame.getGrid()/2){
                    panelHolder[i][j].setBackground(headColor);
                    head = new Point(i,j);
                }
            }
        }
        restOfSnake.clear();
        placeFood();
        snakeLength = 1;
        SnakeFrame.gameOn = true;
        lastMove = Movement.NULL;
        SnakePanelWithScore.scoreLabel.setText("0");
        GameKeyListener.key = 50;
    }

//    JPanel panelHolder[][] = new JPanel[SnakeFrame.getGrid()][SnakeFrame.getGrid()];
//    Point head;
//    Point food;
//    int snakeLength = 1;
//    static Movement lastMove;
//    LinkedList<Point> restOfSnake = new LinkedList<>();

//    static Color headColor = new Color(33,77,34);
//    static Color bodyColor = new Color(92,154,99);
}
