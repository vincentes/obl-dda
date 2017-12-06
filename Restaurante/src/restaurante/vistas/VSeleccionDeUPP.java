/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.vistas;

import restaurante.dominio.UPP;

/**
 *
 * @author alumnoFI
 */
public interface VSeleccionDeUPP {

    public void registrarseEnUPP();

    public void yaRegistrado(UPP upp);

    public void irAGestion();

    public void cerrarVentana();

    public void cargarCombo();

    public void error(String msg);

}
