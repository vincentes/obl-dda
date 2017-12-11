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
import restaurante.dominio.persistencia.Cliente;

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
    
    public double getMonto() {
        double monto = 0;
        for(Articulo a : articulos) {
            monto += a.getMonto();
        }
        return monto;
    }
    
    public double getMonto(Cliente cliente) {
       double monto = getMonto();
       monto -= cliente.descuento(this);
       monto = Math.max(monto, 0);
       return monto;
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
