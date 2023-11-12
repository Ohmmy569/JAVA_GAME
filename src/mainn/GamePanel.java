package mainn;

import javax.swing.JPanel;

import bot.PathFinding;
import entity.Entity;
import entity.Player;
import mainn.object.mainObj;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    // Screen settings
    final int originalTileSize = 16; // 16 pixels
    final int scale = 3; // 3x scale

    public int tileSize = originalTileSize * scale; // 48 pixels
    public int maxScreenCol = 16; // 16 tiles
    public int maxScreenRow = 12; // 12 tiles
    public int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    // FPS
    final int FPS = 60;

    public TileManager tm = new TileManager(this);
    KeyHandle keyHandle = new KeyHandle(this);// add key listener
    Thread gameThread;
    public Player player = new Player(this, keyHandle);

    // Game systems
    public CollisionCheck cCheck = new CollisionCheck(this);
    public Seter seter = new Seter(this);
    public mainObj[] obj = new mainObj[100];
    public UI ui = new UI(this);
    public Event event = new Event(this);

    // Entity
    public Entity entity[] = new Entity[100];
    public ArrayList<Entity> projectileList = new ArrayList<>();

    public PathFinding pFinder = new PathFinding(this);

    // Game State
    public int gameState = 0; // 0 = menu, 1 = game, 2 = dialog , 3 = game over , 4 = win

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true);
    }

    public void setupGame() {
        player.setDefaultValues();
        seter.setObj();
        gameState = 0;
    }

    public void setupObjects() {
        seter.setObj();
    }

    public void startGameThread() {
        gameThread = new Thread(this); // this refers to the GamePanel class
        gameThread.start();
    }

    public void resetGame() {

        // reset player
        player.setDefaultValues();
        player.worldX = tileSize * 8;
        player.worldY = tileSize * 42;
        player.inventory[0] = null;
        player.inventory[1] = null;
        player.Handslot = 0;
        player.Attack = false;
        player.Shoot = false;
        player.spriteCounter = 0;
        player.spriteDelay = 1;
        player.energy = player.maxEnergy;
        player.life = player.maxLife;
        player.invincible = false;
        player.invincibleCounter = 0;
        player.dying = false;
        player.live = true;
        player.projectile.live = false;
        player.projectile.worldX = 0;
        player.projectile.worldY = 0;
        player.projectile.direction = "down";
        player.projectile.speed = 0;
        player.projectile.life = 0;
        player.projectile.spriteCounter = 0;
        player.projectile.spriteDelay = 0;
        player.projectile.spriteCounter = 0;
        player.projectile.spriteDelay = 0;
        player.projectile.spriteCounter = 0;

        // reset entity
        for (int i = 0; i < entity.length; i++) {
            if (entity[i] != null) {
                entity[i] = null;
            }
        }

        // reset obj
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i] = null;
            }
        }

        setupGame();
        setupObjects();

        //reset event
        event.waveCount = 0;
        event.monsterCount = 0;
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // 1 second = 1 billion nanoseconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta = delta + ((currentTime - lastTime) / drawInterval);
            timer = timer + (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;

            }

            if (timer >= 1000000000) {

                timer = 0;
            }
        }

    }

    public void update() {
        if (gameState == 1) {
            player.update();
            for (int i = 0; i < entity.length; i++) {
                if (entity[i] != null) {
                    if (entity[i].live == true && entity[i].dying == false) {
                        entity[i].update();
                    }
                    if (entity[i].live == false) {
                        entity[i] = null;
                    }
                }
            }

            for (int i = 0; i < projectileList.size(); i++) {
                if (projectileList.get(i) != null) {
                    projectileList.get(i).update();
                } else {
                    return;
                }
                if (projectileList.get(i).live == false) {
                    projectileList.remove(i);
                }
            }

        }
        if (gameState == 2) {
            // nothing
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // menu
        if (gameState == 0) {
            ui.draw(g2d);
        } else {

            tm.draw(g2d); // draw tiles

            // obj
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2d, this);
                }
            }
            // draw player
            player.draw(g2d);
            // draw zombie
            for (int i = 0; i < entity.length; i++) {
                if (entity[i] != null) {
                    entity[i].draw(g2d);

                }
            }

            // draw projectile
            for (int i = 0; i < projectileList.size(); i++) {
                if (projectileList.get(i) != null) {
                    projectileList.get(i).draw(g2d);
                }
            }

            // UI
            ui.draw(g2d);

            g2d.dispose();
        }

    }
}
