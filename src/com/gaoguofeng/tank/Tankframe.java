package com.gaoguofeng.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author gaoguofeng
 */
public class Tankframe extends Frame {

    Tank tank;
    Tank enemy;

    public Tankframe () {
        this.setTitle("Tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);

        this.addKeyListener(new TankKeyListener());
        tank = new Tank(100, 100, Dir.R);
        enemy = new Tank(100, 100, Dir.D);
    }


    @Override
    public void paint(Graphics g) {
        tank.paint(g);
        enemy.paint(g);
    }

    /**
     * ?????????????????????????????
     */
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
