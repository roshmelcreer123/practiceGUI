/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.roshmelguitutorial;

import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author roshmelcreer
 */
public class AddNewJob extends javax.swing.JFrame {

    ArrayList<Job> jobs;
    
    /**
     * Creates new form AddNewJob
     */
    public AddNewJob() {
        initComponents();
        jobs = new ArrayList<Job>();
        populateArrayList();
    }
    
    public void populateArrayList(){
    
        try{
            FileInputStream file = new FileInputStream("Jobs.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile = false;
            
            while(!endOfFile){
            
                try{
                    jobs.add((Job)inputFile.readObject());
                }
                catch(EOFException e){
                    endOfFile = true;
                }
                catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
                
            }
            
            inputFile.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void saveJobsToFile(){
        
        try{
            FileOutputStream file = new FileOutputStream("Jobs.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for(int i = 0; i < jobs.size(); i++){
                
                outputFile.writeObject(jobs.get(i));
            }
            
            outputFile.close();
            
            JOptionPane.showMessageDialog(null, "Successfully saved!");
            this.dispose();
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        createJob = new javax.swing.JLabel();
        nameJobLabel = new javax.swing.JLabel();
        jobName = new javax.swing.JTextField();
        salaryJobLabel = new javax.swing.JLabel();
        salaryJob = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Job");

        createJob.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        createJob.setText("Create a new job by entering the data below");

        nameJobLabel.setText("Name of the Job:");

        jobName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobNameActionPerformed(evt);
            }
        });

        salaryJobLabel.setText("Salary for this Job:");

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salaryJobLabel)
                    .addComponent(nameJobLabel))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salaryJob, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobName, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(createJob)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(138, 138, 138))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(createJob)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJobLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryJobLabel)
                    .addComponent(salaryJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobNameActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        if(jobName.getText().isEmpty() || salaryJob.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(null, "Please enter all fields");
        }
        
        else{
            String name = jobName.getText().trim();
            String salary = salaryJob.getText().trim();
            
            Job job = new Job(Double.parseDouble(salary), name);
            
            jobs.add(job);
            
            saveJobsToFile();
            
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createJob;
    private javax.swing.JTextField jobName;
    private javax.swing.JLabel nameJobLabel;
    private javax.swing.JTextField salaryJob;
    private javax.swing.JLabel salaryJobLabel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
