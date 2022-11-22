# Rectangles
Java library that can be used to analyze rectangles and the features that exist among rectangles.  
**Note**: This library considers rectangles to be axis-aligned. Angled rectangles would be a future enhancement:-).

The following features can be analyzed for two rectangles:  
------------------------------------------------------------------------

**1.Intersection**:  
Determine whether two rectangles intersect each other and also get the list of intersecting points.  
 
*Intersection scenarios*: 

<img src="/images/Intersection.jpg" width="400">

**2.Containment**: Determine whether a rectangle is wholly contained within another rectangle.

*Containment scenarios*:

<img src="/images/Containment.jpg" width="400">

**3.Adjacency**:  
Determine whether two rectangles are adjacent.  
Adjacency is defined as the sharing of at least one side. Side sharing may be proper, sub-line or partial.detect whether two rectangles are adjacent.
A sub-line share is a share where one side of rectangle A is a line that exists as a set of points wholly contained on some other side of rectangle B,
where partial is one where some line segment on a side of rectangle A exists as a set of points on some side of Rectangle B.

*Adjacency scenarios*:  

<img src="/images/Adjacency.jpg" width="400">

## Clean and Build the project:
Build and package the project using the below command:
```
    mvn clean package
   ```
This above command creates the jar file in your target directory.
If you want to install the library in your local maven repository, then run the below command:
```
    mvn clean install
   ```
Tests in this project illustrates the different ways Rectangle class methods can be used.
Run the tests using the below command:
```
    mvn clean test
   ```

