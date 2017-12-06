/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio.persistencia;

/**
 *
 * @author vincentes
 */
public class TipoPreferencial implements ClienteTipo {

    @Override
    public double descuento() {
        return 0;
    }
    
    
    @Override
    public String toString() {
        return "preferencial";
    }
}
