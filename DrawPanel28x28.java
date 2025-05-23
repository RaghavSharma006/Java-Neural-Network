import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel28x28 extends JPanel {
    private final int GRID_SIZE = 28;
    private final int CELL_SIZE = 20;
    private float[][] pixels = new float[GRID_SIZE][GRID_SIZE];

    public DrawPanel28x28() {
        setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE));
        setBackground(Color.WHITE);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() / CELL_SIZE;
                int y = e.getY() / CELL_SIZE;
                if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
                    pixels[y][x] = 1.0f;
                    repaint();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                mouseDragged(e);
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                int gray = (int) ((1 - pixels[y][x]) * 255);
                g.setColor(new Color(gray, gray, gray));
                g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    public double[] getInputVector() {
        double[] input = new double[GRID_SIZE * GRID_SIZE];
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                input[y * GRID_SIZE + x] = pixels[y][x];
            }
        }
        return input;
    }

    public void clear() {
        for (int y = 0; y < GRID_SIZE; y++)
            for (int x = 0; x < GRID_SIZE; x++)
                pixels[y][x] = 0f;
        repaint();
    }
}
