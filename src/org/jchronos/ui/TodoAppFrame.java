/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TodoAppFrame.java
 *
 * Created on Oct 13, 2008, 9:47:13 PM
 */

package org.jchronos.ui;

/**
 *
 * @author ranjith
 */
public class TodoAppFrame extends javax.swing.JFrame {

    public TodoAppFrame(String title) {
        super(title);
        initComponents();
    }
    /** Creates new form TodoAppFrame */
    public TodoAppFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashBoardUIPanel1 = new org.jchronos.ui.DashBoardUIPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(dashBoardUIPanel1, java.awt.BorderLayout.CENTER);
        setSize(590,460);

        //pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jchronos.ui.DashBoardUIPanel dashBoardUIPanel1;
    // End of variables declaration//GEN-END:variables

}
