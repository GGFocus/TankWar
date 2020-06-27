import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 面向对象编程，设计对应的类
 */
public class Tank {
    public int x;
    public int y;

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

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Tank() {
    }

    /**
     * 坦克的
     * @param g
     */
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
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
        switch (dir){
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
        }

        setMainDir();
    }

    /**
     * 设置主战坦克的方向
     */
    private void setMainDir() {
        if (!bL && !bR && !bU && !bD) {
            dir = Dir.STOP;
        }
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
