package entity;

import javax.imageio.ImageIO;

import mainn.GamePanel;

public class Arrow extends Projectile {

    public Arrow(GamePanel gp) {
super(gp);

this.gp = gp;
maxLife = 70;
life = maxLife;
speed = 8;
Dmg = 1;
live = false;
getArrowImg();
    }

    public void getArrowImg() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Arrow/arrow_Up.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Arrow/arrow_Down.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Arrow/arrow_Left.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/img/Arrow/arrow_Right.png"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Arrow image");
        }
    }
}
