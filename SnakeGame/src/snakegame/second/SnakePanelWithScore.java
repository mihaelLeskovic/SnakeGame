package snakegame.second;

import javax.swing.*;
import java.awt.*;

public class SnakePanelWithScore extends JPanel{

    static SnakePanel snakePanel = new SnakePanel();
    static JLabel scoreLabel = new JLabel("0", SwingConstants.CENTER);

    public SnakePanelWithScore(){
        setLayout(new BorderLayout());
        add(scoreLabel, BorderLayout.NORTH);
        add(snakePanel, BorderLayout.CENTER);
//        snakePanel = new SnakePanel();
    }

    void move(Movement move){
        snakePanel.move(move);
    }

    static void die(){
        System.out.println("died");
        HighscoresPanel.scoreMap.clear();
        HighscoresPanel.sortedSet.clear();
        HighscoresPanel.scoreMap = ScoreFileManager.loadScores(ScoreFileManager.scoreFilePath);
        String name=JOptionPane.showInputDialog
                (SnakeFrame.gameWindow,"Your score was " + scoreLabel.getText() + "\nEnter your name");
        if(!(HighscoresPanel.scoreMap.containsKey(name))
                || HighscoresPanel.scoreMap.get(name)<Integer.parseInt(scoreLabel.getText())){
            HighscoresPanel.scoreMap.put(name, Integer.parseInt(scoreLabel.getText()));
            HighscoresPanel.sortedSet.addAll(HighscoresPanel.scoreMap.entrySet());
            ScoreFileManager.scoreSaver();
        }
        SnakeFrame.goToMainMenu();
    }

}
