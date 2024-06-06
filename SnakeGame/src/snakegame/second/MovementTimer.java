package snakegame.second;

import java.awt.event.KeyEvent;

public class MovementTimer implements Runnable{
    static boolean delayGameOn = true;
    static long delay = 250L;

    @Override
    public void run() {
        while(true){
//            System.out.println("Game on:" + gameOn + " delayGameOn:" + delayGameOn);
            System.out.print("");
            if (SnakeFrame.gameOn || delayGameOn) {
                if (SnakeFrame.gameOn) {
                    if (SnakeFrame.gameOn) delayGameOn = true;
                    try {
                        Thread.sleep(delay);
//                        System.out.println("Trying to move");
                        SnakeFrame.gamePanel.move(getMove());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!SnakeFrame.gameOn && delayGameOn) {
                    SnakePanelWithScore.die();
                    delayGameOn = false;
                }
            }
        }
    }

    Movement getMove(){
        switch(SnakeFrame.gkl.key) {
            case KeyEvent.VK_DOWN:
                return Movement.DOWN;
            case KeyEvent.VK_UP:
                return Movement.UP;
            case KeyEvent.VK_RIGHT:
                return Movement.RIGHT;
            case KeyEvent.VK_LEFT:
                return Movement.LEFT;
            case KeyEvent.VK_S:
                return Movement.DOWN;
            case KeyEvent.VK_W:
                return Movement.UP;
            case KeyEvent.VK_D:
                return Movement.RIGHT;
            case KeyEvent.VK_A:
                return Movement.LEFT;
            default:
                return Movement.NULL;
        }
    }
}
