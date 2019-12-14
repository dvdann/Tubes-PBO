package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nabillaaura
 */
public class BukuModel {
    private String kode_buku;
    private String JudulBuku;
    private String Penerbit;
    private String Pengarang;
    private String Tahun;

    public BukuModel(String KodeBuku, String JudulBuku, String Penerbit, String Pengarang, String Tahun) {
        this.kode_buku = KodeBuku;
        this.JudulBuku = JudulBuku;
        this.Penerbit = Penerbit;
        this.Pengarang = Pengarang;
        this.Tahun = Tahun;
    }

    public String getKodeBuku() {
        return kode_buku;
    }

    public void setKodeBuku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public String getJudulBuku() {
        return JudulBuku;
    }

    public void setJudulBuku(String JudulBuku) {
        this.JudulBuku = JudulBuku;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public String getTahun() {
        return Tahun;
    }

    public void setTahun(String Tahun) {
        this.Tahun = Tahun;
    }
    
    
}
