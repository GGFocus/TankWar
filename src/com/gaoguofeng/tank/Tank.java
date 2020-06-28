package com.gaoguofeng.tank;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.gaoguofeng.tank.Tankframe.INSTANCE;

/**
 * 面向对象编程，设计对应的类
 */
public class Tank<add> {
    public int x;
    public int y;
    Tankframe tf;

    private Group group;

    private boolean moving = false;

    private boolean bL, bR, bU, bD;

    private Dir dir;

    public static final int SPEED = 5;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public Tank(int x, int y, Dir dir,Group group,Tankframe tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    /**
     * 坦克的
     * @param g
     */
    public void paint(Graphics g) {
        //这段代码的问题是每次都要重新load资源。图片和声音的资源一般都是加载一次。
        //用静态代码块定义图片资源，这样就可以只加载一次。
       /* try {
            BufferedImage imageTank = ImageIO.read(Tank.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            g.drawImage(imageTank, x, y, null);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        if(this.group == Group.Good){
            switch (dir) {
                case L:
                    g.drawImage(ResourceMgr.goodTankL, x, y, null);
                    break;
                case R:
                    g.drawImage(ResourceMgr.goodTankR, x, y, null);
                    break;
                case U:
                    g.drawImage(ResourceMgr.goodTankU, x, y, null);
                    break;
                case D:
                    g.drawImage(ResourceMgr.goodTankD, x, y, null);
                    break;
            }
        }


        if(this.group == Group.Bad){
            switch (dir) {
                case L:
                    g.drawImage(ResourceMgr.badTankL, x, y, null);
                    break;
                case R:
                    g.drawImage(ResourceMgr.badTankR, x, y, null);
                    break;
                case U:
                    g.drawImage(ResourceMgr.badTankU, x, y, null);
                    break;
                case D:
                    g.drawImage(ResourceMgr.badTankD, x, y, null);
                    break;
            }
        }

        move();
    }

    /**
     * tank的操作系统
     * move这个方法不能放到键盘事件内，因为有敌方坦克，
     * 问题是驱动事物发展的动力，要注意发现问题，收集问题。
     * 按键时 事件
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
        }

        setMainDir();
    }

    /**
     * 当一个键被抬起时，方向要重新计算
     */
    public void move(){

        if(moving) {
            switch (dir) {
                case L:
                    x -= SPEED;
                    break;
                case U:
                    y -= SPEED;
                    break;
                case R:
                    x += SPEED;
                    break;
                case D:
                    y += SPEED;
                    break;
            }
        }
    }

    /**
     * @param e
     * 按键松开事件,设置方向
     * 这四个值代表这四个键是否被按下
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_CONTROL:
                fire();
                break;
        }

        setMainDir();
    }


    private void fire() {
        //如何将这个新建的子弹对象，传给Tankframe
        this.tf.add(new Bullet(x, y, dir, group));
    }

    /**
     * 设置主战坦克的方向
     */
    private void setMainDir() {

        //all dir keys are released tank should be stop
        if (!bL && !bR && !bU && !bD) {
            dir = Dir.STOP;
            moving = false;

        } else {
            //any dir is pressed, tank should be moving
            moving = true;

            if (bL && !bR && !bU && !bD) {
                dir = Dir.L;
            }
            if (!bL && bR && !bU && !bD) {
                dir = Dir.R;
            }
            if (!bL && !bR && bU && !bD) {
                dir = Dir.U;
            }
            if (!bL && !bR && !bU && bD) {
                dir = Dir.D;
            }
        }
    }
}
