package mainn.object;

import javax.imageio.ImageIO;

import mainn.GamePanel;

public class obj_enegry extends mainObj {
        GamePanel gp;

    public obj_enegry(GamePanel gp) {
        this.gp = gp;
        name = "enegry";
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/En_Full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/img/obj/En_Blank.png"));
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
