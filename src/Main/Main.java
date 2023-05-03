package Main;

import Implementation.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame("Loading");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(600, 338);
        f.setLocation(200, 200);

        MyPanel panel = new MyPanel();
        f.add(panel);

        f.setVisible(true);
    }
}