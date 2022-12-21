package AICode;

import java.awt.Point;

import SnakeCode.*;

public class AI 
{
    public static Direction getDirection(Snake snake, Point fruit)
    {
        int changeX = fruit.x - snake.body.get(0).position.x;
        int changeY = fruit.y - snake.body.get(0).position.y;

        System.out.println(changeX + " " + changeY);
        
        if(changeX <= changeY)
        {
            return (changeX <= 0) ? Direction.Left : Direction.Right;
        }

        return (changeY <= 0) ? Direction.Up : Direction.Down;
    }
}
