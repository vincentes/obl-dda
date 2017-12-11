/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import restaurante.dominio.Articulo;
import restaurante.dominio.Gestor;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mozo;
import restaurante.dominio.Pedido;
import restaurante.dominio.UPP;
import restaurante.dominio.Producto;
import restaurante.dominio.Sistema;
import restaurante.dominio.SistemaGestor;
import restaurante.dominio.SistemaMozo;
import restaurante.dominio.SistemaProcesadora;
import restaurante.dominio.SistemaUsuario;
import restaurante.ui.LanzadorDeLogins;


/**
 *
 * @author vincentes
 */
public class Restaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//SEBA: Test...        
//new LoginDialog(null, false).setVisible(true);

        preCargaDeDatos();
        //Lanzamos la ventana de Selección de Login
        new LanzadorDeLogins().setVisible(true);

    }

    public static void preCargaDeDatos() {

        Sistema system = Sistema.getInstancia();
        SistemaMozo sm = system.getSMozos();
        SistemaGestor sg = system.getSGestores();

        SistemaProcesadora sp = system.getSistemaProcesadora();

        //Creación de Unidades Procesadoras de Pedidos:
        UPP cocina = new UPP("Cocina");
        UPP bar = new UPP("Bar");

        //Agregamos productos a la UPP:
        cocina.agregarProducto(new Producto("Milanesa al pan", 200, 200, cocina));
        cocina.agregarProducto(new Producto("Hamburguesa", 150, 200, cocina));
        cocina.agregarProducto(new Producto("Tortilla de papa", 180, 200, cocina));

        bar.agregarProducto(new Producto("Agua mineral sin gas 600ML", 60, 200, bar));
        bar.agregarProducto(new Producto("Regresco Naranja 600ML", 80, 200, bar));
        bar.agregarProducto(new Producto("Cerveza 900ML", 140, 200, bar));

        //Agregamos las UPP:
        sp.agregar(cocina);
        sp.agregar(bar);

        //Creación de Mozos:
        Mozo mozo1 = new Mozo("vincentes", "postm", "Y. Vicente Bermúdez F.");
        Mozo mozo2 = new Mozo("m2", "m2", "Mozo 2");
        Mozo mozo3 = new Mozo("m3", "m3", "Mozo 3");
        Mozo mozo4 = new Mozo("m4", "m4", "Mozo 4");
        final Mesa mesa1 = new Mesa(1, mozo1);
        mesa1.toggle();
        //Asignación de Mesas:
        mozo1.agregarMesa(mesa1);
        mozo1.agregarMesa(new Mesa(2, mozo1));
        mozo1.agregarMesa(new Mesa(3, mozo1));
        mozo1.agregarMesa(new Mesa(4, mozo1));
        mozo2.agregarMesa(new Mesa(5, mozo2));
        mozo2.agregarMesa(new Mesa(6, mozo2));
        mozo2.agregarMesa(new Mesa(7, mozo2));
        mozo2.agregarMesa(new Mesa(8, mozo2));
        mozo3.agregarMesa(new Mesa(9, mozo3));
        mozo3.agregarMesa(new Mesa(10, mozo3));
        mozo3.agregarMesa(new Mesa(11, mozo3));
        mozo3.agregarMesa(new Mesa(12, mozo3));
        mozo4.agregarMesa(new Mesa(13, mozo4));
        mozo4.agregarMesa(new Mesa(14, mozo4));
        mozo4.agregarMesa(new Mesa(15, mozo4));
        mozo4.agregarMesa(new Mesa(16, mozo4));

        //Ingreso de mozos al sistema:
        sm.agregar(mozo1);
        sm.agregar(mozo2);
        sm.agregar(mozo3);
        sm.agregar(mozo4);

        //Ingreso de gestores al sistema:
        sg.agregar(new Gestor("vincentex", "postm", "Y. Vicente Bermúdez F."));
        sg.agregar(new Gestor("g1", "g1", "Gestor Número 1"));
        //El gestor 2 ya estará registrado en cocina desde el principio
        Gestor g2 = new Gestor("g2", "g2", "Gestor Número 2");
        sg.agregar(g2);
        sp.registrarGestorEnUPP(g2, cocina);
        sg.agregar(new Gestor("g3", "g3", "Gestor Número 3"));
        


        //TEST:
        Articulo art1 = new Articulo(cocina.getProductos().get(0), 2, "Prueba art 1", mesa1.getServicio());
        mesa1.getServicio().agregar(art1);
        Pedido ped1 = new Pedido(art1, mesa1);

        cocina.getPedidos().add(ped1);

    }

}
