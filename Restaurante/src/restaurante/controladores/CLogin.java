/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import restaurante.dominio.Gestor;
import restaurante.dominio.ModoSistema;
import restaurante.dominio.Mozo;
import restaurante.dominio.Sistema;
import restaurante.dominio.Usuario;
import restaurante.utils.Utilidades;
import restaurante.vistas.VLogin;

/**
 *
 * @author vincentes
 */
public class CLogin  {
    private final Sistema modelo = Sistema.getInstancia();
    private VLogin vista;
    
    public CLogin(VLogin vista) {
        this.vista = vista;
    }
    
    public void loginMozo(String usuario, String password) {
        
        if(modelo.getSMozos().logueado(usuario)) {
            vista.error("El Mozo ya se encuentra logueado.");
            return;
        }
        
        Mozo mozo = modelo.getSMozos().login(usuario, password);
        if(mozo != null) {
                    vista.login((Mozo) mozo);
                    modelo.avisar(Utilidades.eventosMozo.mozoLoginLogout);
                
        }
        else {
            vista.error("La combinación de usuario y contraseña introducida es incorrecta.");
        }
    }
    
    public void loginGestor(String usuario, String password) {
        
        if(modelo.getSGestores().logueado(usuario)) {
            vista.error("El Gestor ya se encuentra logueado.");
            return;
        }
        
        Gestor gestor = modelo.getSGestores().login(usuario, password);
        if(gestor != null) {
            if(gestor.getUpp() != null){
                vista.login((Gestor) gestor);
            }else{
                vista.seleccionUPP((Gestor) gestor);
            }
                    
                
        }
        else {
            vista.error("La combinación de usuario y contraseña introducida es incorrecta.");
        }
    }
}
