package com.michaelpearcey.ConvexHull;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private Point[] hull;
    private Point[] polys;
    private Point[] hull2;
    private Point[] p2;
    private final int multiplier = 150;
    private final int pointSize = 20;

    Frame(Point[] hull, Point[] polys, Point[] hull2, Point[] p2) {
        this.hull = hull;
        this.polys = polys;
        this.hull2 = hull2;
        this.p2 = p2;
        setSize(1800, 1800);
        setContentPane(new JLayeredPane());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void drawLines(Graphics g) {
        drawPolys(hull, g);
        drawDots(polys, g);
        drawPolys(hull2, g);
        drawDots(p2, g);
    }

    private void drawDots(Point[] hull, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < hull.length; i++) {
            g2d.drawOval(hull[i].x*multiplier-(pointSize/2), hull[i].y*multiplier-(pointSize/2), pointSize, pointSize);
        }
    }

    private void drawPolys(Point[] hull, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < hull.length-1; i++) {
            g2d.drawLine(hull[i].x*multiplier, hull[i].y*multiplier, hull[i+1].x*multiplier, hull[i+1].y*multiplier);
        }
        g2d.drawLine(hull[hull.length-1].x*multiplier, hull[hull.length-1].y*multiplier, hull[0].x*multiplier, hull[0].y*multiplier);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}
