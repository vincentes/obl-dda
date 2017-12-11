/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;
import restaurante.utils.Utilidades;

/**
 *
 * @author vincentes
 */
public class Gestor extends Usuario {
    private UPP upp;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    public UPP getUpp() {
        return upp;
    }

    public void setUpp(UPP upp) {
        this.upp = upp;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    public Gestor(String usuario, String password) {
        super(usuario, password);
    }

    public Gestor(String usuario, String password, String nombre) {
        super(usuario, password, nombre,  ModoSistema.GESTOR);
    }

    public void tomarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void finalizarPedido(Pedido pedido) {
        pedido.getArticulo().setListo(true);
        this.pedidos.remove(pedido);
        upp.avisar(Utilidades.eventosUPP.pedidoFinalizado);
    }

    public void registrarUPP(UPP uppRecibida) {
        this.upp = uppRecibida;
    }

    public boolean pedidosPendientes() {
        return this.pedidos.size() > 0;
    }
}
