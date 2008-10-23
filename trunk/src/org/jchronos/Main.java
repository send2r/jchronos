/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jchronos;

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
                new TodoAppFrame("jChronos").setVisible(true);
            }
        });
    }
}
