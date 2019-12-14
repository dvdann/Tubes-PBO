/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.FormHalamanUtama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Daniel Septyadi
 */
public class HalamanUtamaController implements ActionListener {
    private FormHalamanUtama view;
    
    public HalamanUtamaController() {
        view = new FormHalamanUtama();
        view.setVisible(true);
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o.equals(view.getBtnaddbuku())) {
            new TambahBukuControler();
        } else if (o.equals(view.getBtnPeminjaman())) {
            new PeminjamanController();
        } else if (o.equals(view.getBtnHistory())) {
            new HistoryController();
        }
    }
    
}
