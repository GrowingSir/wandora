/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 *
 * Copyright (C) 2004-2015 Wandora Team
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
 * VariantNameEditor.java
 *
 * Created on 26.4.2011, 17:53:33
 */



package org.wandora.application.gui;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.ListModel;
import org.wandora.application.Wandora;
import org.wandora.application.gui.simple.*;
import org.wandora.topicmap.Locator;
import org.wandora.topicmap.Topic;
import org.wandora.topicmap.TopicMap;
import org.wandora.topicmap.TopicMapException;
import org.wandora.topicmap.XTMPSI;


/**
 *
 * @author akivela
 */
public class VariantNameEditor extends javax.swing.JPanel {

    private JDialog myDialog = null;
    private boolean wasAccepted = false;
    private ArrayList<Topic> scopeTopics = new ArrayList<Topic>();
    private Wandora wandora = null;
    private static ArrayList<Locator> lastScopeSubjects = new ArrayList<Locator>();


    /** Creates new form VariantNameEditor */
    public VariantNameEditor(Wandora w) {
        wandora = w;
        initComponents();
    }

    
    public void initialize(Set<Topic> scope, String variantString) {
        if(variantString != null) variantTextField.setText(variantString);
        else variantTextField.setText("");
        scopeTopics.addAll(scope);
        wasAccepted = false;
    }


    public void openEditor(String title) {
        wandora = Wandora.getWandora();
        
        myDialog = new JDialog(wandora, true);
        myDialog.add(this);
        myDialog.setSize(800,300);
        myDialog.setTitle(title);
        wandora.centerWindow(myDialog);

        myDialog.setVisible(true);
    }


    // -----


    public boolean wasAccepted() {
        return wasAccepted;
    }

    public String getVariantString() {
        return variantTextField.getText();
    }

    public Set<Topic> getVariantScope() {
        LinkedHashSet<Topic> set =  new LinkedHashSet();
        set.addAll(scopeTopics);
        return set;
    }


