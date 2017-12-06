/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.utils;


/**
 *
 * @author vincentes
 */
public abstract class Observable<T> extends java.util.Observable {
    public void avisar(T evt) {
        setChanged();
        notifyObservers(evt);
    }
}
