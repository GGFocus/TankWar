import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * @author gaoguofeng
 * @description 坦克大战
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tankframe f = new Tankframe();

        f.setVisible(true);

        for (int i = 0; i < 10000; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            f.repaint();
        }
    }


}

/**
 *
 * 为什么使用内部类？
 * a.不需要让别的类访问
 * b.高内聚，低耦合
 *
 */


/**
 * 面向对象与面向过程的区别？
 * 面对对象就是找到需求中的名词，然后建立相应的类。
 *
 *
 *
 */
