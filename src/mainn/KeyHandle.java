package mainn;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandle implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, AttackPressed;
    GamePanel gp;

    public KeyHandle(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // menu
        if (gp.gameState == 0) {
            if (code == KeyEvent.VK_W) {
                if (gp.ui.menuSelect > 0) {
                    gp.ui.menuSelect--;
                }
            }
            if (code == KeyEvent.VK_S) {
                if (gp.ui.menuSelect < 1) {
                    gp.ui.menuSelect++;
                }
            }
            if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
                if (gp.ui.menuSelect == 0) {
                    gp.gameState = 1;
                }
                if (gp.ui.menuSelect == 1) {
                    System.exit(0);
                }
            }
        } else if (gp.gameState == 1) {
            // ingame
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_1) {
                gp.player.Handslot = 0;
            }
            if (code == KeyEvent.VK_2) {
                gp.player.Handslot = 1;
            }
            if (code == KeyEvent.VK_SPACE) {
                AttackPressed = true;
            }
        } else if (gp.gameState == 2) {
            // dialog
            if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {

                gp.gameState = 1;
            }
        } else {
            // game over or win
            if (code == KeyEvent.VK_SPACE) {

                gp.resetGame();
                
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (gp.gameState == 2) {

            if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_ENTER) {
                gp.gameState = 1;

            }
        }
        if (gp.gameState == 3) {

            if (code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_ENTER) {
                gp.setupGame();

            }
        }
        if (code == KeyEvent.VK_SPACE) {
            AttackPressed = false;
        }
    }
}
