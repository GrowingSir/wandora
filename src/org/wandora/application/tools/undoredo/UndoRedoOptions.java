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
 */


package org.wandora.application.tools.undoredo;

import java.util.ArrayList;
import javax.swing.JDialog;
import org.wandora.application.Wandora;
import org.wandora.application.gui.UIBox;
import org.wandora.application.gui.WandoraOptionPane;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.table.OperationTable;
import org.wandora.topicmap.layered.LayerStack;
import org.wandora.topicmap.undowrapper.UndoOperation;

/**
 *
 * @author akivela
 */


public class UndoRedoOptions extends javax.swing.JPanel {


	private static final long serialVersionUID = 1L;
	
	private Wandora wandora = null;
    private JDialog dialog = null;
    
    
    /**
     * Creates new form UndoRedoOptions
     */
    public UndoRedoOptions() {
        initComponents();
    }

    
    public void open(Wandora w) {
        wandora = w;
        initializeOperationTable();
        dialog = new JDialog(w, true);
        dialog.setSize(800, 400);
        dialog.add(this);
        dialog.setTitle("Undo buffer and options");
        UIBox.centerWindow(dialog, w);
        dialog.setVisible(true);
    }
    
    
    
    
    private void initializeOperationTable() {
        if(wandora == null) return;
        LayerStack ltm = wandora.getTopicMap();
        ArrayList<UndoOperation> ops = ltm.getUndoOperations();
        ((OperationTable) operationTable).initialize(ops);
        if(ops == null || ops.isEmpty()) {
            tableScrollPane.setVisible(false);
            noopsLabel.setVisible(true);
        }
        else {
            tableScrollPane.setVisible(true);
            noopsLabel.setVisible(false);
        }
    }
    
    
    // -------------------------------------------------------------------------
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        operationTable = new OperationTable();
        noopsLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        undoButtonPanel = new javax.swing.JPanel();
        undoButton = new SimpleButton();
        redoButton = new SimpleButton();
        buttonFillerPanel = new javax.swing.JPanel();
        rightButtonPanel = new javax.swing.JPanel();
        clearUndoBuffers = new SimpleButton();
        closeButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        headerPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(headerPanel, gridBagConstraints);

        tablePanel.setLayout(new java.awt.GridBagLayout());

        operationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableScrollPane.setViewportView(operationTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        tablePanel.add(tableScrollPane, gridBagConstraints);

        noopsLabel.setText("No undo operations available");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        tablePanel.add(noopsLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(tablePanel, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        undoButtonPanel.setLayout(new java.awt.GridBagLayout());

        undoButton.setText("Undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        undoButtonPanel.add(undoButton, gridBagConstraints);

        redoButton.setText("Redo");
        redoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });
        undoButtonPanel.add(redoButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        buttonPanel.add(undoButtonPanel, gridBagConstraints);

        buttonFillerPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(buttonFillerPanel, gridBagConstraints);

        rightButtonPanel.setLayout(new java.awt.GridBagLayout());

        clearUndoBuffers.setText("Clear undo buffer");
        clearUndoBuffers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearUndoBuffersActionPerformed(evt);
            }
        });
        rightButtonPanel.add(clearUndoBuffers, new java.awt.GridBagConstraints());

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        rightButtonPanel.add(closeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        buttonPanel.add(rightButtonPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(buttonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        if(dialog != null) dialog.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void clearUndoBuffersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearUndoBuffersActionPerformed
        if(wandora != null) wandora.clearUndoBuffers();
        initializeOperationTable();
    }//GEN-LAST:event_clearUndoBuffersActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        if(wandora != null) {
            try {
                wandora.undo();
            }
            catch(Exception e) {
                //e.printStackTrace();
                WandoraOptionPane.showMessageDialog(wandora, e.getMessage(), "Undo exception");
            }
            wandora.doRefresh();
        }
        initializeOperationTable();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        if(wandora != null) {
            try {
                wandora.redo();
            }
            catch(Exception e) {
                //e.printStackTrace();
                WandoraOptionPane.showMessageDialog(wandora, e.getMessage(), "Redo exception");
            }
            wandora.doRefresh();
        }
        initializeOperationTable();
    }//GEN-LAST:event_redoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonFillerPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton clearUndoBuffers;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel noopsLabel;
    private javax.swing.JTable operationTable;
    private javax.swing.JButton redoButton;
    private javax.swing.JPanel rightButtonPanel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JButton undoButton;
    private javax.swing.JPanel undoButtonPanel;
    // End of variables declaration//GEN-END:variables
}
