/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.ui;

import javax.swing.JFrame;
import restaurante.dominio.Mozo;

/**
 *
 * @author vincentes
 */
public class MozoVentana extends JFrame {

    public MozoVentana(Mozo mozo) {
        JPMozoPrincipal principal = new JPMozoPrincipal(mozo);
        setContentPane(principal);
        setSize(700,720);
        setTitle(mozo.getNombre());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
