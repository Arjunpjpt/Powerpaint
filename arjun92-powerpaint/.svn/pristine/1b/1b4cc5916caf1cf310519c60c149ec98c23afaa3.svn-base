/*
 * TCSS 305 - Power Paint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

/**
 * Tools to draw ellipse.
 * @author Arjun Prajapati
 * @version November 11, 2017
 */
public class EllipseTool extends AbstractTools {
    
    @Override
    public void draw(final Shape theShape
                     , final Point theStartPoint
                     , final MouseEvent theEvent) {

        ((Ellipse2D) theShape).setFrameFromDiagonal(theStartPoint, theEvent.getPoint());
        
    }

    @Override
    public Shape setNewShape(final  MouseEvent theEvent) {
        return new Ellipse2D.Double();
    }

    @Override
    public String getDescription() {
        return "";
    }

}
