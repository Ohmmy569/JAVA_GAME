package mainn;

import mainn.object.obj_bow;
import mainn.object.obj_sword;
import mainn.object.obj_wall_down;
import mainn.object.obj_wall_up;
import entity.Ghost;
import entity.zombie;

public class Seter {
    GamePanel gp;
    public int MonsterCount;

    public Seter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObj() {
       gp.obj[0] = new obj_wall_down();
        gp.obj[0].worldX = 9 * gp.tileSize;
        gp.obj[0].worldY = 33 * gp.tileSize;

        gp.obj[1] = new obj_wall_down();
        gp.obj[1].worldX = 10 * gp.tileSize;
        gp.obj[1].worldY = 33 * gp.tileSize;

        gp.obj[2] = new obj_wall_down();
        gp.obj[2].worldX = 11 * gp.tileSize;
        gp.obj[2].worldY = 33 * gp.tileSize;

        gp.obj[4] = new obj_sword();
        gp.obj[4].worldX = 10 * gp.tileSize;
        gp.obj[4].worldY = 39 * gp.tileSize;

        
        gp.obj[21] = new obj_bow();
        gp.obj[21].worldX = 21 * gp.tileSize;
        gp.obj[21].worldY = 26 * gp.tileSize;

        gp.obj[5] = new obj_wall_down();
        gp.obj[5].worldX = 20 * gp.tileSize;
        gp.obj[5].worldY = 26 * gp.tileSize;

        gp.obj[6] = new obj_wall_down();
        gp.obj[6].worldX = 20 * gp.tileSize;
        gp.obj[6].worldY = 25 * gp.tileSize;

        gp.obj[7] = new obj_wall_down();
        gp.obj[7].worldX = 20 * gp.tileSize;
        gp.obj[7].worldY = 27 * gp.tileSize;

        gp.obj[8] = new obj_wall_down();
        gp.obj[8].worldX = 23 * gp.tileSize;
        gp.obj[8].worldY = 27 * gp.tileSize;

        gp.obj[9] = new obj_wall_down();
        gp.obj[9].worldX = 23 * gp.tileSize;
        gp.obj[9].worldY = 26 * gp.tileSize;

        gp.obj[10] = new obj_wall_down();
        gp.obj[10].worldX = 23 * gp.tileSize;
        gp.obj[10].worldY = 25 * gp.tileSize;

        gp.obj[11] = new obj_wall_down();
        gp.obj[11].worldX = 28 * gp.tileSize;
        gp.obj[11].worldY = 20 * gp.tileSize;

        gp.obj[12] = new obj_wall_down();
        gp.obj[12].worldX = 29 * gp.tileSize;
        gp.obj[12].worldY = 20 * gp.tileSize;

        gp.obj[13] = new obj_wall_down();
        gp.obj[13].worldX = 30 * gp.tileSize;
        gp.obj[13].worldY = 20 * gp.tileSize;



        gp.obj[14] = new obj_wall_down();
        gp.obj[14].worldX = 28 * gp.tileSize;
        gp.obj[14].worldY = 16 * gp.tileSize;

        gp.obj[15] = new obj_wall_down();
        gp.obj[15].worldX = 29 * gp.tileSize;
        gp.obj[15].worldY = 16 * gp.tileSize;

        gp.obj[16] = new obj_wall_down();
        gp.obj[16].worldX = 30 * gp.tileSize;
        gp.obj[16].worldY = 16 * gp.tileSize;




        gp.obj[17] = new obj_wall_down();
        gp.obj[17].worldX = 20 * gp.tileSize;
        gp.obj[17].worldY = 12 * gp.tileSize;

        gp.obj[18] = new obj_wall_down();
        gp.obj[18].worldX = 20 * gp.tileSize;
        gp.obj[18].worldY = 11 * gp.tileSize;

        gp.obj[19] = new obj_wall_down();
        gp.obj[19].worldX = 20 * gp.tileSize;
        gp.obj[19].worldY = 10 * gp.tileSize;


    }

