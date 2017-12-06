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
public class SistemaGestor {
    private ArrayList<Gestor> gestores = new ArrayList();
    private ArrayList<Gestor> gestoresLogueados = new ArrayList();
    
    public void agregar(Gestor g){
        if(!gestores.contains(g)) {
            gestores.add(g);
        }
    }

    public Gestor login(String n,String p){
        for(Gestor g:gestores){
            if(g.getUsuario().equals(n) && g.getPassword().equals(p)){
                gestoresLogueados.add(g);
                return g;
            }
        }
        return null;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }
    
    
    public boolean logueado(String usuario) {
        for(Gestor g : gestoresLogueados) {
            if(g.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public boolean procesando(Articulo articulo) {
        for(Gestor gestor : gestores) {
            for(Pedido pedido : gestor.getPedidos()) {
                if(pedido.getArticulo().equals(articulo) && !pedido.isFinalizado()) {
                    return true;
                }
            }
        }
        return false;
    }
}
