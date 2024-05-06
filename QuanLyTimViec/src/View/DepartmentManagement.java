package View;

import Process.Department;
import Process.DepartmentDao;
import Process.MessageDialog;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class DepartmentManagement extends javax.swing.JFrame {

    /**
     * Creates new form DepartmentManage
     */
    private int maPhong;
    private String tenPhong;
    private DefaultTableModel model;

    public DepartmentManagement() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        model = (DefaultTableModel) tblDEPARTMENT.getModel();
        LoadData();
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
        tblDEPARTMENT = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDlt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Departments List");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        tblDEPARTMENT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDEPARTMENT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        tblDEPARTMENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDEPARTMENTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDEPARTMENT);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 75, 550, 284));

        jButton3.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jButton3.setText("See Department");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        btnAdd.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        btnAdd.setText("Add Department");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        btnDlt.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        btnDlt.setText("Delete Department");
        btnDlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDltActionPerformed(evt);
            }
        });
        getContentPane().add(btnDlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, -1));

        jButton1.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/profilebg2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDEPARTMENTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDEPARTMENTMouseClicked
        // TODO add your handling code here:
        int row = tblDEPARTMENT.getSelectedRow();

        if (row >= 0) {
            int id = (int) tblDEPARTMENT.getValueAt(row, 0);
            maPhong = id;
            DepartmentDao dao = new DepartmentDao();
            Department d = new Department();

            try {
                d = dao.findByID(id);
            } catch (Exception e) {
                MessageDialog.showErrorDialog(this, e.getMessage(), "Error");
            }

            if (d != null) {
                tenPhong = d.getDEPARTMENTNAME();
            }
        }
    }//GEN-LAST:event_tblDEPARTMENTMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        PositionManagement pm = new PositionManagement(maPhong);
        pm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddDepartment ad = new AddDepartment();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltActionPerformed
        // TODO add your handling code here:
        try {
            DepartmentDao dao = new DepartmentDao();
            int choose = MessageDialog.showConfirmDialog(this, "Do you sure want to delete department?", "Confirm");
            if (choose == JOptionPane.YES_OPTION) {
                if (dao.delete(tenPhong)) {
                    MessageDialog.showMessageDialog(this, "Deleted successfully!", "Notification");
                    LoadData();
                } else {
                    MessageDialog.showConfirmDialog(this, "Delete successfully!", "Notification");
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnDltActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CompanyFrame cf = new CompanyFrame();
        cf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDlt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDEPARTMENT;
    // End of variables declaration//GEN-END:variables

    private void LoadData() {
        try {
            DepartmentDao dao = new DepartmentDao();
            List<Department> list = dao.findByAccountID();
            model.setRowCount(0);
            for (Department x : list) {
                model.addRow(new Object[]{
                    x.getDEPARTMENTNO(), x.getDEPARTMENTNAME()});
            }
            model.fireTableDataChanged();
            tblDEPARTMENT.setModel(model);
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, e.getMessage(), "Error");
        }
    }
}