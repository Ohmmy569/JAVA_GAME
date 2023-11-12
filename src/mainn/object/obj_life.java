package mainn.object;

import javax.imageio.ImageIO;

import mainn.GamePanel;

public class obj_life extends mainObj {

    GamePanel gp;

    public obj_life(GamePanel gp) {
        this.gp = gp;
        name = "life";
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/Life_Full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/Life_Blank.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
