package com.michaelpearcey.ConvexHull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Frame extends JFrame {

    private Point[] hull;
    private int multiplier = 50;

    public Frame(Point[] hull) {
        this.hull = hull;
        setSize(600, 600);
        setContentPane(new JLayeredPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void drawLines(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < hull.length-1; i++) {
            g2d.drawLine(hull[i].x*multiplier, hull[i].y*multiplier, hull[i+1].x*multiplier, hull[i+1].y*multiplier);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}
