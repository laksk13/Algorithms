package com.example.rectangles;

import java.util.List;
/*
 * Utility class to determine the features of two given axis-aligned rectangles.
 *
 */
public class RectangleUtils {
    public static boolean validateRectangle(Rectangle r) throws Exception {
        if(r==null || r.getWidth()==0 || r.getHeight()==0)
        {
            throw new Exception("Not a valid rectangle");
        }
        if(r.getWidth()<0 ||  r.getHeight()<0)
        {
            throw new Exception("Please provide valid bottom-left and top-right coordinates");
        }
        return true;
    }
    public static boolean intersects(Rectangle r1, Rectangle r2) throws Exception {
        validateRectangle(r1);
        validateRectangle(r2);
        return r1.contains(r2);
    }

    public static List<Point> findIntersectingPoints(Rectangle r1, Rectangle r2) throws Exception {
        validateRectangle(r1);
        validateRectangle(r2);
        return r1.findIntersectingPoints(r2);
    }

    public static boolean containsWholly(Rectangle r1, Rectangle r2) throws Exception {
        validateRectangle(r1);
        validateRectangle(r2);
        return r1.containsWholly(r2);
    }
    public static boolean contains(Rectangle r1, Rectangle r2) throws Exception {
        validateRectangle(r1);
        validateRectangle(r2);
        return r1.contains(r2);
    }

    public static boolean areAdjacent(Rectangle r1, Rectangle r2) throws Exception {
        validateRectangle(r1);
        validateRectangle(r2);
        return r1.adjacent(r2);
    }




}
