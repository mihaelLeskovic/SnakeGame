package snakegame.second;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    static int key;

    public static Integer getKey() {
        return key;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!(key==KeyEvent.VK_DOWN && e.getKeyCode()==KeyEvent.VK_UP) &&
                !(key==KeyEvent.VK_UP && e.getKeyCode()==KeyEvent.VK_DOWN) &&
                !(key==KeyEvent.VK_RIGHT && e.getKeyCode()==KeyEvent.VK_LEFT) &&
                !(key==KeyEvent.VK_LEFT && e.getKeyCode()==KeyEvent.VK_RIGHT) &&
                (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT ||
                 e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN ||
                 e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_D ||
                 e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_A)) key = e.getKeyCode();

//        System.out.println(getKey());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
