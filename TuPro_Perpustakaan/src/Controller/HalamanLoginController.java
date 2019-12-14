/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB;
import View.HalamanLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Septyadi
 */
public class HalamanLoginController implements ActionListener {
    private HalamanLogin view;
    private DB db;
    
    public HalamanLoginController() {
        view = new HalamanLogin();
        view.setVisible(true);
        view.setActionListener(this);
        db = new DB();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o.equals(view.getBtnsubmit())) {
            String username = view.gettUsername();
            String password = view.gettPassword();
            
            boolean cekLogin = db.getLogin(username, password);
            if (cekLogin) {
                new HalamanUtamaController();
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah!");
            }
        }
    }   
}
