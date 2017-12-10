/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import restaurante.controladores.CMozoMenu;

/**
 *
 * @author vincentes
 */
public class ESWriter  {
    private PrintWriter out;
    
    public ESWriter(AsyncContext context) {
        try {
            out = context.getResponse().getWriter();
        } catch(IOException e) {
            System.out.println("Error al obtener el writer del stream.");
        }
    }
    
    public void enviar(String evento, String data) {
        out.write("event: " + evento + "\n");
        if(data!=null) {
            data = data.replace("\n", "");
        }
        out.write("data: " + data + "\n\n");
        if(!out.checkError()) {
            System.out.println("Enviado");
        } else {
            System.out.println("Error");
        }
    }
}
