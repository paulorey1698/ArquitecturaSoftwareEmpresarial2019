/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Model.metodosUsuario;
import View.NuevaContraseña;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Controller3 implements ActionListener {

    private NuevaContraseña view;
    private metodosUsuario modelo = new metodosUsuario();
    Usuario usuario = new Usuario();

    public void eventos() {

        view.btnActualizar.addActionListener(this);

    }

    public Controller3(NuevaContraseña view) {
        this.view = view;
        eventos();
    }

    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if (evt.equals(view.btnActualizar)) {

            usuario.setUser(view.txtUser.getText());
            usuario.setPassword(view.txtPass.getText());
            //usuario.setPassword(view.txtPass1.getText());
            if (view.txtPass.getText() == view.txtPass1.getText()) {
                if (modelo.modificar(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario Registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar usuario");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales");
            }

        }
    }
}
