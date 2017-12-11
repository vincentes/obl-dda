/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import restaurante.dominio.Articulo;
import restaurante.dominio.Mesa;
import restaurante.dominio.persistencia.Cliente;

/**
 *
 * @author Dario
 */
public class Componentes {
    
    public static String lista(boolean multiple,String id,ArrayList opciones){
        String lista = "<select " + (multiple?" multiple ":"") +  " id='" + id+ "'>";
        int x=0;
        for(Object obj:opciones){
            lista+= "<option id='" + x + "'>" + obj + "</option>";
            x++;
        }
        lista+="</select>";
        return lista;
    }
    
    public static String lista(boolean multiple,String id,String[] opciones){
        String lista = "<select " + (multiple?" multiple ":"") +  " id='" + id+ "'>";
        int x=0;
        for(Object obj:opciones){
            lista+= "<option id='" + x + "'>" + obj + "</option>";
            x++;
        }
        lista+="</select>";
        return lista;
    }
    
    public static String clienteInfo(ArrayList<Articulo> arts, Cliente cliente, double montoOriginal, double montoDescuento, double descuento) {
        String info = "<ul>";
        for(Articulo a : arts) {
            info += "<li>" + a.toString() + "</li>";
        }
        info += "</ul>";
        info += String.format("Monto: %.2f <br>El monto original era %.2f, se le aplicó un descuento de $%.2f<br/>", montoDescuento, montoOriginal, descuento);
        info += "Cliente: " + cliente.getNombre() + " (" + cliente.getId() + ")<br/>";
        info += String.format("Beneficio: %s<br/><button class='btn btn-primary' id='beneficio-cerrarm'>Cerrar mesa</button>", cliente.getTipo());
        return info;
    }
    
    public static String mesas(ArrayList<Mesa> mesas) {
        String output = "";
        for (Mesa mesa : mesas) {
            output += String.format("<button class='mesa boton-mesa btn %s' id='mesa-%d' style='margin-right:10px'>%d</button>", mesa.getAbierta() ? "btn-primary" : "", mesa.getNumero(), mesa.getNumero()); 
        }
        return output;
    }
  
}
