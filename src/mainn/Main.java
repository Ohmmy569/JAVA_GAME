package mainn;
import javax.swing.JFrame;

public class Main {


public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Little Knight");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // packs the window to fit the preferred size of the components

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();


    }
}
