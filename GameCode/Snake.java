import java.awt.Point;

public class Snake 
{
    public Point position;

    public int size;

    public String direction; 

    public Snake(Point position, int initialSize, String initialDirection)
    {
        this.position = position;

        this.size = initialSize;

        this.direction = initialDirection;
    }
}
