/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2016 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * 
 *
 * InputDialogWithHistory.java
 *
 * Created on 25. maaliskuuta 2005, 15:40
 */

package org.wandora.utils.swing;


import java.util.*;
import java.awt.*;
import org.wandora.utils.*;
import org.wandora.application.gui.simple.*;



/**
 *
 * @author  akivela
 */
public class InputDialogWithHistory extends javax.swing.JDialog {
    
    public static int HISTORYMAXSIZE = 40;
    public java.awt.Frame parent = null;
    public boolean accepted = true;
    
    public static Font buttonLabelFont = new Font("SansSerif", Font.PLAIN, 11);
    public static Font labelFont = new Font("SansSerif", Font.PLAIN, 12);
    
    
    /** Creates new form InputDialogWithHistory */
    public InputDialogWithHistory(java.awt.Frame parent, boolean modal, String label, String title) {
        super(parent, modal);
        initComponents();
        this.setTitle(title);
        this.label.setText(label);
        this.parent = parent;
        this.options.addItem("");
        centerWindow();
    }
    
    
    
    
    
    public String showDialog() {
        String sel = "";
        try {
            accepted = false;
            this.options.setSelectedIndex(0);
            centerWindow();
            this.setVisible(true);
            sel = (String) this.options.getSelectedItem();
            sel = Textbox.trimExtraSpaces(sel);
            if(accepted && sel.length() > 0) options.addItem(sel);
            if(this.options.getItemCount() > HISTORYMAXSIZE) this.options.removeItemAt(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return sel;
    }
    
    
    
    
    public void centerWindow() {
        if(parent != null) {
            this.setLocation(parent.getX()+parent.getWidth()/2-this.getWidth()/2,parent.getY()+parent.getHeight()/2-this.getHeight()/2);
        }
    }
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        label = new SimpleLabel();
        options = new SimpleComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        label.setFont(labelFont);
        label.setText("Input");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 4, 10);
        jPanel1.add(label, gridBagConstraints);

        options.setEditable(true);
        options.setFont(labelFont);
        options.setMinimumSize(new java.awt.Dimension(400, 20));
        options.setPreferredSize(new java.awt.Dimension(400, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(options, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel3, gridBagConstraints);

        okButton.setFont(buttonLabelFont);
        okButton.setText("OK");
        okButton.setMinimumSize(new java.awt.Dimension(80, 23));
        okButton.setPreferredSize(new java.awt.Dimension(80, 23));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel2.add(okButton, gridBagConstraints);

        cancelButton.setFont(buttonLabelFont);
        cancelButton.setText("Cancel");
        cancelButton.setMinimumSize(new java.awt.Dimension(80, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(80, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel2.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 8, 10);
        jPanel1.add(jPanel2, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        accepted = false;
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        accepted = true;
        this.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox options;
    // End of variables declaration//GEN-END:variables
    
}
