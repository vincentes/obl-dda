/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio.persistencia;

import restaurante.dominio.Articulo;
import restaurante.dominio.Servicio;

/**
 *
 * @author vincentes
 */
public class Cliente {
    private int oid;
    private int id;
    private String email;
    private String nombre;
    private ClienteTipo tipo;

    public Cliente(int id, String email, String name, ClienteTipo tipo) {
        this.id = id;
        this.email = email;
        this.nombre = name;
        this.tipo = tipo;
    }

    public Cliente() {

    }    

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double descuento(Servicio servicio) {
        return tipo.descuento(servicio);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public ClienteTipo getTipo() {
        return tipo;
    }

    public void setTipo(ClienteTipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", nombre, tipo);
    }

    
    
    
}
