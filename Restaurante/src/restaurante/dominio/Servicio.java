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
public class Servicio {
    private ArrayList<Articulo> articulos;
    private Mesa mesa;

    public Servicio(Mesa mesa) {
        articulos = new ArrayList<Articulo>();
        this.mesa = mesa;
    }

    public boolean agregar(Articulo articulo) {
        return articulos.add(articulo);
    }
    
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public Mesa getMesa() {
        return mesa;
    }
    
    
}