    public void setWave1() {
        gp.obj[0] = new obj_wall_up();
        gp.obj[0].worldX = 9 * gp.tileSize;
        gp.obj[0].worldY = 33 * gp.tileSize;

        gp.obj[1] = new obj_wall_up();
        gp.obj[1].worldX = 10 * gp.tileSize;
        gp.obj[1].worldY = 33 * gp.tileSize;

        gp.obj[2] = new obj_wall_up();
        gp.obj[2].worldX = 11 * gp.tileSize;
        gp.obj[2].worldY = 33 * gp.tileSize;

        gp.obj[5] = new obj_wall_up();
        gp.obj[5].worldX = 20 * gp.tileSize;
        gp.obj[5].worldY = 26 * gp.tileSize;

        gp.obj[6] = new obj_wall_up();
        gp.obj[6].worldX = 20 * gp.tileSize;
        gp.obj[6].worldY = 25 * gp.tileSize;

        gp.obj[7] = new obj_wall_up();
        gp.obj[7].worldX = 20 * gp.tileSize;
        gp.obj[7].worldY = 27 * gp.tileSize;

        gp.entity[0] = new zombie(gp);
        gp.entity[0].worldX = gp.tileSize * 10;
        gp.entity[0].worldY = gp.tileSize * 24;

        gp.entity[1] = new zombie(gp);
        gp.entity[1].worldX = gp.tileSize * 16;
        gp.entity[1].worldY = gp.tileSize * 25;

        gp.entity[2] = new zombie(gp);
        gp.entity[2].worldX = gp.tileSize * 16;
        gp.entity[2].worldY = gp.tileSize * 28;

        gp.entity[3] = new zombie(gp);
        gp.entity[3].worldX = gp.tileSize * 16;
        gp.entity[3].worldY = gp.tileSize * 30;

    }

    public void wallOpen2() {

        gp.obj[5] = new obj_wall_down();
        gp.obj[5].worldX = 20 * gp.tileSize;
        gp.obj[5].worldY = 26 * gp.tileSize;

        gp.obj[6] = new obj_wall_down();
        gp.obj[6].worldX = 20 * gp.tileSize;
        gp.obj[6].worldY = 25 * gp.tileSize;

        gp.obj[7] = new obj_wall_down();
        gp.obj[7].worldX = 20 * gp.tileSize;
        gp.obj[7].worldY = 27 * gp.tileSize;
    }

    public void setWave2() {

        gp.obj[8] = new obj_wall_up();
        gp.obj[8].worldX = 23 * gp.tileSize;
        gp.obj[8].worldY = 27 * gp.tileSize;

        gp.obj[9] = new obj_wall_up();
        gp.obj[9].worldX = 23 * gp.tileSize;
        gp.obj[9].worldY = 26 * gp.tileSize;

        gp.obj[10] = new obj_wall_up();
        gp.obj[10].worldX = 23 * gp.tileSize;
        gp.obj[10].worldY = 25 * gp.tileSize;

        gp.entity[4] = new Ghost(gp);
        gp.entity[4].worldX = gp.tileSize * 26;
        gp.entity[4].worldY = gp.tileSize * 23;

        gp.entity[5] = new Ghost(gp);
        gp.entity[5].worldX = gp.tileSize * 32;
        gp.entity[5].worldY = gp.tileSize * 23;

        gp.entity[6] = new Ghost(gp);
        gp.entity[6].worldX = gp.tileSize * 32;
        gp.entity[6].worldY = gp.tileSize * 30;

        gp.entity[7] = new Ghost(gp);
        gp.entity[7].worldX = gp.tileSize * 26;
        gp.entity[7].worldY = gp.tileSize * 30;

        gp.entity[7] = new Ghost(gp);
        gp.entity[7].worldX = gp.tileSize * 30;
        gp.entity[7].worldY = gp.tileSize * 26;

        gp.obj[11] = new obj_wall_up();
        gp.obj[11].worldX = 28 * gp.tileSize;
        gp.obj[11].worldY = 20 * gp.tileSize;

        gp.obj[12] = new obj_wall_up();
        gp.obj[12].worldX = 29 * gp.tileSize;
        gp.obj[12].worldY = 20 * gp.tileSize;

        gp.obj[13] = new obj_wall_up();
        gp.obj[13].worldX = 30 * gp.tileSize;
        gp.obj[13].worldY = 20 * gp.tileSize;
    }

