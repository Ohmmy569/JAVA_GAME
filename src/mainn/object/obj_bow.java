package mainn.object;

import javax.imageio.ImageIO;

import mainn.GamePanel;

public class obj_bow extends mainObj {
    GamePanel gp;
    public int Damage = 4;

    public obj_bow(GamePanel gp) {
        this.gp = gp;
        name = "bow";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/bow.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = false;
    }

    public obj_bow() {
        name = "bow";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/bow.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = false;
    }

}
