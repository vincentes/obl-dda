/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Factura;
import modelo.Linea;
import persistencia.Mapeador;

/**
 *
 * @author docenteFI
 */
public class MapeadorFactura implements Mapeador{
    
    private Factura f;

    public MapeadorFactura() {
    }

    public MapeadorFactura(Factura f) {
        this.f = f;
    }

    public void setF(Factura f) {
        this.f = f;
    }

    public Factura getF() {
        return f;
    }

    @Override
    public int getOid() {
        return f.getOid();
    }
    @Override
    public void setOid(int oid) {
        f.setOid(oid);
    }


    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();        
        sqls.add(
                "INSERT INTO factura values (" + getOid() + "," + f.getNumero() +
                 ",'" + f.getDatosCabezal() + "')"
        );
        generarSqlLineas(sqls);
        return sqls;
    }

    
    @Override
    public ArrayList<String>  getSqlUpdate() {
         ArrayList<String> sqls = new ArrayList();   
         sqls.add("UPDATE Factura set datosCabezal = '" + f.getDatosCabezal() 
                 +"' WHERE oid=" +getOid() );
         sqls.add("DELETE from Linea where oid=" + getOid());
         generarSqlLineas(sqls);
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

    private void generarSqlLineas(ArrayList<String> sqls) {
        Linea l;
       for(int x=0;x<f.getLineas().size();x++){
           l = f.getLineas().get(x);
           sqls.add( "INSERT INTO Linea values (" + getOid() + "," +
                   f.getNumero() + "," + (x+1) + ",'" 
                   + l.getDatos() + "')"
           );
       }
    }
    
    
}
