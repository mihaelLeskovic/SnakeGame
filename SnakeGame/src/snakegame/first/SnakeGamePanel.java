package snakegame.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGamePanel extends JPanel {
    static int grid=40;
    static Point head;
    static LinkedList<Point> restOfSnake = new LinkedList<>();
    static Point food;
    static JPanel[][] panelHolder = new JPanel[grid][grid];
    static boolean gameOn = true;
    static Integer key = null;  //38 left , clockwise ++

    static void move(){
        Point pom = new Point(head);

        if(SnakeGamePanel.key != null){
            switch (GameKeyListener.getKey()) {
                case KeyEvent.VK_UP:
                    head = new Point((int) (head.getX()+1), (int) head.getY());
                    break;
                case KeyEvent.VK_DOWN:
                    head = new Point((int) (head.getX()-1), (int) head.getY());
                    break;
                case KeyEvent.VK_LEFT:
                    head = new Point((int) (head.getX()), (int) head.getY()+1);
                    break;
                case KeyEvent.VK_RIGHT:
                    head = new Point((int) (head.getX()), (int) head.getY()-1);
                    break;
            }
            restOfSnake.offer(pom);
            pom = restOfSnake.poll();
            panelHolder[(int) pom.getX()][(int) pom.getY()].setBackground(Color.lightGray);
        }
    }

    static void keySet(Integer k){
        key=k;
    }

    void run(){
        while(gameOn){
            try {
                wait(500);
                move();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public SnakeGamePanel() {
        setLayout(new GridLayout(grid, grid, 2, 2));
        fill();
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        putFood();
    }

    void fill(){
        for(int i=0; i<grid; i++){
            for(int j=0; j<grid; j++){
                JPanel panel = new JPanel();
                if(i==grid/2 && i==j){
                    panel.setBackground(new Color(102, 124, 38));
                    head = new Point(i, j);
                } else panel.setBackground(Color.LIGHT_GRAY);
                add(panel);
                panelHolder[i][j]=panel;
            }
        }
    }

    void putFood(){
        Random rand = new Random();
        int randX = rand.nextInt(40);
        int randY = rand.nextInt(40);
        food = new Point(randX, randY);
        panelHolder[randX][randY].setBackground(Color.RED);
    }

}
