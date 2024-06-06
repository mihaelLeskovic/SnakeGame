package snakegame.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuPanel extends JPanel {
    JButton startGameBtn = new JButton("Start Game");
    JButton highscoreBtn = new JButton("High scores");

    public MainMenuPanel() {
        setLayout(new GridLayout(4, 3, 5, 5));

        for(int i=0; i<4; i++){
            add(new JPanel());
        }
        add(startGameBtn);
        add(new JPanel());
        add(new JPanel());
        add(highscoreBtn);
        for(int i=0; i<4; i++){
            add(new JPanel());
        }

        startGameBtn.addActionListener(e -> startGameAction(e));
        highscoreBtn.addActionListener(e -> highscoreAction(e));
        setVisible(true);
    }

    void startGameAction(ActionEvent e){

    }

    void highscoreAction(ActionEvent e){

    }
}
