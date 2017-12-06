/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import restaurante.dominio.Gestor;
import restaurante.dominio.Sistema;
import restaurante.dominio.UPP;
import restaurante.dominio.Usuario;
import restaurante.ui.FrameSeleccionDeUPP;
import restaurante.vistas.VSeleccionDeUPP;

/**
 *
 * @author alumnoFI
 */
public class CSeleccionDeUPP {

    private final Sistema modelo = Sistema.getInstancia();
    private VSeleccionDeUPP vista;
    private Gestor gestor;
    private UPP upp;

    public CSeleccionDeUPP(Gestor gestor, VSeleccionDeUPP vista) {
        this.gestor = gestor;
        this.vista = vista;
        vista.cargarCombo();

    }

    public void registrarseEnUPP(UPP uppRecibida) {
        if(modelo.registrarGestorEnUPP(gestor, uppRecibida) == true){
            vista.yaRegistrado(uppRecibida);
            vista.irAGestion();
            vista.cerrarVentana();
        }else{
            vista.error("Error: No se pudo registrar a la UPP");
        }
        
    }

    public void chequearYaRegistrado(Gestor gestor) {
        UPP upp = modelo.estaRegistradoGestorUPP(gestor);
        
        if (upp != null) {
            vista.yaRegistrado(upp);
            vista.irAGestion();
            vista.cerrarVentana();
        }
    }

    public void cerrar() {
        vista.error("Debe registrarse en una UPP");
    }
}
