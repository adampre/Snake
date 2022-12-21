package AICode;

import java.awt.Point;

import SnakeCode.*;

public class AI 
{
    public static Direction getDirection(Snake snake, Point fruit, int dimension)
    {
        Direction output = null;

        int changeX = fruit.x - snake.body.get(0).position.x;
        int changeY = fruit.y - snake.body.get(0).position.y;
        
        if(Math.abs(changeX) > Math.abs(changeY))
        {
            output = (changeX <= 0) ? Direction.Left : Direction.Right;
        }
        else
        {
            output = (changeY <= 0) ? Direction.Up : Direction.Down;
        }

        if(!willCollide(snake, output, dimension)) return output;

        output = (output == Direction.Up || output == Direction.Down) ? ((changeX <= 0) ? Direction.Left : Direction.Right) : ((changeY <= 0) ? Direction.Up : Direction.Down);

        if(!willCollide(snake, output, dimension)) return output;

        if(willCollide(snake, output, dimension) && !willCollide(snake, oppositeDirection(output), dimension))
        {
            return oppositeDirection(output);
        }

        changeX = averagePositionOfSnake(snake).x - snake.body.get(0).position.x;
        changeY = averagePositionOfSnake(snake).y - snake.body.get(0).position.y;

        if(Math.abs(changeX) > Math.abs(changeY))
        {
            output = (changeX <= 0) ? Direction.Left : Direction.Right;
        }
        else
        {
            output = (changeY <= 0) ? Direction.Up : Direction.Down;
        }

        if(!willCollide(snake, output, dimension)) return output;

        output = (output == Direction.Up || output == Direction.Down) ? ((changeX <= 0) ? Direction.Left : Direction.Right) : ((changeY <= 0) ? Direction.Up : Direction.Down);

        if(!willCollide(snake, output, dimension)) return output;

        if(willCollide(snake, output, dimension) && !willCollide(snake, oppositeDirection(output), dimension))
        {
            return oppositeDirection(output);
        }

        return output;
    }

    private static Point averagePositionOfSnake(Snake snake)
    {
        int x = 0;
        int y = 0;

        for(int i = 0; i < snake.body.size(); i++)
        {
            x += snake.body.get(i).position.x;
            y += snake.body.get(i).position.y;
        }

        return new Point(x, y);
    }

    private static boolean willCollide(Snake snake, Direction direction, int dimension)
    {
        Point newHeadPosition = null;

        switch(direction)
        {
            case Down:
                newHeadPosition = new Point(snake.body.get(0).position.x, snake.body.get(0).position.y + snake.boxDimensions);
                break;

            case Left:
                newHeadPosition = new Point(snake.body.get(0).position.x - snake.boxDimensions, snake.body.get(0).position.y);
                break;

            case Right:
                newHeadPosition = new Point(snake.body.get(0).position.x + snake.boxDimensions, snake.body.get(0).position.y);
                break;

            case Up:
                newHeadPosition = new Point(snake.body.get(0).position.x, snake.body.get(0).position.y - snake.boxDimensions);
                break;            
        }

        for(int i = 1; i < snake.body.size(); i++)
        {
            if(newHeadPosition.equals(snake.body.get(i).position))
            {
                return true;
            }
        }

        if(newHeadPosition.y < 10 || newHeadPosition.y >= dimension || newHeadPosition.x < 10 || newHeadPosition.x >= dimension)
        {
            return true;
        }

        return false;
    }

    private static Direction oppositeDirection(Direction direction)
    {
        switch(direction)
        {
            case Down:
                return Direction.Up;

            case Left:
                return Direction.Right;

            case Right:
                return Direction.Left;

            case Up:
                return Direction.Down;
        }

        return null;
    }
}
