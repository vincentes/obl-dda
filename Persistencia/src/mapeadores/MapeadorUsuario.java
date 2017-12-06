/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;
import persistencia.Mapeador;

/**
 *
 * @author docenteFI
 */
public class MapeadorUsuario implements Mapeador{
    
    private Usuario u;

    public MapeadorUsuario() {
    }

    public MapeadorUsuario(Usuario u) {
        this.u = u;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
    

    @Override
    public int getOid() {
        return u.getOid();
    }
    @Override
    public void setOid(int oid) {
        u.setOid(oid);
    }
    

    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add( "INSERT INTO usuario (oid,nombre,password) values (" 
                + getOid() + ",'" + u.getNombre() + "','" + u.getPassword() + "')");        
        return sqls;
    }

    @Override
    public ArrayList<String>  getSqlUpdate() {
       ArrayList<String> sqls = new ArrayList();
       sqls.add( "UPDATE usuario set nombre='" + u.getNombre() 
               + "',password='" + u.getPassword() + "' WHERE oid=" + u.getOid()
       );
       return sqls;
        
    }

    @Override
    public String getSqlDelete() {
        return "DELETE FROM usuario WHERE oid=" + u.getOid();
        
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM usuario ";
    }

    @Override
    public void crearNuevo() {
       u = new Usuario();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        u.setNombre(rs.getString("nombre"));
        u.setPassword(rs.getString("password"));
        
    }

    @Override
    public Object getObjeto() {
        return u;
    }

    
}
