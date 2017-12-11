/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.utils;

import java.util.ArrayList;
import javax.swing.JComboBox;
import restaurante.dominio.Sistema;
import restaurante.dominio.UPP;


/**
 *
 * @author alumnoFI
 */
public class Utilidades {
    
    public static void cargarComboUpp(JComboBox cboUPP){
        ArrayList<UPP> upps = Sistema.getInstancia().getSistemaProcesadora().getProcesadoras();
        for(UPP u:upps)
        {
            cboUPP.addItem(u);
        }    
    }
    
    public enum eventosUPP{
        nuevoPedido,pedidoEnProceso, pedidoFinalizado;
    }
    
    public enum eventosMozo{
        mozoLoginLogout, mozoTransfer;
    }
}
