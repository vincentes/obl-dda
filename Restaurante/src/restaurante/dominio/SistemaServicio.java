/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import restaurante.dominio.SistemaServicio.ServicioEvento;
import restaurante.utils.Observable;


/**
 *
 * @author vincentes
 */
public class SistemaServicio extends Observable<ServicioEvento> {
    
    public enum ServicioEvento {
        ARTICULO_AGREGADO
    }
    
    public SistemaServicio() {
        
    }
    
    public boolean nuevoArticulo(Producto producto, int cantidad, String descripcion, Servicio servicio) {
        if(producto.getStock() >= cantidad) {
            servicio.agregar(new Articulo(producto, cantidad, descripcion, servicio));        
            producto.setStock(producto.getStock() - cantidad);
            avisar(ServicioEvento.ARTICULO_AGREGADO);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean nuevoArticulo(Articulo articulo) {
        Producto producto = articulo.getProducto();
        int cantidad = articulo.getCantidad();
        String descripcion = articulo.getDescription();
        Servicio servicio = articulo.getServicio();
        if(producto.getStock() >= cantidad) {
            servicio.agregar(articulo);        
            producto.setStock(producto.getStock() - cantidad);
            avisar(ServicioEvento.ARTICULO_AGREGADO);
            return true;
        } else {
            return false;
        }
    }
}
