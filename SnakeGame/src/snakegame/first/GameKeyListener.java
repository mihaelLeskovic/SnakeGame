package snakegame.first;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    public static Integer getKey() {
        return SnakeGamePanel.key;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        SnakeGamePanel.keySet(e.getKeyCode());
        System.out.println(getKey());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
