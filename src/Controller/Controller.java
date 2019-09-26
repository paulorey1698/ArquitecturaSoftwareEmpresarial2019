/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Model.metodosUsuario;
import View.Inicio;
import View.Registro;
import View.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Controller implements ActionListener{

    private VistaLogin view;
    private Registro view1=new Registro();
    private metodosUsuario modelo = new metodosUsuario();
    Inicio inicio = new Inicio();
    Usuario usuario=null;
    public void eventos(){
        view.btnLoginIn.addActionListener(this);
        //view1.btnRegistrar.addActionListener(this);
        
    }

    public Controller(VistaLogin view) {
        this.view = view;
        eventos();
    }
    public void actionPerformed(ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(view.btnLoginIn)){
            char p[] = view.txtPass.getPassword();
            String pass = new String(p);
            
            if(view.txtUsuario.getText().isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe ingresar Usuario y Contraseña");
            }else{
                String user = view.txtUsuario.getText();
                ArrayList<Usuario> list;
                list=modelo.login(user, pass);
                if(list.size()>0){
                    JOptionPane.showMessageDialog(null, "Bienvenido al Sistemas");
                    view.dispose();
                    inicio.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Acceso denegado");
                }
                
            }
        } 
        
    }
    

}
