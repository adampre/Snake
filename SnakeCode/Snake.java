package SnakeCode;
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

    public void addBodyPart()
    {
        switch(body.get(body.size() - 1).direction)
        {
            case Up:
                body.add(new BodyPart(new Point(body.get(body.size() - 1).position.x, body.get(body.size() - 1).position.y + boxDimensions), body.get(body.size() - 1).direction));
                return;
            
            case Left:
                body.add(new BodyPart(new Point(body.get(body.size() - 1).position.x + boxDimensions, body.get(body.size() - 1).position.y), body.get(body.size() - 1).direction));
                return;

            case Right:
                body.add(new BodyPart(new Point(body.get(body.size() - 1).position.x - boxDimensions, body.get(body.size() - 1).position.y), body.get(body.size() - 1).direction));
                return;

            case Down:
                body.add(new BodyPart(new Point(body.get(body.size() - 1).position.x, body.get(body.size() - 1).position.y - boxDimensions), body.get(body.size() - 1).direction));
                return;
        }
    }
}
