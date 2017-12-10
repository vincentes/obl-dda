/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import restaurante.utils.Utilidades;

/**
 *
 * @author vincentes
 */
public class Articulo {
    private static int CONTADOR_ARTICULO = 0;
    private int codigo;
    private Producto producto;
    private int cantidad;
    private String description;
    private Servicio servicio;
    private boolean listo;
    private boolean avisado = false;


    public Articulo(Producto producto, int cantidad, Servicio servicio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.servicio = servicio;
        codigo = CONTADOR_ARTICULO++;
        this.listo = false;
    }

    public Articulo(Producto producto, int cantidad, String description, Servicio servicio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.description = description;
        this.servicio = servicio;
        codigo = CONTADOR_ARTICULO++;
        this.listo = false;
    }

    public boolean getListo() {
        return this.listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }
    
     public boolean getAvisado() {
        return this.avisado;
    }

    public void setAvisado(boolean a) {
        this.avisado = a;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Producto getProducto() {
        return producto;
    }
    
        @Override
    public String toString() {
        String status = "Pendiente";
        if(this.listo) status = "Finalizado";
        return producto.getNombre() + " x" + cantidad + " - " + status;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo;
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
        final Articulo other = (Articulo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
}
