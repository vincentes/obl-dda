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
public class Producto {

    public static int CONTADOR_CODIGO = 0;
    private int codigo;
    private String nombre;
    private double price;
    private int stock;
    private UPP procesadora;
    private int oid;
    
    public Producto(String nombre, UPP procesadora) {
        this.codigo = CONTADOR_CODIGO++;
        this.nombre = nombre;
        this.procesadora = procesadora;
        if(procesadora == null) {
            throw new NullPointerException("procesadora no puede ser null");
        }
    }
    
    public Producto(String nombre, double price, int stock, UPP procesadora) {
        this.codigo = CONTADOR_CODIGO++;
        this.nombre = nombre;
        this.price = price;
        this.stock = stock;
        this.nombre = nombre;
        this.procesadora = procesadora;
        if(procesadora == null) {
            throw new NullPointerException("procesadora no puede ser null");
        }
    }

    public Producto() {
    
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public UPP getProcesadora() {
        return procesadora;
    }

    public void setProcesadora(UPP procesadora) {
        if(procesadora == null) {
            throw new NullPointerException("procesadora no puede ser null");
        }
        this.procesadora = procesadora;
        
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    
    
    
    @Override
    public String toString() {
        return nombre;
    }
}
