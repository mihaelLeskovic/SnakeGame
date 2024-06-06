package snakegame.second;

import javax.swing.border.Border;
import java.awt.*;

public class RoundBorder implements Border {
    int radius;

    public RoundBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius+1, radius+1, radius+1, radius+1);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
