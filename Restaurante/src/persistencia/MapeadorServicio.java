/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import restaurante.dominio.Servicio;

/**
 *
 * @author vincentes
 */
public class MapeadorServicio implements Mapeador {

    private Servicio s = new Servicio();
    
    public MapeadorServicio(Servicio servicio) {
        this.s = servicio;
    }
    
    public MapeadorServicio() {
    
    }
    
    @Override
    public int getOid() {
        return s.getOid();
    }

    @Override
    public void setOid(int oid) {
        s.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(String.format(
                "INSERT INTO Servicio(oid, id) values(%d, %d)", s.getOid(), s.getId()));
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();
        return sqls;
    }

    @Override
    public String getSqlDelete() {
        // eliminar articulos del servicio
        // eliminar servicio
        return "";
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM Servicio";
    }

    @Override
    public void crearNuevo() {
        s = new Servicio();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        
    }

    @Override
    public Object getObjeto() {
        return s;
    }
    
    public void setServicio(Servicio servicio) {
        s = servicio;
    }
    
    
}
