package mainn;

import java.awt.*;
import java.awt.image.BufferedImage;

import mainn.object.mainObj;
import mainn.object.obj_enegry;
import mainn.object.obj_life;
import mainn.object.obj_sword;
import mainn.object.obj_bow;

public class UI {
    GamePanel gp;
    Font arial_20;
    Graphics2D g2;
    BufferedImage Life_Full, Life_Blank, En_Full, En_Blank, Sword, Bow;

    public int menuSelect = 0;

    public String message = "";

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_20 = new Font("Arial", Font.BOLD, 23);

        mainObj life = new obj_life(gp);
        Life_Full = life.image;
        Life_Blank = life.image2;
        mainObj energy = new obj_enegry(gp);
        En_Full = energy.image;
        En_Blank = energy.image2;
        mainObj sword = new obj_sword(gp);
        Sword = sword.image;
        mainObj bow = new obj_bow(gp);
        Bow = bow.image;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        // Menu
        if (gp.gameState == 0) {
            Menu();
        }

        // dialog
        if (gp.gameState == 2) {
            if (gp.player.inventory[1] == "bow") {
                drawDialog_bow();
            } else if (gp.player.inventory[0] == "sword") {
                drawDialog_sword();
            }

        }
        if (gp.gameState == 3) {
            drawGameOver();

        }
        if (gp.gameState == 4) {
            drawGameWin();

        }

