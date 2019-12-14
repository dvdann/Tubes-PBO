/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BukuModel;
import Model.DB;
import Model.PeminjamanModel;
import View.ViewPeminjaman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Septyadi
 */
public class PeminjamanController extends MouseAdapter implements ActionListener  {
    private ViewPeminjaman view;
    private DB db;

    public PeminjamanController() {
        view = new ViewPeminjaman();
        db = new DB();
        view.setVisible(true);
        view.setActionListener(this);
        view.setMouseListener(this);
        
        setTableBuku(db.getBuku());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource(); //mengubah & menganti berdasarkan kode_buku
        if (o.equals(view.getSavebtn())){
            String kode_buku = view.getKode_buku();
            String nim = view.gettNim();
            String nama = view.gettNama();
            String tglpinjam = view.getTglpinjam();
            int lamapinjam = Integer.parseInt(view.getLamapinjam());
            PeminjamanModel p = new PeminjamanModel(nim, nama, kode_buku, tglpinjam, lamapinjam, "dipinjam");
            db.addPeminjaman(p);
            
            new HistoryController();
        }
    }
    
    private void setTableBuku(List<BukuModel> listBuku){
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Kode Buku","Judul Buku", "Penerbit", "Pengarang", "Tahun"}, 0);
           for (BukuModel b : listBuku) {
               dtm.addRow(new Object []{b.getKodeBuku(),b.getJudulBuku(),b.getPenerbit(),b.getPengarang(),b.getTahun()});
           }
           view.setTablebuku(dtm);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Object o = me.getSource();
        if (o.equals(view.getTablebuku())) {
            int i = view.getSelectedRow();
            String kodebuku = view.getTablebuku().getModel().getValueAt(i, 0).toString();
            
            view.setKode_buku(kodebuku);
            
        }
    }
    
    
    
}
