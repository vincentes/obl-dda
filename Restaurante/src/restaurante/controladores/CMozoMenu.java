/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import restaurante.dominio.Articulo;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Producto;
import restaurante.dominio.Servicio;
import restaurante.dominio.Sistema;
import restaurante.dominio.SistemaMozo;
import restaurante.dominio.UPP;
import restaurante.dominio.Usuario;
import restaurante.vistas.VMozoMenu;

/**
 *
 * @author vincentes
 */
public class CMozoMenu  {
    private final Sistema modelo = Sistema.getInstancia();
    private Mozo mozo;
    private VMozoMenu vista;
    private Mesa seleccionada;
    
    public CMozoMenu(Mozo mozo, VMozoMenu vista) {
        this.mozo = mozo;
        this.vista = vista;
        vistaSinSeleccion();
        cargarDatosListas();
    }

    private void vistaSinSeleccion() {
        vista.mostrarMesas(mozo.getMesas());
        vista.deshabilitarAbrir();
    }

    public void setSeleccionada(Mesa seleccionada) {
        this.seleccionada = seleccionada;
        actualizarMesaSeleccionada();
    }

    public void actualizarMesaSeleccionada() {
        vista.avisarMesaSeleccionada(seleccionada);
        vista.habilitarToggle();
        vista.textoToggle(seleccionada.getAbierta());
    }
    
    public void abrirMesaSeleccionada() {
        seleccionada.setAbierta(true);
        cargarDatosListas();
    }

    public Mesa getSeleccionada() {
        return seleccionada;
    }

    public boolean toggleMesaSeleccionada() {
        if(seleccionada.getAbierta()) {
            if(Sistema.getInstancia().isCerreable(seleccionada)) {
                seleccionada.toggle();
            } else {
                return false;
            }
        } else {
            seleccionada.toggle();
        }
        cargarDatosListas();
        return true;
    }

    private void cargarDatosListas() {
        if(seleccionada != null && seleccionada.getAbierta()) {
            actualizarArticulos();
            actualizarProcesadores();
            actualizarProductos();
        }
    }

    public void actualizarArticulos() {
        Servicio servicio = seleccionada.getServicio();
        if(servicio != null) {
            ArrayList<Articulo> articulos = servicio.getArticulos();
            String[] articulosStr = new String[articulos.size()];
            for(int i = 0; i < articulos.size(); i++) {
                articulosStr[i] = articulos.get(i).toString();
            }
            vista.mostrarArticulos(articulosStr);
        }
    }
    
    public void actualizarProcesadores() {
        ArrayList<UPP> procs = Sistema.getInstancia().getProcesadoras();
        String[] procsStr = new String[procs.size()];
        for(int i = 0; i < procs.size(); i++) {
            procsStr[i] = procs.get(i).toString();
        }
        vista.actualizarProcesadores(procsStr);
    }
    
    public void actualizarProductos() {
        UPP procesadora = Sistema.getInstancia().procesadora(vista.getProcesadoraSeleccionada());
        ArrayList<Producto> prods = Sistema.getInstancia().productosPorProcesadoraConStock(procesadora);
        String[] prodsStr = new String[prods.size()];
        for(int i = 0; i < prods.size(); i++) {
            prodsStr[i] = prods.get(i).toString();
        }
        vista.actualizarProductos(prodsStr);
    }
    
    
    public boolean ingresar(String producto, int cantidad, String descripcion) {
        Producto prod = Sistema.getInstancia().getProducto(producto);
        
        Articulo articulo = Sistema.getInstancia().ingresarArticulo(prod, cantidad, descripcion, seleccionada.getServicio());
        if(articulo != null) {
            actualizarArticulos();
            actualizarProductos();
        }
        return articulo != null;
    }

}
