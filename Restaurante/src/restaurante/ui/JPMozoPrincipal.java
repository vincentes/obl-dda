/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import restaurante.dominio.Mozo;

/**
 *
 * @author vincentes
 */
public class JPMozoPrincipal extends JPanel {

    private JPMozoEstatico estatico;

    public JPMozoPrincipal(Mozo mozo) {

        setLayout(new GridLayout(2, 1));
        JPMozoMesas pm = new JPMozoMesas();
        this.estatico = new JPMozoEstatico(pm, mozo);
        add(this.estatico);
        add(pm);
    }

    public JPMozoEstatico Estatico() {
        return this.estatico;
    }

}
