/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import restaurante.dominio.Sistema;
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
        vista.aceptar();
    }
    
     public void rechazar(){
        vista.rechazar();
    }
    
}
