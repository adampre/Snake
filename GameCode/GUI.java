import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.Timer;

import AICode.AI;

public class GUI extends JFrame implements ActionListener
{
    // * TRUE MEANS THE AI WILL PLAY
    // * FALSE MEANS YOU HAVE TO PLAY
    private final boolean doAI = true;

    private GamePanel gamePanel; 

    private Timer timer;

    public GUI()
    {
        this.setTitle("Snake");
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel(this.getWidth() - 50, this.getHeight() - 50);
        this.add(gamePanel, BorderLayout.CENTER);
        this.addKeyListener(gamePanel);

        timer = new Timer(70, this);
    }

    public void gameInit()
    {
        this.setVisible(true);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(doAI)
        {
            gamePanel.snake.body.get(0).direction = AI.getDirection(gamePanel.snake, gamePanel.fruit, gamePanel.numberOfBoxes);
        }

        gamePanel.update();
    }
}
