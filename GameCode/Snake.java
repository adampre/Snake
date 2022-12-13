import java.awt.Point;

public class Snake 
{
    public Point position;

    public int size;

    public String direction; 

    public Snake(Point position, int startingSize)
    {
        this.position = position;

        this.size = startingSize;
    }
}
