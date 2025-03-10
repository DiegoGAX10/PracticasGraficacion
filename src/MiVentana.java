import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class MiVentana extends JFrame{
public MiVentana(){
    setTitle("Mi primera ventana");
    setSize(600, 600);
    setLocationRelativeTo(null);
    setUndecorated(true);
    setVisible(true);
    setBackground(Color.BLACK);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

}
public void paint (Graphics g){
    g.setColor(Color.BLUE);
    g.drawLine(0, 0, 599, 599);
    g.setColor(Color.RED);
    g.drawLine(599, 0, 0, 599);
    g.setColor(Color.MAGENTA);
    g.drawRect(150, 100, 200, 200);
    g.fillRect(200, 200, 200, 200);
    g.setColor(Color.GREEN);
    g.drawOval(200, 200, 200, 200);
    int[] xPoints = {300, 400, 300, 250};
    int[] yPoints = {300, 500, 400, 500};
    int nPoints = 4;
    g.setColor(Color.ORANGE);
    g.drawPolygon(xPoints, yPoints, nPoints);
    g.fillPolygon(xPoints, yPoints, nPoints);
}
    public static void main(String[] args) {
    MiVentana ventana = new MiVentana();

    }
}
