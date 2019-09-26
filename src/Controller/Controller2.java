/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Model.metodosUsuario;
import View.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Controller2 implements ActionListener {

    private Registro view;
    private metodosUsuario modelo = new metodosUsuario();
    Usuario usuario = new Usuario();

    public void eventos() {
      
        view.btnRegistrar.addActionListener(this);

    }

    public Controller2(Registro view) {
        this.view = view;
        eventos();
    }

    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();

        

        if (evt.equals(view.btnRegistrar)) {
            usuario.setId(Integer.parseInt(view.txtId.getText()));
            usuario.setNombre(view.txtNombre.getText());
            usuario.setApellido(view.txtApellido.getText());
            usuario.setUser(view.txtUser.getText());
            usuario.setPassword(view.txtPass.getText());
            usuario.setEmail(view.txtEmail.getText());
            if (modelo.registrar(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario Registrado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar usuario");
            }

        }
        
        
    }
    public void limpiar(){
        view.txtNombre.setText(null);
        view.txtApellido.setText(null);
        view.txtUser.setText(null);
        view.txtPass.setText(null);
        view.txtEmail.setText(null);
    }

}
