package mainn.object;

import javax.imageio.ImageIO;

public class obj_wall_up extends mainObj{

    public obj_wall_up() {
        name = "wall_up";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/wall_up.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
    
}
