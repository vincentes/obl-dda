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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JPMozoPrincipal(mozo));
        setSize(700,700);
        setTitle(mozo.getNombre());
        setLocationRelativeTo(null);
    }
}
