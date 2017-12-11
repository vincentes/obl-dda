/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import restaurante.dominio.Sistema;
import restaurante.utils.Utilidades;
import restaurante.vistas.VTransferencia;



/**
 *
 * @author L&S
 */
public class CTransferencia {
    private final Sistema modelo = Sistema.getInstancia();
    private VTransferencia vista;
    

    public CTransferencia(VTransferencia vista) {
       
        this.vista = vista;
        

    }
    
    public void aceptar(){
        modelo.avisar(Utilidades.eventosMozo.transferAccepted);
        vista.cerrarVentana();
    }
    
     public void rechazar(){
        modelo.avisar(Utilidades.eventosMozo.transferRejected);
        vista.cerrarVentana();
    }
    
}
