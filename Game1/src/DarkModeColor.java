import javax.swing.*;
import java.awt.*;

class DarkModeColor implements IColor {
    @Override
    public void applyColor(Container container, JButton[] buttons) {
        container.setBackground(Color.DARK_GRAY);
        for (JButton button : buttons) {
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
        }
    }
}
