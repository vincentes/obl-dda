/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;
import restaurante.dominio.persistencia.Cliente;
import restaurante.utils.Observable;

/**
 *
 * @author vincentes
 */
public class Sistema extends Observable{

    //private SistemaUsuario usuarios = new SistemaUsuario();
    private SistemaMozo sMozos = new SistemaMozo();
    private SistemaGestor sGestores = new SistemaGestor();
    private SistemaServicio sServicios = new SistemaServicio();
    private SistemaProcesadora sistemaProcesadora = new SistemaProcesadora();
    private SistemaCliente sClientes = new SistemaCliente();

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
    
    public boolean logOutMozo(Mozo m){
        return sMozos.logOut(m);
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
        Articulo articulo = sistemaProcesadora.ingresoDeArticulo( producto,  cantidad,  descripcion,  servicio);
        servicio.agregar(articulo);
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
        boolean ret = true;
        if (seleccionada.getAbierta()) {
            if (seleccionada.getServicio() == null) {
                ret = false;
            }
            for (Articulo articulo : seleccionada.getServicio().getArticulos()) {
                if (Sistema.getInstancia().estaEnPedido(articulo)) {
                    ret = false;
                }
            }
        }
        return ret;
    }
    
    
    public boolean estaEnPedido(Articulo articulo){
        return sistemaProcesadora.estaEnPedido(articulo);
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
        sGestores.logOut(gestor);
        return sistemaProcesadora.logOutGestor(gestor, upp);
    }

    public Transferencia transferirMesa(Mesa seleccionada, Mozo mozoDestino) {
        return sMozos.transferir(mozoDestino, seleccionada);
    }

    public void updateVentanasGestores(){
        sistemaProcesadora.updateVentanasGestores();
    }

    public boolean nuevoArticulo(Articulo articulo) {
       return sServicios.nuevoArticulo(articulo);
    }

    public boolean agregarCliente(Cliente e) {
        return sClientes.agregar(e);
    }

    public Cliente getCliente(Cliente cliente) {
        return sClientes.get(cliente);
    }
    
    public Cliente getCliente(int numero) {
        return sClientes.get(numero);
    }

    public SistemaCliente getSClientes() {
        return sClientes;
    }
}
