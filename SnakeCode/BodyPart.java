package SnakeCode;
import java.awt.Point;

public class BodyPart 
{
    public Point position;
    public Direction direction;

    public BodyPart(Point position, Direction direction)
    {
        this.position = position;
        this.direction = direction;
    }

    public BodyPart(Point position)
    {
        this.position = position;
        this.direction = null;
    }
}
