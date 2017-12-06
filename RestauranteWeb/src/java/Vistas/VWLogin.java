/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurante.controladores.CLogin;
import restaurante.dominio.Gestor;
import restaurante.dominio.Mozo;
import restaurante.dominio.Sistema;
import restaurante.vistas.VLogin;

/**
 *
 * @author alumnoFI
 */
public class VWLogin implements VLogin {
    private CLogin controlador;
    private HttpServletResponse response; 
    private HttpServletRequest request; 
    
    public VWLogin() {
        controlador = new CLogin(this);
    }
    
    @Override
    public void error(String msg) {
        try { 
            response.sendRedirect("index.jsp?msg=" + msg);
        } catch (IOException ex) {
            System.out.println("Error al redirect:" + ex.getMessage());
        }
    }
    
    public void login(HttpServletRequest req,HttpServletResponse res) {
        String usr = req.getParameter("usuario");
        String pass = req.getParameter("pass");
        response = res;
        request = req;
        controlador.loginMozo(usr, pass);
    }

    @Override
    public void login(Gestor usr) {
        
    }

    @Override
    public void login(Mozo usr) {
        try {
            request.getSession(true).setAttribute("mozo", usr);
            response.sendRedirect("home.jsp");
        } catch (IOException ex) {
            Logger.getLogger(VWLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
