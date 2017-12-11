/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;
import restaurante.dominio.persistencia.Cliente;

/**
 *
 * @author vincentes
 */
public class SistemaCliente {
    private ArrayList<Cliente> clientes;
    
    public SistemaCliente() {
        clientes = new ArrayList<Cliente>();
    }

    public boolean agregar(Cliente e) {
        return clientes.add(e);
    }
    
    public Cliente get(Cliente cliente) {
        for(Cliente c : clientes) {
            if(c.equals(cliente)) {
                return cliente;
            }
        }
        return null;
    }
    
    public Cliente get(int numero) {
        for(Cliente cliente : clientes) {
            if(cliente.getId() == numero) {
                return cliente;
            }
        }
        return null;
    }
    
    
    
    
}
