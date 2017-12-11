/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

/**
 *
 * @author alumnoFI
 */
public class Pedido {

   
    private Articulo articulo;
    private Mesa mesa;
    private boolean finalizado = false;
    

     public Pedido(Articulo articulo, Mesa mesa) {
        this.articulo = articulo;
        this.mesa = mesa;
    }
     
    public Articulo getArticulo() {
        return articulo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    @Override
    public String toString() {
        return articulo.getProducto().getNombre() + " - Cantidad: " + articulo.getCantidad()  + " - " + articulo.getDescripcion()  + " - Mesa: " + mesa.getNumero()  + " - " + mesa.getMozo().nombre;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
    
    
}
