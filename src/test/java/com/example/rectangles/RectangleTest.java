package com.example.rectangles;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.rectangles.TestDataSetupUtils.*;
import static com.example.rectangles.TestValidationUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    @Test
    public void testRectanglesIntersect() {
        Arrays.stream(INTERSECTIONTYPE.values()).forEach(enumVal->validateIntersection(enumVal, true));
    }

    @Test
    public void testRectanglesNotIntersect_WithAdjacentRectangles() {
        Arrays.stream(ADJACENCYTYPE.values()).forEach(enumVal->validateIntersection(enumVal, false));
    }

    @Test
    public void testRectanglesNotIntersect_WithContainedRectangles() {
        Arrays.stream(CONTAINMENTTYPE.values()).forEach(enumVal->validateIntersection(enumVal, false));
    }

    @Test
    public void testFindIntersectingPoints() {
        Arrays.stream(INTERSECTIONTYPE.values()).forEach(enumVal-> validateIntersectingPoints(enumVal));
    }

    @Test
    public void testFindIntersectingPoints_ForNonIntersectingRectangles() {
        List<Rectangle> rectangles = ADJACENCYTYPE.PROPER_BOTTOM.getRectangles();
        List<Point> actualIntersectingPoints = rectangles.get(0).findIntersectingPoints(rectangles.get(1));
        assertEquals(null,actualIntersectingPoints);
    }

    @Test
    public void testRectangleContainsWholly() {

        CONTAINMENTTYPE.getNoTouchingRectangles().stream().forEach(enumVal->validateContainment(enumVal, true));
    }

    @Test
    public void testRectangleContains() {
        Arrays.stream(CONTAINMENTTYPE.values()).forEach(enumVal->validateContainment(enumVal, true));
    }
    @Test
    public void testRectangleNotContains_withIntersectingRectangles() {
        Arrays.stream(INTERSECTIONTYPE.values()).forEach(enumVal->validateContainment(enumVal, false));
    }
    @Test
    public void testRectangleNotContains_withAdjacentRectangles() {
        Arrays.stream(ADJACENCYTYPE.values()).forEach(enumVal->validateContainment(enumVal, false));
    }
    @Test
    public void testRectangleAdjacency() {
        Arrays.stream(ADJACENCYTYPE.values()).forEach(enumVal->validateAdjacency(enumVal, true));
    }

    @Test
    public void testRectangleNotAdjacency_withContainedRectangles() {
        Arrays.stream(CONTAINMENTTYPE.values()).forEach(enumVal->validateAdjacency(enumVal, false));
    }

    @Test
    public void testRectangleNotAdjacency_WithIntersectingRectangles() {
        Arrays.stream(INTERSECTIONTYPE.values()).forEach(enumVal->validateAdjacency(enumVal, false));
    }
    @Test
    public void testRectangleNotRelated_ForIntersection()
    {
        Arrays.stream(NONRELATEDTYPE.values()).forEach(enumVal->validateIntersection(enumVal, false));
    }
    @Test
    public void testRectangleNotRelated_ForAdjacency()
    {
        Arrays.stream(NONRELATEDTYPE.values()).forEach(enumVal->validateAdjacency(enumVal, false));
    }
    @Test
    public void testRectangleNotRelated_ForContainment()
    {
        Arrays.stream(NONRELATEDTYPE.values()).forEach(enumVal->validateContainment(enumVal, false));
    }
}
