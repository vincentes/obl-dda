/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Utils.ESWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurante.controladores.CLogin;
import restaurante.controladores.CMozoMenu;
import restaurante.dominio.Mesa;
import restaurante.vistas.VMozoMenu;
import restaurante.dominio.Mozo;
import Utils.Componentes;
import restaurante.dominio.Producto;
import restaurante.dominio.Sistema;
import restaurante.dominio.persistencia.Cliente;
/**
 *
 * @author vincentes
 */
public class VWMozoMenu implements VMozoMenu {
    private CMozoMenu controlador;
    private HttpServletResponse response; 
    private HttpServletRequest request;
    private AsyncContext contexto;
    private ESWriter out;

    public VWMozoMenu(Mozo mozo, AsyncContext contexto) {
        this.contexto = contexto;
        out = new ESWriter(contexto);
        controlador = new CMozoMenu(mozo, this);
        out.enviar("titulo", String.format("%s (%s)", mozo.getNombre(), mozo.getCantMesas()));
    }
    
    @Override
    public void mostrarMesas(ArrayList<Mesa> mesas) {
        out.enviar("mostrarMesas", Componentes.mesas(mesas));
    }

    @Override
    public void avisarMesaSeleccionada(Mesa mesa) {
        if(mesa != null) {
            controlador.setSeleccionada(mesa);
        }
    }
    
    @Override
    public void toggleMesaSeleccionada() {
        controlador.toggleMesaSeleccionada();
    }
    
    public void mesaNoVacia() {
        out.enviar("cerreable", "");
    }
    
    @Override
    public void hideServicio() {
        out.enviar("hideListas", "");
    }

    @Override
    public void deshabilitarAbrir() {
        out.enviar("deshabilitarToggle", "");
    }

    @Override
    public void habilitarToggle() {
        out.enviar("habilitarToggle", "");
    }

    @Override
    public void textoToggle(boolean abierta) {
        out.enviar("textoToggle", String.valueOf(abierta));
    }

    @Override
    public void mostrarArticulos(String[] string) {
        out.enviar("mostrarArticulos", Componentes.lista(true, "articulos", string));
    }

    @Override
    public void actualizarProcesadores(String[] string) {
        out.enviar("mostrarProcesadores", Componentes.lista(false, "procesadores", string));
    }

    @Override
    public String getProcesadoraSeleccionada() {
        return "";
    }
    
    public void procesadoraSeleccionada(String proc) {
        controlador.actualizarProductos(proc);
    }

    @Override
    public void actualizarProductos(String[] prodsStr) {
        out.enviar("mostrarProductos", Componentes.lista(false, "productos", prodsStr));
    }

    @Override
    public void mostrarServicio() {
        out.enviar("mostrarServicio", "");
    }

    public void ingresarArticulo(Producto producto, int cantidad, String desc) {
        controlador.ingresar(producto, cantidad, desc);
    }

    public boolean logOutBool() {
        return controlador.logOut();
    }

    @Override
    public void logOut() {
        out.enviar("logoutExitoso", "");
    }

    @Override
    public void error(String msg) {
        out.enviar("errorVista", msg);
    }

    @Override
    public void actualizarMozosTransfer(String[] mozosStr) {
    }

    @Override
    public void actualizarTransferencia() {
    }

    public void buscarBeneficio(int numero) {
        Cliente cliente = Sistema.getInstancia().getCliente(numero);
        if(cliente == null) {
            errorBeneficio("Cliente inválido.");
        }
        out.enviar("beneficio", Componentes.clienteInfo(controlador.getArticulos(), cliente, controlador.getMonto(), controlador.getAplicarDescuento(cliente), controlador.getDescuento(cliente)));
    }
    
    public void buscarBeneficio(Cliente cliente) {
        
    }

    public void errorBeneficio(String msg) {
        out.enviar("errorBeneficio", msg);
    }

    public void mesaVacia() {
        controlador.mesaVacia();
    }

    @Override
    public void ocultarServicio() {    }

    @Override
    public void ocultarMesas() {
    }

}
