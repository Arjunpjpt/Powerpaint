/*
 * TCSS 305 - Power Paint
 */
package tools;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * Tools to draw ellipse.
 * @author Arjun Prajapati
 * @version November 11, 2017
 */
public class RectangleTool extends AbstractTools {

    @Override
    public void draw(final Shape theShape,
                     final Point theStartPoint,
                     final MouseEvent theEvent) {
        

        ((Rectangle) theShape).setFrameFromDiagonal(theStartPoint, theEvent.getPoint());
        
    }

    @Override
    public Shape setNewShape(final  MouseEvent theEvent) {
        return new Rectangle();
    }

    @Override
    public String getDescription() {
        return "";
    }


}
