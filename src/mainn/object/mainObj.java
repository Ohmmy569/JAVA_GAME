package mainn.object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import mainn.GamePanel;

public class mainObj {

    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidbox = new Rectangle(0, 0, 48, 48);
    public int solidboxDeafaultX = 0, solidboxDeafaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp) {

        int screenX = worldX - gp.player.worldX + gp.player.ScreenX;
        int screenY = worldY - gp.player.worldY + gp.player.ScreenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.ScreenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.ScreenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.ScreenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.ScreenY) {

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }

    }

}
