package Controller;


import View.FormTambahBuku;
import Model.DB;
import Model.BukuModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nabillaaura
 */
public class TambahBukuControler extends MouseAdapter implements ActionListener  {
    private FormTambahBuku view;
    private DB db;
    private Boolean isEdit = false ;

    public TambahBukuControler() {
        view = new FormTambahBuku();
        view.setActionListener(this);
        view.AddMuouseListener(this);
        view.setVisible(true);
        db= new DB();
        setTableBuku(db.getBuku());
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object object = ae.getSource();
       if (object.equals(view.getBSubmit())) {
           String kodebuku = view.getKodeBuku();
           String judulbuku = view.getJudulBuku();
           String penerbit = view.getPenerbit();
           String pengarang = view.getPengarang();
           String tahun = view.getTahun();
           BukuModel buku = new BukuModel(kodebuku, judulbuku, penerbit, pengarang, tahun); 
           if (isEdit) {
               isEdit = false;
               db.EditBuku(buku);
           } else {
              if (db.addBuku(buku)) {
               System.out.println("Data Buku Berhasil Ditambah");
           } else {
               System.out.println("Data Buku Gagal Ditambahkan");
           } 
           }
           
           setTableBuku(db.getBuku());
           view.clearView();
           
           
       } else if (object.equals(view.getBDelete())) {
           isEdit = false;
           String kodebuku = view.getKodeBuku();
           db.DeleteBuku(kodebuku);
           setTableBuku(db.getBuku());
       }
    }
    
    private void setTableBuku(List<BukuModel> listBuku){
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Kode Buku","Judul Buku", "Penerbit", "Pengarang", "Tahun"}, 0);
           for (BukuModel b : listBuku) {
               dtm.addRow(new Object []{b.getKodeBuku(),b.getJudulBuku(),b.getPenerbit(),b.getPengarang(),b.getTahun()});
           }
           view.setTableBuku(dtm);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Object o = me.getSource();
        if (o.equals(view.getTable())) {
            isEdit = true;
            int i = view.getSelectedBuku();
            String kodebuku = view.getTable().getModel().getValueAt(i, 0).toString();
            String judulbuku = view.getTable().getModel().getValueAt(i, 1).toString();
            String penerbit = view.getTable().getModel().getValueAt(i, 2).toString();
            String pengarang = view.getTable().getModel().getValueAt(i, 3).toString();
            String tahun = view.getTable().getModel().getValueAt(i, 4).toString();
            
            view.setKodeBuku(kodebuku);
            view.setJudulBuku(judulbuku);
            view.setPenerbit(penerbit);
            view.setPengarang(pengarang);
            view.setTahun(tahun);
            
        }
    }
    
    
}