    private void setScope(String[] scopeLocators) {
        TopicMap tm = Wandora.getWandora().getTopicMap();
        Topic t;
        for(String l : scopeLocators) {
            try {
                if(l != null) {
                    t = tm.getTopic(l);
                    if(t != null && !t.isRemoved()) {
                        scopeTopics.add(t);
                    }
                }
            } 
            catch (TopicMapException ex) {
                Logger.getLogger(VariantNameEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        scopeTopicList.setModel(new VariantScopeListModel());
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        innerPanel = new javax.swing.JPanel();
        nameLabel = new SimpleLabel();
        variantTextField = new SimpleField();
        scopeLabel = new SimpleLabel();
        scopeTopicScrollPane = new SimpleScrollPane();
        scopeTopicList = new javax.swing.JList();
        scopeButtonPanel = new javax.swing.JPanel();
        addScopeTopicButton = new SimpleButton();
        removeScopeTopicButton = new SimpleButton();
        addEnglishDisplayButton = new SimpleButton();
        addLangndepDisplayButton = new SimpleButton();
        addSameAsPreviousButton = new SimpleButton();
        buttonPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        innerPanel.setLayout(new java.awt.GridBagLayout());

        nameLabel.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 4);
        innerPanel.add(nameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        innerPanel.add(variantTextField, gridBagConstraints);

        scopeLabel.setText("Scope");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        innerPanel.add(scopeLabel, gridBagConstraints);

        scopeTopicScrollPane.setMinimumSize(new java.awt.Dimension(23, 130));

        scopeTopicList.setModel(new VariantScopeListModel());
        scopeTopicScrollPane.setViewportView(scopeTopicList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        innerPanel.add(scopeTopicScrollPane, gridBagConstraints);

        scopeButtonPanel.setLayout(new java.awt.GridBagLayout());

        addScopeTopicButton.setText("Add scope topic...");
        addScopeTopicButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        addScopeTopicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScopeTopicButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        scopeButtonPanel.add(addScopeTopicButton, gridBagConstraints);

        removeScopeTopicButton.setText("Remove selected scope topics");
        removeScopeTopicButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        removeScopeTopicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeScopeTopicButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        scopeButtonPanel.add(removeScopeTopicButton, gridBagConstraints);

        addEnglishDisplayButton.setText("Set English display scope");
        addEnglishDisplayButton.setActionCommand("Set English display scope");
        addEnglishDisplayButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        addEnglishDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnglishDisplayButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        scopeButtonPanel.add(addEnglishDisplayButton, gridBagConstraints);

        addLangndepDisplayButton.setText("Set lang independent display scope");
        addLangndepDisplayButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        addLangndepDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLangndepDisplayButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        scopeButtonPanel.add(addLangndepDisplayButton, gridBagConstraints);

        addSameAsPreviousButton.setText("Set previous scope topics");
        addSameAsPreviousButton.setActionCommand("Add previous scope topics");
        addSameAsPreviousButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        addSameAsPreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSameAsPreviousButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        scopeButtonPanel.add(addSameAsPreviousButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        innerPanel.add(scopeButtonPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(innerPanel, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(jPanel3, gridBagConstraints);

        okButton.setText("OK");
        okButton.setMargin(new java.awt.Insets(2, 24, 2, 24));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        buttonPanel.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(buttonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents



    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        wasAccepted = false;
        if(myDialog != null) myDialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if(scopeTopics != null && !scopeTopics.isEmpty()) {
            lastScopeSubjects = new ArrayList<Locator>();
            for(Topic t : scopeTopics) {
                try {
                    if(t != null && !t.isRemoved()) {
                        lastScopeSubjects.add(t.getOneSubjectIdentifier());
                    }
                } 
                catch (TopicMapException ex) {
                    Logger.getLogger(VariantNameEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        wasAccepted = true;
        if(myDialog != null) myDialog.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void addEnglishDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnglishDisplayButtonActionPerformed
        setScope( new String[] {
                XTMPSI.DISPLAY,
                XTMPSI.getLang("en")
            }
        );
    }//GEN-LAST:event_addEnglishDisplayButtonActionPerformed

    private void addSameAsPreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSameAsPreviousButtonActionPerformed
        if(lastScopeSubjects != null && !lastScopeSubjects.isEmpty()) {
            TopicMap tm = Wandora.getWandora().getTopicMap();
            Topic t;
            for(Locator l : lastScopeSubjects) {
                try {
                    t = tm.getTopic(l);
                    if(t != null && !t.isRemoved()) {
                        scopeTopics.add(t);
                    }
                } 
                catch (TopicMapException ex) {
                    Logger.getLogger(VariantNameEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            scopeTopicList.setModel(new VariantScopeListModel());
        }
    }//GEN-LAST:event_addSameAsPreviousButtonActionPerformed

    private void removeScopeTopicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeScopeTopicButtonActionPerformed
        try {
            int[] selection = scopeTopicList.getSelectedIndices();
            ArrayList<Topic> removeScopeTopics = new ArrayList();
            for(int i=0; i<selection.length; i++) {
                removeScopeTopics.add(scopeTopics.get(selection[i]));
            }
            scopeTopics.removeAll(removeScopeTopics);
            scopeTopicList.setModel(new VariantScopeListModel());
        }
        catch(Exception e) {
            Logger.getLogger(VariantNameEditor.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_removeScopeTopicButtonActionPerformed

    private void addScopeTopicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addScopeTopicButtonActionPerformed
        try {
            Topic addedScope = wandora.showTopicFinder("Select variant scope topic...");
            if(addedScope != null) {
                scopeTopics.add(addedScope);
                scopeTopicList.setModel(new VariantScopeListModel());
            }
        }
        catch(Exception e) {
            Logger.getLogger(VariantNameEditor.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_addScopeTopicButtonActionPerformed

    private void addLangndepDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLangndepDisplayButtonActionPerformed
        setScope( new String[] {
                XTMPSI.DISPLAY,
                XTMPSI.LANG_INDEPENDENT
            }
        );
    }//GEN-LAST:event_addLangndepDisplayButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEnglishDisplayButton;
    private javax.swing.JButton addLangndepDisplayButton;
    private javax.swing.JButton addSameAsPreviousButton;
    private javax.swing.JButton addScopeTopicButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel innerPanel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeScopeTopicButton;
    private javax.swing.JPanel scopeButtonPanel;
    private javax.swing.JLabel scopeLabel;
    private javax.swing.JList scopeTopicList;
    private javax.swing.JScrollPane scopeTopicScrollPane;
    private javax.swing.JTextField variantTextField;
    // End of variables declaration//GEN-END:variables





    private class VariantScopeListModel extends DefaultListModel implements ListModel {

        @Override
        public int getSize() {
            if(scopeTopics != null) {
                return scopeTopics.size();
            }
            else {
                return 0;
            }
        }

        
        @Override
        public Object getElementAt(int index) {
            if(scopeTopics != null) {
                if(index >= 0 && index < scopeTopics.size()) {
                    return scopeTopics.get(index);
                }
            }
            return null;
        }

    }

}
