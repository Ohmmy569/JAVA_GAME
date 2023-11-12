package mainn;

import entity.*;

public class CollisionCheck {

    GamePanel gp;

    public CollisionCheck(GamePanel gp) {

        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidbox.x;
        int entityRightWorldX = entity.worldX + entity.solidbox.x + entity.solidbox.width;

        int entityTopWorldY = entity.worldY + entity.solidbox.y;
        int entityBottomWorldY = entity.worldY + entity.solidbox.y + entity.solidbox.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tm.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tm.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tm.mapTileNum[entityLeftCol][entityBottomRow];

                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tm.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

        }
    }

    public int checkObj(Entity entity, boolean player) {

        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {

            if (gp.obj[i] != null) {

                // get entity solidbox position
                entity.solidbox.x = entity.solidbox.x + entity.worldX;
                entity.solidbox.y = entity.solidbox.y + entity.worldY;
                // get obj solidbox position
                gp.obj[i].solidbox.x = gp.obj[i].solidbox.x + gp.obj[i].worldX;
                gp.obj[i].solidbox.y = gp.obj[i].solidbox.y + gp.obj[i].worldY;

                switch (entity.direction) {
                    case "up":
                        entity.solidbox.y = entity.solidbox.y - entity.speed;
                        if (entity.solidbox.intersects(gp.obj[i].solidbox)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.solidbox.y = entity.solidbox.y + entity.speed;
                        if (entity.solidbox.intersects(gp.obj[i].solidbox)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solidbox.x = entity.solidbox.x - entity.speed;
                        if (entity.solidbox.intersects(gp.obj[i].solidbox)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solidbox.x = entity.solidbox.x + entity.speed;
                        if (entity.solidbox.intersects(gp.obj[i].solidbox)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidbox.x = entity.solidboxDeafaultX;
                entity.solidbox.y = entity.solidboxDeafaultY;
                gp.obj[i].solidbox.x = gp.obj[i].solidboxDeafaultX;
                gp.obj[i].solidbox.y = gp.obj[i].solidboxDeafaultY;
            }
        }

        return index;
    }

    // monster collision
    public int checkEntity(Entity entity, Entity[] target) {
        int index = 999;

        for (int i = 0; i < target.length; i++) {

            if (target[i] != null) {

                // get entity solidbox position
                entity.solidbox.x = entity.solidbox.x + entity.worldX;
                entity.solidbox.y = entity.solidbox.y + entity.worldY;
                // gtarget solidbox position
                target[i].solidbox.x = target[i].solidbox.x + target[i].worldX;
                target[i].solidbox.y = target[i].solidbox.y + target[i].worldY;

                switch (entity.direction) {
                    case "up":
                        entity.solidbox.y = entity.solidbox.y - entity.speed;
                        if (entity.solidbox.intersects(target[i].solidbox)) {

                            entity.collisionOn = true;

                            index = i;
                        }
                        break;

                    case "down":
                        entity.solidbox.y = entity.solidbox.y + entity.speed;
                        if (entity.solidbox.intersects(target[i].solidbox)) {

                            entity.collisionOn = true;

                            index = i;
                        }
                        break;

                    case "left":
                        entity.solidbox.x = entity.solidbox.x - entity.speed;
                        if (entity.solidbox.intersects(target[i].solidbox)) {

                            entity.collisionOn = true;

                            index = i;
                        }
                        break;

                    case "right":
                        entity.solidbox.x = entity.solidbox.x + entity.speed;
                        if (entity.solidbox.intersects(target[i].solidbox)) {

                            entity.collisionOn = true;

                            index = i;
                        }
                        break;
                }
                entity.solidbox.x = entity.solidboxDeafaultX;
                entity.solidbox.y = entity.solidboxDeafaultY;
                target[i].solidbox.x = target[i].solidboxDeafaultX;
                target[i].solidbox.y = target[i].solidboxDeafaultY;
            }
        }

        return index;
    }

    public boolean checkPlayer(Entity entity) {
        boolean hit = false;
        // get entity solidbox position
        entity.solidbox.x = entity.solidbox.x + entity.worldX;
        entity.solidbox.y = entity.solidbox.y + entity.worldY;
        // gtarget solidbox position
        gp.player.solidbox.x = gp.player.solidbox.x + gp.player.worldX;
        gp.player.solidbox.y = gp.player.solidbox.y + gp.player.worldY;

        switch (entity.direction) {
            case "up":
                entity.solidbox.y = entity.solidbox.y - entity.speed;

                break;

            case "down":
                entity.solidbox.y = entity.solidbox.y + entity.speed;

                break;

            case "left":
                entity.solidbox.x = entity.solidbox.x - entity.speed;

                break;

            case "right":
                entity.solidbox.x = entity.solidbox.x + entity.speed;

                break;
        }
        if (entity.solidbox.intersects(gp.player.solidbox)) {
            entity.collisionOn = true;
            hit = true;

        }
        entity.solidbox.x = entity.solidboxDeafaultX;
        entity.solidbox.y = entity.solidboxDeafaultY;
        gp.player.solidbox.x = gp.player.solidboxDeafaultX;
        gp.player.solidbox.y = gp.player.solidboxDeafaultY;

        return hit;

    }
}
