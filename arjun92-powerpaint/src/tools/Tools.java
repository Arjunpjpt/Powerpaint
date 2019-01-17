/*
 * TCSS 305 - Power Paint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * Tools to draw ellipse.
 * @author Arjun Prajapati
 * @version November 11, 2017
 */
public interface Tools {
    /**
     * method to draw a shape.
     * @param theShape , shape of a tool
     * @param theStartPoint , start point to draw
     * @param theEvent , for the end point
     */
    void draw(Shape theShape, Point theStartPoint, MouseEvent theEvent);
    
    /**
     * method return shape.
     * @param theEvent , mouse event
     * @return Shape , shape drawn
     */
    Shape setNewShape(MouseEvent theEvent);
    /**
     * method to get description of tool.
     * @return String
     */
    String getDescription();
    
}
