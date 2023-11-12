package mainn.object;

import javax.imageio.ImageIO;

public class obj_wall_down extends mainObj{

    public obj_wall_down() {
        name = "wall_down";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/wall_down.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = false;
    }
    
}
