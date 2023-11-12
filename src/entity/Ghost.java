package entity;

import mainn.GamePanel;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class Ghost extends Entity {

    public Ghost(GamePanel gp) {
super(gp);
direction = "down";
name = "Ghost";
maxLife = 9;
life = maxLife;
DeafualtSpeed = 1;
speed = DeafualtSpeed;
Dmg = 2;

solidbox = new Rectangle();
solidbox.width = 25;
solidbox.height = 25;
solidbox.x = 8;
solidbox.y = 16;
solidboxDeafaultX = solidbox.x;
solidboxDeafaultY = solidbox.y;

getGhostimage();

    }


    public void knockback() {
        return;
    }

    public void update() {

        if (knockback == true) {
            checkCollision();
            if (collisionOn == true) {
                knockbackCounter = 0;
                knockback = false;
                speed = DeafualtSpeed;
            } else if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY = worldY - 0;
                        break;
                    case "down":
                        worldY = worldY + 0;
                        break;
                    case "left":
                        worldX = worldX - 0;
                        break;
                    case "right":
                        worldX = worldX + 0;
                        break;

                }
                knockbackCounter++;
                if (knockbackCounter == 5) {
                    knockbackCounter = 0;
                    knockback = false;
                    speed = DeafualtSpeed;
                }
            }
        } else {

            setAction();
            checkCollision();

            if (collisionOn == false) {

                switch (direction) {
                    case "up":
                        worldY = worldY - speed;
                        break;
                    case "down":
                        worldY = worldY + speed;
                        break;
                    case "left":
                        worldX = worldX - speed;
                        break;
                    case "right":
                        worldX = worldX + speed;
                        break;

                }

            }

        }

        spriteCounter++;
        if (spriteCounter > 20) {
            if (spriteDelay == 1) {
                spriteDelay = 2;
            } else if (spriteDelay == 2) {
                spriteDelay = 1;
            }
            spriteCounter = 0;
        }

        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 40) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void getGhostimage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost3.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/img/Ghost/ghost2.png"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading player image");
        }
    }

    public void setAction() {
        if (onPath == true) {
            knockback = false;
            int goalCol = (gp.player.worldX + gp.player.solidbox.x) / gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidbox.y) / gp.tileSize;

            searchPath(goalCol, goalRow);
        }
    }

}
