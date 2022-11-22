package com.example.rectangles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangleUtilsTest {
    @Test
    public void testValidateRectangle() throws Exception {
        Rectangle r1 = new Rectangle(new Point(3,4), new Point(6,8));
        assertTrue(RectangleUtils.validateRectangle(r1));
    }

    @Test
    public void testValidateRectangleNotValid_NullValue() throws Exception {
        Exception ex = Assertions.assertThrows(Exception.class, () -> {
            RectangleUtils.validateRectangle(null);
        });

        Assertions.assertEquals("Not a valid rectangle", ex.getMessage());
    }
    @Test
    public void testValidateRectangleNotValid_withCoordinatesWrongOrder() throws Exception {
        //bottom-left and top-right coordinates swapped.
        Rectangle r1 = new Rectangle(new Point(6,8), new Point(3,4));
        Exception ex = Assertions.assertThrows(Exception.class, () -> {
            RectangleUtils.validateRectangle(r1);
        });

        Assertions.assertEquals("Please provide valid bottom-left and top-right coordinates", ex.getMessage());
    }
}
