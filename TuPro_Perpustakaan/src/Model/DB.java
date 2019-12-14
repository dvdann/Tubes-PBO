/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Septyadi
 */
public class DB {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    private void connect() {
        try{
            String db = "jdbc:mysql://localhost/perpustakaan";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(db, user, pass);
            stmt = con.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private void disconnect() {
        try {
            con.close();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Boolean addBuku (BukuModel b){
        connect();
        try{
            String query = "insert into buku values ("
                + "'" + b.getKodeBuku() + "',"
                + "'" + b.getJudulBuku() + "',"
                + "'" + b.getPenerbit() + "',"
                + "'" + b.getPengarang() + "',"
                + "'" + b.getTahun() + "'"
                + ")";
            int row = stmt.executeUpdate(query);
            if (row > 0 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public List<BukuModel> getBuku (){
       connect();
         List<BukuModel> listBuku = new ArrayList<>();

       try{
           String query = "select * from buku";
           rs = stmt.executeQuery(query);
           while (rs.next()){
               String kodebuku = rs.getString("Kode_Buku");
               String judul = rs.getString("Judul_Buku");
               String penerbit = rs.getString("Penerbit");
               String pengarang = rs.getString("Pengarang");
               int tahun = rs.getInt("Tahun");
               BukuModel buku = new BukuModel(kodebuku, judul, pengarang, penerbit, String.valueOf(tahun));
               listBuku.add(buku);
           }
       } catch(SQLException e){
           e.printStackTrace();
       } 
       disconnect();
       return listBuku;
    }
    
    public void EditBuku (BukuModel e) {
        connect();
        String query = "UPDATE buku SET Judul_buku='"+e.getJudulBuku()+"',"
                + "Penerbit='"+e.getPenerbit()+"',"
                + "Pengarang='"+e.getPengarang()+"',"
                + "Tahun='"+e.getTahun()+"'"
                + " WHERE Kode_buku = '"+e.getKodeBuku()+"'";
        try {
            stmt.executeUpdate(query);
        } catch(SQLException s) {
            s.printStackTrace();
        }
        disconnect();
    }
    public void DeleteBuku (String kodebuku) {
        connect();
        String query = "DELETE FROM buku WHERE Kode_buku = '"+kodebuku+"'";
        try {
            stmt.executeUpdate(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }
    
    public void DeletePeminjaman (String kode_peminjaman) {
        connect();
        String query = "DELETE FROM history WHERE kode_peminjaman = '"+kode_peminjaman+"'";
        try {
            stmt.executeUpdate(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }
    
    public List<PeminjamanModel> getHistory(){
        connect();
        List<PeminjamanModel> history = new ArrayList<>();
        String query = "SELECT * FROM history";
        try{ //menghadapi segala kemungkinan error pda database saat query nanti
            rs = stmt.executeQuery(query);
            while (rs.next()){
                String kode_buku = rs.getString("kode_buku");
                String nim = rs.getString("nim");
                String nama = rs.getString("nama");
                String tglpinjam = rs.getString("tanggal");
                int lamapinjam = rs.getInt("lamapinjam");
                int kode_peminjaman = rs.getInt("kode_peminjaman");
                String status = rs.getString("status");
                PeminjamanModel h = new PeminjamanModel(nim,nama,kode_buku,kode_peminjaman,tglpinjam,lamapinjam,status);
                history.add(h);
            }
        }catch (SQLException e){ 
            e.printStackTrace();
        }
        disconnect();
        return history;
    }
    
    public void UpdateHistory(String kode_peminjaman, String status){
        connect();
        String query = "UPDATE history SET status = '" + status + "' WHERE kode_peminjaman ='" +kode_peminjaman+ "'";
        try{
            stmt.executeUpdate(query);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        disconnect();
    }
    
    public Boolean addPeminjaman (PeminjamanModel b){
        connect();
        try{
            String query = "insert into history(kode_buku, nama, nim, tanggal, lamapinjam, status) values ("
                + "'" + b.getKode_buku()+ "',"
                + "'" + b.getNama()+ "',"
                + "'" + b.getNim()+ "',"
                + "'" + b.getTglpinjam()+ "',"
                + "'" + b.getLamapinjam()+ "',"
                + "'" + b.getStatus()+ "'"
                + ")";
            int row = stmt.executeUpdate(query);
            if (row > 0 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
        public Boolean getLogin (String username, String password){
        connect();
        String query = "select * from user WHERE username = '" + username + "' and password = '" + password + "'";
        try{
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println("LOGIN BERHASIL");
                return true;
            } else {
                System.out.println("LOGIN GAGAL");
                return false;
            }
        } catch(SQLException e){
            e.printStackTrace();
        } 
        disconnect();
        return false;
    }
    
    
}
