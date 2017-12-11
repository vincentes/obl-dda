/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.Observable;
import java.util.Observer;
import restaurante.dominio.Gestor;
import restaurante.dominio.Pedido;
import restaurante.dominio.Sistema;
import restaurante.dominio.UPP;
import restaurante.dominio.Usuario;
import restaurante.vistas.VGestionDePedidos;
import restaurante.vistas.VSeleccionDeUPP;

/**
 *
 * @author alumnoFI
 */
public class CGestionDePedidos implements Observer {

    private final Sistema modelo = Sistema.getInstancia();
    private VGestionDePedidos vista;
    private Gestor gestor;
    private UPP upp;

    public CGestionDePedidos(VGestionDePedidos vistaGestion, Gestor gestor, UPP upp) {
        this.vista = vistaGestion;
        this.gestor = gestor;
        this.upp = upp;
        upp.addObserver(this);
    }

    @Override
    public void update(Observable o, Object evento) {
        
        vista.actualizar();
    }

    public void tomarPedido(Object pedidoSeleccionado) {
        if (pedidoSeleccionado instanceof Pedido) {
            modelo.tomarPedido(((Pedido)pedidoSeleccionado), gestor, upp);
        }
        
    }

    public void finalizarPedido(Object pedidoSeleccionado) {
         if (pedidoSeleccionado instanceof Pedido) {
            modelo.finalizarPedido(((Pedido)pedidoSeleccionado), gestor, upp);
        }
    }

    public void cerrarVentana() {
        if(modelo.logOutGestor(gestor, upp)){
            upp.deleteObserver(this);
            vista.cerrar();
        }else{
            vista.error("Usted aún tiene pedidos sin finalizar");
        }
    }

}
