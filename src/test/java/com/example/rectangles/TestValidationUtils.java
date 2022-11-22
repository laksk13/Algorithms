package com.example.rectangles;

import java.util.List;

import static com.example.rectangles.TestSetupUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestValidationUtils {
    public static void validateIntersection(FeatureType featureType, boolean assertFlag) {
        List<Rectangle> rectangles = featureType.getRectangles();
        assertEquals(assertFlag, rectangles.get(0).intersects(rectangles.get(1)), "Failed for "+ featureType);
    }

    public static void validateIntersectingPoints(INTERSECTIONTYPE enumVal)
    {
        List<Rectangle> rectangles = enumVal.getRectangles();
        List<Point> expectedIntersectingPoints = enumVal.getIntersectPoints();

        List<Point> actualIntersectingPoints = rectangles.get(0).findIntersectingPoints(rectangles.get(1));
        assertTrue(expectedIntersectingPoints.equals(actualIntersectingPoints), "Failed for "+ enumVal);
    }

    public static void validateContainment(FeatureType featureType, boolean assertFlag)
    {
        List<Rectangle> rectangles = featureType.getRectangles();
        assertEquals(assertFlag, rectangles.get(0).contains(rectangles.get(1)), "Failed for "+ featureType);
    }
    public static void validateContainmentWholly(FeatureType featureType, boolean assertFlag)
    {
        List<Rectangle> rectangles = featureType.getRectangles();
        assertEquals(assertFlag, rectangles.get(0).containsWholly(rectangles.get(1)), "Failed for "+ featureType);
    }

    public static void validateAdjacency(FeatureType featureType, boolean assertFlag)
    {
        List<Rectangle> rectangles = featureType.getRectangles();
        assertEquals(assertFlag, rectangles.get(0).adjacent(rectangles.get(1)), "Failed for "+ featureType);
    }
}
