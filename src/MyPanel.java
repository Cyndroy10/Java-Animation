import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 350;
    Image birds;
    Image sun;
    Image car;
    Image birds1;
    Image background;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 400;
    int y = 50;
    int sx = 280;
    int sy = 120;
    int cx = -40;
    int cy = 210;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        birds = new ImageIcon("birds.png").getImage();
        car = new ImageIcon("car.png").getImage();
        sun = new ImageIcon("sun.png").getImage();
        birds1 = new ImageIcon("birds.png").getImage();
        background = new ImageIcon("background.jpg").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, null);
        g2D.drawImage(sun, sx, sy, null);
        g2D.drawImage(birds, x, y, null);
        g2D.drawImage(birds, x+100, y+50, null);
        g2D.drawImage(car, cx, cy, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(sy<=-20){
            yVelocity = 0;
        }
        x = x - xVelocity;
        sy = sy - yVelocity;
        cx = cx + xVelocity + 1;
        repaint();
    }
}
