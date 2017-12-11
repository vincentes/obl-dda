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

    public Mesa getMesa() {
        return mesa;
    }
    private Mozo mozoDestino; 

    public Mozo getMozoDestino() {
        return mozoDestino;
    }

    public Transferencia(Mesa mesa, Mozo mozoDestino) {
        this.mozoDestino = mozoDestino;
        this.mesa = mesa;
    }
    
    public String datosMozo(){
        return mesa.getMozo().getNombre();
    }
    
    public String datosMesa(){
        return "" + mesa.getNumero();
    }

    public void realizarTransferencia() {
        this.mesa.getMozo().getMesas().remove(mesa);
        this.mesa.getMozo().setTransfer(null);
        this.mesa.setMozo(mozoDestino);
        this.mozoDestino.getMesas().add(mesa);
        this.mozoDestino.setTransfer(null);
        
        
    }
}
