import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

import SnakeCode.Snake;
import SnakeCode.Direction;

public class GamePanel extends JPanel implements KeyListener
{
    private final Random RANDOM = new Random();

    private int dimension;
    private int numberOfBoxes;
    private int boxDimensions;

    private Snake snake;
    private Point fruit;

    public GamePanel(int width, int height)
    {
        this.setBackground(Color.BLACK);

        //code gets the nearest multiple of 30 to the minimum dimension of both the width and the height
        int nearestMultiple = Math.min(width, height) / 30 * 30;
        if(Math.min(width, height) % 30 > 15)
        {
            nearestMultiple += 30;
        }

        this.dimension = nearestMultiple;
        this.numberOfBoxes = dimension / 30;
        boxDimensions = (dimension / numberOfBoxes);

        snake = new Snake(new Point(100, 100), 5, Direction.Right, (dimension / numberOfBoxes));

        newFruit();

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

        drawFruit(g);
    }

    private void drawFruit(Graphics g)
    {
        g.setColor(Color.RED);

        g.fillRect(fruit.x + 1, fruit.y + 1, boxDimensions, boxDimensions - 1);
    }   

    private void drawSnake(Graphics g)
    {
        g.setColor(Color.WHITE);

        for(int i = 0; i < snake.body.size(); i++)
        {
            g.fillRect(snake.body.get(i).position.x + 1, snake.body.get(i).position.y, boxDimensions, boxDimensions + 1);
        }
    }

    private void drawBoxes(Graphics g)
    {
        g.setColor(Color.BLUE);

        for(int i = 0; i < numberOfBoxes; i++)
        {
            for(int j = 0; j < numberOfBoxes; j++)
            {
                g.drawRect(j * boxDimensions + 10, i * boxDimensions + 10, boxDimensions, boxDimensions);
            }
        }
    }

    private boolean isGameOver()
    {
        switch(snake.body.get(0).direction)
        {
            case Up: 
                if(snake.body.get(0).position.y < 10) 
                return true;

            case Down:
                if(snake.body.get(0).position.y >= dimension)
                return true;

            case Left:
                if(snake.body.get(0).position.x < 10)
                return true;

            case Right:
                if(snake.body.get(0).position.x >= dimension)
                return true;
        }

        for(int i = 1; i < snake.body.size(); i++)
        {
            if(snake.body.get(0).position.equals(snake.body.get(i).position))
            {
                return true;
            }
        }

        return false;
    }

    private void newFruit()
    {
        Point newPosition = null;

        do
        {
            newPosition = new Point(RANDOM.nextInt(numberOfBoxes) * boxDimensions + 10, RANDOM.nextInt(numberOfBoxes) * boxDimensions + 10);
        }
        while(snake.containsPoint(newPosition));

        fruit = newPosition;
    }

    public void update()
    {
        for(int i = snake.body.size() - 1; i >= 0; i--)
        {
            switch(snake.body.get(i).direction)
            {
                case Up: 
                    snake.body.get(i).position.y -= boxDimensions;
                    break;

                case Left: 
                    snake.body.get(i).position.x -= boxDimensions;
                    break;

                case Right: 
                    snake.body.get(i).position.x += boxDimensions;
                    break;

                case Down: 
                    snake.body.get(i).position.y += boxDimensions;
                    break;
            }

            if(i > 0)
            {
                snake.body.get(i).direction = snake.body.get(i - 1).direction;
            }
        }

        if(snake.body.get(0).position.equals(fruit))
        {
            snake.addBodyPart();
            
            newFruit();
        }

        if(isGameOver()) 
        {
            JOptionPane.showMessageDialog(null, "Game over. Your score was " + snake.body.size() + "!");

            System.exit(0);
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
                if(snake.body.get(0).direction == Direction.Down) break;
                snake.body.get(0).direction = Direction.Up;
                break;

            case KeyEvent.VK_LEFT:
                if(snake.body.get(0).direction == Direction.Right) break;
                snake.body.get(0).direction = Direction.Left;
                break;

            case KeyEvent.VK_RIGHT:
                if(snake.body.get(0).direction == Direction.Left) break;
                snake.body.get(0).direction = Direction.Right;
                break;

            case KeyEvent.VK_DOWN:
                if(snake.body.get(0).direction == Direction.Up) break;
                snake.body.get(0).direction = Direction.Down;
                break;
        }  
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
