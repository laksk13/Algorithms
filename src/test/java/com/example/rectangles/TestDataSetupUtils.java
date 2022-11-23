package com.example.rectangles;


import java.util.Arrays;
import java.util.List;

public class TestDataSetupUtils {
    public static final int xOffset = 10;
    public static final int yOffset = 12;

    public static final Rectangle r1 = new Rectangle(new Point(3, 4), new Point(7, 8));
    public static final Rectangle r1_q2 = new Rectangle(new Point(3-xOffset, 4), new Point(7-xOffset, 8));
    public static final Rectangle r1_q3 = new Rectangle(new Point(3-xOffset, 4-yOffset), new Point(7-xOffset, 8-yOffset));
    public static final Rectangle r1_q4 = new Rectangle(new Point(3, 4-yOffset), new Point(7, 8-yOffset));

    public static final Rectangle r1_float = new Rectangle(new Point(3.1, 4), new Point(7, 8.2));

    public interface FeatureType
    {
        List<Rectangle> getRectangles();
    }
    public enum NONRELATEDTYPE implements FeatureType{
        LOCATED_ON_TOP(Arrays.asList(r1, new Rectangle(new Point(3, 9), new Point(7, 12)))),
        LOCATED_ON_BOTTOM(Arrays.asList(r1, new Rectangle(new Point(3, 1), new Point(7, 2)))),
        LOCATED_ON_LEFT(Arrays.asList(r1, new Rectangle(new Point(-1, 4), new Point(2, 12)))),
        LOCATED_ON_RIGHT(Arrays.asList(r1, new Rectangle(new Point(8, 4), new Point(12, 12)))),
        TOUCH_AT_CORNER(Arrays.asList(r1, new Rectangle(new Point(7, 8), new Point(12, 12))));

        private List<Rectangle> rectangles;

        public List<Rectangle> getRectangles() {
            return rectangles;
        }

