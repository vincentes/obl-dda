/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.Mapeador;
import restaurante.dominio.persistencia.Cliente;

/**
 *
 * @author vincentes
 */
public class MapeadorCliente implements Mapeador {

    private Cliente cliente;

    public MapeadorCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public MapeadorCliente() {
    
    }
    
    @Override
    public int getOid() {
        return cliente.getOid();
    }

    @Override
    public void setOid(int oid) {
        cliente.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(String.format("INSERT INTO Cliente(oid, cliente_id, cliente_nombre, cliente_email) values(%d, %d, %s, %s)", getOid(), cliente.getId(), cliente.getNombre(), cliente.getEmail()));
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(String.format("UPDATE Cliente set cliente_nombre='%s', cliente_email='%s', cliente_tipo='%s'", cliente.getNombre(), cliente.getEmail(), cliente.getTipo()));
        return sqls;
    }

    @Override
    public String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
