/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB;
import Model.PeminjamanModel;
import View.HistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Septyadi
 */
public class HistoryController extends MouseAdapter implements ActionListener {
    private String kode_peminjaman = "";
    private HistoryView view;
    private DB db;
    
    public HistoryController(){
        view = new HistoryView();
        db = new DB();
        view.setVisible(true);
        showHistory();
        view.setActionListener(this);
        view.setMouseListener(this);
    }
    
    
    
    private void showHistory(){
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"kode_peminajaman","kode_buku","nim","nama","tglpinjam","lamapinjam","status"},0);
        List<PeminjamanModel> history = db.getHistory();
        for (PeminjamanModel h:history){ // looping sebanyak data yg ada di list
            dtm.addRow(new Object[]{h.getKode_peminjaman(),h.getKode_buku(),h.getNim(),h.getNama(),h.getTglpinjam(),h.getLamapinjam(),h.getStatus()});
        }
        view.setTabOutput(dtm);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object o = ae.getSource(); //mengubah & menganti berdasarkan kode_buku
       if (o.equals(view.getBtnpengembalian())){
           db.UpdateHistory(kode_peminjaman, "kembali");
           showHistory();
       } else if (o.equals(view.getDeletebtn())) {
           db.DeletePeminjaman(kode_peminjaman);
           showHistory();
       }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Object o = me.getSource(); // action ketika mouse klik pengembalian berubah menjadi kembali
        if (o.equals(view.getTabOutput())){
            int i = view.getSelectedHistory();
            kode_peminjaman = view.getTabOutput().getModel().getValueAt(i, 0).toString();
        }
    }
    

}
