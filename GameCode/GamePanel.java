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

        this.dimension = Math.min(width, height) - 20;
        this.numberOfBoxes = dimension / 10;

        snake = new Snake(new Point(100, 100), 5, Direction.Right, dimension / numberOfBoxes);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        drawBoxes(g);

        g.setColor(Color.WHITE);

        g.drawRect(10, 10, dimension, dimension);

        drawSnake(g);
    }

    private void drawSnake(Graphics g)
    {
        for(int i = 0; i < snake.bodyParts.size(); i++)
        {
            g.fillRect(snake.bodyParts.get(i).x, snake.bodyParts.get(i).y, snake.boxDimensions, snake.boxDimensions);
        }
    }

    private void drawBoxes(Graphics g)
    {
        g.setColor(Color.BLUE);

        for(int i = 0; i < numberOfBoxes; i++)
        {
            for(int j = 0; j < numberOfBoxes; j++)
            {
                g.drawRect(j * snake.boxDimensions + 10, i * snake.boxDimensions + 10, snake.boxDimensions, snake.boxDimensions);
            }
        }
    }

    private boolean isGameOver()
    {
        switch(snake.direction)
        {
            case Up:
            if(snake.bodyParts.get(0).y <= 0)
            {
                return true;
            }
            break;

            case Left:
            if(snake.bodyParts.get(0).x <= 0)
            {
                return true;
            }
            break;

            case Right: 
            if(snake.bodyParts.get(0).x >= dimension)
            {
                return true;
            }
            break;

            case Down: 
            if(snake.bodyParts.get(0).y >= dimension)
            {
                return true;
            }
            break;
        }

        for(int i = 1; i < snake.bodyParts.size(); i++)
        {
            if(snake.bodyParts.get(0).equals(snake.bodyParts.get(i))) return true;
        }

        return false;
    }

    public void update()
    {
        if(isGameOver()) 
        {
            JOptionPane.showMessageDialog(null, "Game over. Your score was " + snake.bodyParts.size() + "!");

            System.exit(0);
        }

        switch(snake.direction)
        {
            case Up:   
            for(int i = 0; i < snake.bodyParts.size(); i++)
            {
                snake.bodyParts.get(i).y -= snake.boxDimensions;
            }
            break; 

            case Left:
            for(int i = 0; i < snake.bodyParts.size(); i++)
            {
                snake.bodyParts.get(i).x -= snake.boxDimensions;
            }
            break;

            case Right:
            for(int i = 0; i < snake.bodyParts.size(); i++)
            {
                snake.bodyParts.get(i).x += snake.boxDimensions;
            }
            break;

            case Down:
            for(int i = 0; i < snake.bodyParts.size(); i++)
            {
                snake.bodyParts.get(i).y += snake.boxDimensions;
            }
            break;
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
         
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            snake.direction = Direction.Up;
            break;

            case KeyEvent.VK_LEFT:
            snake.direction = Direction.Left;
            break;

            case KeyEvent.VK_RIGHT:
            snake.direction = Direction.Right;
            break;

            case KeyEvent.VK_DOWN:
            snake.direction = Direction.Down;
        }  
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
