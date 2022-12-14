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
        g.setColor(Color.WHITE);

        for(int i = 0; i < snake.body.size(); i++)
        {
            g.fillRect(snake.body.get(i).position.x, snake.body.get(i).position.y, snake.boxDimensions, snake.boxDimensions);
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
        

        return false;
    }

    public void update()
    {
        if(isGameOver()) 
        {
            JOptionPane.showMessageDialog(null, "Game over. Your score was " + snake.body.size() + "!");

            System.exit(0);
        }

        for(int i = snake.body.size() - 1; i >= 0; i--)
        {
            if(i > 0)
            {
                snake.body.get(i).direction = snake.body.get(i - 1).direction;
            }

            switch(snake.body.get(i).direction)
            {
                case Up: 
                snake.body.get(i).position.y -= snake.boxDimensions;
                break;

                case Left: 
                snake.body.get(i).position.x -= snake.boxDimensions;
                break;

                case Right: 
                snake.body.get(i).position.x += snake.boxDimensions;
                break;

                case Down: 
                snake.body.get(i).position.y += snake.boxDimensions;
                break;
            }
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
            snake.body.get(0).direction = Direction.Up;
            break;

            case KeyEvent.VK_LEFT:
            snake.body.get(0).direction = Direction.Left;
            break;

            case KeyEvent.VK_RIGHT:
            snake.body.get(0).direction = Direction.Right;
            break;

            case KeyEvent.VK_DOWN:
            snake.body.get(0).direction = Direction.Down;
        }  
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
