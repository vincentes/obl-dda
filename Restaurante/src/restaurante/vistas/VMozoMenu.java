/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.vistas;

import java.util.ArrayList;
import restaurante.dominio.Mesa;

/**
 *
 * @author vincentes
 */
public interface VMozoMenu {

    public void mostrarMesas(ArrayList<Mesa> mesas);
    public void avisarMesaSeleccionada(Mesa mesa);
    public void deshabilitarAbrir();
    public void habilitarToggle();
    public void textoToggle(boolean abierta);

    public void mostrarArticulos(String[] string);

    public void actualizarProcesadores(String[] string);

    public String getProcesadoraSeleccionada();

    public void actualizarProductos(String[] prodsStr);
    public void logOut();
    
     public void error(String msg);
     public void actualizarMozosTransfer(String[] mozosStr);

    public void actualizarTransferencia();

    public void hideServicio();
public void toggleMesaSeleccionada();
    public void mostrarServicio();

    public void mesaNoVacia();
    public void ocultarServicio();
    public void ocultarMesas();

}
