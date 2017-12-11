/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;
import java.util.Observer;
import javafx.beans.Observable;
import restaurante.utils.Utilidades;

/**
 *
 * @author Usuario7
 */
public class SistemaProcesadora{

    private ArrayList<UPP> procesadoras = new ArrayList();

    public ArrayList<UPP> getProcesadoras() {
        return procesadoras;
    }

    public void agregar(UPP p) {
        if (!procesadoras.contains(p)) {
            procesadoras.add(p);
        }
    }

    public void agregarProducto(Producto prod, UPP proc) {
        if (prod.getProcesadora().equals(proc)) {
            proc.agregarProducto(prod);
        } else {
            prod.setProcesadora(proc);
        }
    }

   
     
    public void agregarPedido(Articulo articulo, Mozo mozo, Mesa mesa) {
        UPP procesadora = articulo.getProducto().getProcesadora();
        procesadora.agregarPedido(new Pedido(articulo, mesa));
    }

    public UPP procesadora(Producto prod) {
        for (UPP p : procesadoras) {
            if (p.getProductos().contains(prod)) {
                return p;
            }
        }
        return null;
    }

    public UPP procesadora(String nombre) {
        for (UPP p : procesadoras) {
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Producto> productosPorProcesadoraConStock(UPP procesadora) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        for (UPP proc : procesadoras) {
            if (proc.equals(procesadora)) {
                for (Producto p : proc.getProductos()) {
                    if (p.getStock() != 0) {
                        productos.add(p);
                    }
                }
            }
        }
        return productos;
    }

    public Producto getProducto(String producto) {
        for (UPP p : procesadoras) {
            for (Producto prod : p.getProductos()) {
                if (prod.getNombre().equals(producto)) {
                    return prod;
                }
            }
        }
        return null;
    }

    public boolean estaEnPedido(Articulo articulo) {
        for (UPP upp : procesadoras) {
            for (Pedido prod : upp.getPedidos()) {
                if (prod.getArticulo().equals(articulo)) {
                    return true;
                }
            }
        }
        return false;
    }

    
     //Modificación SEBA 25/10
    public UPP estaRegistradoGestorUPP(Gestor gestor) {
        for (UPP upp : procesadoras) {
            if (upp.getGestores().contains(gestor)) {
               
                return upp;
            }
        }

        return null;
    }

    public boolean registrarGestorEnUPP(Gestor gestor, UPP upp) {
        if(this.estaRegistradoGestorUPP(gestor)==null){
        return upp.registrarGestor(gestor);
    }
       return false;  
       
    }

    public void tomarPedido(Pedido pedido, Gestor gestor, UPP upp) {
        gestor.tomarPedido(pedido);
        upp.quitarPedido(pedido);
        
    }

    public void finalizarPedido(Pedido pedido, Gestor gestor, UPP upp) {
        gestor.finalizarPedido(pedido);
        
    }

    public boolean logOutGestor(Gestor gestor, UPP upp) {
        return upp.logOutGestor(gestor);
    }

    public void updateVentanasGestores() {
       for(UPP p : procesadoras)
       {
           p.avisar(Utilidades.eventosUPP.actualizar);
       }
    }

    public Articulo ingresoDeArticulo(Producto producto, int cantidad, String descripcion, Servicio servicio) {
       return new Articulo(producto, cantidad, descripcion, servicio);
        
    }
}
