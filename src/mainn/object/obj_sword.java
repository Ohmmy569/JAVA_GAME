package mainn.object;

import javax.imageio.ImageIO;

import mainn.GamePanel;

public class obj_sword extends mainObj {
    GamePanel gp;
    public int Damage = 2;

    public obj_sword(GamePanel gp) {
        this.gp = gp;
        name = "sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/sword.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = false;
    }
    
    public obj_sword() {
     name = "sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/sword.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = false;
    }

}
