/*
 * TCSS 305 - Power Paint
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;

/**
 * Tools to draw ellipse.
 * @author Arjun Prajapati
 * @version November 11, 2017
 */
public class PencilTool extends AbstractTools {

    @Override
    public void draw(final Shape theShape
                     , final Point theStartPoint
                     , final  MouseEvent theEvent) {
        
        ((Path2D) theShape).lineTo(theEvent.getX(), theEvent.getY());
    }

    @Override
    public Shape setNewShape(final  MouseEvent theEvent) {
        
        final Path2D path = new Path2D.Double();
        path.reset();
        path.moveTo(theEvent.getX(), theEvent.getY());
        return path;
    }

    @Override
    public String getDescription() {
        return "";
    }
    
    


}
