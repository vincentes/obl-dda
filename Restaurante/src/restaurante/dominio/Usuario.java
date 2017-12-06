/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dominio;

import java.util.Objects;
import restaurante.dominio.Mozo.MozoInternoEvento;
import restaurante.utils.Observable;

/**
 *
 * @author vincentes
 */
public abstract class Usuario extends Observable<MozoInternoEvento> {
    protected String usuario;
    protected String password;
    protected String nombre;
    //Seba:
    protected ModoSistema soy;

    public ModoSistema getSoy() {
        return soy;
    }

    public void setSoy(ModoSistema soy) {
        this.soy = soy;
    }
//Fin
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public Usuario(String usuario, String password, String nombre, ModoSistema soyUn) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.soy = soyUn;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(!(obj instanceof Usuario)) {
            return false;
        } else {
            Usuario u = (Usuario) obj;
            return u.usuario.equals(usuario);
        }
    }

    @Override
    public String toString() {
        return usuario;
    }
    
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
