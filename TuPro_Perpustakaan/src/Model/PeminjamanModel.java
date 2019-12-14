/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Daniel Septyadi
 */
public class PeminjamanModel {
    private String nim;
    private String nama;
    private String kode_buku;
    private int kode_peminjaman;
    private String tglpinjam;
    private int lamapinjam;
    private String status;

    public PeminjamanModel(String nim, String nama, String kode_buku, int kode_peminjaman, String tglpinjam, int lamapinjam, String status) {
        this.nim = nim;
        this.nama = nama;
        this.kode_buku = kode_buku;
        this.kode_peminjaman = kode_peminjaman;
        this.tglpinjam = tglpinjam;
        this.lamapinjam = lamapinjam;
        this.status = status;
    }

    public PeminjamanModel(String nim, String nama, String kode_buku, String tglpinjam, int lamapinjam, String status) {
        this.nim = nim;
        this.nama = nama;
        this.kode_buku = kode_buku;
        this.tglpinjam = tglpinjam;
        this.lamapinjam = lamapinjam;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode_buku() {
        return kode_buku;
    }

    public void setKode_buku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public int getKode_peminjaman() {
        return kode_peminjaman;
    }

    public void setKode_peminjaman(int kode_peminjaman) {
        this.kode_peminjaman = kode_peminjaman;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public int getLamapinjam() {
        return lamapinjam;
    }

    public void setLamapinjam(int lamapinjam) {
        this.lamapinjam = lamapinjam;
    }
    
    
}
