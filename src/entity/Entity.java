package entity;

import java.awt.image.BufferedImage;

import mainn.GamePanel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.AlphaComposite;
import java.awt.Color;

public class Entity {

    public int worldX, worldY;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, dead;
    public BufferedImage atkup1, atkup2, atkup3, atkdown1, atkdown2, atkdown3, atkleft1, atkleft2, atkleft3, atkright1,
            atkright2, atkright3;
    public BufferedImage shootup1, shootup2, shootup3, shootdown1, shootdown2, shootdown3, shootleft1, shootleft2,
            shootleft3, shootright1, shootright2, shootright3;
    public String direction;

    public int spriteCounter = 0;
    public int spriteDelay = 1;
    public int actionLockCounter = 0;
    public int DyingCounter = 0;

    public Rectangle solidbox = new Rectangle(0, 0, 48, 48);
    public Rectangle atkbox = new Rectangle(0, 0, 0, 0);
    public int solidboxDeafaultX, solidboxDeafaultY;
    public boolean collisionOn = false;
    public boolean invincible = false;
    public int invincibleCounter = 0;

    public String name;

    public boolean Attack = false;
    public boolean Shoot = false;

    // entity stats
    public int life;
    public int maxLife;
    public int energy;
    public int maxEnergy;
    public boolean live = true;
    public boolean dying = false;
    public int type = 0; // 0 = Monster, 1 = Player
    public boolean onPath = true;
    public boolean knockback = false;
    public int knockbackCounter = 0;
    public int speed;
    public int DeafualtSpeed;
    public int Dmg;
    public Projectile projectile;

    GamePanel gp;

    public Entity(GamePanel gp) {

        this.gp = gp;
    }

    public void setAction() {
    }

    public void checkCollision() {
        collisionOn = false;
        gp.cCheck.checkTile(this);
        gp.cCheck.checkObj(this, false);
        boolean hit = gp.cCheck.checkPlayer(this);
        if (hit == true) {
            if (gp.player.invincible == false) {
                gp.player.life--;
                gp.player.invincible = true;
            }
        }
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

    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.ScreenX;
        int screenY = worldY - gp.player.worldY + gp.player.ScreenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.ScreenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.ScreenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.ScreenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.ScreenY) {

            BufferedImage playerImage = null;

            switch (direction) {
                case "up":
                    if (spriteDelay == 1) {
                        playerImage = up1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = up2;
                    }

                    break;
                case "down":
                    if (spriteDelay == 1) {
                        playerImage = down1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = down2;
                    }
                    break;
                case "left":
                    if (spriteDelay == 1) {
                        playerImage = left1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = left2;
                    }
                    break;
                case "right":
                    if (spriteDelay == 1) {
                        playerImage = right1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = right2;
                    }
                    break;
            }
            // Monster Health Bar
            if (type == 0) {
                double scale = (double) gp.tileSize / (double) maxLife;
                double lifeBar = (double) life * scale;

                g2.setColor(Color.black);
                g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2, 12);
                g2.setColor(Color.red);
                g2.fillRect(screenX, screenY - 15, (int) lifeBar, 10);
            }

            if (invincible == true) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            }
            if (dying == true) {
                playerImage = dead;
                Dying(g2);
            }
            g2.drawImage(playerImage, screenX, screenY, gp.tileSize, gp.tileSize, null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        }
    }

    public void Dying(Graphics2D g2) {
        DyingCounter++;
        if (DyingCounter <= 20) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        }
        if (DyingCounter > 30) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            DyingCounter = 0;
            live = false;
        }

    }

    public void searchPath(int goalCol, int goalRow) {

        int startCol = (worldX + solidbox.x) / gp.tileSize;
        int startRow = (worldY + solidbox.y) / gp.tileSize;

        gp.pFinder.setNode(startCol, startRow, goalCol, goalRow);

        if (gp.pFinder.search() == true) {

            int nextX = gp.pFinder.PathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.PathList.get(0).row * gp.tileSize;

            int enLeftX = worldX + solidbox.x;
            int enRightX = worldX + solidbox.x + solidbox.width;
            int enTopY = worldY + solidbox.y;
            int enBottomY = worldY + solidbox.y + solidbox.height;

            if (enTopY > nextY && enLeftX >= nextX && enRightX <= nextX + gp.tileSize) {
                direction = "up";
            } else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "down";
            } else if (enTopY >= nextY && enBottomY < nextY + gp.tileSize) {

                if (enLeftX > nextX) {
                    direction = "left";
                }
                if (enLeftX < nextX) {
                    direction = "right";
                }
            } else if (enTopY > nextY && enLeftX > nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn == true) {
                    direction = "left";
                }
            } else if (enTopY > nextY && enLeftX < nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn == true) {
                    direction = "right";
                }

            } else if (enTopY < nextY && enLeftX > nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn == true) {
                    direction = "left";
                }

            } else if (enTopY < nextY && enLeftX < nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn == true) {
                    direction = "right";
                }

            }

        }

    }
}
