/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sksmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormRegister extends javax.swing.JFrame {
    // variable konstanta
    private final Connection con;
    // Funsi FormRegister
    public FormRegister() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("D:/New Folder/sksmanager/src/sksmanager/image/logo.png");
        setIconImage(icon.getImage());
        con = Sksmanager.getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Koneksi database gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0); // Keluar jika koneksi gagal
        }
    }
     
    // Fungsi Register
     private void register() {
        String nimm = tf_nim.getText().trim();
        String password = new String(tf_pass.getPassword()).trim();
        String confirmPassword = new String(tf_confirmPass.getPassword()).trim();
        String kampus = tf_kampus.getText().trim();
        String nama_mahasiswa = tf_mahasiswa.getText().trim();
        String fakultas = tf_fakultas.getText().trim();
        String sks_tempuh = tf_sks.getText().trim();

        // Validasi input
        if (nimm.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()|| kampus.isEmpty()|| nama_mahasiswa.isEmpty() || fakultas.isEmpty() || sks_tempuh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password dan konfirmasi password tidak cocok!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "INSERT INTO users (nim, password, kampus, nama_mahasiswa, fakultas, min_sks) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, nimm);
            pst.setString(2, password);
            pst.setString(3, kampus);
            pst.setString(4, nama_mahasiswa);
            pst.setString(5, fakultas);
            pst.setString(6, sks_tempuh);
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Pendaftaran berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new FormLogin().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Pendaftaran gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        panel_logo = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        register = new javax.swing.JLabel();
        nim = new javax.swing.JLabel();
        tf_nim = new javax.swing.JTextField();
        lb_pass = new javax.swing.JLabel();
        tf_pass = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        lb_pass1 = new javax.swing.JLabel();
        tf_confirmPass = new javax.swing.JPasswordField();
        lb_pass2 = new javax.swing.JLabel();
        lb_mahasiswa = new javax.swing.JLabel();
        lb_fakultas = new javax.swing.JLabel();
        lb_sks = new javax.swing.JLabel();
        tf_kampus = new javax.swing.JTextField();
        tf_mahasiswa = new javax.swing.JTextField();
        tf_fakultas = new javax.swing.JTextField();
        tf_sks = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SKS MANAGER | REGISTER");
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(null);
        setName("frmLogin"); // NOI18N
        setPreferredSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(944, 520));

        panel_logo.setBackground(new java.awt.Color(255, 255, 255));

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setForeground(new java.awt.Color(19, 44, 58));
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sksmanager/image/logo.png"))); // NOI18N
        logo.setToolTipText("");
        logo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));

        javax.swing.GroupLayout panel_logoLayout = new javax.swing.GroupLayout(panel_logo);
        panel_logo.setLayout(panel_logoLayout);
        panel_logoLayout.setHorizontalGroup(
            panel_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_logoLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_logoLayout.setVerticalGroup(
            panel_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        logo.getAccessibleContext().setAccessibleName("");

        panel1.setBackground(new java.awt.Color(19, 44, 58));
        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        panel1.setForeground(new java.awt.Color(255, 255, 255));

        register.setBackground(new java.awt.Color(19, 44, 58));
        register.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTER");

        nim.setBackground(new java.awt.Color(19, 44, 58));
        nim.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        nim.setForeground(new java.awt.Color(255, 255, 255));
        nim.setText("NIM                                       :");
        nim.setAlignmentY(0.0F);
        nim.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tf_nim.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tf_nim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        tf_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nimActionPerformed(evt);
            }
        });

        lb_pass.setBackground(new java.awt.Color(19, 44, 58));
        lb_pass.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lb_pass.setForeground(new java.awt.Color(255, 255, 255));
        lb_pass.setText("PASSWORD                         :");
        lb_pass.setAlignmentY(0.0F);
        lb_pass.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tf_pass.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tf_pass.setForeground(new java.awt.Color(19, 44, 58));
        tf_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        tf_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passActionPerformed(evt);
            }
        });

        btn_login.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        btn_login.setForeground(new java.awt.Color(19, 44, 58));
        btn_login.setActionCommand("LOGIN");
        btn_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        btn_login.setLabel("LOGIN");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_register.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        btn_register.setForeground(new java.awt.Color(19, 44, 58));
        btn_register.setText("REGISTER");
        btn_register.setAlignmentX(0.1F);
        btn_register.setAlignmentY(0.0F);
        btn_register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        btn_register.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        lb_pass1.setBackground(new java.awt.Color(19, 44, 58));
        lb_pass1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lb_pass1.setForeground(new java.awt.Color(255, 255, 255));
        lb_pass1.setText("COMFIRM PASSWORD    :");
        lb_pass1.setAlignmentY(0.0F);
        lb_pass1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tf_confirmPass.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tf_confirmPass.setForeground(new java.awt.Color(19, 44, 58));
        tf_confirmPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        tf_confirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_confirmPassActionPerformed(evt);
            }
        });

        lb_pass2.setBackground(new java.awt.Color(19, 44, 58));
        lb_pass2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lb_pass2.setForeground(new java.awt.Color(255, 255, 255));
        lb_pass2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_pass2.setText("KAMPUS                               : ");
        lb_pass2.setAlignmentY(0.0F);
        lb_pass2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lb_mahasiswa.setBackground(new java.awt.Color(19, 44, 58));
        lb_mahasiswa.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lb_mahasiswa.setForeground(new java.awt.Color(255, 255, 255));
        lb_mahasiswa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_mahasiswa.setText("NAMA MAHASISWA         : ");
        lb_mahasiswa.setAlignmentY(0.0F);
        lb_mahasiswa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lb_fakultas.setBackground(new java.awt.Color(19, 44, 58));
        lb_fakultas.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lb_fakultas.setForeground(new java.awt.Color(255, 255, 255));
        lb_fakultas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_fakultas.setText("FAKULTAS                            : ");
        lb_fakultas.setAlignmentY(0.0F);
        lb_fakultas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lb_sks.setBackground(new java.awt.Color(19, 44, 58));
        lb_sks.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lb_sks.setForeground(new java.awt.Color(255, 255, 255));
        lb_sks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_sks.setText("SKS TEMPUH                       : ");
        lb_sks.setAlignmentY(0.0F);
        lb_sks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tf_kampus.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tf_kampus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        tf_kampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_kampusActionPerformed(evt);
            }
        });

        tf_mahasiswa.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tf_mahasiswa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        tf_mahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mahasiswaActionPerformed(evt);
            }
        });

        tf_fakultas.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tf_fakultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        tf_fakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fakultasActionPerformed(evt);
            }
        });

        tf_sks.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tf_sks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 44, 58), 3));
        tf_sks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_register, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nim)
                                                .addComponent(lb_pass)
                                                .addComponent(lb_pass1))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(lb_pass2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(lb_mahasiswa)
                                        .addGap(4, 4, 4)))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(lb_fakultas)
                                    .addGap(7, 7, 7)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lb_sks)
                                .addGap(5, 5, 5)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_sks, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(tf_fakultas)
                            .addComponent(tf_mahasiswa)
                            .addComponent(tf_kampus)
                            .addComponent(tf_nim)
                            .addComponent(tf_pass)
                            .addComponent(tf_confirmPass, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(144, 144, 144))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(register)
                        .addGap(9, 9, 9)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_nim, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_confirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_pass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_kampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_fakultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_fakultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_sks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_sks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nimActionPerformed

    private void tf_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        this.dispose();
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_btn_loginActionPerformed

    private void tf_confirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_confirmPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_confirmPassActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        register();
    }//GEN-LAST:event_btn_registerActionPerformed

    private void tf_kampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_kampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_kampusActionPerformed

    private void tf_mahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mahasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mahasiswaActionPerformed

    private void tf_fakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fakultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fakultasActionPerformed

    private void tf_sksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_sksActionPerformed

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
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel lb_fakultas;
    private javax.swing.JLabel lb_mahasiswa;
    private javax.swing.JLabel lb_pass;
    private javax.swing.JLabel lb_pass1;
    private javax.swing.JLabel lb_pass2;
    private javax.swing.JLabel lb_sks;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nim;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel_logo;
    private javax.swing.JLabel register;
    private javax.swing.JPasswordField tf_confirmPass;
    private javax.swing.JTextField tf_fakultas;
    private javax.swing.JTextField tf_kampus;
    private javax.swing.JTextField tf_mahasiswa;
    private javax.swing.JTextField tf_nim;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_sks;
    // End of variables declaration//GEN-END:variables
}
