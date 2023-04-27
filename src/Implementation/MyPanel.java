package Loading;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class MyPanel extends JPanel
{
    private final int pacmanHeight = 40;
    private final int pacmanWidth = 40;
    private int xcenter = -pacmanWidth/2;
    private int ycenter = 0;
    private boolean mouthOpen = false;
    private int nFrame = 0;
    private Timer timer = new Timer();

    public MyPanel ()
    {
        setBackground(Color.BLACK);

        timer.scheduleAtFixedRate(
                new TimerTask()
                {
                    public void run()
                    {
                        xcenter++;
                        repaint();
                    }
                }, 0, 1000 / 120);
    }

    @Override
    public void paint (Graphics g)
    {
        super.paint(g);

        Dimension size = getSize();

        ycenter = (int) size.getHeight() / 2;

        int x = xcenter - pacmanHeight / 2;
        int y = ycenter - pacmanHeight / 2;

        //g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, pacmanWidth, pacmanHeight);

        if (mouthOpen)
        {
            g.setColor(Color.BLACK);
            g.fillPolygon(new int[] {xcenter, xcenter + pacmanWidth/2, xcenter + pacmanWidth/2},
                    new int[] {ycenter, ycenter + pacmanHeight/4, ycenter - pacmanHeight/4}, 3);
        }

        //xcenter = (x <= size.getWidth()? xcenter+1 : -pacmanWidth);
        if (x > size.getWidth())
        {
            xcenter = -pacmanWidth;
        }

        if (nFrame < 60)
        {
            nFrame++;
        }
        else
        {
            mouthOpen ^= true;
            nFrame = 0;
        }
    }
}
