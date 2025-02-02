/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sksmanager;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author YOGA
 */
public class Dashboard extends javax.swing.JFrame {
    
    // Variable Global
    public static String nim = FormLogin.userNIM;
    
    // Inisialisasi Object
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    // Fungsi Mengambil Data
    private void loadData() {
        try {
            nim = FormLogin.userNIM;
            rs = stmt.executeQuery("SELECT nama_mahasiswa, kampus, fakultas, min_sks FROM users WHERE nim = '" + nim + "'");
            int minSks = 0;
            
            if (rs.next()) {
                String namaMahasiswa = rs.getString("nama_mahasiswa");
                String kampus = rs.getString("kampus");
                String fakultas = rs.getString("fakultas");
                String sks_tempuh = rs.getString("min_sks");
                minSks = Integer.parseInt(sks_tempuh);
                lbnama_mahasiswa.setText(namaMahasiswa);
                lbnama_kampus.setText(kampus);
                lbnama_fakultas.setText(fakultas);
                nilai_sks_tempuh.setText(sks_tempuh);
            } else {
                lbnama_mahasiswa.setText("Nama Mahasiswa: Tidak ditemukan");
                lbnama_kampus.setText("Kampus: Tidak ditemukan");
                lbnama_fakultas.setText("Fakultas: Tidak ditemukan");
            }
            
            int totalSksLulus = 0;
            rs = stmt.executeQuery("SELECT SUM(sks) AS total_sks_lulus FROM data_manager WHERE nim = '" + nim + "' AND status = 'LULUS'");
            if (rs.next()) {
                String sksLulus = rs.getString("total_sks_lulus");
                if (sksLulus == null) sksLulus = "0";
                totalSksLulus = Integer.parseInt(sksLulus);
                nilai_sks_lulus.setText(sksLulus);
            }

            rs = stmt.executeQuery("SELECT SUM(sks) AS total_sks_tidaklulus FROM data_manager WHERE nim = '" + nim + "' AND status = 'TIDAK LULUS'");
            if (rs.next()) {
                String sksTidakLulus = rs.getString("total_sks_tidaklulus");
                if (sksTidakLulus == null) sksTidakLulus = "0"; 
                nilai_sks_tidaklulus.setText(sksTidakLulus);
            }
            
            int sksSisa = minSks - totalSksLulus;
            if (sksSisa < 0) sksSisa = 0; 
            nilai_sks_sisa.setText(String.valueOf(sksSisa));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // Fungsi Dashboard
    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
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
        loadData();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_nav = new javax.swing.JPanel();
        btn_dashboard = new javax.swing.JButton();
        btn_manager1 = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        panel_dashboard = new javax.swing.JPanel();
        lbnama_kampus = new javax.swing.JLabel();
        lbnama_mahasiswa = new javax.swing.JLabel();
        lbnama_fakultas = new javax.swing.JLabel();
        panel_tempuh = new javax.swing.JPanel();
        nilai_sks_tempuh = new javax.swing.JLabel();
        lbsks_tempuh1 = new javax.swing.JLabel();
        panel_lulus = new javax.swing.JPanel();
        nilai_sks_lulus = new javax.swing.JLabel();
        lbsks_lulus = new javax.swing.JLabel();
        panel_tidaklulus = new javax.swing.JPanel();
        nilai_sks_tidaklulus = new javax.swing.JLabel();
        lbsks_tidaklulus = new javax.swing.JLabel();
        panel_tempuh1 = new javax.swing.JPanel();
        nilai_sks_sisa = new javax.swing.JLabel();
        lbsks_sisa = new javax.swing.JLabel();
        panel_log = new javax.swing.JPanel();
        title_dashboard1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SKS MANAGER | DASHBOARD");
        setResizable(false);
        setSize(new java.awt.Dimension(983, 636));

        panel_nav.setBackground(new java.awt.Color(19, 44, 58));
        panel_nav.setForeground(new java.awt.Color(255, 255, 255));

        btn_dashboard.setBackground(new java.awt.Color(39, 82, 107));
        btn_dashboard.setFont(new java.awt.Font("Calibri", 1, 25)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sksmanager/image/home.png"))); // NOI18N
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setAlignmentX(0.1F);
        btn_dashboard.setAlignmentY(0.0F);
        btn_dashboard.setBorder(null);
        btn_dashboard.setBorderPainted(false);
        btn_dashboard.setIconTextGap(10);
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });

        btn_manager1.setBackground(new java.awt.Color(19, 44, 58));
        btn_manager1.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        btn_manager1.setForeground(new java.awt.Color(255, 255, 255));
        btn_manager1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sksmanager/image/table.png"))); // NOI18N
        btn_manager1.setText("Manager");
        btn_manager1.setActionCommand("");
        btn_manager1.setAlignmentX(0.1F);
        btn_manager1.setAlignmentY(0.0F);
        btn_manager1.setBorder(null);
        btn_manager1.setBorderPainted(false);
        btn_manager1.setIconTextGap(10);
        btn_manager1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manager1ActionPerformed(evt);
            }
        });

        btn_logout.setBackground(new java.awt.Color(19, 44, 58));
        btn_logout.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sksmanager/image/log-out.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.setActionCommand("");
        btn_logout.setAlignmentX(0.1F);
        btn_logout.setAlignmentY(0.0F);
        btn_logout.setBorder(null);
        btn_logout.setBorderPainted(false);
        btn_logout.setIconTextGap(10);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_navLayout = new javax.swing.GroupLayout(panel_nav);
        panel_nav.setLayout(panel_navLayout);
        panel_navLayout.setHorizontalGroup(
            panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_manager1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
            .addComponent(btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_navLayout.setVerticalGroup(
            panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_navLayout.createSequentialGroup()
                .addComponent(btn_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_manager1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_dashboard.setBackground(new java.awt.Color(255, 255, 255));

        lbnama_kampus.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbnama_kampus.setText("Nama Kampus");

        lbnama_mahasiswa.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbnama_mahasiswa.setText("Nama Mahasiswa");

        lbnama_fakultas.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbnama_fakultas.setText("Nama Fakultas");

        panel_tempuh.setBackground(new java.awt.Color(19, 44, 58));
        panel_tempuh.setForeground(new java.awt.Color(255, 255, 255));

        nilai_sks_tempuh.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        nilai_sks_tempuh.setForeground(new java.awt.Color(255, 255, 255));
        nilai_sks_tempuh.setText("0");

        lbsks_tempuh1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lbsks_tempuh1.setForeground(new java.awt.Color(255, 255, 255));
        lbsks_tempuh1.setText("Sks Tempuh");

        javax.swing.GroupLayout panel_tempuhLayout = new javax.swing.GroupLayout(panel_tempuh);
        panel_tempuh.setLayout(panel_tempuhLayout);
        panel_tempuhLayout.setHorizontalGroup(
            panel_tempuhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tempuhLayout.createSequentialGroup()
                .addGroup(panel_tempuhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_tempuhLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(nilai_sks_tempuh))
                    .addGroup(panel_tempuhLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbsks_tempuh1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panel_tempuhLayout.setVerticalGroup(
            panel_tempuhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tempuhLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbsks_tempuh1)
                .addGap(31, 31, 31)
                .addComponent(nilai_sks_tempuh)
                .addGap(35, 35, 35))
        );

        panel_lulus.setBackground(new java.awt.Color(19, 44, 58));
        panel_lulus.setForeground(new java.awt.Color(255, 255, 255));

        nilai_sks_lulus.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        nilai_sks_lulus.setForeground(new java.awt.Color(255, 255, 255));
        nilai_sks_lulus.setText("0");

        lbsks_lulus.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lbsks_lulus.setForeground(new java.awt.Color(255, 255, 255));
        lbsks_lulus.setText("Sks Lulus");

        javax.swing.GroupLayout panel_lulusLayout = new javax.swing.GroupLayout(panel_lulus);
        panel_lulus.setLayout(panel_lulusLayout);
        panel_lulusLayout.setHorizontalGroup(
            panel_lulusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_lulusLayout.createSequentialGroup()
                .addGroup(panel_lulusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_lulusLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(nilai_sks_lulus))
                    .addGroup(panel_lulusLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lbsks_lulus)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panel_lulusLayout.setVerticalGroup(
            panel_lulusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_lulusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbsks_lulus)
                .addGap(31, 31, 31)
                .addComponent(nilai_sks_lulus)
                .addGap(35, 35, 35))
        );

        panel_tidaklulus.setBackground(new java.awt.Color(19, 44, 58));
        panel_tidaklulus.setForeground(new java.awt.Color(255, 255, 255));

        nilai_sks_tidaklulus.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        nilai_sks_tidaklulus.setForeground(new java.awt.Color(255, 255, 255));
        nilai_sks_tidaklulus.setText("0");

        lbsks_tidaklulus.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lbsks_tidaklulus.setForeground(new java.awt.Color(255, 255, 255));
        lbsks_tidaklulus.setText("Sks Tidak Lulus");

        javax.swing.GroupLayout panel_tidaklulusLayout = new javax.swing.GroupLayout(panel_tidaklulus);
        panel_tidaklulus.setLayout(panel_tidaklulusLayout);
        panel_tidaklulusLayout.setHorizontalGroup(
            panel_tidaklulusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tidaklulusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_tidaklulusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tidaklulusLayout.createSequentialGroup()
                        .addComponent(lbsks_tidaklulus)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tidaklulusLayout.createSequentialGroup()
                        .addComponent(nilai_sks_tidaklulus)
                        .addGap(78, 78, 78))))
        );
        panel_tidaklulusLayout.setVerticalGroup(
            panel_tidaklulusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tidaklulusLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbsks_tidaklulus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(nilai_sks_tidaklulus)
                .addGap(35, 35, 35))
        );

        panel_tempuh1.setBackground(new java.awt.Color(19, 44, 58));
        panel_tempuh1.setForeground(new java.awt.Color(255, 255, 255));

        nilai_sks_sisa.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        nilai_sks_sisa.setForeground(new java.awt.Color(255, 255, 255));
        nilai_sks_sisa.setText("0");

        lbsks_sisa.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lbsks_sisa.setForeground(new java.awt.Color(255, 255, 255));
        lbsks_sisa.setText("Sks Sisa");

        javax.swing.GroupLayout panel_tempuh1Layout = new javax.swing.GroupLayout(panel_tempuh1);
        panel_tempuh1.setLayout(panel_tempuh1Layout);
        panel_tempuh1Layout.setHorizontalGroup(
            panel_tempuh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tempuh1Layout.createSequentialGroup()
                .addGroup(panel_tempuh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_tempuh1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(nilai_sks_sisa))
                    .addGroup(panel_tempuh1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lbsks_sisa)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panel_tempuh1Layout.setVerticalGroup(
            panel_tempuh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tempuh1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbsks_sisa)
                .addGap(31, 31, 31)
                .addComponent(nilai_sks_sisa)
                .addGap(35, 35, 35))
        );

        panel_log.setBackground(new java.awt.Color(19, 44, 58));

        title_dashboard1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        title_dashboard1.setForeground(new java.awt.Color(255, 255, 255));
        title_dashboard1.setText("DASHBOARD");

        javax.swing.GroupLayout panel_logLayout = new javax.swing.GroupLayout(panel_log);
        panel_log.setLayout(panel_logLayout);
        panel_logLayout.setHorizontalGroup(
            panel_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_logLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_dashboard1)
                .addContainerGap(518, Short.MAX_VALUE))
        );
        panel_logLayout.setVerticalGroup(
            panel_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_logLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(title_dashboard1))
        );

        javax.swing.GroupLayout panel_dashboardLayout = new javax.swing.GroupLayout(panel_dashboard);
        panel_dashboard.setLayout(panel_dashboardLayout);
        panel_dashboardLayout.setHorizontalGroup(
            panel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dashboardLayout.createSequentialGroup()
                        .addGroup(panel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnama_mahasiswa)
                            .addComponent(lbnama_kampus)
                            .addGroup(panel_dashboardLayout.createSequentialGroup()
                                .addGroup(panel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbnama_fakultas, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_dashboardLayout.createSequentialGroup()
                                        .addComponent(panel_tempuh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel_tempuh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel_lulus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(panel_tidaklulus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dashboardLayout.createSequentialGroup()
                        .addComponent(panel_log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel_dashboardLayout.setVerticalGroup(
            panel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbnama_kampus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbnama_fakultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbnama_mahasiswa)
                .addGap(18, 18, 18)
                .addGroup(panel_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_tempuh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_tempuh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_lulus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_tidaklulus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(291, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_nav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        this.dispose();
        new FormLogin().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_manager1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manager1ActionPerformed
        this.dispose();
        new Manager().setVisible(true);
    }//GEN-LAST:event_btn_manager1ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_manager1;
    private javax.swing.JLabel lbnama_fakultas;
    private javax.swing.JLabel lbnama_kampus;
    private javax.swing.JLabel lbnama_mahasiswa;
    private javax.swing.JLabel lbsks_lulus;
    private javax.swing.JLabel lbsks_sisa;
    private javax.swing.JLabel lbsks_tempuh1;
    private javax.swing.JLabel lbsks_tidaklulus;
    private javax.swing.JLabel nilai_sks_lulus;
    private javax.swing.JLabel nilai_sks_sisa;
    private javax.swing.JLabel nilai_sks_tempuh;
    private javax.swing.JLabel nilai_sks_tidaklulus;
    private javax.swing.JPanel panel_dashboard;
    private javax.swing.JPanel panel_log;
    private javax.swing.JPanel panel_lulus;
    private javax.swing.JPanel panel_nav;
    private javax.swing.JPanel panel_tempuh;
    private javax.swing.JPanel panel_tempuh1;
    private javax.swing.JPanel panel_tidaklulus;
    private javax.swing.JLabel title_dashboard1;
    // End of variables declaration//GEN-END:variables
}