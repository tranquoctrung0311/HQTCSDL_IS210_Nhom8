package View;

import Process.MessageDialog;
import Process.Register;
import Process.RegisterDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ListApplicantRegister extends javax.swing.JFrame {

    /**
     * Creates new form ListApplicantRegister
     */
    private DefaultTableModel model;
    private int maLich, maUngVien;

    public ListApplicantRegister(int interviewscheduleno) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

        model = (DefaultTableModel) tblREGISTER.getModel();
        maLich = interviewscheduleno;
        LoadData(maLich);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblREGISTER = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Candidate List");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        tblREGISTER.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblREGISTER.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Interview Position"
            }
        ));
        tblREGISTER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblREGISTERMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblREGISTER);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 560, 275));

        jButton1.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jButton1.setText("Confirm Interview Completed");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        jButton2.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jButton2.setText("Absent");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jButton3.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/profilebg2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -290, 640, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblREGISTERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblREGISTERMouseClicked
        // TODO add your handling code here:
        int row = tblREGISTER.getSelectedRow();

        if (row >= 0) {
            int id = (int) tblREGISTER.getValueAt(row, 0);
            maUngVien = id;
        }
    }//GEN-LAST:event_tblREGISTERMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            RegisterDao dao = new RegisterDao();
            if (dao.confirmComplete(maUngVien, maLich)) {
                MessageDialog.showMessageDialog(this, "Confirmed successfully!", "Notification");
            } else {
                MessageDialog.showConfirmDialog(this, "Confirm unsuccessfully!", "Notification");
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, e.getMessage(), "Error");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            RegisterDao dao = new RegisterDao();
            if (dao.confirmNotEngaged(maUngVien, maLich)) {
                MessageDialog.showMessageDialog(this, "Confirmed successfully!", "Notification");
            } else {
                MessageDialog.showConfirmDialog(this, "Confirme unsuccessfully!", "Notification");
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, e.getMessage(), "Error");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ListInterviewSchedule lis = new ListInterviewSchedule();
        lis.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblREGISTER;
    // End of variables declaration//GEN-END:variables

    private void LoadData(int maLich) {
        try {
            RegisterDao dao = new RegisterDao();
            List<Register> list = dao.ListRegister(maLich);
            model.setRowCount(0);
            for (Register x : list) {
                model.addRow(new Object[]{
                    x.getAPPLICANTNO(), x.getAPPLICANTNAME(), x.getPOSITIONNAME()});
            }
            model.fireTableDataChanged();
            tblREGISTER.setModel(model);
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, e.getMessage(), "Error");
        }
    }
}
