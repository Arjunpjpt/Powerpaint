/*
 * TCSS 305 - Power Paint
 */
package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import tools.AbstractTools;
import tools.EllipseTool;
import tools.EraserTool;
import tools.LineTool;
import tools.PencilTool;
import tools.RectangleTool;



/**
 * This is a main class to setup GUI appearance and function for the power paint.
 * @author Arjun Prajapati
 * @version November 11, 2017
 */
public class PowerPaintGui {
    /** Major tick spacing for JSlider. */
    public static final int MAJOR_SPACING = 5;
    
    /** Minor tick spacing for JSlider. */
    public static final int MINOR_SPACING = 1;
    
    /** the default value of the slider. */
    public static final int SLIDER = 10;
    
    /** directory for the UW image. */
    public static final String ICON_DIRECTORY = "images/uw.png";
    
    /** to setup UW icon. */
    public static final Icon ICON = new ImageIcon(ICON_DIRECTORY);
    
    /** window frame. */
    private JFrame myFrame;
    
    /** setup the menu bar. */
    private JMenuBar myMenuBar;
    
    /** Tool bar for the window. */
    private JToolBar myToolBar;
    
    /** the draw panel of the window. */
    private CenterPanel myCenterPanel;
    
    
    /** clear button. */
    private JMenuItem myCLearButton;

    /** the clear button in the option menu. */
    private List<ToolAction> myToolActions;
    
    
    /**
     * constructor to call the method.
     */
    public PowerPaintGui() {
        createAndShowGUI();
        
    }
    
    /**
     * This method to setup GUI appearance.
     */
    public void createAndShowGUI() {
        
        // setup frame
        myFrame = new JFrame("Assignment 5");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Image im = Toolkit.getDefaultToolkit().getImage(ICON_DIRECTORY);
        myFrame.setIconImage(im);
        
        //setup tool action
        myToolActions = new ArrayList<ToolAction>();

        myToolActions.add(new ToolAction("Pencil", new ImageIcon("./images/pencil.gif"),
                                             new PencilTool()));
        myToolActions.add(new ToolAction("Line", new ImageIcon("./images/line.gif"),
                                         new LineTool()));
        myToolActions.add(new ToolAction("Rectangle", new ImageIcon("./images/rectangle.gif"),
                                         new RectangleTool()));
        myToolActions.add(new ToolAction("Ellipse", new ImageIcon("./images/ellipse.gif"),
                                         new EllipseTool()));
        myToolActions.add(new ToolAction("Eraser", new ImageIcon("./images/eraser.gif"),
                                         new EraserTool()));
//        myCenterPanel.setTool(new LineTool());
        
        
        // set up the drawing panel
        myCenterPanel = new CenterPanel(this);
        myMenuBar = new JMenuBar();
        myMenuBar.add(buildOptionMenu());
        myMenuBar.add(buildToolMenu());
        myMenuBar.add(buildHelpMenu());
        // to build tool bar
        myToolBar = new JToolBar();
        buildToolBar();
        
       // setup menubar and tools
        myFrame.setJMenuBar(myMenuBar);
        myFrame.add(myCenterPanel, BorderLayout.CENTER);
        myFrame.add(myToolBar, BorderLayout.SOUTH);

        myFrame.pack();
        myFrame.setVisible(true);
    }
    
   
    
    /**
     * This method is to build option menu.
     * @return JMenu
     */
    private JMenu buildOptionMenu() {
        
        final JMenu optionMenu = new JMenu("Option");
        optionMenu.setMnemonic(KeyEvent.VK_O);
        optionMenu.add(buildThicknessMenu());
        
        final JMenuItem primaryColor = new JMenuItem("Primary Color...");
        final JMenuItem secondaryColor = new JMenuItem("Secondary Color...");
        primaryColor.setMnemonic(KeyEvent.VK_P);
        secondaryColor.setMnemonic(KeyEvent.VK_S);
        primaryColorMenu(primaryColor);
        secondaryColorMenu(secondaryColor);

        myCLearButton = new JMenuItem("Clear");
        myCLearButton.setMnemonic(KeyEvent.VK_C);
        myCLearButton.setEnabled(false);
        myCLearButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCLearButton.setEnabled(false);
                myCenterPanel.clear();
                myCenterPanel.repaint();
            }
            
        });
        
        // add them one by one to the option menu
//        option.add(thicknessButton);
        optionMenu.addSeparator();
        optionMenu.add(primaryColor);
        optionMenu.add(secondaryColor);
        optionMenu.addSeparator();
        optionMenu.add(myCLearButton);
