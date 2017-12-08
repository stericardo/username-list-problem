/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenprogramming.demo.application;

import com.stevenprogramming.demo.config.SpringConfiguration;
import com.stevenprogramming.demo.constants.DemoConstants;
import com.stevenprogramming.demo.services.UserNameService;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author steven.mendez
 * @since Dec 07 2017
 * @version 1.0
 */
public class Window extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(Window.class.getName());
    private final static String NEW_LINE = "\n";
    private UserNameService userNameService;

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        init();
    }

    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        userNameService = context.getBean(UserNameService.class);
        Set<String> defaultKeysRestricted = new HashSet<>();
        defaultKeysRestricted.add("Cannabis");
        defaultKeysRestricted.add("Abuse");
        defaultKeysRestricted.add("Crack");
        defaultKeysRestricted.add("Damn");
        defaultKeysRestricted.add("Drunk");
        defaultKeysRestricted.add("Drass");
        userNameService.fillRestrictedWord(defaultKeysRestricted);
        defaultKeysRestricted = userNameService.getRestrictedWords();
        if (!defaultKeysRestricted.isEmpty()) {
            fillTextArea(defaultKeysRestricted, jTextAreaRestrictedList);
        }

    }

    public void fillTextArea(Set<String> elements, JTextArea jTextArea) {
        jTextArea.setText("");
        if (null != elements) {
            for (String element : elements) {
                jTextArea.append(element.concat(NEW_LINE));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaUserNameList = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaRestrictedList = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaSuggestions = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAddUserName = new javax.swing.JTextField();
        jTextFieldAddRestricted = new javax.swing.JTextField();
        jButtonAddUsername = new javax.swing.JButton();
        jButtonAddRestricted = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaUserNameList.setColumns(20);
        jTextAreaUserNameList.setRows(5);
        jScrollPane1.setViewportView(jTextAreaUserNameList);

        jLabel1.setText("Username List");

        jLabel2.setText("Restricted List");

        jTextAreaRestrictedList.setColumns(20);
        jTextAreaRestrictedList.setRows(5);
        jScrollPane2.setViewportView(jTextAreaRestrictedList);

        jLabel3.setText("Suggestions");

        jTextAreaSuggestions.setColumns(20);
        jTextAreaSuggestions.setRows(5);
        jScrollPane3.setViewportView(jTextAreaSuggestions);

        jLabel4.setText("Add user name");

        jLabel5.setText("Add restricted word");

        jButtonAddUsername.setText("Add");
        jButtonAddUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUsernameActionPerformed(evt);
            }
        });

        jButtonAddRestricted.setText("Add");
        jButtonAddRestricted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRestrictedActionPerformed(evt);
            }
        });

        jLabelError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldAddUserName)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel4))
                    .addComponent(jButtonAddUsername))
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAddRestricted)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldAddRestricted)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelError)
                        .addGap(149, 149, 149))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabelError))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddRestricted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddUsername)
                    .addComponent(jButtonAddRestricted))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUsernameActionPerformed
        fillTextArea(null, jTextAreaSuggestions);
        if (jTextFieldAddUserName.getText().equals("")) {
            jLabelError.setText(DemoConstants.ENTER_VALUE);
        } else {
            userNameService.saveUserName(jTextFieldAddUserName.getText());
            Set<String> userNameList = userNameService.getUserNameList();
            if (!userNameList.isEmpty()) {
                fillTextArea(userNameList, jTextAreaUserNameList);
            }
            String error = userNameService.getError();
            jLabelError.setText(error);
            if (error.equals(DemoConstants.INVALID_USER) || error.equals(DemoConstants.INVALID_LENGTH) || error.equals(DemoConstants.ALREADY_EXIST)) {
                Set<String> userNameSuggestionList = userNameService.generateSuggestionValues(jTextFieldAddUserName.getText());
                fillTextArea(userNameSuggestionList, jTextAreaSuggestions);
            }
            jTextFieldAddUserName.setText("");
        }

    }//GEN-LAST:event_jButtonAddUsernameActionPerformed

    private void jButtonAddRestrictedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRestrictedActionPerformed
        userNameService.addRestrictedWord(jTextFieldAddRestricted.getText());
        Set<String> restrictedList = userNameService.getRestrictedWords();
        if (!restrictedList.isEmpty()) {
            fillTextArea(restrictedList, jTextAreaRestrictedList);
        }
        jLabelError.setText(userNameService.getError());
        jTextFieldAddRestricted.setText("");
    }//GEN-LAST:event_jButtonAddRestrictedActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddRestricted;
    private javax.swing.JButton jButtonAddUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaRestrictedList;
    private javax.swing.JTextArea jTextAreaSuggestions;
    private javax.swing.JTextArea jTextAreaUserNameList;
    private javax.swing.JTextField jTextFieldAddRestricted;
    private javax.swing.JTextField jTextFieldAddUserName;
    // End of variables declaration//GEN-END:variables
}