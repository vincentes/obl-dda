/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import restaurante.dominio.Mesa;

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
    
    public static String mesas(ArrayList<Mesa> mesas) {
        String output = "";
        for (Mesa mesa : mesas) {
            output += String.format("<button class='mesa boton-mesa btn %s' id='mesa-%d' style='margin-right:10px'>%d</button>", mesa.getAbierta() ? "btn-primary" : "", mesa.getNumero(), mesa.getNumero()); 
        }
        return output;
    }
  
}
