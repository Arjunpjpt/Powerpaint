/*
 * TCSS 305 - Power Paint
 */

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

/**
 *  Method to setup the color icon.
 *  
 * @author Arjun Prajapati
 * @version November 11, 2017
 */
public class ColorIcon implements Icon {
    /** primary uw purple color. */
    public static final Color UW_PURPLE = Color.decode("#4B2E83");
    
    /** secondary UW gold color. */
    public static final Color UW_GOLD = Color.decode("#b7a57a");
    
    /** the height of the color icon. */
    public static final int HEIGHT = 14;
    
    /** the width of the color icon. */
    public static final int WIDTH = 14;

    /** to store the color value. */
    private Color myColor;
    
    /**
     * constructor to initialize the color value.
     * @param theColor , to initialize the color.
     */
    public ColorIcon(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * returns the primary UW Color.
     * @return Color
     */
    public static Color getPrimaryUWColor() {
        return UW_PURPLE;
    }
    
    /**
    * returns the Secondary UW Color.
    * @return Color
    */
    public static Color getSecondaryUWColor() {
        return UW_GOLD;
    }
    /**
     * method to return the color.
     * @return Color
     */
    public Color getColor() {
        return myColor;
    }
    
//    /**
//     * method returns default UW primary color.
//     * @return Color
//     */
//    public Color getPrimaryColor() {
//        return UW_PURPLE;
//    }
//    
//    /**
//     * method returns default UW secondary color.
//     * @return Color
//     */
//    public Color getSecondaryColor() {
//        return UW_GOLD;
//    }
    
    /**
     * Method to set the color.
     * @param theColor 
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }

    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphics
                          , final int theWidth, final int theHeight) {
        theGraphics.setColor(myColor);
        theGraphics.fillRect(theWidth, theHeight, WIDTH, HEIGHT);
        theGraphics.setColor(Color.BLACK);
        theGraphics.drawRect(theWidth, theHeight, WIDTH, HEIGHT);
        
    }

}
