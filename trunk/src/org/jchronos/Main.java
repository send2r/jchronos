/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jchronos;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import org.jchronos.ui.TodoAppFrame;

/**
 *
 * @author XR1CTSO
 */
public class Main {

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               TodoAppFrame frame =  new TodoAppFrame("jChronos");
               Toolkit toolkit = Toolkit.getDefaultToolkit();
               Dimension screenSize = toolkit.getScreenSize();

                int x = (screenSize.width - frame.getWidth()) / 2;
                int y = (screenSize.height - frame.getHeight()) / 2;
                frame.setLocation(x, y);
               frame.setVisible(true);
            }
        });
    }
}
