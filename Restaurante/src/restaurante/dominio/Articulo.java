/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

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

    public Articulo(Producto producto, int cantidad, Servicio servicio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.servicio = servicio;
        codigo = CONTADOR_ARTICULO++;
    }

    public Articulo(Producto producto, int cantidad, String description, Servicio servicio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.description = description;
        this.servicio = servicio;
        codigo = CONTADOR_ARTICULO++;
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
        return producto.getNombre() + " x" + cantidad;
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
