package sksmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    private Connection conn;
    private Statement stat;
    private ResultSet res;
    
    public Main() {
        initComponents();
        koneksi();
        tampilData();
    }
    
    private void koneksi(){
        try { 
            //Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sksmanager", "root", "12345");
            stat=conn.createStatement(); 
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e); 
        } 
    }
    
    private void tampilData(){
        DefaultTableModel isitabel = new DefaultTableModel();
        isitabel.addColumn("ID");
        isitabel.addColumn("NAMA");
        isitabel.addColumn("SKS");
        isitabel.addColumn("NILAI");
        isitabel.addColumn("STATUS");
        try{
            res = stat.executeQuery("SELECT * FROM semester");
            while(res.next()){
                isitabel.addRow(new Object[] {res.getString("id"),
                    res.getString("nama"),
                    res.getString("sks"),
                    res.getString("nilai"),
                    res.getString("status")});
            }
            jTable1.setModel(isitabel);
        }catch(SQLException e){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Tf_id = new javax.swing.JTextField();
        Tf_nama = new javax.swing.JTextField();
        Tf_sks = new javax.swing.JTextField();
        Tf_nilai = new javax.swing.JTextField();
        Tf_status = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Btn_save = new javax.swing.JButton();
        Btn_update = new javax.swing.JButton();
        Btn_delete = new javax.swing.JButton();
        Btn_reset = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Btn_select = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SKS MANAGER");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SKS MANAGER");

        jLabel2.setText("ID");

        jLabel3.setText("NAMA");

        jLabel4.setText("SKS");

        jLabel5.setText("NILAI");

        jLabel6.setText("STATUS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        Btn_save.setText("Save");
        Btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_saveActionPerformed(evt);
            }
        });

        Btn_update.setText("Update");
        Btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_updateActionPerformed(evt);
            }
        });

        Btn_delete.setText("Delete");
        Btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_deleteActionPerformed(evt);
            }
        });

        Btn_reset.setText("Reset");
        Btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_resetActionPerformed(evt);
            }
        });

        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        Btn_select.setText("Select");
        Btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_selectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Tf_status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(Tf_nilai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tf_sks))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Tf_id, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                        .addComponent(Tf_nama)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn_save)
                                    .addGap(18, 18, 18)
                                    .addComponent(Btn_update)
                                    .addGap(18, 18, 18)
                                    .addComponent(Btn_delete)
                                    .addGap(18, 18, 18)
                                    .addComponent(Btn_reset)
                                    .addGap(18, 18, 18)
                                    .addComponent(Btn_select))))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addComponent(jLabel7)
                .addGap(187, 187, 187))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tf_sks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tf_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_save)
                    .addComponent(Btn_update)
                    .addComponent(Btn_delete)
                    .addComponent(Btn_reset)
                    .addComponent(Btn_select))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_resetActionPerformed
        Tf_id.setText("");
        Tf_nama.setText("");
        Tf_sks.setText("");
        Tf_nilai.setText("");
        Tf_status.setText("");
    }//GEN-LAST:event_Btn_resetActionPerformed

    private void Btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_saveActionPerformed
        String id = Tf_id.getText();
        String nama = Tf_nama.getText();
        String sks = Tf_sks.getText();
        String nilai = Tf_nilai.getText();
        String status = Tf_status.getText();

        if (id.isEmpty() || nama.isEmpty() || sks.isEmpty() || nilai.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
        } else {
            try {
                String sql = "INSERT INTO semester (id, nama, sks, nilai, status) VALUES ('" 
                             + id + "', '" 
                             + nama + "', '" 
                             + sks + "', '" 
                             + nilai + "', '" 
                             + status + "')";
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
                tampilData(); // Refresh tabel setelah menambah data
                resetInputFields(); // Reset inputan
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menambahkan data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_Btn_saveActionPerformed

    private void Btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_updateActionPerformed
        String id = Tf_id.getText();
        String nama = Tf_nama.getText();
        String sks = Tf_sks.getText();
        String nilai = Tf_nilai.getText();
        String status = Tf_status.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID tidak boleh kosong untuk memperbarui data!");
        } else {
            try {
                String sql = "UPDATE semester SET nama = '" + nama 
                             + "', sks = '" + sks 
                             + "', nilai = '" + nilai 
                             + "', status = '" + status 
                             + "' WHERE id = '" + id + "'";
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
                tampilData(); // Refresh tabel setelah update
                resetInputFields(); // Reset inputan
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_Btn_updateActionPerformed

    private void Btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_deleteActionPerformed
        String id = Tf_id.getText();
    
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID tidak boleh kosong untuk menghapus data!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, 
                            "Apakah Anda yakin ingin menghapus data ini?", 
                            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String sql = "DELETE FROM semester WHERE id = '" + id + "'";
                    stat.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                    tampilData(); // Refresh tabel setelah delete
                    resetInputFields(); // Reset inputan
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_Btn_deleteActionPerformed

    private void Btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_selectActionPerformed
        int selectedRow = jTable1.getSelectedRow(); // Ambil baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Silakan pilih data di tabel terlebih dahulu!");
        } else {
            // Ambil data dari tabel berdasarkan indeks kolom
            String id = jTable1.getValueAt(selectedRow, 0).toString();
            String nama = jTable1.getValueAt(selectedRow, 1).toString();
            String sks = jTable1.getValueAt(selectedRow, 2).toString();
            String nilai = jTable1.getValueAt(selectedRow, 3).toString();
            String status = jTable1.getValueAt(selectedRow, 4).toString();

            // Set data ke text field
            Tf_id.setText(id);
            Tf_nama.setText(nama);
            Tf_sks.setText(sks);
            Tf_nilai.setText(nilai);
            Tf_status.setText(status);
        }
    }//GEN-LAST:event_Btn_selectActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void resetInputFields() {
        Tf_id.setText("");
        Tf_nama.setText("");
        Tf_sks.setText("");
        Tf_nilai.setText("");
        Tf_status.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_delete;
    private javax.swing.JButton Btn_reset;
    private javax.swing.JButton Btn_save;
    private javax.swing.JButton Btn_select;
    private javax.swing.JButton Btn_update;
    private javax.swing.JTextField Tf_id;
    private javax.swing.JTextField Tf_nama;
    private javax.swing.JTextField Tf_nilai;
    private javax.swing.JTextField Tf_sks;
    private javax.swing.JTextField Tf_status;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
