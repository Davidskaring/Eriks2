import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class mainGUI {
    private JButton färgsättningButton;
    private JButton väljSymbolFörSpelarnaButton;
    private JButton femIRadButton;
    private JButton fyraIRadButton;
    private JButton treIRadButton;
    private JPanel mainPanel;
    private JLabel lbl;

    public static void main(String[] args) {
        JFrame frame = new JFrame("tic tac toe");
        frame.setContentPane(new mainGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setVisible(true);  // Gör fönstret synligt
    }
    public mainGUI() {
            mainPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                }
            });
            treIRadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Gui();
                }
            });
            fyraIRadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Game1GUI();
                }
            });
            femIRadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            väljSymbolFörSpelarnaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            färgsättningButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
    }
