/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;

/**
 *
 * @author vincentes
 */
public class SistemaUsuario {
    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Usuario> logeados = new ArrayList();
    
    public void agregar(Usuario u){
        if(!usuarios.contains(u)) {
            usuarios.add(u);
        }
    }

    public Usuario login(String n,String p){
        for(Usuario u:usuarios){
            if(u.getUsuario().equals(n) && u.getPassword().equals(p)){
                logeados.add(u);
                return u;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean logeado(String usuario) {
        for(Usuario u : logeados) {
            if(u.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }
}
