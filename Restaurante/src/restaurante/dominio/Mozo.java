/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;

/**
 *
 * @author vincentes
 */
public class Mozo extends Usuario {
    
    public enum MozoInternoEvento {
        PENDIENTE
    }
    
    private ArrayList<Mesa> mesas;
    private ArrayList<Mesa> transferencia = new ArrayList<Mesa>();
    private Transferencia transfer;
    //Seba:

    public Transferencia getTransfer() {
        return transfer;
    }

    public void setTransfer(Transferencia transfer) {
        this.transfer = transfer;
    }
    
    
    public Mozo(String usuario, String password) {
        super(usuario, password);
        mesas = new ArrayList<Mesa>();
        
    }

    public Mozo(String usuario, String password, String nombre) {
        super(usuario, password, nombre, ModoSistema.MOZO);
        mesas = new ArrayList<Mesa>();
    }

    public void agregarMesa(Mesa mesa) {
        if(!mesas.contains(mesa)) {
            mesa.setMozo(this);
            mesas.add(mesa);
        }     
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    

    public void transferir(Mesa seleccionada) {
        transferencia.add(seleccionada);
        avisar(MozoInternoEvento.PENDIENTE);
    }
    
    public boolean tieneMesasAbiertas(){
        for(Mesa m : mesas)
        {
            if(m.isAbierta())
                return true;
        }
        return false;
    }
}
