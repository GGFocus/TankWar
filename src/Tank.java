import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 面向对象编程，设计对应的类
 */
public class Tank {
    public int x;
    public int y;

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

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank() {
    }

    /**
     * 坦克的
     * @param g
     */
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);

    }

    /**
     * tank的操作系统
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        switch (key) {
            case KeyEvent.VK_LEFT:
                x -= SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                x += SPEED;
                break;
            case KeyEvent.VK_UP:
                y -= SPEED;
                break;
            case KeyEvent.VK_DOWN:
                y += SPEED;
                break;
        }
    }
}
