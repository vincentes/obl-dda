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
public class TipoCasa implements ClienteTipo {

    public static final String ETIQUETA = "casa"; 
    
    @Override
    public double descuento(Servicio servicio) {
        return 500;
    }

    @Override
    public String toString() {
        return ETIQUETA;
    }
}
