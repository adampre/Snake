import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame 
{
    private GamePanel gamePanel; 

    public GUI()
    {
        this.setTitle("Snake");
        this.setLayout(new BorderLayout());
        this.setBounds(0, 0, 1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel(this.getWidth() - 200, this.getHeight() - 200);
        this.add(gamePanel, BorderLayout.CENTER);
        this.addKeyListener(gamePanel);
    }

    public void gameInit()
    {
        this.setVisible(true);
    }
}
