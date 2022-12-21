# Snake Game
*1 Player Game*
---
**Introduction**

Full snake game and an AI that can play if you choose to. 
---
**Rules**
1. The game takes place on a grid, with the player controlling a snake that moves around the grid.
2. The snake starts off as a small length and grows in size as it eats "food" that is randomly placed on the grid.
3. The player controls the direction that the snake moves in by using the arrow keys or WASD keys on the keyboard.
4. The snake cannot move through walls or its own body. If the snake runs into a wall or its own body, the game is over.
5. The goal of the game is to make the snake as long as possible by eating as much food as possible without running into a wall or its own body.
---
**AI**

The AI code has its own seperate folder, which is in the AICode folder. The AI choosed the shortest path to the food that doesn't run into itself. 
```java
public static Direction getDirection(Snake snake, Point fruit, int dimension)
```
---
**DISCLAIMER**

The AI is not complete. It chooses the shortest path to the food, such that the average point of the body (average of all the x's and y's of the body) is not directly in between the head and the food. This does not keep the snake from trapping itself. This is still in development. 
