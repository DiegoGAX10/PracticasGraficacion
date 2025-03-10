package Curvas_Bezier;

import javax.swing.*;
import java.awt.*;

public class Bezier extends JFrame {
    public Bezier() {
        setTitle("Curva de Bézier");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
    }


    public static void main(String[] args) {
        new Bezier();
}
}
