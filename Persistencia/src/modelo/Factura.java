/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public class Factura {
    private ArrayList<Linea> lineas = new ArrayList();
    private int oid;
    private int numero;
    private String datosCabezal;

    public Factura() {
    }

    public Factura(int numero, String datosCabezal) {
        this.numero = numero;
        this.datosCabezal = datosCabezal;
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }

    public void agregarLinea(String datos) {
        lineas.add(new Linea(datos));
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDatosCabezal() {
        return datosCabezal;
    }

    public void setDatosCabezal(String datosCabezal) {
        this.datosCabezal = datosCabezal;
    }

    @Override
    public String toString() {
        return "\nFactura{" + "lineas=" + lineas + ", oid=" + oid + ", numero=" + numero + ", datosCabezal=" + datosCabezal + '}';
    }
    
    
}
