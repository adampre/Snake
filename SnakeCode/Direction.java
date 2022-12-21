package SnakeCode;

import java.util.Map;
import java.util.HashMap;

public enum Direction 
{
    Up(0), 
    Left(1), 
    Right(2), 
    Down(3);

    private int value;
    private static Map<Integer, Direction> map = new HashMap<Integer, Direction>();

    private Direction(int value)
    {
        this.value = value;
    }

    static 
    {
        for(Direction direction : Direction.values())
        {
            map.put(direction.value, direction);
        }
    }

    public static Direction valueOf(int direction)
    {
        return (Direction)map.get(direction);
    }

    public int getValue()
    {
        return value;
    }
}