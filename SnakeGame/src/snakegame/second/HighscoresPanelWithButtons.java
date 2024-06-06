package snakegame.second;

import javax.swing.*;
import java.awt.*;

public class HighscoresPanelWithButtons extends JPanel {
    static HighscoresPanel highscoresPanel = new HighscoresPanel();
    static JButton backButton = new JButton("Back");

    public HighscoresPanelWithButtons() {
        setLayout(new BorderLayout());
        backButton.setBorder(new RoundBorder(10));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 6));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        buttonPanel.add(backButton);
        for(int i=0; i<5; i++){
            buttonPanel.add(new JPanel());
        }
        highscoresPanel = new HighscoresPanel();
        add(buttonPanel, BorderLayout.NORTH);
        add(highscoresPanel, BorderLayout.CENTER);
        backButton.addActionListener((event)->{
            SnakeFrame.goToMainMenu();
        });
    }
}
