package snakegame.second;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        setLayout(new GridLayout(5, 3, 7, 7));
        setBorder(BorderFactory.createEmptyBorder(10,0,10, 0));

        JButton playGame = new JButton("Play");
        JButton highscores = new JButton("High scores");
        playGame.setBorder(new RoundBorder(10));
        highscores.setBorder(new RoundBorder(10));

        JPanel iconPanel = new JPanel();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("res\\snake.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(100, 127, Image.SCALE_FAST)));
        imageLabel.setBounds(0, 0, 100, 100);
        iconPanel.add(imageLabel);

        add(new JPanel());
        add(iconPanel);
        add(new JPanel());
        add(new JPanel());
        add(playGame);
        add(new JPanel());
        add(new JPanel());
        add(highscores);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());

        playGame.addActionListener((e -> SnakeFrame.startGameAction()));
        highscores.addActionListener(e -> SnakeFrame.highscoresAction());
    }
}
