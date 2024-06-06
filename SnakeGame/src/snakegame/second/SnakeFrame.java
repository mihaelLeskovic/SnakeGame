package snakegame.second;

import javax.swing.*;

//TODO ubaciti imena

public class SnakeFrame extends JFrame {
    static int grid = 12;
    static GameKeyListener gkl = new GameKeyListener();
    static boolean gameOn = true;
    static SnakeFrame gameWindow = new SnakeFrame();
    static MenuPanel mainMenu = new MenuPanel();
    static SnakePanelWithScore gamePanel = new SnakePanelWithScore();
    static HighscoresPanelWithButtons highscores = new HighscoresPanelWithButtons();
    static boolean hasBeenRan = false;

    public static int getGrid() {
        return grid;
    }

    public static void main(String[] args) throws InterruptedException {
        runWindow();
        Runnable r1 = new MovementTimer();
        new Thread(r1).start();
    }

    private static void runWindow() {
        gameWindow.setTitle("Snake Game by mih");
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setFocusable(true);

        gameWindow.addKeyListener(gkl);
        gameWindow.add(mainMenu);
        gameWindow.setContentPane(mainMenu);

        gameWindow.setBounds(420, 100, 680, 680);
        gameWindow.setVisible(true);

    }

    static void setGameOn(boolean bool){
        gameOn = bool;
    }

    static void goToMainMenu(){
        mainMenu = new MenuPanel();
        gameWindow.getContentPane().removeAll();
        gameWindow.setContentPane(mainMenu);
        gameWindow.revalidate();
    }

    static void startGameAction(){
//        System.out.printf("attempting the switch to game");
        gamePanel = new SnakePanelWithScore();
        if(hasBeenRan) {
            gamePanel.snakePanel.reset();     //TODO
        }
        gameWindow.getContentPane().removeAll();
        gameWindow.setContentPane(gamePanel);
        gameWindow.revalidate();
        hasBeenRan = true;
        System.out.println(gameOn);
    }

    static void highscoresAction(){
//        System.out.printf("attempting the switch to hs");
        highscores = new HighscoresPanelWithButtons();
        gameWindow.getContentPane().removeAll();
        gameWindow.setContentPane(highscores);
        gameWindow.revalidate();
    }

}
