import javax.swing.*;

public class Ventana_Default extends JFrame {

    int resX = 600;
    int resY = 600;


    public Ventana_Default(){
        setTitle("Graficando en 2d");
        setSize(resX, resY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Ventana_Default();
    }

}