//        myMenuBar.add(option);
        return optionMenu;
    }
    
    /**
     * method to setup primary color.
     * 
     * @param theColor 
     */
    private void primaryColorMenu(final JMenuItem theColor) {
        // menu icon for primary color
        final ColorIcon iconColor;

        iconColor = new ColorIcon(ColorIcon.getPrimaryUWColor());
        myCenterPanel.setPrimaryColor(ColorIcon.getPrimaryUWColor());
        theColor.setIcon(iconColor);
        theColor.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                
                final Color result = JColorChooser.showDialog(null, null, null);
                if (!(result == null)) {
                    iconColor.setColor(result);
                    myCenterPanel.setPrimaryColor(result);
                }
                }
            });

        
        
    }
     
    /**
     * method to setup primary color.
     * 
     * @param theColorMenu 
     */
    private void secondaryColorMenu(final JMenuItem theColorMenu) {
        // menu icon for secondary color
        final ColorIcon iconColor;
        iconColor = new ColorIcon(ColorIcon.getSecondaryUWColor());
        myCenterPanel.setSecondaryColor(ColorIcon.getSecondaryUWColor());
        theColorMenu.setIcon(iconColor);
        theColorMenu.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    final Color result = JColorChooser.showDialog(null, null, null);
                    if (!(result == null)) {
                        iconColor.setColor(result);
                        myCenterPanel.setSecondaryColor(result);
                    }
                }
        });
            
    }
     
    
    /**
     * Building the JSlider.
     * @return JMenu , return the JSlider for the JMenu.
     */
    public JMenu buildThicknessMenu() {
        final JMenu thicknessMenu = new JMenu("Thickness");
        thicknessMenu.setMnemonic(KeyEvent.VK_T);
        final JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL,
                                                    0, 20, SLIDER);
        thicknessMenu.add(thicknessSlider);
        thicknessSlider.setMajorTickSpacing(MAJOR_SPACING);
        thicknessSlider.setMinorTickSpacing(MINOR_SPACING);
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.setPaintTicks(true);
        
        thicknessSlider.addChangeListener(new ChangeListener() {
            @Override

            public void stateChanged(final ChangeEvent theEvent) {
                final int thickness = thicknessSlider.getValue();
//                System.out.println(thickness);
                myCenterPanel.setThickness(thickness);
            }
        });
        return thicknessMenu;
        
    }

    /**
     * method to setup the Tool menu.
     * @return JMenu
     */
    private JMenu buildToolMenu() {
        final JMenu toolMenu = new JMenu("Tool");
        toolMenu.setMnemonic(KeyEvent.VK_T);
        
        final ButtonGroup btngrp = new ButtonGroup();

        for (final ToolAction ca : myToolActions) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(ca);
            btngrp.add(btn);
            toolMenu.add(btn);
            if (btn.getText().equals("Line")) {
                btn.setSelected(true);
            }

        }
       
        return toolMenu;
    }


    /**
     * method to setup the help menu.
     * @return JMenu
     */
    private JMenu buildHelpMenu() {
        
        // create a menu and a menu item object
        final JMenu helpMenu = new JMenu("Help");  
        helpMenu.setMnemonic(KeyEvent.VK_H);
        
        final JMenuItem aboutButton = new JMenuItem("About...");
        aboutButton.setMnemonic(KeyEvent.VK_A);
        helpMenu.add(aboutButton);
        
        
        aboutButton.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, "Arjun Prajapati\nAutumn 2017\nTCSS "
                            + "305 Assignment 5", "About",
                                             JOptionPane.INFORMATION_MESSAGE, ICON);
            }
        });
        
        return helpMenu;
    }

    /**
     * method to setup the tool bar.
     */
    private void buildToolBar() {
//        final JToolBar toolBar = new JToolBar();
       
        

        final ButtonGroup btngrp = new ButtonGroup();
        for (final ToolAction ca : myToolActions) {
            final JToggleButton tb = new JToggleButton(ca);
            
            btngrp.add(tb);
            myToolBar.add(tb);
        }
    }
    
    /**
     * to Enable the clear button.
     * @param theIsEnable enable or not.
     */
    public void setEnable(final boolean theIsEnable) {
        myCLearButton.setEnabled(theIsEnable);
    }
    
    /**
     * class for installing tools in tool bar and menu.
     * @author Arjun Prajapati
     * @version November 16, 2017
     */
    private class ToolAction extends AbstractAction {
        
        
   
        /**
         * default serial number.
         */
        private static final long serialVersionUID = -1917281926039033590L;
        /**
         * Selected tool.
         */
        private AbstractTools myTool;
        
        /**String for eraser. */
        private String myEraser = "Eraser";

        /**
         * Constructor to initialize the field.
         * @param theName ,Name of a tool
         * @param theIcon , icon directory
         * @param theTools , selected tool
         */
        ToolAction(final String theName, final Icon theIcon, final AbstractTools theTools) {
            super(theName);
            myTool = theTools;
            putValue(Action.SMALL_ICON, theIcon);
            
            // Here is how to assign a larger icon to the tool bar.
            final ImageIcon icon = (ImageIcon) theIcon;
            final Image largeImage =
                icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
            final ImageIcon largeIcon = new ImageIcon(largeImage);
            putValue(Action.LARGE_ICON_KEY, largeIcon);
            
            // set a mnemonic on the first character of the name
            putValue(Action.MNEMONIC_KEY,
                     KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));
            if (theName.equals(myEraser)) {
                putValue(Action.MNEMONIC_KEY,
                         KeyEvent.getExtendedKeyCodeForChar(theName.charAt(2)));
            }
            
            // tool tips
            putValue(Action.SHORT_DESCRIPTION, theName + " tool");
            
            // coordinate button selection
            putValue(Action.SELECTED_KEY, true);
            
            myTool = theTools;
        }
        
        @Override
      public void actionPerformed(final ActionEvent theActionEvent) {
            myCenterPanel.setTool(myTool);
          
        }
        
    }
}





