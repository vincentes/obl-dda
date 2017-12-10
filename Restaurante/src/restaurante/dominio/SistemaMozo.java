/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.ArrayList;
import restaurante.dominio.SistemaMozo.MozoEvento;
import restaurante.utils.Observable;
import restaurante.utils.Utilidades;

/**
 *
 * @author vincentes
 */
public class SistemaMozo extends Observable<MozoEvento> {

    private ArrayList<Mozo> mozos = new ArrayList();
    private ArrayList<Mozo> mozosLogueados = new ArrayList();

    public enum MozoEvento {
        LOGEADO
    }

    public void agregar(Mozo m) {
        if (!mozos.contains(m)) {
            mozos.add(m);
        }
    }

    public Mozo encontrarL(String usuario) {
        for (Mozo mozo : mozosLogueados) {
            if (mozo.getUsuario().equals(usuario)) {
                return mozo;
            }
        }
        return null;
    }

    public void transferir(Mozo mozoDestino, Mesa mesa) {
        if(mozosLogueados.contains(mozoDestino))
        {
            mozoDestino.setTransfer(new Transferencia(mesa));
            Sistema.getInstancia().avisar(Utilidades.eventosMozo.mozoTransfer);
        }
    }

    public Mozo login(String n, String p) {
        for (Mozo m : mozos) {
            if (m.getUsuario().equals(n) && m.getPassword().equals(p)) {
                mozosLogueados.add(m);
                avisar(MozoEvento.LOGEADO);
                return m;
            }
        }
        return null;
    }

    public boolean logOut(Mozo m) {
        boolean ret = false;
        if (mozosLogueados.contains(m)) {
            if (!m.tieneMesasAbiertas()) {
                mozosLogueados.remove(m);
                Sistema.getInstancia().avisar(Utilidades.eventosMozo.mozoLoginLogout);
                ret = true;
            }

        }
        return ret;
    }

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public ArrayList<Mozo> getMozosLogueados() {
        return mozosLogueados;
    }

    public boolean logueado(String usuario) {
        for (Usuario u : mozosLogueados) {
            if (u.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }
}
