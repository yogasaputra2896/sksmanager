package sksmanager;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Manager extends javax.swing.JFrame {
    
    public static String nim = FormLogin.userNIM;
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    
    public Manager() {
        initComponents();
        con = Sksmanager.getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal membuat Statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        tampilData();
    }
    
    private void tampilData(){
        DefaultTableModel isitabel = new DefaultTableModel();
        isitabel.addColumn("ID");
        isitabel.addColumn("KODE");
        isitabel.addColumn("NAMA");
        isitabel.addColumn("SKS");
        isitabel.addColumn("NILAI");
        isitabel.addColumn("STATUS");
        try{
            rs = stmt.executeQuery("SELECT id, nama, sks, nilai, status, kode_matkul FROM semester WHERE nim = '" + nim + "'");
            while(rs.next()){
                isitabel.addRow(new Object[] {rs.getString("id"),
                    rs.getString("kode_matkul"),
                    rs.getString("nama"),
                    rs.getString("sks"),
                    rs.getString("nilai"),
                    rs.getString("status")});
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
        jLabel8 = new javax.swing.JLabel();
        Tf_kode = new javax.swing.JTextField();

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
        Btn_update.setEnabled(false);
        Btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_updateActionPerformed(evt);
            }
        });

        Btn_delete.setText("Delete");
        Btn_delete.setEnabled(false);
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

        jLabel8.setText("KODE MATKUL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tf_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_save)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_update)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_delete)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_reset))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(Tf_sks, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Tf_nilai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Btn_select)))
                .addGap(0, 171, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Tf_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Tf_nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Tf_sks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Tf_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
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
        Tf_kode.setText("");
        Tf_nama.setText("");
        Tf_sks.setText("");
        Tf_nilai.setText("");
        Tf_status.setText("");
    }//GEN-LAST:event_Btn_resetActionPerformed

    private void Btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_saveActionPerformed
        String id = Tf_id.getText();
        String kode = Tf_kode.getText();
        String nama = Tf_nama.getText();
        String sks = Tf_sks.getText();
        String nilai = Tf_nilai.getText();
        String status = Tf_status.getText();

        if (id.isEmpty() || kode.isEmpty() || nama.isEmpty() || sks.isEmpty() || nilai.isEmpty() || status.isEmpty() || nim.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
        } else {
            try {
                // Query untuk mengecek apakah data dengan kombinasi id, kode, nama, dan nim sudah ada
                String checkSql = "SELECT COUNT(*) AS count FROM semester WHERE id = '" + id 
                                  + "' AND kode_matkul = '" + kode 
                                  + "' AND nama = '" + nama 
                                  + "' AND nim = '" + nim + "'";
                rs = stmt.executeQuery(checkSql);
                rs.next();
                int count = rs.getInt("count");

                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Data dengan kombinasi id, kode, nama, dan nim sudah ada!");
                } else {
                    // Jika tidak ada data duplikat, lakukan insert
                    String sql = "INSERT INTO semester (id, kode_matkul, nama, sks, nilai, status, nim) VALUES ('" 
                                 + id + "', '"
                                 + kode + "', '" 
                                 + nama + "', '" 
                                 + sks + "', '" 
                                 + nilai + "', '" 
                                 + status + "', '" 
                                 + nim + "')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
                    tampilData(); // Refresh tabel setelah menambah data
                    resetInputFields(); // Reset inputan
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menambahkan data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_Btn_saveActionPerformed

    private void Btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_updateActionPerformed
        String id = Tf_id.getText();
        String kode = Tf_kode.getText();
        String nama = Tf_nama.getText();
        String sks = Tf_sks.getText();
        String nilai = Tf_nilai.getText();
        String status = Tf_status.getText();
        

        if (kode.isEmpty()) {
            JOptionPane.showMessageDialog(null, "KODE tidak boleh kosong untuk memperbarui data!");
        } else {
            try {
                String sql = "UPDATE semester SET nim = '" + nim
                             + "', id = '" + id
                             + "', sks = '" + sks 
                             + "', nilai = '" + nilai 
                             + "', status = '" + status 
                             + "', nama = '" + nama 
                             + "' WHERE kode_matkul = '" + kode + "'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
                tampilData(); // Refresh tabel setelah update
                resetInputFields(); // Reset inputan
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data: " + e.getMessage());
            }
        }
    Btn_save.setEnabled(true);
    Btn_update.setEnabled(false);
    Btn_delete.setEnabled(false);
    }//GEN-LAST:event_Btn_updateActionPerformed

    private void Btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_deleteActionPerformed
        String kode = Tf_kode.getText();
    
        if (kode.isEmpty()) {
            JOptionPane.showMessageDialog(null, "KODE tidak boleh kosong untuk menghapus data!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, 
                            "Apakah Anda yakin ingin menghapus data ini?", 
                            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String sql = "DELETE FROM semester WHERE kode_matkul = '" + kode + "'";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                    tampilData(); // Refresh tabel setelah delete
                    resetInputFields(); // Reset inputan
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
                }
            }
        }
        Btn_save.setEnabled(true);
        Btn_delete.setEnabled(false);
        Btn_update.setEnabled(false);
    }//GEN-LAST:event_Btn_deleteActionPerformed

    private void Btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_selectActionPerformed
        int selectedRow = jTable1.getSelectedRow(); // Ambil baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Silakan pilih data di tabel terlebih dahulu!");
        } else {
            // Ambil data dari tabel berdasarkan indeks kolom
            String id = jTable1.getValueAt(selectedRow, 0).toString();
            String kode = jTable1.getValueAt(selectedRow, 1).toString();
            String nama = jTable1.getValueAt(selectedRow, 2).toString();
            String sks = jTable1.getValueAt(selectedRow, 3).toString();
            String nilai = jTable1.getValueAt(selectedRow, 4).toString();
            String status = jTable1.getValueAt(selectedRow, 5).toString();
            

            // Set data ke text field
            Tf_id.setText(id);
            Tf_nama.setText(nama);
            Tf_sks.setText(sks);
            Tf_nilai.setText(nilai);
            Tf_status.setText(status);
            Tf_kode.setText(kode);
        }
        Btn_delete.setEnabled(true);
        Btn_update.setEnabled(true);
        Btn_save.setEnabled(false);
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
        Tf_kode.setText("");
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
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager().setVisible(true);
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
    private javax.swing.JTextField Tf_kode;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
