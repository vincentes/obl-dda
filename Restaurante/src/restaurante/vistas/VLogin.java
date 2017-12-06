/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.vistas;

import restaurante.dominio.Gestor;
import restaurante.dominio.Mozo;
import restaurante.dominio.Usuario;

/**
 *
 * @author vincentes
 */
public interface VLogin {
    public void login(Gestor usr);
    public void login(Mozo usr);
    public void error(String msg);
}
