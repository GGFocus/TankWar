import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tankframe extends Frame {

    Tank tank;

    public Tankframe () {
        this.setTitle("Tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);

        this.addKeyListener(new TankKeyListener());
        tank =new Tank(100, 100);
    }


    @Override
    public void paint(Graphics g) {
        tank.paint(g);
    }

    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            tank.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
