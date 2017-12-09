/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;
import persistencia.MapeadorArticulo;
import persistencia.MapeadorServicio;
import persistencia.Persistencia;
import persistencia.Persistible;

/**
 *
 * @author vincentes
 */
public class Servicio implements Persistible {
    private static int ID_CONTADOR = 0;
    private int oid;
    private int id;
    private ArrayList<Articulo> articulos;
    private Mesa mesa;

    public Servicio(Mesa mesa) {
        articulos = new ArrayList<Articulo>();
        this.mesa = mesa;
        this.id = ID_CONTADOR++;
    }
    
    public Servicio() {
        
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

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Override
    public void guardar() {
        Persistencia persistencia = Persistencia.getInstancia();
        MapeadorArticulo artMap = new MapeadorArticulo();
        MapeadorServicio servMap = new MapeadorServicio();
        servMap.setServicio(this);
        for(Articulo articulo : articulos) {
            artMap.setArticulo(articulo);
            persistencia.guardar(artMap);
        }
        persistencia.guardar(servMap);
    }
}
