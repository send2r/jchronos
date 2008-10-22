/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TodoPanel.java
 *
 * Created on Oct 14, 2008, 1:35:50 AM
 */

package org.jtodo.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.jdesktop.swingx.graphics.GraphicsUtilities;
import org.jdesktop.swingx.graphics.ShadowRenderer;

/**
 *
 * @author XR1CTSO
 */
public class TodoPanel extends JPanel {
BufferedImage shadow;

        private static int X_OFFSET = 5;
        private static int Y_OFFSET = 5;
        private static int SHADOW_SIZE = 5;
    /** Creates new form TodoPanel */
    public TodoPanel() {
        initComponents();
    }

    public void setCancelAction(ActionListener cancelActionListener){
        cancelButton.addActionListener(cancelActionListener);
    }
    public void setSaveAction(ActionListener saveActionListener){
        okButton.addActionListener(saveActionListener);
    }
        @Override
        protected void paintComponent(Graphics g) {
                int x = X_OFFSET;
                int y = Y_OFFSET;
                int w = getWidth() - 2 * X_OFFSET;
                int h = getHeight() - 2 * Y_OFFSET;
                int arc = 30;

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

                if (shadow != null) {
                        int xOffset = (shadow.getWidth() - w) / 2;
                        int yOffset = (shadow.getHeight() - h) / 2;
                        g2.drawImage(shadow, x - xOffset, y - yOffset, null);
                }

                // ////////////////////////////////////////////////////////////////
                // fill content
                g2.setColor(new Color(255, 255, 255, 220));
                g2.fillRoundRect(x, y, w, h, arc, arc);
                // ////////////////////////////////////////////////////////////////

                // ////////////////////////////////////////////////////////////////
                // draw border
                g2.setStroke(new BasicStroke(3f));
                g2.setColor(Color.BLACK);
                // g2.setColor(Color.GRAY);

                g2.drawRoundRect(x, y, w, h, arc, arc);
                // ////////////////////////////////////////////////////////////////

                g2.dispose();
        }

        @Override
        public void setBounds(int x, int y, int width, int height) {
                super.setBounds(x, y, width, height);

                int w = getWidth() - 2 * X_OFFSET;
                int h = getHeight() - 2 * Y_OFFSET;
                int arc = 30;

                shadow = GraphicsUtilities.createCompatibleTranslucentImage(w, h);
                Graphics2D g2 = shadow.createGraphics();
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, w, h, arc, arc);
                g2.dispose();

                ShadowRenderer renderer = new ShadowRenderer(SHADOW_SIZE, 0.5f,
                                Color.BLACK);
                shadow = renderer.createShadow(shadow);

        }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priorityComboBox = new javax.swing.JComboBox();
        categoryComboBox = new javax.swing.JComboBox();
        statusComboBox = new javax.swing.JComboBox();
        dueDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        startDatePicker = new org.jdesktop.swingx.JXDatePicker();
        subjectTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        spacerLabel = new javax.swing.JLabel();

        cancelButton.setText("Cancel");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Notes :");

        jLabel5.setText("Status :");

        jLabel4.setText("Category :");

        jLabel3.setText("Priority :");

        jLabel1.setText("Subject :");

        jLabel2.setText("Due By :");

        priorityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Urgent & Important", "Important but not Urgent", "Urgent but not Important", "Neither Urgent nor Important" }));

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Live", "WIP", "Done", "Cancelled" }));

        jLabel7.setText("Start By :");

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane1.setViewportView(notesTextArea);

        spacerLabel.setText("          ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(okButton))
                    .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dueDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(subjectTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spacerLabel))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(subjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spacerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dueDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox categoryComboBox;
    private org.jdesktop.swingx.JXDatePicker dueDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox priorityComboBox;
    private javax.swing.JLabel spacerLabel;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JTextField subjectTextField;
    // End of variables declaration//GEN-END:variables

}
