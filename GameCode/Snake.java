import java.awt.Point;

import java.util.ArrayList;

public class Snake 
{
    public Point position;
    public Direction direction; 
    public int boxDimensions;

    public ArrayList<Point> bodyParts;

    public Snake(Point position, int initialSize, Direction initialDirection, int boxDimensions)
    {
        this.position = position;
        this.direction = initialDirection;
        this.boxDimensions = boxDimensions;

        bodyParts = new ArrayList<Point>();

        for(int i = 0; i < initialSize; i++)
        {
            bodyParts.add(new Point(position.x - (i * boxDimensions), position.y));
        }
    }
}
