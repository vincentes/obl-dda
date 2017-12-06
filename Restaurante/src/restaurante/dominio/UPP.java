/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;
import restaurante.utils.Observable;


/**
 *
 * @author vincentes
 */
public class UPP extends Observable{
    private String nombre; 
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();

//     private void avisar(eventos eventos) {
//        setChanged();
//        notifyObservers(eventos);
//    }

    void quitarPedido(Pedido pedido) {
        pedidos.remove(pedido);
        avisar(eventos.pedidoEnProceso);
    }

    public boolean logOutGestor(Gestor gestor, UPP upp) {
        if(!gestor.pedidosPendientes()){
            gestores.remove(gestor);
            return true;
        }else{
            return false;
        }
    }
    public enum eventos{
        pedidoEnProceso, pedidoFinalizado;
    }
    
    public ArrayList<Gestor> getGestores() {
        return gestores;
    }


    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public UPP(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<Producto>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarProducto(Producto p){
        if(!productos.contains(p)) {
            productos.add(p);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public boolean agregarPedido(Pedido e) {
        return pedidos.add(e);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(!(obj instanceof UPP)) {
            return false;
        } else {
            UPP m = (UPP) obj;
            return m.getNombre().equals(nombre);
        }
    }

    public boolean registrarGestor(Gestor gestor) {
        if(!gestores.contains(gestor)){
            gestores.add(gestor);
            gestor.registrarUPP(this);
            return true;
        }
           return false; 
    }
}
