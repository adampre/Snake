import java.awt.Point;

import java.util.ArrayList;

public class Snake 
{
    public int boxDimensions;

    public ArrayList<BodyPart> body;

    public Snake(Point position, int initialSize, Direction initialDirection, int boxDimensions)
    {
        this.boxDimensions = boxDimensions;

        body = new ArrayList<BodyPart>();

        for(int i = 0; i < initialSize; i++)
        {
            body.add(new BodyPart(new Point(position.x - (i * boxDimensions), position.y), initialDirection));
        }
    }
}