    public void wallOpen3() {

        gp.obj[11] = new obj_wall_down();
        gp.obj[11].worldX = 28 * gp.tileSize;
        gp.obj[11].worldY = 20 * gp.tileSize;

        gp.obj[12] = new obj_wall_down();
        gp.obj[12].worldX = 29 * gp.tileSize;
        gp.obj[12].worldY = 20 * gp.tileSize;

        gp.obj[13] = new obj_wall_down();
        gp.obj[13].worldX = 30 * gp.tileSize;
        gp.obj[13].worldY = 20 * gp.tileSize;
    }

    public void setWave3() {

        
        gp.obj[14] = new obj_wall_up();
        gp.obj[14].worldX = 28 * gp.tileSize;
        gp.obj[14].worldY = 16 * gp.tileSize;

        gp.obj[15] = new obj_wall_up();
        gp.obj[15].worldX = 29 * gp.tileSize;
        gp.obj[15].worldY = 16 * gp.tileSize;

        gp.obj[16] = new obj_wall_up();
        gp.obj[16].worldX = 30 * gp.tileSize;
        gp.obj[16].worldY = 16 * gp.tileSize;

        

        gp.obj[17] = new obj_wall_up();
        gp.obj[17].worldX = 20 * gp.tileSize;
        gp.obj[17].worldY = 12 * gp.tileSize;

        gp.obj[18] = new obj_wall_up();
        gp.obj[18].worldX = 20 * gp.tileSize;
        gp.obj[18].worldY = 11 * gp.tileSize;

        gp.obj[19] = new obj_wall_up();
        gp.obj[19].worldX = 20 * gp.tileSize;
        gp.obj[19].worldY = 10 * gp.tileSize;


        gp.entity[8] = new zombie(gp);
        gp.entity[8].worldX = gp.tileSize * 33;
        gp.entity[8].worldY = gp.tileSize * 10;

            gp.entity[9] = new zombie(gp);
        gp.entity[9].worldX = gp.tileSize * 27;
        gp.entity[9].worldY = gp.tileSize * 12;

        gp.entity[10] = new zombie(gp);
        gp.entity[10].worldX = gp.tileSize * 27;
        gp.entity[10].worldY = gp.tileSize * 12;

         gp.entity[11] = new Ghost(gp);
        gp.entity[11].worldX = gp.tileSize * 32;
        gp.entity[11].worldY = gp.tileSize * 7;


         gp.entity[12] = new Ghost(gp);
        gp.entity[12].worldX = gp.tileSize * 36;
        gp.entity[12].worldY = gp.tileSize * 12;

        

         gp.entity[13] = new Ghost(gp);
        gp.entity[13].worldX = gp.tileSize * 22;
        gp.entity[13].worldY = gp.tileSize * 11;
        
    }

    public void wallOpen4(){

        
        gp.obj[17] = new obj_wall_down();
        gp.obj[17].worldX = 20 * gp.tileSize;
        gp.obj[17].worldY = 12 * gp.tileSize;

        gp.obj[18] = new obj_wall_down();
        gp.obj[18].worldX = 20 * gp.tileSize;
        gp.obj[18].worldY = 11 * gp.tileSize;

        gp.obj[19] = new obj_wall_down();
        gp.obj[19].worldX = 20 * gp.tileSize;
        gp.obj[19].worldY = 10 * gp.tileSize;



    }
}
