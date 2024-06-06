package snakegame.first;

import javax.swing.*;
import java.awt.*;

public class MainProgram extends JFrame {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            MainProgram frame = new MainProgram();
            frame.setBounds(510, 190, 500, 500);
            frame.setVisible(true);

        });
    }

    public MainProgram() throws HeadlessException {
        setName("Snake Game by mih");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setFocusable(true);
        GameKeyListener gkl = new GameKeyListener();
        addKeyListener(gkl);
        runGame();


    }

    void runGame(){
        setContentPane(new SnakeGamePanel());
    }

}
