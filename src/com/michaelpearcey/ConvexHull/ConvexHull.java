package com.michaelpearcey.ConvexHull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConvexHull {

    static long cross(Point O, Point A, Point B) {
        return (A.x - O.x) * (long) (B.y - O.y) - (A.y - O.y) * (long) (B.x - O.x);
    }

    static Point[] convex_hull(Point[] P) {
        if (P.length > 1) {
            int n = P.length, k = 0;
            Point[] H = new Point[2 * n];
            Arrays.sort(P);
            // Build lower hull
            for (int i = 0; i < n; ++i) {
                while (k >= 2 && cross(H[k - 2], H[k - 1], P[i]) <= 0)
                    k--;
                H[k++] = P[i];
            }
            // Build upper hull
            for (int i = n - 2, t = k + 1; i >= 0; i--) {
                while (k >= t && cross(H[k - 2], H[k - 1], P[i]) <= 0)
                    k--;
                H[k++] = P[i];
            }
            if (k > 1) {
                H = Arrays.copyOfRange(H, 0, k - 1); // remove non-hull vertices after k; remove k - 1 which is a duplicate
            }
            return H;
        } else if (P.length <= 1) {
            return P;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hull.txt")); 	//Input Sample => size x y x y x y x y
        StringTokenizer st = new StringTokenizer(f.readLine());
        Point[] p = new Point[Integer.parseInt(st.nextToken())];
        for (int i = 0; i < p.length; i++) { //Loop through each value inputting it to the array of points.
            p[i] = new Point();
            p[i].x = Integer.parseInt(st.nextToken()); // Read X coordinate
            p[i].y = Integer.parseInt(st.nextToken()); // Read y coordinate
        }
        st = new StringTokenizer(f.readLine());
        Point[] p2 = new Point[Integer.parseInt(st.nextToken())];
        System.out.println(p2.length);
        for (int i = 0; i < p2.length; i++) { //Loop through each value inputting it to the array of points.
            p2[i] = new Point();
            p2[i].x = Integer.parseInt(st.nextToken()); // Read X coordinate
            p2[i].y = Integer.parseInt(st.nextToken()); // Read y coordinate
        }
        Point[] hull = convex_hull(p).clone();
        Point[] hull2 = convex_hull(p2).clone();
        for (Point aHull : hull) {
            if (aHull != null)
                System.out.print(aHull);
        }
        Frame fr = new Frame(hull, p, hull2, p2);
    }

}