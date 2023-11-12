package mainn;

import java.awt.Rectangle;

public class Event {
    GamePanel gp;
    Rectangle eventRec;
    int eventRecDeafaultX, eventRecDeafaultY;
    int monsterCount = 0;
    int waveCount = 0;
    public int State = 0;

    public Event(GamePanel gp) {
        this.gp = gp;
        eventRec = new Rectangle();
        eventRec.x = 23;
        eventRec.y = 23;
        eventRec.width = 10;
        eventRec.height = 10;
        eventRecDeafaultX = eventRec.x;
        eventRecDeafaultY = eventRec.y;
    }

    public void checkEvent() {

        if (waveCount == 0) {
            if (hit(10, 33, "any") == true ||
                    hit(9, 33, "any") == true ||
                    hit(8, 33, "any") == true) {
                waveCount = 1;
                gp.player.worldX = gp.tileSize * 10;
                gp.player.worldY = gp.tileSize * 32;
                gp.seter.setWave1();
            }

        } else if (waveCount == 1) {
            monsterCount = 0;
            for (int i = 0; i < gp.entity.length; i++) {
                if (gp.entity[i] != null) {
                    monsterCount = 1;
                }
            }
            if (monsterCount == 0) {
                gp.seter.wallOpen2();
            }

            if (hit(22, 25, "any") == true ||
                    hit(22, 26, "any") == true ||
                    hit(22, 27, "any") == true) {
                waveCount = 2;
                gp.player.worldX = gp.tileSize * 24;
                gp.player.worldY = gp.tileSize * 26;
                gp.seter.setWave2();
            }

        } else if (waveCount == 2) {
            // if no monster
            monsterCount = 0;
            for (int i = 0; i < gp.entity.length; i++) {
                if (gp.entity[i] != null) {
                    monsterCount = 1;
                }
            }
            if (monsterCount == 0) {
                gp.seter.wallOpen3();
            }

            if (hit(28, 17, "any") == true ||
                    hit(29, 17, "any") == true ||
                    hit(30, 17, "any") == true) {
                waveCount = 3;
                gp.player.worldX = gp.tileSize * 28;
                gp.player.worldY = gp.tileSize * 15;
                gp.seter.setWave3();
            }
        } else if (waveCount == 3) {

            monsterCount = 0;
            for (int i = 0; i < gp.entity.length; i++) {
                if (gp.entity[i] != null) {
                    monsterCount = 1;
                }
            }
            if (monsterCount == 0) {
                gp.seter.wallOpen4();
            }

            if (hit(16, 10, "any") == true ||
                    hit(16, 11, "any") == true ||
                    hit(16, 12, "any") == true) {
                waveCount = 4;
                gp.player.worldX = gp.tileSize * 15;
                gp.player.worldY = gp.tileSize * 10;
                gp.gameState = 4;

            }
        }
    }

    public boolean hit(int eventCol, int eventRow, String direction) {
        boolean hit = false;

        gp.player.solidbox.x = gp.player.worldX + gp.player.solidbox.x;
        gp.player.solidbox.y = gp.player.worldY + gp.player.solidbox.y;
        eventRec.x = eventCol * gp.tileSize + eventRec.x;
        eventRec.y = eventRow * gp.tileSize + eventRec.y;

        if (gp.player.solidbox.intersects(eventRec)) {
            if (gp.player.direction.contentEquals(direction) || direction.contentEquals("any")) {
                hit = true;
            }
        }
        gp.player.solidbox.x = gp.player.solidboxDeafaultX;
        gp.player.solidbox.y = gp.player.solidboxDeafaultY;
        eventRec.x = eventRecDeafaultX;
        eventRec.y = eventRecDeafaultY;

        return hit;
    }

}
