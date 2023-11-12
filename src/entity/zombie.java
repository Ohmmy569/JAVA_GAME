package entity;

import mainn.GamePanel;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class zombie extends Entity {

    public zombie(GamePanel gp) {
        super(gp);
        direction = "down";
        name = "zombie";
        maxLife = 5;
        life = maxLife;
        DeafualtSpeed = 2;
        speed = DeafualtSpeed;
        Dmg = 1;

        solidbox = new Rectangle();
        solidbox.width = 25;
        solidbox.height = 25;
        solidbox.x = 8;
        solidbox.y = 16;
        solidboxDeafaultX = solidbox.x;
        solidboxDeafaultY = solidbox.y;

        getZombieimage();

    }

    public void getZombieimage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_right2.png"));
            dead = ImageIO.read(getClass().getResourceAsStream("/res/img/Zombie/zom_Dead.png"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading player image");
        }
    }

    public void setAction() {
        if (onPath == true) {

            int goalCol = (gp.player.worldX + gp.player.solidbox.x) / gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidbox.y) / gp.tileSize;

            searchPath(goalCol, goalRow);
        }
    }

}