        // play game
        if (gp.gameState == 1) {

            drawHUD();
            drawLife();
            drawEnergy();

        }
    }

    public void drawGameWin() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawWinWindow(x, y, width, height);
    }

    public void drawWinWindow(int x, int y, int width, int height) {
        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(6));
        g2.drawRoundRect(x - 2, y - 2, width + 4, height + 4, 35, 35);
        Color c = new Color(255, 255, 255, 240);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setFont(new Font("Arial", Font.BOLD, 80));
        g2.setColor(Color.BLACK);
        g2.drawString("You Win!", x + 120, y + 80);
        g2.setFont(arial_20);
        g2.drawString("Press ' Space_Bar ' to Restart", x + 120, y + 140);

    }

    public void drawGameOver() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawOverWindow(x, y, width, height);
    }

    public void drawOverWindow(int x, int y, int width, int height) {
        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(6));
        g2.drawRoundRect(x - 2, y - 2, width + 4, height + 4, 35, 35);
        Color c = new Color(255, 255, 255, 240);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setFont(new Font("Arial", Font.BOLD, 80));
        g2.setColor(Color.BLACK);
        g2.drawString("Game Over!", x + 50, y + 80);
        g2.setFont(arial_20);
        g2.drawString("Press ' Space_Bar ' to Restart", x + 120, y + 140);

    }

    public void drawDialog_sword() {

        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawMessageWindow_sword(x, y, width, height);
    }

    public void drawMessageWindow_sword(int x, int y, int width, int height) {

        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(6));
        g2.drawRoundRect(x - 2, y - 2, width + 4, height + 4, 35, 35);
        Color c = new Color(255, 255, 255, 240);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setFont(arial_20);
        g2.setColor(Color.BLACK);
        g2.drawString("You pick up Sword! now you can attack by ", x + 15, y + 35);
        g2.drawString("pressing ' Space_Bar ' and '1' or '2' ", x + 15, y + 70);
        g2.drawString("to switch your hands Sword will use 2 energy ", x + 15, y + 105);
        g2.drawString("per attack becareful with it!", x + 15, y + 140);

    }

    public void drawDialog_bow() {

        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawMessageWindow_bow(x, y, width, height);
    }

    public void drawMessageWindow_bow(int x, int y, int width, int height) {

        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(6));
        g2.drawRoundRect(x - 2, y - 2, width + 4, height + 4, 35, 35);
        Color c = new Color(255, 255, 255, 240);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setFont(arial_20);
        g2.setColor(Color.BLACK);
        g2.drawString("You pick up Bow! now you can shooting arrows ", x + 15, y + 35);
        g2.drawString("this weapon have poweful damage but", x + 15, y + 70);
        g2.drawString("it use 4 energy! becareful with it!", x + 15, y + 105);

    }

    public void drawHUD() {
        //Healh And Energy ---------------------------------------------------------------------------------------
        int x = gp.tileSize / 2 - 8;
        int y = gp.tileSize / 2 + 20;
        g2.setFont(arial_20);

        g2.setColor(Color.BLACK);
        g2.drawString("H : ", x + 2, y + 2);
        g2.setColor(Color.WHITE);
        g2.drawString("H : ", x, y);

        y += gp.tileSize;

        g2.setColor(Color.BLACK);
        g2.drawString("E : ", x + 2, y + 2);
        g2.setColor(Color.WHITE);
        g2.drawString("E : ", x, y);
        //-------------------------------------------------------------------------------------------------------

        // Hand Slot --------------------------------------------------------------------------------------------
        y += gp.tileSize;
        g2.setColor(Color.WHITE);
        g2.drawRect(x, y - 20, gp.tileSize, gp.tileSize);
        g2.setColor(Color.WHITE);
        g2.drawRect(x + 70, y - 20, gp.tileSize, gp.tileSize);
        if (gp.player.Handslot == 0) {
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(x - 2, y - 22, gp.tileSize + 4, gp.tileSize + 4);
        }
        if (gp.player.Handslot == 1) {
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(x + 68, y - 22, gp.tileSize + 4, gp.tileSize + 4);
        }
        if (gp.player.inventory[0] != null) {
            int x_sword = x;
            int y_sword = y - 15;
            g2.drawImage(Sword, x_sword, y_sword, gp.tileSize - 5, gp.tileSize - 5, null);
        }
        if (gp.player.inventory[1] != null) {
            int x_sword = x + 70;
            int y_sword = y - 15;
            g2.drawImage(Bow, x_sword, y_sword, gp.tileSize - 5, gp.tileSize - 5, null);
        }
        //-------------------------------------------------------------------------------------------------------

    }

    public void drawLife() {
        int x = gp.tileSize / 2 + gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        // Draw Max Life
        while (i < gp.player.maxLife) {
            g2.drawImage(Life_Blank, x, y, gp.tileSize / 2, gp.tileSize / 2, null);
            i++;
            x += gp.tileSize / 2;
        }

        // Draw Life
        x = gp.tileSize / 2 + gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        while (i < gp.player.life) {
            g2.drawImage(Life_Full, x, y, gp.tileSize / 2, gp.tileSize / 2, null);
            i++;
            x += gp.tileSize / 2;
        }

    }

    public void drawEnergy() {

        int x = gp.tileSize / 2 + gp.tileSize / 2;
        int y = gp.tileSize / 2 + gp.tileSize;
        int i = 0;

        // Draw Max Energy
        while (i < gp.player.maxEnergy) {
            g2.drawImage(En_Blank, x, y, gp.tileSize / 2, gp.tileSize / 2, null);
            i++;
            x += gp.tileSize / 2;
        }

        // Draw Energy
        x = gp.tileSize / 2 + gp.tileSize / 2;
        y = gp.tileSize / 2 + gp.tileSize;
        i = 0;

        while (i < gp.player.energy) {
            g2.drawImage(En_Full, x, y, gp.tileSize / 2, gp.tileSize / 2, null);
            i++;
            x += gp.tileSize / 2;
        }

    }

    public void Menu() {
        // Label "Little Knight " -------------------------------------------------
        String text = "Little Knight";
        int x = gp.screenWidth / 2 - 220;
        int y = gp.tileSize * 2;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 5, y + 5);
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        //--------------------------------------------------------------------------

        // รูปตัวเอก ------------------------------------------------------------------
        x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
        y += gp.tileSize * 2;
        g2.drawImage(gp.player.down1, x, y, 100, 100, null);
        //--------------------------------------------------------------------------

        //ตัวเลือก และ cursor ----------------------------------------------------------
        g2.setColor(Color.BLACK);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));
        text = "Play";
        x = gp.screenWidth / 2 - 40;
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if (menuSelect == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Exit";
        x = gp.screenWidth / 2 - 40;
        y += gp.tileSize * 2;
        g2.drawString(text, x, y);
        if (menuSelect == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        //---------------------------------------------------------------------------

    }

}
