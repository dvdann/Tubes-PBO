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
public class HistoryModel {
    private String kode_buku;
    private String judul;
    private String penerbit;
    private String status;
    private String tglpinjam;
    private String tglbalik;
    private int harga;

    public HistoryModel(String kode_buku, String judul, String penerbit, String status, String tglpinjam, String tglbalik, int harga) {
        this.kode_buku = kode_buku;
        this.judul = judul;
        this.penerbit = penerbit;
        this.status = status;
        this.tglpinjam = tglpinjam;
        this.tglbalik = tglbalik;
        this.harga = harga;
    }

    public String getKode_buku() {
        return kode_buku;
    }

    public void setKode_buku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglbalik() {
        return tglbalik;
    }

    public void setTglbalik(String tglbalik) {
        this.tglbalik = tglbalik;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
