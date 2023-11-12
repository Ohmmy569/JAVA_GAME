package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import mainn.GamePanel;
import mainn.KeyHandle;
import mainn.ResizeImg;
import mainn.object.obj_sword;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.AlphaComposite;

public class Player extends Entity {
    KeyHandle keyHandle;
    int deadcounter = 0;

    public final int ScreenX;
    public final int ScreenY;
    int hasWeapon = 0;
    public String[] inventory = new String[2];
    int lifeCounter = 0;
    int EnergyCounter = 0;
    public int Handslot = 0;
    obj_sword sword = new obj_sword();

    public Player(GamePanel gp, KeyHandle kh) {
        super(gp);
        this.keyHandle = kh;
        type = 1;

        ScreenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        ScreenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidbox = new Rectangle();
        solidbox.x = 8;
        solidbox.y = 16;
        solidboxDeafaultX = solidbox.x;
        solidboxDeafaultY = solidbox.y;

        solidbox.width = 32;
        solidbox.height = 32;

        atkbox.width = 45;
        atkbox.height = 45;

        setDefaultValues();
        getPlayerimage();
        getPlayer_Atkimage();
        getPlayer_Shootimage();

    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 8;
        worldY = gp.tileSize * 42;
        DeafualtSpeed = 3;
        speed = DeafualtSpeed;
        direction = "down";

        // stats
        maxLife = 5;
        life = maxLife;
        maxEnergy = 5;
        energy = maxEnergy;
        projectile = new Arrow(gp);
    }

    public void knockback(Entity entity) {

        entity.direction = direction;
        entity.speed += 10;
        entity.knockback = true;
    }

