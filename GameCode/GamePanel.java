import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener
{
    private int dimension;

    private int numberOfBoxes;

    private Snake snake;

    public GamePanel(int width, int height)
    {
        this.setBackground(Color.BLACK);

        this.dimension = (width + height) / 2;

        numberOfBoxes = dimension / 10;

        snake = new Snake(new Point(30, 30), 5, "w");

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        drawBoxes(g);

        g.setColor(Color.WHITE);

        g.drawRect(10, 10, dimension, dimension);
    }

    private void drawBoxes(Graphics g)
    {
        g.setColor(Color.BLUE);

        for(int i = 0; i < numberOfBoxes; i++)
        {
            for(int j = 0; j < numberOfBoxes; j++)
            {
                g.drawRect(j * (dimension / numberOfBoxes) + 10, i * (dimension / numberOfBoxes) + 10, (dimension / numberOfBoxes), (dimension / numberOfBoxes));
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
