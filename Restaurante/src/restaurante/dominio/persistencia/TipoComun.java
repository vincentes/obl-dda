/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio.persistencia;

import restaurante.dominio.Articulo;
import restaurante.dominio.Servicio;

/**
 *
 * @author vincentes
 */
public class TipoComun implements ClienteTipo {

    public static final String ETIQUETA = "comun"; 
    
    @Override
    public double descuento(Servicio servicio) {
        double descuento = 0;
        for(Articulo a : servicio.getArticulos()) {
            if(a.getProductoNombre().equals("Café")) {
                descuento += a.getMonto();
            }
        }
        return descuento;
    }
    
    @Override
    public String toString() {
        return ETIQUETA;
    }

}