        NONRELATEDTYPE(List<Rectangle> rects)
        {
            this.rectangles = rects;
        }
    }
    public enum INTERSECTIONTYPE implements FeatureType{
        INTERSECTION_WITH_ONE_SIDE_OVERLAPPING(Arrays.asList(r1_float,new Rectangle(new Point(3.1, 3), new Point(5, 7))), Arrays.asList(new Point(5, 4))),
        INTERSECTION_WITH_TWO_SIDES_OVERLAPPING(Arrays.asList(r1_float, new Rectangle(new Point(5.1, 4), new Point(7, 9.4))), Arrays.asList(new Point(5.1, 8.2))),
        INTERSECTION_WITH_NO_OVER_LAPPING_TOP(Arrays.asList(r1_float,new Rectangle(new Point(5.1, 5.2), new Point(6.3, 9.4))), Arrays.asList(new Point(5.1, 8.2),new Point(6.3, 8.2))),
        INTERSECTION_WITH_NO_OVER_LAPPING_BOTTOM(Arrays.asList(r1_float,new Rectangle(new Point(5.1, 0.2), new Point(6.3, 5.4))), Arrays.asList(new Point(5.1, 4),new Point(6.3, 4))),
        INTERSECTION_WITH_NO_OVER_LAPPING_LEFT(Arrays.asList(r1,new Rectangle(new Point(1, 5), new Point(5, 9))), Arrays.asList(new Point(3, 5),new Point(5, 8))),
        INTERSECTION_WITH_NO_OVER_LAPPING_RIGHT(Arrays.asList(r1,new Rectangle(new Point(5, 5), new Point(8, 9))), Arrays.asList(new Point(5, 8),new Point(7, 5))),
        INTERSECTION_WITH_ONE_SIDE_OVERLAPPINGQ2(Arrays.asList(r1_q2,new Rectangle(new Point(3-xOffset, 3), new Point(5-xOffset, 7))), Arrays.asList(new Point(5-xOffset, 4))),
        INTERSECTION_WITH_TWO_SIDES_OVERLAPPINGQ2(Arrays.asList(r1_q2, new Rectangle(new Point(5-xOffset, 4), new Point(7-xOffset, 9))), Arrays.asList(new Point(5-xOffset, 8))),
        INTERSECTION_WITH_NO_OVER_LAPPING_TOPQ2(Arrays.asList(r1_q2,new Rectangle(new Point(5-xOffset, 5), new Point(6-xOffset, 9))), Arrays.asList(new Point(5-xOffset, 8),new Point(6-xOffset, 8))),
        INTERSECTION_WITH_NO_OVER_LAPPING_BOTTOMQ2(Arrays.asList(r1_q2,new Rectangle(new Point(5-xOffset, 0), new Point(6-xOffset, 5))), Arrays.asList(new Point(5-xOffset, 4),new Point(6-xOffset, 4))),
        INTERSECTION_WITH_NO_OVER_LAPPING_LEFTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(1-xOffset, 5), new Point(5-xOffset, 9))), Arrays.asList(new Point(3-xOffset, 5),new Point(5-xOffset, 8))),
        INTERSECTION_WITH_NO_OVER_LAPPING_RIGHTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(5-xOffset, 5), new Point(8-xOffset, 9))), Arrays.asList(new Point(5-xOffset, 8),new Point(7-xOffset, 5))),
        INTERSECTION_WITH_ONE_SIDE_OVERLAPPINGQ3(Arrays.asList(r1_q3,new Rectangle(new Point(3-xOffset, 3-yOffset), new Point(5-xOffset, 7-yOffset))), Arrays.asList(new Point(5-xOffset, 4-yOffset))),
        INTERSECTION_WITH_TWO_SIDES_OVERLAPPINGQ3(Arrays.asList(r1_q3, new Rectangle(new Point(5-xOffset, 4-yOffset), new Point(7-xOffset, 9-yOffset))), Arrays.asList(new Point(5-xOffset, 8-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_TOPQ3(Arrays.asList(r1_q3,new Rectangle(new Point(5-xOffset, 5-yOffset), new Point(6-xOffset, 9-yOffset))), Arrays.asList(new Point(5-xOffset, 8-yOffset),new Point(6-xOffset, 8-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_BOTTOMQ3(Arrays.asList(r1_q3,new Rectangle(new Point(5-xOffset, 0-yOffset), new Point(6-xOffset, 5-yOffset))), Arrays.asList(new Point(5-xOffset, 4-yOffset),new Point(6-xOffset, 4-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_LEFTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(1-xOffset, 5-yOffset), new Point(5-xOffset, 9-yOffset))), Arrays.asList(new Point(3-xOffset, 5-yOffset),new Point(5-xOffset, 8-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_RIGHTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(5-xOffset, 5-yOffset), new Point(8-xOffset, 9-yOffset))), Arrays.asList(new Point(5-xOffset, 8-yOffset),new Point(7-xOffset, 5-yOffset))),
        INTERSECTION_WITH_ONE_SIDE_OVERLAPPINGQ4(Arrays.asList(r1_q4,new Rectangle(new Point(3, 3-yOffset), new Point(5, 7-yOffset))), Arrays.asList(new Point(5, 4-yOffset))),
        INTERSECTION_WITH_TWO_SIDES_OVERLAPPINGQ4(Arrays.asList(r1_q4, new Rectangle(new Point(5, 4-yOffset), new Point(7, 9-yOffset))), Arrays.asList(new Point(5, 8-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_TOPQ4(Arrays.asList(r1_q4,new Rectangle(new Point(5, 5-yOffset), new Point(6, 9-yOffset))), Arrays.asList(new Point(5, 8-yOffset),new Point(6, 8-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_BOTTOMQ4(Arrays.asList(r1_q4,new Rectangle(new Point(5, 0-yOffset), new Point(6, 5-yOffset))), Arrays.asList(new Point(5, 4-yOffset),new Point(6, 4-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_LEFTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(1, 5-yOffset), new Point(5, 9-yOffset))), Arrays.asList(new Point(3, 5-yOffset),new Point(5, 8-yOffset))),
        INTERSECTION_WITH_NO_OVER_LAPPING_RIGHTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(5, 5-yOffset), new Point(8, 9-yOffset))), Arrays.asList(new Point(5, 8-yOffset),new Point(7, 5-yOffset)));
        private List<Rectangle> rectangles;
        private List<Point> intersectPoints;

        public List<Rectangle> getRectangles() {
            return rectangles;
        }

        public List<Point> getIntersectPoints() {
            return intersectPoints;
        }

        INTERSECTIONTYPE(List<Rectangle> rects, List<Point> intersectingPoints)
        {
            this.rectangles = rects;
            this.intersectPoints=intersectingPoints;
        }

    }

    public enum CONTAINMENTTYPE implements FeatureType{
        CONTAINS_WITH_NO_TOUCHING_SIDES(Arrays.asList(r1,new Rectangle(new Point(5, 5), new Point(6, 7)))),
        CONTAINS_WITH_ONE_TOUCHING_SIDES(Arrays.asList(r1,new Rectangle(new Point(3, 4), new Point(6, 7)))),
        CONTAINS_WITH_TWO_TOUCHING_SIDES(Arrays.asList(r1,new Rectangle(new Point(3, 4), new Point(5, 6)))),
        CONTAINS_WITH_THREE_TOUCHING_SIDES(Arrays.asList(r1,new Rectangle(new Point(3, 4), new Point(7, 7)))),
        CONTAINS_WITH_ALL_TOUCHING_SIDES(Arrays.asList(r1,new Rectangle(new Point(3, 4), new Point(7, 8)))),
        CONTAINS_WITH_NO_TOUCHING_SIDESQ2(Arrays.asList(r1_q2,new Rectangle(new Point(5-xOffset, 5), new Point(6-xOffset, 7)))),
        CONTAINS_WITH_ONE_TOUCHING_SIDESQ2(Arrays.asList(r1_q2,new Rectangle(new Point(3-xOffset, 4), new Point(6-xOffset, 7)))),
        CONTAINS_WITH_TWO_TOUCHING_SIDESQ2(Arrays.asList(r1_q2,new Rectangle(new Point(3-xOffset, 4), new Point(5-xOffset, 6)))),
        CONTAINS_WITH_THREE_TOUCHING_SIDESQ2(Arrays.asList(r1_q2,new Rectangle(new Point(3-xOffset, 4), new Point(7-xOffset, 7)))),
        CONTAINS_WITH_ALL_TOUCHING_SIDESQ2(Arrays.asList(r1_q2,new Rectangle(new Point(3-xOffset, 4), new Point(7-xOffset, 8)))),
        CONTAINS_WITH_NO_TOUCHING_SIDESQ3(Arrays.asList(r1_q3,new Rectangle(new Point(5-xOffset, 5-yOffset), new Point(6-xOffset, 7-yOffset)))),
        CONTAINS_WITH_ONE_TOUCHING_SIDESQ3(Arrays.asList(r1_q3,new Rectangle(new Point(3-xOffset, 4-yOffset), new Point(6-xOffset, 7-yOffset)))),
        CONTAINS_WITH_TWO_TOUCHING_SIDESQ3(Arrays.asList(r1_q3,new Rectangle(new Point(3-xOffset, 4-yOffset), new Point(5-xOffset, 6-yOffset)))),
        CONTAINS_WITH_THREE_TOUCHING_SIDESQ3(Arrays.asList(r1_q3,new Rectangle(new Point(3-xOffset, 4-yOffset), new Point(7-xOffset, 7-yOffset)))),
        CONTAINS_WITH_ALL_TOUCHING_SIDESQ3(Arrays.asList(r1_q3,new Rectangle(new Point(3-xOffset, 4-yOffset), new Point(7-xOffset, 8-yOffset)))),
        CONTAINS_WITH_NO_TOUCHING_SIDESQ4(Arrays.asList(r1_q4,new Rectangle(new Point(5, 5-yOffset), new Point(6, 7-yOffset)))),
        CONTAINS_WITH_ONE_TOUCHING_SIDESQ4(Arrays.asList(r1_q4,new Rectangle(new Point(3, 4-yOffset), new Point(6, 7-yOffset)))),
        CONTAINS_WITH_TWO_TOUCHING_SIDESQ4(Arrays.asList(r1_q4,new Rectangle(new Point(3, 4-yOffset), new Point(5, 6-yOffset)))),
        CONTAINS_WITH_THREE_TOUCHING_SIDESQ4(Arrays.asList(r1_q4,new Rectangle(new Point(3, 4-yOffset), new Point(7, 7-yOffset)))),
        CONTAINS_WITH_ALL_TOUCHING_SIDESQ4(Arrays.asList(r1_q4,new Rectangle(new Point(3, 4-yOffset), new Point(7, 8-yOffset))));

        private List<Rectangle> rectangles;

        public List<Rectangle> getRectangles() {
            return rectangles;
        }

        CONTAINMENTTYPE(List<Rectangle> rects)
        {
            this.rectangles = rects;
        }

        public static List<CONTAINMENTTYPE> getNoTouchingRectangles()
        {
            return Arrays.asList(CONTAINS_WITH_NO_TOUCHING_SIDES,CONTAINS_WITH_NO_TOUCHING_SIDESQ2, CONTAINS_WITH_NO_TOUCHING_SIDESQ3, CONTAINS_WITH_NO_TOUCHING_SIDESQ4);
        }

    }

    public enum ADJACENCYTYPE implements FeatureType{
        PROPER_TOP(Arrays.asList(r1,new Rectangle(new Point(3, 8), new Point(7, 9)))),
        PROPER_LEFT(Arrays.asList(r1,new Rectangle(new Point(1, 4), new Point(3, 8)))),
        PROPER_BOTTOM(Arrays.asList(r1,new Rectangle(new Point(3, 2), new Point(7, 4)))),
        PROPER_RIGHT(Arrays.asList(r1,new Rectangle(new Point(7, 4), new Point(8, 8)))),
        SUBLINE_TOP(Arrays.asList(r1,new Rectangle(new Point(5, 8), new Point(6, 9)))),
        SUBLINE_BOTTOM(Arrays.asList(r1,new Rectangle(new Point(5, 2), new Point(6, 4)))),
        SUBLINE_LEFT(Arrays.asList(r1,new Rectangle(new Point(1, 5), new Point(3, 6)))),
        SUBLINE_RIGHT(Arrays.asList(r1,new Rectangle(new Point(7, 5), new Point(8, 6)))),
        PARTIAL_TOP(Arrays.asList(r1,new Rectangle(new Point(1, 8), new Point(5, 9)))),
        PARTIAL_LEFT(Arrays.asList(r1,new Rectangle(new Point(1, 0), new Point(3, 5)))),
        PARTIAL_BOTTOM(Arrays.asList(r1,new Rectangle(new Point(5, 1), new Point(8, 4)))),
        PARTIAL_RIGHT(Arrays.asList(r1,new Rectangle(new Point(7, 6), new Point(8, 9)))),
        PROPER_TOPQ2(Arrays.asList(r1_q2,new Rectangle(new Point(3-xOffset, 8), new Point(7-xOffset, 9)))),
        PROPER_LEFTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(1-xOffset, 4), new Point(3-xOffset, 8)))),
        PROPER_BOTTOMQ2(Arrays.asList(r1_q2,new Rectangle(new Point(3-xOffset, 2), new Point(7-xOffset, 4)))),
        PROPER_RIGHTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(7-xOffset, 4), new Point(8-xOffset, 8)))),
        SUBLINE_TOPQ2(Arrays.asList(r1_q2,new Rectangle(new Point(5-xOffset, 8), new Point(6-xOffset, 9)))),
        SUBLINE_BOTTOMQ2(Arrays.asList(r1_q2,new Rectangle(new Point(5-xOffset, 2), new Point(6-xOffset, 4)))),
        SUBLINE_LEFTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(1-xOffset, 5), new Point(3-xOffset, 6)))),
        SUBLINE_RIGHTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(7-xOffset, 5), new Point(8-xOffset, 6)))),
        PARTIAL_TOPQ2(Arrays.asList(r1_q2,new Rectangle(new Point(1-xOffset, 8), new Point(5-xOffset, 9)))),
        PARTIAL_LEFTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(1-xOffset, 0), new Point(3-xOffset, 5)))),
        PARTIAL_BOTTOMQ2(Arrays.asList(r1_q2,new Rectangle(new Point(5-xOffset, 1), new Point(8-xOffset, 4)))),
        PARTIAL_RIGHTQ2(Arrays.asList(r1_q2,new Rectangle(new Point(7-xOffset, 6), new Point(8-xOffset, 9)))),
        PROPER_TOPQ3(Arrays.asList(r1_q3,new Rectangle(new Point(3-xOffset, 8-yOffset), new Point(7-xOffset, 9-yOffset)))),
        PROPER_LEFTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(1-xOffset, 4-yOffset), new Point(3-xOffset, 8-yOffset)))),
        PROPER_BOTTOMQ3(Arrays.asList(r1_q3,new Rectangle(new Point(3-xOffset, 2-yOffset), new Point(7-xOffset, 4-yOffset)))),
        PROPER_RIGHTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(7-xOffset, 4-yOffset), new Point(8-xOffset, 8-yOffset)))),
        SUBLINE_TOPQ3(Arrays.asList(r1_q3,new Rectangle(new Point(5-xOffset, 8-yOffset), new Point(6-xOffset, 9-yOffset)))),
        SUBLINE_BOTTOMQ3(Arrays.asList(r1_q3,new Rectangle(new Point(5-xOffset, 2-yOffset), new Point(6-xOffset, 4-yOffset)))),
        SUBLINE_LEFTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(1-xOffset, 5-yOffset), new Point(3-xOffset, 6-yOffset)))),
        SUBLINE_RIGHTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(7-xOffset, 5-yOffset), new Point(8-xOffset, 6-yOffset)))),
        PARTIAL_TOPQ3(Arrays.asList(r1_q3,new Rectangle(new Point(1-xOffset, 8-yOffset), new Point(5-xOffset, 9-yOffset)))),
        PARTIAL_LEFTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(1-xOffset, 0-yOffset), new Point(3-xOffset, 5-yOffset)))),
        PARTIAL_BOTTOMQ3(Arrays.asList(r1_q3,new Rectangle(new Point(5-xOffset, 1-yOffset), new Point(8-xOffset, 4-yOffset)))),
        PARTIAL_RIGHTQ3(Arrays.asList(r1_q3,new Rectangle(new Point(7-xOffset, 6-yOffset), new Point(8-xOffset, 9-yOffset)))),
        PROPER_TOPQ4(Arrays.asList(r1_q4,new Rectangle(new Point(3, 8-yOffset), new Point(7, 9-yOffset)))),
        PROPER_LEFTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(1, 4-yOffset), new Point(3, 8-yOffset)))),
        PROPER_BOTTOMQ4(Arrays.asList(r1_q4,new Rectangle(new Point(3, 2-yOffset), new Point(7, 4-yOffset)))),
        PROPER_RIGHTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(7, 4-yOffset), new Point(8, 8-yOffset)))),
        SUBLINE_TOPQ4(Arrays.asList(r1_q4,new Rectangle(new Point(5, 8-yOffset), new Point(6, 9-yOffset)))),
        SUBLINE_BOTTOMQ4(Arrays.asList(r1_q4,new Rectangle(new Point(5, 2-yOffset), new Point(6, 4-yOffset)))),
        SUBLINE_LEFTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(1, 5-yOffset), new Point(3, 6-yOffset)))),
        SUBLINE_RIGHTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(7, 5-yOffset), new Point(8, 6-yOffset)))),
        PARTIAL_TOPQ4(Arrays.asList(r1_q4,new Rectangle(new Point(1, 8-yOffset), new Point(5, 9-yOffset)))),
        PARTIAL_LEFTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(1, 0-yOffset), new Point(3, 5-yOffset)))),
        PARTIAL_BOTTOMQ4(Arrays.asList(r1_q4,new Rectangle(new Point(5, 1-yOffset), new Point(8, 4-yOffset)))),
        PARTIAL_RIGHTQ4(Arrays.asList(r1_q4,new Rectangle(new Point(7, 6-yOffset), new Point(8, 9-yOffset))));
        private List<Rectangle> rectangles;

        public List<Rectangle> getRectangles() {
            return rectangles;
        }

        ADJACENCYTYPE(List<Rectangle> rects)
        {
            this.rectangles = rects;
        }

    }
}
