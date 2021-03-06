/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import persistencia.MapeadorArticulo;
import persistencia.Persistencia;
import persistencia.Persistible;


/**
 *
 * @author vincentes
 */
public class Articulo implements Persistible {
    private static int CONTADOR_ARTICULO = 0;
    private int oid;
    private int codigo;
    private Producto producto;
    private int cantidad;
    private String descripcion;
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
        this.descripcion = description;
        this.servicio = servicio;
        codigo = CONTADOR_ARTICULO++;
        this.listo = false;
    }

    public Articulo() {
    
    }
    
    public double getMonto() {
        return cantidad * producto.getPrice();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String description) {
        this.descripcion = description;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getServicioId() {
        return servicio.getId();
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
    
    public int getProductoCodigo() {
        return producto.getCodigo();
    }

    @Override
    public void guardar() {
        servicio.guardar();
    }

    public String getProductoNombre() {
        return producto.getNombre();
    }

    public double getPrecioUnitario() {
        return producto.getPrice();
    }
}
