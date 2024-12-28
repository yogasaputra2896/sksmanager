/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sksmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Sksmanager {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String sql;

    // Metode untuk konfigurasi koneksi ke database
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Menambahkan driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sksmanager", "root", "12345");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: Mysql Tidak Terhubung atau Database Tidak Ditemukan - " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

    public static void main(String[] args) {
        // Mencoba menghubungkan ke database
        Connection con = getConnection();

        if (con == null) {
            // Jika koneksi gagal, keluar dari program
            System.exit(0);
        }

        // Jika koneksi berhasil, tampilkan FormLogin
        new FormLogin().setVisible(true);
    }
}
