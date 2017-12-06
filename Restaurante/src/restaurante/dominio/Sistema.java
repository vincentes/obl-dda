/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;

/**
 *
 * @author vincentes
 */
public class Sistema {

    //private SistemaUsuario usuarios = new SistemaUsuario();
    private SistemaMozo sMozos = new SistemaMozo();
    private SistemaGestor sGestores = new SistemaGestor();
    private SistemaServicio sServicios = new SistemaServicio();
    private SistemaProcesadora sistemaProcesadora = new SistemaProcesadora();

    private static Sistema instancia = new Sistema();
    private ModoSistema modo;

    public Sistema() {
        //SEBA: Esto pasa a restaurante
//        modo = ModoSistema.MOZO;
//        Mozo m = new Mozo("vincentes", "postm", "Y. Vicente Bermúdez F.");
//        m.agregarMesa(new Mesa(1));
//        m.agregarMesa(new Mesa(3));
//        m.agregarMesa(new Mesa(5));
//        m.agregarMesa(new Mesa(25));
//        m.agregarMesa(new Mesa(10));
//        m.agregarMesa(new Mesa(8));
//        m.agregarMesa(new Mesa(15));
//        usuarios.agregar(m);
//        usuarios.agregar(new Gestor("vincentex", "postm", "Y. Vicente Bermúdez F."));
    }

    public Mozo loginMozo(String n, String p) {
        return sMozos.login(n, p);
    }
    
    public Gestor loginGestor(String n, String p) {
        return sGestores.login(n, p);
    }

    public static Sistema getInstancia() {
        return instancia;
    }

    public SistemaMozo getSMozos() {
        return sMozos;
    }
    
     public SistemaGestor getSGestores() {
        return sGestores;
    }

    public ModoSistema getModo() {
        return modo;
    }

    public void setModo(ModoSistema modo) {
        this.modo = modo;
    }

    public boolean MozoLogueado(String usuario) {
        return sMozos.logueado(usuario);
    }

    public SistemaProcesadora getSistemaProcesadora() {
        return sistemaProcesadora;
    }
    
    public void nuevoArticulo(Producto producto, int cantidad, String descripcion, Servicio servicio) {
        sServicios.nuevoArticulo(producto, cantidad, descripcion, servicio);
    }
    
    public void agregar(UPP p) {
        sistemaProcesadora.agregar(p);
    }
    
    public void agregarProducto(Producto prod, UPP proc) {
        sistemaProcesadora.agregarProducto(prod, proc);
    }

    public ArrayList<UPP> getProcesadoras() {
        return sistemaProcesadora.getProcesadoras();
    }
    
    public UPP procesadora(String nombre) {
        return sistemaProcesadora.procesadora(nombre);
    }

    public ArrayList<Producto> productosPorProcesadoraConStock(UPP procesadora) {
        return sistemaProcesadora.productosPorProcesadoraConStock(procesadora);
    }

    public SistemaServicio getsServicios() {
        return sServicios;
    }
    
    

    public Articulo ingresarArticulo(Producto producto, int cantidad, String descripcion, Servicio servicio) {
        Articulo articulo = new Articulo(producto, cantidad, servicio);
        boolean resultado = sServicios.nuevoArticulo(articulo);
        sistemaProcesadora.agregarPedido(articulo, servicio.getMesa().getMozo(), servicio.getMesa());
        if(!resultado) {
            articulo = null;
        } 
        return articulo;
    }

    public void agregarPedido(Articulo articulo, Mozo mozo, Mesa mesa) {
        sistemaProcesadora.agregarPedido(articulo, mozo, mesa);
    }
    
    public Producto getProducto(String producto) {
        return sistemaProcesadora.getProducto(producto);
    }

    public ArrayList<Mozo> getMozosLogueados() {
        return sMozos.getMozosLogueados();
    }
    
    public boolean isCerreable(Mesa seleccionada) {
        if(seleccionada.getServicio() == null) {
            return false;
        }
        for(Articulo articulo : seleccionada.getServicio().getArticulos()) {
            if(sistemaProcesadora.estaEnPedido(articulo)) {
                return false;
            }
            if(sGestores.procesando(articulo)) {
                
            }
        }
        return true;
    }
    
    //Modificación SEBA 25/10
    public UPP estaRegistradoGestorUPP(Gestor gestor)
    {
        return sistemaProcesadora.estaRegistradoGestorUPP(gestor);
    }
    
    public boolean registrarGestorEnUPP(Gestor gestor, UPP upp){
        return sistemaProcesadora.registrarGestorEnUPP(gestor, upp);
    }

    public void tomarPedido(Pedido pedido, Gestor gestor, UPP upp) {
     sistemaProcesadora.tomarPedido(pedido, gestor, upp);

    }

    public void finalizarPedido(Pedido pedido, Gestor gestor, UPP upp) {
        sistemaProcesadora.finalizarPedido(pedido, gestor, upp);
    }

    public boolean logOutGestor(Gestor gestor, UPP upp) {
        return sistemaProcesadora.logOutGestor(gestor, upp);
    }
}
