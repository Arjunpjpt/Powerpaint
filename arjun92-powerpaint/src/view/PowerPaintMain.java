/*
 * TCSS 305 - Power Paint
 */
package view;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;





//import examples.ColorChooserMenuExample;

/**
 * This is a main class to call the GUI class PowerPaintGui.
 * @author Arjun Prajapati
 * @version November 7, 2017
 *
 */
public final class PowerPaintMain {
   /**
    * 
    */
    private PowerPaintMain() {
    //
    }
    /**
     * Creates a JFrame to demonstrate this panel.
     * It is OK, even typical to include a main method 
     * in the same class file as a GUI for testing purposes. 
     * 
     * @param theArgs Command line arguments, ignored.
     */
    public static void main(final String[] theArgs) {
        
        /* 
         * Use an appropriate Look and Feel 
         * https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         * 
         */
        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            private PowerPaintGui myGui = new PowerPaintGui();
            public void run() {
                new PowerPaintGui();
            }
        });
    }
   
    


}
