package com.example.rectangles;


import java.util.ArrayList;
import java.util.List;

/*
* Rectangle class represents an area on coordinate plan whose location is identified by bottomleft and topRight coordinates
* Given bottomleft and topRight coordinates, rectangle's width and height can be derived, hence 'width' and 'height' properties are
* not needed to construct the Rectangle object, only bottomleft and topRight coordinates are needed.
*/

public class Rectangle {
    Point bottomLeftPoint;
    Point topRightPoint;
    double width;
    double height;

    public Point getBottomLeftPoint() {
        return bottomLeftPoint;
    }

    public void setBottomLeftPoint(Point bottomLeftPoint) {
        this.bottomLeftPoint = bottomLeftPoint;
    }

    public Point getTopRightPoint() {
        return topRightPoint;
    }

    public void setTopRightPoint(Point topRightPoint) {
        this.topRightPoint = topRightPoint;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle(Point lowLeftPoint, Point topRightPoint) {
        this.bottomLeftPoint = lowLeftPoint;
        this.topRightPoint = topRightPoint;
        width = topRightPoint.getX() - bottomLeftPoint.getX();
        height = topRightPoint.getY() - bottomLeftPoint.getY();
    }

    /*
     * Determines whether this rectangle and the specified rectangle intersect or not.
     * Two rectangles do not intersect if the either of the below scenarios are true:
     *    1.Other rectangle is contained in this rectangle, either touching or not touching the edges.
     *    2.Other rectangle is completely outside of this rectangle, either touching or not touching the edges.
     * @Param: other – the specified Rectangle
     * @Return: true if the specified Rectangle and this Rectangle intersect; false otherwise
     */
    public boolean intersects(Rectangle other) {
        if(contains(other))
        {
            return false;
        }
        if (this.getTopRightPoint().getY() <= other.getBottomLeftPoint().getY()
                || this.getBottomLeftPoint().getY() >= other.getTopRightPoint().getY()
                || this.getTopRightPoint().getX() <= other.getBottomLeftPoint().getX()
                || this.getBottomLeftPoint().getX() >= other.getTopRightPoint().getX()) {
            return false;
        }
        return true;
    }
    /*
     * Determines whether the specified rectangle is contained inside this rectangle without touching any sides.
     * The specified rectangle is said to be contained in this rectangle if both below scenarios are true:
     *    1.Other rectangle's topright coordinates must be less than this rectangle's topright coordinates.
     *    2.Other rectangle's bottomleft coordinates are greater than this rectangle's bottomleft coordinates.
     * @Param: other – the specified Rectangle
     * @Return: true if the specified Rectangle is contained inside this Rectangle; false otherwise
     */
    public boolean containsWholly(Rectangle other) {

        if (this.getTopRightPoint().getX() > other.getTopRightPoint().getX() && this.getTopRightPoint().getY() > other.getTopRightPoint().getY()
                && this.getBottomLeftPoint().getX() < other.getBottomLeftPoint().getX() && this.getBottomLeftPoint().getY() < other.getBottomLeftPoint().getY())
            return true;
        return false;
    }

    /*
     * Determines whether the specified rectangle is contained inside this rectangle.
     * The specified rectangle is said to be contained in this rectangle if both below scenarios are true:
     *    1.Other rectangle's topright coordinates must be less than or equal to this rectangle's topright coordinates.
     *    2.Other rectangle's bottomleft coordinates are greater than or equal to this rectangle's bottomleft coordinates.
     * @Param: other – the specified Rectangle
     * @Return: true if the specified Rectangle is contained inside this Rectangle; false otherwise
     */
    public boolean contains(Rectangle other) {

        if (this.getTopRightPoint().getX() >= other.getTopRightPoint().getX() && this.getTopRightPoint().getY() >= other.getTopRightPoint().getY()
                && this.getBottomLeftPoint().getX() <= other.getBottomLeftPoint().getX() && this.getBottomLeftPoint().getY() <= other.getBottomLeftPoint().getY())
            return true;
        return false;
    }

    /*
     * Determines whether the specified rectangle is adjacent to this rectangle.
     * Logic to determine adjacency:
     * -If other rectangle is contained within this rectangle, then rectangles are not adjacent.
     * -If this rectangle's topRight or bottomleft either of the coordinates do not align with other rectangle's bottomleft or topright coordinates respectively, then
     * rectangles are not adjacent.
     * -Find the intersecting rectangle, if the both width and height are 0 then rectangles touching at the corner.
     * -If intersecting rectangle width is 0, then:
     *        -If other rectangle top-right y is greater than this rectangle topright y or if other rectangle bottom-left y is less than this rectangle bottom-left y,
     *         then it is partial adjacency.
     *        -If other rectangle top-right y is less than this rectangle topright y or if other rectangle bottom-left y is greater than this rectangle bottom-left y,
     *         then it is subline adjacency.
     *        -If other rectangle top-right y and bottom-left y are equal to this rectangle top-right y and bottom-left y respectively,
     *         then it is proper adjacency.
     *  -If intersecting rectangle height is 0, then:
     *        -If other rectangle top-right x is greater than this rectangle topright x or if other rectangle bottom-left x is less than this rectangle bottom-left x,
     *         then it is partial adjacency.
     *        -If other rectangle top-right x is less than this rectangle topright x or if other rectangle bottom-left x is greater than this rectangle bottom-left x,
     *         then it is subline adjacency.
     *        -If other rectangle top-right x and bottom-left x are equal to this rectangle top-right x and bottom-left x respectively,
     *         then it is proper adjacency.
     * @Param: other – the specified Rectangle
     * @Return: true if the specified Rectangle is adjacent to this Rectangle; false otherwise
     *
     */
    public boolean adjacent(Rectangle other) {
        if (contains(other)) {
            return false;
        }
        if (!(this.getTopRightPoint().getY() == other.getBottomLeftPoint().getY()
                || this.getBottomLeftPoint().getY() == other.getTopRightPoint().getY()
                || this.getTopRightPoint().getX() == other.getBottomLeftPoint().getX()
                || this.getBottomLeftPoint().getX() == other.getTopRightPoint().getX())) {
            return false;
        }

        Rectangle intersectingRect = findIntersectingRectangle(other);
        if(intersectingRect.getWidth() == 0 && intersectingRect.getHeight() == 0)
        {
            return false; //touching at the corner, may be not called adjacent, TODO: Need to clarfy.
        }

        if(intersectingRect.getWidth() == 0)
        {
            if(other.getTopRightPoint().getY()>this.getTopRightPoint().getY() ||
                    other.getBottomLeftPoint().getY()<this.getBottomLeftPoint().getY())
            {
                return true; //partial adjacency
            } else if(other.getTopRightPoint().getY()<this.getTopRightPoint().getY() &&
                    other.getBottomLeftPoint().getY()>this.getBottomLeftPoint().getY() )
            {
                return true; //subline adjacency
            } else if(other.getTopRightPoint().getY()==this.getTopRightPoint().getY() &&
                    other.getBottomLeftPoint().getY()==this.getBottomLeftPoint().getY())
            {
                return true; //proper adjacency
            } else
            {
                return false;
            }
        }
        if(intersectingRect.getHeight() == 0)
        {
            if(other.getTopRightPoint().getX()>this.getTopRightPoint().getX() ||
                    other.getBottomLeftPoint().getX()<this.getBottomLeftPoint().getX())
            {
                return true; //partial adjacency
            } else if(other.getTopRightPoint().getX()<this.getTopRightPoint().getX() &&
                    other.getBottomLeftPoint().getX()>this.getBottomLeftPoint().getX() )
            {
                return true; //subline adjacency
            }else if(other.getTopRightPoint().getX()==this.getTopRightPoint().getX() && other.getBottomLeftPoint().getX()==this.getBottomLeftPoint().getX())
            {
                return true; //proper adjacency
            }else{
                return false;
            }
        }

        return false;

    }


     /*
     * Creates intersecting rectangle formed when this rectangle and other rectangle intersects.
     * @Param: other – the specified Rectangle
     * @Return: Rectangle - represents intersecting rectangle.
     *
     */
    private Rectangle findIntersectingRectangle(Rectangle other) {
        double intersectRectX1 = Math.max(this.getBottomLeftPoint().getX(), other.getBottomLeftPoint().getX());
        double intersectRectY1 = Math.max(this.getBottomLeftPoint().getY(), other.getBottomLeftPoint().getY());
        double intersectRectX2 = Math.min(this.getTopRightPoint().getX(), other.getTopRightPoint().getX());
        double intersectRectY2 = Math.min(this.getTopRightPoint().getY(), other.getTopRightPoint().getY());
        return new Rectangle(new Point(intersectRectX1, intersectRectY1), new Point(intersectRectX2, intersectRectY2));

    }
    /*
     * Creates list of intersecting points where this rectangle and other rectangle sides intersect each other.
     * First, we find the intersecting rectangle and then determine which corner points of the intersecting rectangle are on both 'this' rectangle and 'other' rectangle.
     * @Param: other – the specified Rectangle
     * @Return: Rectangle - represents intersecting rectangle.
     *
     */
    public List<Point> findIntersectingPoints(Rectangle other) {
        if(!this.intersects(other))
        {
            return null;
        }
        Rectangle intersectingRect = findIntersectingRectangle(other);

        Point intersectingRectBottomLeft = intersectingRect.getBottomLeftPoint();
        Point intersectingRectTopRight = intersectingRect.getTopRightPoint();
        //Create flags to determine if bottomleft and topright coordinates of intersecting rectangle came from either this rectangle or other rectangle or both.
        int x1Flag = (intersectingRectBottomLeft.getX() == this.getBottomLeftPoint().getX() ? 1 : 0) | ((intersectingRectBottomLeft.getX() == other.getBottomLeftPoint().getX() ? 1 : 0) << 1);
        int y1Flag = (intersectingRectBottomLeft.getY() == this.getBottomLeftPoint().getY() ? 1 : 0) | ((intersectingRectBottomLeft.getY() == other.getBottomLeftPoint().getY() ? 1 : 0) << 1);
        int x2Flag = (intersectingRectTopRight.getX() == this.getTopRightPoint().getX() ? 1 : 0) | ((intersectingRectTopRight.getX() == other.getTopRightPoint().getX() ? 1 : 0) << 1);
        int y2Flag = (intersectingRectTopRight.getY() == this.getTopRightPoint().getY() ? 1 : 0) | ((intersectingRectTopRight.getY() == other.getTopRightPoint().getY() ? 1 : 0) << 1);
        List<Point> intersectingPoints = new ArrayList<>();
        //If bitwise '&' operation between x and y flags is 0, that means, x and y coordinates came from different rectangles, hence we can say the point is an intersection point.
        if ((x1Flag & y1Flag) == 0) {
            intersectingPoints.add(intersectingRectBottomLeft);
        }
        if ((x1Flag & y2Flag) == 0) {
            intersectingPoints.add(new Point(intersectingRectBottomLeft.getX(), intersectingRectTopRight.getY()));
        }
        if ((x2Flag & y1Flag) == 0) {
            intersectingPoints.add(new Point(intersectingRectTopRight.getX(), intersectingRectBottomLeft.getY()));
        }
        if ((x2Flag & y2Flag) == 0) {
            intersectingPoints.add(intersectingRectTopRight);
        }

        return intersectingPoints;
    }

}
