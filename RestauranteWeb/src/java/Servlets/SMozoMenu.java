/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Vistas.VWMozoMenu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Producto;
import restaurante.dominio.Sistema;

/**
 *
 * @author vincentes
 */
@WebServlet(name = "MozoMenuServlet", urlPatterns = {"/mozo"})
public class SMozoMenu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mozo mozo = (Mozo) request.getSession(true).getAttribute("mozo");
        if(mozo == null) {
            response.sendRedirect("/login/");
            return;
        }
        
        String accion = request.getParameter("accion");
        if(accion.equals("new")){
          request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
          AsyncContext contexto = request.startAsync(); 
          contexto.getResponse().setContentType("text/event-stream");
              contexto.getResponse().setCharacterEncoding("UTF-8");
          contexto.setTimeout(0);
          VWMozoMenu vista = new VWMozoMenu(mozo, contexto);
          request.getSession().setAttribute("vista", vista);
        }else{
            VWMozoMenu vista = (VWMozoMenu) request.getSession().getAttribute("vista");
            switch (accion){
                case "mostrarMesas" : 
                    vista.mostrarMesas(mozo.getMesas()); 
                    break;
                case "avisarSeleccionada":
                    int numero = Integer.valueOf(request.getParameter("numero"));
                    Mesa mesa = mozo.getMesa(numero);
                    vista.avisarMesaSeleccionada(mesa);
                    break;
                case "toggleMesaSeleccionada":
                    vista.toggleMesaSeleccionada();
                    break;
                case "procesadoraSeleccionada":
                    String proc = request.getParameter("procesadora");
                    vista.procesadoraSeleccionada(proc);
                    break;
                case "ingresarArticulo":
                    Producto producto = Sistema.getInstancia().getProducto(request.getParameter("producto"));
                    int cantidad;
                    try {
                        cantidad = Integer.valueOf(request.getParameter("cantidad"));
                    } catch(NumberFormatException e) {
                        cantidad = Integer.MAX_VALUE;
                    }
                    String desc = request.getParameter("descripcion");
                    vista.ingresarArticulo(producto, cantidad, desc);
                    break;
                case "logout":
                    if(vista.logOutBool()) {
                        request.getSession().setAttribute("vista", null);
                        request.getSession().setAttribute("mozo", null);
                    }
                    break;
                case "buscarBeneficio":
                    int id = 0;
                    try {
                        id = Integer.valueOf(request.getParameter("id"));
                        vista.buscarBeneficio(id);
                    } catch(NumberFormatException e) {
                        vista.errorBeneficio("Cliente inválido.");
                    }
                    break;
                case "pingearMesaNoVacia":
                    vista.mesaVacia();
                    break;
            }
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
