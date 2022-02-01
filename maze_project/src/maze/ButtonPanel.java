package maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static java.lang.System.exit;

public class ButtonPanel extends JPanel implements ActionListener{

    public static final int HEIGHT = 300;
    public static final int WIDTH = 500;
    JButton bGenerate, bLoad, bExit;

    public ButtonPanel() {
        bGenerate = new JButton("Generate MAZE");
        bLoad = new JButton("Load MAZE");
        bExit = new JButton("Exit");

        bGenerate.addActionListener(this);
        bLoad.addActionListener(this);
        bExit.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(bGenerate);
        add(bLoad);
        add(bExit);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bGenerate) {
            // metoda generująca labirynt
            System.out.println("Generowanie labiryntu...");
            Labyrinth L1 = new Labyrinth(10, 10);
            L1.toString();
            System.out.println("\n");
        }
        else if (source == bLoad) {
            // metoda wczytująca labirynt
            System.out.println("Wczytywanie labiryntu...");
        }
        else if (source == bExit) {
            // metoda kończąca działanie programu
            System.out.println("Wyjście z programu.");
            exit(0);
        }
    }
}