package tile;

import mainn.GamePanel;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    Boolean drawPath = false;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[40];

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileimg();
        LoadMap("/res/map/map1.txt");
    }

    public void getTileimg() {
        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_floor.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_bot.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_left.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_right.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_topLC.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_topRC.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_botLC.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_botRC.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/sand_top.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/water_buble.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/plam.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/wall.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/wall_full.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_BackL.png"));
            tile[14].collision = false;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_BackR.png"));
            tile[15].collision = false;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_FrontL.png"));
            tile[16].collision = false;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_FrontR.png"));
            tile[17].collision = false;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_Left.png"));
            tile[18].collision = false;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_Right.png"));
            tile[19].collision = false;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_Left_bai.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/boat_Right_bai.png"));
            tile[21].collision = true;

            // tile[2] = new Tile();
            // tile[2].image =
            // ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/water.png"));
            // tile[2].collision = true;

            // tile[3] = new Tile();
            // tile[3].image =
            // ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/water_buble"));

            // tile[4] = new Tile();
            // tile[4].image =
            // ImageIO.read(getClass().getResourceAsStream("/res/img/Tile/plam.png"));
            // tile[4].collision = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading tile image");
        }
    }

    public void LoadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                System.out.println(line);

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");

                    int arrnum = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = arrnum;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }

        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading map");
        }
    }

    public void draw(Graphics2D g2d) {
        int WorldCol = 0;
        int WorldRow = 0;

        while (WorldCol < gp.maxWorldCol && WorldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[WorldCol][WorldRow];

            int worldX = WorldCol * gp.tileSize;
            int worldY = WorldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.ScreenX;
            int screenY = worldY - gp.player.worldY + gp.player.ScreenY;

            // if when the tile is off the screen, don't draw it
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.ScreenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.ScreenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.ScreenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.ScreenY) {

                g2d.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            WorldCol++;

            if (WorldCol == gp.maxWorldCol) {
                WorldCol = 0;
                WorldRow++;
            }
        }
        if (drawPath == true) {
            g2d.setColor(java.awt.Color.red);

            for (int i = 0; i < gp.pFinder.PathList.size(); i++) {
                int worldX = gp.pFinder.PathList.get(i).col * gp.tileSize;

                int worldY = gp.pFinder.PathList.get(i).row * gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.ScreenX;
                int screenY = worldY - gp.player.worldY + gp.player.ScreenY;

                g2d.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
            }
        }
    }
}
