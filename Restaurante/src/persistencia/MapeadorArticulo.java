/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import restaurante.dominio.Articulo;
import restaurante.dominio.Sistema;
import restaurante.dominio.persistencia.Cliente;
import restaurante.dominio.persistencia.ClienteTipo;

/**
 *
 * @author vincentes
 */
public class MapeadorArticulo implements Mapeador {
    private Articulo articulo;

    public MapeadorArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public MapeadorArticulo() {
        
    }
    
    @Override
    public int getOid() {
        return articulo.getOid();
    }

    @Override
    public void setOid(int oid) {
        articulo.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(String.format(
                "INSERT INTO Articulo(oid, codigo, producto, cantidad, descripcion, servicio) values(%d, %d, %d, %d, '%s', %d)", getOid(), articulo.getCodigo(), articulo.getProductoCodigo(), articulo.getCantidad(), articulo.getDescripcion(), articulo.getServicioId()));
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(String.format("UPDATE Articulo set producto = %d, cantidad = %d, descripcion = %s, servicio = %d", articulo.getProductoCodigo(), articulo.getCantidad(), articulo.getDescripcion(), articulo.getServicioId()));
        return sqls;
    }

    @Override
    public String getSqlDelete() {
        return String.format("DELETE FROM Articulo where oid = %d", articulo.getOid());
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM Articulo";
    }

    @Override
    public void crearNuevo() {
        articulo = new Articulo();
    }

    @Override
    public void cargarDatos(ResultSet rs) throws SQLException {
        articulo.setOid(rs.getInt("oid"));
        articulo.setCodigo(rs.getInt("codigo"));
        articulo.setCantidad(rs.getInt("cantidad"));
        articulo.setDescripcion(rs.getString("descripcion"));
        // articulo.setProducto(Sistema.getInstancia().getProducto(rs.getInt("articulo_producto")));
        // articulo.setServicio();
    }

    @Override
    public Object getObjeto() {
        return articulo;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
