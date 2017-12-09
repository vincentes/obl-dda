/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio.persistencia;

import restaurante.dominio.Servicio;

/**
 *
 * @author vincentes
 */
public interface ClienteTipo {

    public static ClienteTipo traducir(String string) {
        switch(string) {
            case TipoCasa.ETIQUETA:
                return new TipoCasa();
            case TipoComun.ETIQUETA:
                return new TipoComun();
            case TipoPreferencial.ETIQUETA:
                return new TipoPreferencial();
        }
        return null;
    }
    
    public double descuento();
}
