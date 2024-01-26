import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CercInteractiv extends JFrame {
    private int cercX = 100; // Coordonata x a centrului cercului
    private int cercY = 100; // Coordonata y a centrului cercului

    public CercInteractiv() {
        setTitle("Cerc Interactiv");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                cercX = e.getX(); // Actualizează coordonata x a cercului la coordonata x a mouse-ului
                cercY = e.getY(); // Actualizează coordonata y a cercului la coordonata y a mouse-ului
                repaint(); // Redesenează fereastra pentru a reflecta modificările
            }
        });
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight()); // Umple fereastra cu culoare albă pentru a șterge cercul anterior
        g.setColor(Color.BLUE);
        g.fillOval(cercX - 20, cercY - 20, 40, 40); // Desenează un cerc albastru cu centrul la coordonatele cercX și cercY
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CercInteractiv::new);
    }
}
