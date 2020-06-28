package com.gaoguofeng.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author gaoguofeng
 */
public class Tankframe extends Frame {

    public static final Tankframe INSTANCE = new Tankframe();

    Tank tank;
    Tank enemy;
    Bullet bullet;
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private Tankframe () {
        this.setTitle("Tank war");
        this.setLocation(400, 100);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);

        this.addKeyListener(new TankKeyListener());
        tank = new Tank(100, 100, Dir.R, Group.Good,this);
        enemy = new Tank(300, 100, Dir.D, Group.Bad,this);
        bullet = new Bullet(100,100, Dir.D, Group.Bad);
    }

    //以下这段代码是解决双缓冲问题 -- 一直闪
    //为什么会有双缓冲问题？
    Image offScreenImage = null;

    /**
     * @param b
     * 添加子弹
     */
    public void add(Bullet b){
        this.bullet = b;
    }


    @Override
    public void update(Graphics g) {
        //在内存中创建一张图片，和整个界面同样的大小。
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        //如何区分敌我坦克？
        tank.paint(g);
        enemy.paint(g);
        bullet.paint(g);
    }

    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            tank.keyPressed(e);
            enemy.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {

            tank.keyReleased(e);
            enemy.keyReleased(e);
        }
    }
}
