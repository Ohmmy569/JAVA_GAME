package entity;

import mainn.GamePanel;
import mainn.object.obj_bow;

public class Projectile extends Entity {
    obj_bow bow = new obj_bow();

    public Projectile(GamePanel gp) {
        super(gp);
    }

    public void set(int worldX, int worldY, String direction, boolean live) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.live = live;
        this.life = maxLife;
        this.type = 2;

    }

    public void update() {

        int MonsterIndex = gp.cCheck.checkEntity(this, gp.entity);
        if (MonsterIndex != 999) {
            gp.player.Dodamage(MonsterIndex, bow.Damage, bow.name);
            live = false;
        }

        switch (direction) {
            case "up":
                worldY -= speed;
                break;
            case "down":
                worldY += speed;
                break;
            case "left":
                worldX -= speed;
                break;
            case "right":
                worldX += speed;
                break;
        }
        life--;
        if (life <= 0) {
            live = false;
        }
    }
}