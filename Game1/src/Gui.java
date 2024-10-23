import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    JButton changeColorbutton;
    JButton changeSymbolsButton;
    JPanel CPanel;
    JPanel SPanel;

    Gui() {
// AAAA
        this.setTitle("TicTacTo");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel north_panel = new JPanel();
        north_panel.setLayout(new GridLayout(6, 1, 50, 20)); // Justerat layout för att rymma fler knappar
        north_panel.setBorder(new LineBorder(Color.BLUE, 5));


        changeSymbolsButton = new JButton("Välj Figurere");
        changeSymbolsButton.addActionListener(this);

        changeColorbutton = new JButton("Välj färg");
        changeColorbutton.addActionListener(this);

        JButton btn3 = new JButton("Spela");
        btn3.addActionListener(this);

        JButton btn4 = new JButton("Tre i rad");
        btn4.addActionListener(this);

        JButton btn5 = new JButton("Fyra i rad");
        btn5.addActionListener(this);

        JButton btn6 = new JButton("Fem i rad");
        btn6.addActionListener(this);

        north_panel.add(changeSymbolsButton);
        north_panel.add(changeColorbutton);
        north_panel.add(btn3);
        north_panel.add(btn4);
        north_panel.add(btn5);
        north_panel.add(btn6);

        CPanel = new JPanel();
        SPanel = new JPanel();

        TitledBorder north_panelTitle = BorderFactory.createTitledBorder("Main meny");
        TitledBorder CPanelTitle = BorderFactory.createTitledBorder("Färger");
        TitledBorder SpanelTitle = BorderFactory.createTitledBorder("Figurer");

        CPanel.setBorder(CPanelTitle);
        SPanel.setBorder(SpanelTitle);
        north_panel.setBorder(north_panelTitle);

        this.add(north_panel, BorderLayout.NORTH);
        this.add(CPanel, BorderLayout.CENTER);
        this.add(SPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Välj färg":
                CPanel.setBackground(Color.red);
                break;

            case "Välj Figurere":
                System.out.println("Välj Figurere");
                break;

            case "Spela":
                System.out.println("Spela");
                break;

            case "Tre i rad":
                System.out.println("Tre i rad");
                break;

            case "Fyra i rad":
                System.out.println("Fyra i rad");
                break;

            case "Fem i rad":
                System.out.println("Fem i rad");
                break;
        }
    }

}