    public void getPlayerimage() {
        try {

            up1 = setup("Player_Back1", gp.tileSize, gp.tileSize);
            up2 = setup("Player_Back2", gp.tileSize, gp.tileSize);
            down1 = setup("Player_Front1", gp.tileSize, gp.tileSize);
            down2 = setup("Player_Front2", gp.tileSize, gp.tileSize);
            left1 = setup("Player_left1", gp.tileSize, gp.tileSize);
            left2 = setup("Player_left2", gp.tileSize, gp.tileSize);
            right1 = setup("Player_right1", gp.tileSize, gp.tileSize);
            right2 = setup("Player_right2", gp.tileSize, gp.tileSize);
            dead = setup("Player_Dead", gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading player image");
        }
    }

    public void getPlayer_Atkimage() {
        try {

            atkup1 = setup("Player_Back_atk1", gp.tileSize, gp.tileSize * 2);
            atkup2 = setup("Player_Back_atk2", gp.tileSize, gp.tileSize * 2);
            atkup3 = setup("Player_Back_atk3", gp.tileSize, gp.tileSize * 2);
            atkdown1 = setup("Player_Front_atk1", gp.tileSize, gp.tileSize * 2);
            atkdown2 = setup("Player_Front_atk2", gp.tileSize, gp.tileSize * 2);
            atkdown3 = setup("Player_Front_atk3", gp.tileSize, gp.tileSize * 2);
            atkleft1 = setup("Player_left_atk1", gp.tileSize * 2, gp.tileSize);
            atkleft2 = setup("Player_left_atk2", gp.tileSize * 2, gp.tileSize);
            atkleft3 = setup("Player_left_atk3", gp.tileSize * 2, gp.tileSize);
            atkright1 = setup("Player_right_atk1", gp.tileSize * 2, gp.tileSize);
            atkright2 = setup("Player_right_atk2", gp.tileSize * 2, gp.tileSize);
            atkright3 = setup("Player_right_atk3", gp.tileSize * 2, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading player image");
        }
    }

    public void getPlayer_Shootimage() {
        try {

            shootup1 = setup("Player_back_Shoot1", gp.tileSize, gp.tileSize);
            shootup2 = setup("Player_back_Shoot1", gp.tileSize, gp.tileSize);
            shootup3 = setup("Player_back_Shoot1", gp.tileSize, gp.tileSize);
            shootdown1 = setup("Player_front_Shoot1", gp.tileSize, gp.tileSize);
            shootdown2 = setup("Player_front_Shoot2", gp.tileSize, gp.tileSize);
            shootdown3 = setup("Player_front_Shoot3", gp.tileSize, gp.tileSize);
            shootleft1 = setup("Player_left_Shoot1", gp.tileSize, gp.tileSize);
            shootleft2 = setup("Player_left_Shoot2", gp.tileSize, gp.tileSize);
            shootleft3 = setup("Player_left_Shoot3", gp.tileSize, gp.tileSize);
            shootright1 = setup("Player_right_Shoot1", gp.tileSize, gp.tileSize);
            shootright2 = setup("Player_right_Shoot2", gp.tileSize, gp.tileSize);
            shootright3 = setup("Player_right_Shoot3", gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading player image");
        }
    }

    public BufferedImage setup(String imgName, int width, int height) {
        ResizeImg scaleIMG = new ResizeImg();
        BufferedImage img = null;

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/res/img/Player/" + imgName + ".png"));
            img = scaleIMG.scaleImage(img, width, height);
            return img;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    public void attacking() {
        spriteCounter++;

        if (spriteCounter <= 5) {
            spriteDelay = 1;

        }
        if (spriteCounter > 5 && spriteCounter <= 15) {
            spriteDelay = 2;

            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidboxWidth = solidbox.width;
            int solidboxYHeight = solidbox.height;

            switch (direction) {
                case "up":
                    worldY -= atkbox.height;
                    break;
                case "down":
                    worldY += atkbox.height;
                    break;
                case "left":
                    worldX -= atkbox.width;
                    break;
                case "right":
                    worldX += atkbox.width;
                    break;

            }

            solidbox.width = atkbox.width;
            solidbox.height = atkbox.height;

            int monsterindex = gp.cCheck.checkEntity(this, gp.entity);
            Dodamage(monsterindex, sword.Damage, sword.name);

            worldX = currentWorldX;
            worldY = currentWorldY;
            solidbox.width = solidboxWidth;
            solidbox.height = solidboxYHeight;

        }
        if (spriteCounter > 15 && spriteCounter <= 25) {
            spriteDelay = 3;
        }
        if (spriteCounter > 25) {
            spriteCounter = 0;
            spriteDelay = 1;
            energy = energy - 2;
            if (energy < 0) {
                energy = 0;
            }
            Attack = false;

        }

    }

    public void Shooting() {
        spriteCounter++;
        if (spriteCounter <= 5) {
            spriteDelay = 1;

        }
        if (spriteCounter > 5 && spriteCounter <= 12) {
            spriteDelay = 2;
        }
        if (spriteCounter > 12 && spriteCounter <= 20) {
            spriteDelay = 3;
        }
        if (spriteCounter > 20) {
            spriteCounter = 0;
            spriteDelay = 1;
            energy = energy - 3;
            if (energy < 0) {
                energy = 0;
            }
            projectile.set(worldX, worldY, direction, true);
            gp.projectileList.add(projectile);
            Shoot = false;

        }
    }

    public void handleAttack() {

        if (keyHandle.AttackPressed == true && energy > 1) {
            if (inventory[0] == "sword") {
                if (Handslot == 0) {
                    Attack = true;
                }

            }
        }
        if (keyHandle.AttackPressed == true && energy > 2) {
            if (inventory[1] == "bow") {
                if (Handslot == 1) {
                    Shoot = true;
                }

            }

        }

    }

    public void update() {
        // print player position tilemap

        if (Attack == true) {
            attacking();
        } else if (Shoot == true) {
            Shooting();

        }

        // Player movement
        else if (keyHandle.downPressed == true || keyHandle.upPressed == true || keyHandle.leftPressed == true
                || keyHandle.rightPressed == true) {
            if (keyHandle.upPressed == true) {
                direction = "up";
            } else if (keyHandle.downPressed == true) {
                direction = "down";
            } else if (keyHandle.leftPressed == true) {
                direction = "left";
            } else if (keyHandle.rightPressed == true) {
                direction = "right";
            }

            // check tile collision
            collisionOn = false;
            gp.cCheck.checkTile(this);

            // check object collision
            int objindex = gp.cCheck.checkObj(this, true);
            pickupObj(objindex);

            int MonsterIndex = gp.cCheck.checkEntity(this, gp.entity);
            interactWithEntity(MonsterIndex);

            // EVENTS
            gp.event.checkEvent();

            // if collision is false player cantmove
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

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteDelay == 1) {
                    spriteDelay = 2;
                } else if (spriteDelay == 2) {
                    spriteDelay = 1;
                }
                spriteCounter = 0;
            }
        }
        // handle Attack
        handleAttack();

        // player get hit
        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

        // regen energy
        if (energy < maxEnergy) {
            EnergyCounter++;
            if (EnergyCounter > 60) {
                energy++;
                EnergyCounter = 0;
            }
        }

        // regen life
        if (life < maxLife) {
            lifeCounter++;
            if (lifeCounter > 600) {
                life++;
                lifeCounter = 0;
            }
        }

        if (life <= 0) {
            life = 0;
        }

    }

    public void pickupObj(int i) {

        if (i != 999) {
            String objName = gp.obj[i].name;

            switch (objName) {
                case "sword":

                    gp.obj[i] = null;
                    inventory[0] = "sword";
                    gp.gameState = 2;
                    break;

                case "bow":

                    gp.obj[i] = null;
                    inventory[1] = "bow";
                    gp.gameState = 2;
                    break;
            }
        }

    }

    public void interactWithEntity(int i) {
        if (i != 999) {
            if (gp.entity[i].dying == false) {

                if (invincible == false) {

                    life -= gp.entity[i].Dmg;
                    invincible = true;
                }
            }

        }
    }

    public void Dodamage(int i, int dmg, String weapon) {
        if (i != 999) {

            if (gp.entity[i].invincible == false) {

                if (weapon == "sword") {
                    knockback(gp.entity[i]);
                }

                gp.entity[i].life -= dmg;
                gp.entity[i].invincible = true;

            }
            if (gp.entity[i].life <= 0) {
                gp.entity[i].dying = true;

            }

        }

    }

    public void draw(Graphics2D g2d) {

        BufferedImage playerImage = null;
        int tempScreenX = ScreenX;
        int tempScreenY = ScreenY;

        switch (direction) {
            case "up":
                // sword attack
                if (Attack == false && Shoot == false) {

                    if (spriteDelay == 1) {
                        playerImage = up1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = up2;
                    }

                }
                if (Attack == true) {
                    tempScreenY = tempScreenY - gp.tileSize;

                    if (spriteDelay == 1) {
                        playerImage = atkup1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = atkup2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = atkup3;
                    }
                } else if (Shoot == true) {

                    if (spriteDelay == 1) {
                        playerImage = shootup1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = shootup2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = shootup3;
                    }
                }

                break;
            case "down":
                if (Attack == false && Shoot == false) {
                    if (spriteDelay == 1) {
                        playerImage = down1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = down2;
                    }
                }
                if (Attack == true) {
                    if (spriteDelay == 1) {
                        playerImage = atkdown1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = atkdown2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = atkdown3;
                    }
                } else if (Shoot == true) {

                    if (spriteDelay == 1) {
                        playerImage = shootdown1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = shootdown2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = shootdown3;
                    }
                }

                break;
            case "left":
                if (Attack == false && Shoot == false) {
                    if (spriteDelay == 1) {
                        playerImage = left1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = left2;
                    }
                }
                if (Attack == true) {
                    tempScreenX = tempScreenX - gp.tileSize;
                    if (spriteDelay == 1) {
                        playerImage = atkleft1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = atkleft2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = atkleft3;
                    }
                } else if (Shoot == true) {

                    if (spriteDelay == 1) {
                        playerImage = shootleft1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = shootleft2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = shootleft3;
                    }
                }

                break;
            case "right":
                if (Attack == false && Shoot == false) {
                    if (spriteDelay == 1) {
                        playerImage = right1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = right2;
                    }
                }
                if (Attack == true) {
                    if (spriteDelay == 1) {
                        playerImage = atkright1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = atkright2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = atkright3;
                    }
                } else if (Shoot == true) {

                    if (spriteDelay == 1) {
                        playerImage = shootright1;
                    }
                    if (spriteDelay == 2) {
                        playerImage = shootright2;
                    }
                    if (spriteDelay == 3) {
                        playerImage = shootright3;
                    }
                }

                break;
        }
        if (invincible == true) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        if (life <= 0) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            playerImage = dead;
            playerDead();
        }

        g2d.drawImage(playerImage, tempScreenX, tempScreenY, null);

        // reset alpha
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

    }

    public void playerDead() {
        deadcounter++;
        if (deadcounter > 5) {
            gp.gameState = 3;

        }

    }
}
