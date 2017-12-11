/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

/**
 *
 * @author L&S
 */
public class Transferencia {
   
    private Mesa mesa;

    public Transferencia(Mesa mesa) {
        
        this.mesa = mesa;
    }
    
    public String datosMozo(){
        return mesa.getMozo().getNombre();
    }
    
    public String datosMesa(){
        return "" + mesa.getNumero();
    }
}
