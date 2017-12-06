/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import mapeadores.MapeadorFactura;
import modelo.Factura;
import persistencia.Persistencia;


/**
 *
 * @author alumnoFI
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Persistencia p = Persistencia.getInstancia();
         MapeadorFactura mf = new MapeadorFactura();
         Factura f = new Factura(5006, "Datos cabezal 5006");
         f.agregarLinea("Datos linea 1 - 5006");
         //f.agregarLinea("Datos linea 2 - 5002");
         //f.agregarLinea("Datos linea 3 - 5002");
         mf.setF(f);
         p.guardar(mf);
         f.setDatosCabezal("Datos Cabezal nuevo para 5006");
         f.getLineas().remove(0);
         f.agregarLinea("L1 - 5006");
         f.agregarLinea("L2 - 5006");
         //p.guardar(mf);
       //  Usuario u = new Usuario("Pedro con MapeadorU","mp");
         //MapeadorUsuario mu = new MapeadorUsuario();
        // mu.setU(u);
        // p.guardar(mu);
         //System.out.println(p.obtenerTodos(mu));
         
         //System.out.println(p.buscar(mu,"nombre =''"));
                 
         
    }
    
}
