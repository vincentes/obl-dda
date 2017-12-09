/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import restaurante.dominio.Articulo;
import restaurante.dominio.Producto;
import restaurante.dominio.UPP;
import restaurante.dominio.Servicio;

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
        MapeadorArticulo artMap = new MapeadorArticulo();
        MapeadorServicio servMap = new MapeadorServicio();
        
        Servicio servicio = new Servicio();
        servMap.setServicio(servicio);
        
        Producto producto = new Producto();
        producto.setNombre("Paquete chico de murcielagos gomita");
        producto.setPrice(12);
        producto.setStock(30);
        
        Articulo articulo = new Articulo();
        articulo.setCantidad(3);
        articulo.setCodigo(3);
        articulo.setDescripcion("Jeje");
        articulo.setProducto(producto);
        articulo.setServicio(servicio);
         
         //f.agregarLinea("Datos linea 2 - 5002");
         //f.agregarLinea("Datos linea 3 - 5002");
         artMap.setArticulo(articulo);
         p.guardar(artMap);
         //p.guardar(mf);
       //  Usuario u = new Usuario("Pedro con MapeadorU","mp");
         //MapeadorUsuario mu = new MapeadorUsuario();
        // mu.setU(u);
        // p.guardar(mu);
         //System.out.println(p.obtenerTodos(mu));
         
         //System.out.println(p.buscar(mu,"nombre =''"));
                 
         
    }
    
}
