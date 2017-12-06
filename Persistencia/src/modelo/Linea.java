/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author docenteFI
 */
public class Linea {
    private String datos;

    public Linea() {
    }

    public Linea(String datos) {
        this.datos = datos;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "\nLinea{" + "datos=" + datos + '}';
    }
    
}
