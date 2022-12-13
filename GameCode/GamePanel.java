import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener
{
    private int width;
    private int height;

    public GamePanel(int width, int height)
    {
        this.setBackground(Color.BLACK);

        this.width = width - 20;
        this.height = height - 20; 

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.setColor(Color.WHITE);

        g.drawRect(10, 10, width, height);
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
