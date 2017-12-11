/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import restaurante.dominio.Articulo;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Producto;
import restaurante.dominio.Servicio;
import restaurante.dominio.Sistema;
import restaurante.dominio.SistemaMozo;
import restaurante.dominio.Transferencia;
import restaurante.dominio.UPP;
import restaurante.dominio.Usuario;
import restaurante.dominio.persistencia.Cliente;
import restaurante.utils.Utilidades;
import restaurante.vistas.VMozoMenu;

/**
 *
 * @author vincentes
 */
public class CMozoMenu implements Observer {

    private final Sistema modelo = Sistema.getInstancia();
    private Mozo mozo;
    private VMozoMenu vista;
    private Mesa seleccionada;
    private Transferencia transferencia;

    public CMozoMenu(Mozo mozo, VMozoMenu vista) {
        this.mozo = mozo;
        this.vista = vista;
        vistaSinSeleccion();
        cargarDatosListas();
        modelo.addObserver(this);

    }

    private void vistaSinSeleccion() {
        if (mozo.getMesas().size() > 0) {
            vista.mostrarMesas(mozo.getMesas());
        } else {
            vista.ocultarMesas();
            vista.error("Ud ya no tiene mesas asignadas");
        }

        vista.deshabilitarAbrir();
        vista.ocultarServicio();

    }

    public void setSeleccionada(Mesa seleccionada) {
        this.seleccionada = seleccionada;
        vista.habilitarToggle();
        vista.textoToggle(seleccionada.getAbierta());
        if(seleccionada.getAbierta()) {
            vista.mostrarServicio();
            cargarDatosListas();
        } else {
            vista.hideServicio();
        }
    }

    public void actualizarMesaSeleccionada() {
        vista.avisarMesaSeleccionada(seleccionada);
    }

    public void abrirMesaSeleccionada() {
        if(seleccionada != null) {
            seleccionada.setAbierta(true);
            cargarDatosListas();
            vista.mostrarMesas(mozo.getMesas());
        } 
    }

    public Mesa getSeleccionada() {
        return seleccionada;
    }

    public boolean toggleMesaSeleccionada() {
        boolean ret = true;
        if (seleccionada.getAbierta()) {
            if (seleccionada.getServicio() == null) {
                ret = false;
            }
            for (Articulo articulo : seleccionada.getServicio().getArticulos()) {
                if (modelo.estaEnPedido(articulo)) {
                    ret = false;
                }
//            if(sGestores.procesando(articulo)) {
//                
//            }
            }

            if (ret) {
                seleccionada.toggle();
                vista.deshabilitarAbrir();
                vista.textoToggle(false);
                vista.hideServicio();
                vista.mostrarMesas(mozo.getMesas());
            } else {
                vista.error("No puede cerrar una mesa teniendo pedidos pendientes.");
                return false;
            }
        } else {
            seleccionada.toggle();
            vista.habilitarToggle();
            vista.textoToggle(true);
            vista.mostrarMesas(mozo.getMesas());
            vista.mostrarServicio();
        }
        cargarDatosListas();
        return true;
    }

    private void cargarDatosListas() {
        if (seleccionada != null && seleccionada.getAbierta()) {
            actualizarArticulos();
            actualizarProcesadores();
            actualizarProductos();
        }
    }

    public void actualizarArticulos() {
        Servicio servicio = seleccionada.getServicio();
        if (servicio != null) {
            ArrayList<Articulo> articulos = servicio.getArticulos();
            String[] articulosStr = new String[articulos.size()];
            for (int i = 0; i < articulos.size(); i++) {
                Articulo obtenido = articulos.get(i);
                articulosStr[i] = obtenido.toString();
                if (obtenido.getListo() && !obtenido.getAvisado()) {
                    vista.error("Pedido Listo:\n" + obtenido.toString() + " - Mesa: " + servicio.getMesa().getNumero());
                    obtenido.setAvisado(true);
                }
            }
            vista.mostrarArticulos(articulosStr);
        }
    }

    public void actualizarProcesadores() {
        ArrayList<UPP> procs = Sistema.getInstancia().getProcesadoras();
        String[] procsStr = new String[procs.size()];
        for (int i = 0; i < procs.size(); i++) {
            procsStr[i] = procs.get(i).toString();
        }
        vista.actualizarProcesadores(procsStr);
    }

    public void actualizarProductos() {
        UPP procesadora = Sistema.getInstancia().procesadora("Cocina");
        ArrayList<Producto> prods = Sistema.getInstancia().productosPorProcesadoraConStock(procesadora);
        String[] prodsStr = new String[prods.size()];
        for(int i = 0; i < prods.size(); i++) {
            prodsStr[i] = prods.get(i).toString();
        }
        vista.actualizarProductos(prodsStr);
    }
    
    public void actualizarProductos(String proc) {
        UPP procesadora = Sistema.getInstancia().procesadora(proc);
        ArrayList<Producto> prods = Sistema.getInstancia().productosPorProcesadoraConStock(procesadora);
        String[] prodsStr = new String[prods.size()];
        for (int i = 0; i < prods.size(); i++) {
            prodsStr[i] = prods.get(i).toString();
        }
        vista.actualizarProductos(prodsStr);
    }

    public ArrayList<Mozo> mozosLogueados() {
        ArrayList<Mozo> mozos = new ArrayList(Sistema.getInstancia().getMozosLogueados());
        if (mozos.contains(this.mozo)) {
            mozos.remove(mozo);
        }

        return mozos;
    }

    public void actualizarMozosTransferencia() {
        String[] mozosStr = new String[mozosLogueados().size()];

        for (int i = 0; i < mozosLogueados().size(); i++) {

            mozosStr[i] = mozosLogueados().get(i).getNombre();

        }
        vista.actualizarMozosTransfer(mozosStr);
    }

