/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import restaurante.utils.Observable;
import java.util.Observer;
import restaurante.dominio.Mesa.Evento;

/**
 *
 * @author vincentes
 */
public class Mesa extends Observable<Evento> {
    private int numero;
    private boolean abierta;
    private Servicio servicio;
    private Mozo mozo;


    public boolean getAbierta() {
        return abierta;
    }

    public void toggle() {
        if(abierta) {
            abierta = false;
            servicio = null;
        } else {
            abierta = true;
            servicio = new Servicio(this);
        }
        avisar(Evento.TOGGLE);
    }
    
    public enum Evento {
        TOGGLE
    }

    public Mesa(int numero, Mozo mozo) {
        this.numero = numero;
        this.mozo = mozo;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public int getNumero() {
        return numero;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    
    public Mozo getMozo() {
        return mozo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(!(obj instanceof Mesa)) {
            return false;
        } else {
            Mesa m = (Mesa) obj;
            return m.numero == numero;
        }
    }
}