    public void actualizarTransferencia() {
        
        vista.actualizarTransferencia();
    }

    public boolean ingresar(String producto, int cantidad, String descripcion) {
        Producto prod = Sistema.getInstancia().getProducto(producto);
        prod.getProcesadora().addObserver(this);
        Articulo articulo = modelo.ingresarArticulo(prod, cantidad, descripcion, seleccionada.getServicio());
        boolean resultado = modelo.nuevoArticulo(articulo);
        modelo.agregarPedido(articulo, seleccionada.getServicio().getMesa().getMozo(), seleccionada.getServicio().getMesa());
        if (!resultado) {
            articulo = null;
        }

        if (articulo != null) {
            actualizarArticulos();
            actualizarProductos();
        }
        return articulo != null;
    }
    
    public boolean ingresar(Producto producto, int cantidad, String descripcion) {        
        if(cantidad < 1) {
            vista.error("Por favor introduzca una cantidad válida mayor a cero.");
            return false;
        }
        Articulo articulo = modelo.ingresarArticulo(producto, cantidad, descripcion, seleccionada.getServicio());
        modelo.agregarPedido(articulo, mozo, seleccionada);
        
        if(articulo != null) {
            actualizarArticulos();
            actualizarProductos();
        } else {
            vista.error("La cantidad introducida en tu orden supera al stock disponible.");
        }
        return articulo != null;
    }
    
    public boolean logOut() {
        if (mozo.getTransfer() == null) {
            if (modelo.logOutMozo(mozo)) {
                modelo.deleteObserver(this);
                vista.logOut();
                return true;
            } else {
                vista.error("Usted aún tiene mesas abiertas");
                return false;
            }
        } else {
            vista.error("Usted aún tiene una transferencia pendiente");
            return false;
        }
    }
    
    public double getMonto() {
        return seleccionada.getMonto();
    }
    
    public double getAplicarDescuento(Cliente cliente) {
        return seleccionada.getMonto(cliente);
    }
    
    public double getDescuento(Cliente cliente) {
        return seleccionada.getDescuento(cliente);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento.equals(Utilidades.eventosUPP.pedidoFinalizado)) {
            actualizarArticulos();
        }
        if (evento.equals(Utilidades.eventosMozo.mozoLoginLogout)) {
            actualizarMozosTransferencia();
        }
        if (evento.equals(Utilidades.eventosMozo.mozoTransfer)) {

            actualizarTransferencia();
        }
        if (evento.equals(Utilidades.eventosMozo.transferRejected)) {
            transferenciaRechazada();
        }
        if (evento.equals(Utilidades.eventosMozo.transferAccepted)) {
            transferenciaAceptada();
        }
        if (evento.equals(Utilidades.eventosMozo.transferCompleted)) {
            transferenciaCompletada();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void transferirMesa(int numero) {

        Mozo mozoDestino = mozosLogueados().get(numero);
        if (mozoDestino != null) {
            if (mozo.getTransfer() == null) {
                this.transferencia = modelo.transferirMesa(seleccionada, mozoDestino);
                if (this.transferencia == null) {
                    vista.error("Se ha producido un error al transferir");
                }
//            else {
//                vista.error("Transferencia Solicitada:\n Mozo destino: " + transferencia.getMozoDestino().getNombre() + " - Mesa: " + transferencia.getMesa().getNumero());
//            }
            } else {
                vista.error("No se puede iniciar una transferencia nueva\nhasta no finalizar la que está en curso");
            }

        } else {
            vista.error("No hay mozos disponibles por el momento");
        }
    }

    private void transferenciaRechazada() {
        if (transferencia != null) {

            if (transferencia.getMesa().getMozo().equals(mozo)) {
                vista.error(transferencia.getMozoDestino().getNombre() + " rechazó la transferencia de la mesa " + transferencia.getMesa().getNumero());
            }
            //nulleamos ambas transferencias
            nullearTransfer();
        }
    }

    private void nullearTransfer() {
        transferencia.getMozoDestino().setTransfer(null);
        transferencia.getMesa().getMozo().setTransfer(null);
        transferencia = null;
    }

    private void transferenciaAceptada() {
        if (transferencia != null) {
            if (transferencia.getMesa().getMozo().equals(mozo)) {
                vista.error(transferencia.getMozoDestino().getNombre() + " aceptó la transferencia de la mesa " + transferencia.getMesa().getNumero());
            }
            transferencia.realizarTransferencia();
            nullearTransfer();
            modelo.avisar(Utilidades.eventosMozo.transferCompleted);

//            if (transferencia.getMozoDestino().equals(mozo)) {
//                System.out.println("ACC mozo destino recibe mesa tr");
//            }
        }

    }

    private void transferenciaCompletada() {
        vistaSinSeleccion();
        modelo.updateVentanasGestores();
    }

    public void cerrarMesaSeleccionada() {
        if(seleccionada != null) {
            seleccionada.setAbierta(false);
            vista.mostrarMesas(mozo.getMesas());
        }
    }

    public boolean logout() {
        return Sistema.getInstancia().logOutMozo(mozo);
    }
 
    public ArrayList<Articulo> getArticulos() {
        return seleccionada.getArticulos();
    }

    public void mesaVacia() {
        if(Sistema.getInstancia().isCerreable(seleccionada)) {
            if(seleccionada.getMonto() == 0) {
                vista.toggleMesaSeleccionada();
            } else {
                vista.mesaNoVacia();
            }
        }
        else {
            vista.toggleMesaSeleccionada();
        }
    }
}
